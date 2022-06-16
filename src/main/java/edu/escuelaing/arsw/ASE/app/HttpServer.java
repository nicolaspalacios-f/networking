package edu.escuelaing.arsw.ASE.app;

import java.net.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class HttpServer {

    private boolean esPath = true;
    private static HttpServer instance = new HttpServer();

    public static HttpServer getInstance() {
        return (instance);
    }

    public void start() throws IOException {
        ServerSocket serverSocket = iniciarServidor();
        String bandera = "a";
        while (bandera != "exit") {
            Socket clientSocket = activarSocket(serverSocket);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            respuesta(request(in), clientSocket);

            out.println("outputline");

            out.close();

            in.close();

            clientSocket.close();
        }
        serverSocket.close();

    }

    private ServerSocket iniciarServidor() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        return serverSocket;
    }

    private Socket activarSocket(ServerSocket socket) {
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = socket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        return clientSocket;
    }

    private void respuesta(String url, Socket socket) throws IOException {
        String tipo = url.substring(url.indexOf(".") + 1);
        File file = new File(url);
        PrintWriter out;
        if (file.exists()) {
            tipoArchivo(tipo, socket, file);
        } else {
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(errors(404));
            out.close();
        }

    }

    private void tipoArchivo(String tipo, Socket clientSocket, File archivo) throws IOException {

        if (tipo.equals("png") || tipo.equals("jpg") || tipo.equals("gif")
                || tipo.equals("jpeg")) {
            binario(tipo, clientSocket, archivo);
        } else if (tipo.equals("html") || tipo.equals("js")) {
            archivos(tipo, clientSocket, archivo);
        }
    }

    private String binario(String tipo, Socket clientSocket, File archivo) throws IOException {
        String outputLine = "";
        byte[] imagen = leerImagen(archivo);
        DataOutputStream binario = new DataOutputStream(clientSocket.getOutputStream());

        outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: image/" + tipo + "\r\n"
                + "Content-Length: " + imagen.length + "\r\n"
                + "\r\n";
        binario.writeBytes(outputLine);
        binario.write(imagen);
        binario.close();
        binario.close();
        return outputLine;
    }

    private String archivos(String tipo, Socket clientSocket, File archivo) throws IOException {
        String outputLine = "";
        PrintWriter out;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/" + tipo + "\r\n"
                + "\r\n"
                + leerArchivo(archivo);
        out.println(outputLine);
        out.close();
        return outputLine;
    }

    private String leerArchivo(File archivo) throws FileNotFoundException {
        try (Scanner scanne = new Scanner(archivo)) {
            String lista = new String();
            while (scanne.hasNextLine()) {
                lista += (scanne.nextLine());
            }
            return (lista);
        } catch (NumberFormatException e) {
            String lista = new String();
            return (lista);
        }
    }

    private byte[] leerImagen(File archivo) throws IOException {
        try {
            FileInputStream inputImage = new FileInputStream(archivo);
            byte[] bytes = new byte[(int) archivo.length()];
            inputImage.read(bytes);
            inputImage.close();
            return bytes;
        } catch (Exception e) {
            byte[] bytes = new byte[0];
            return bytes;
        }

    }

    private String request(BufferedReader in) throws IOException {
        String path = "";
        String inputLine = "";
        while ((inputLine = in.readLine()) != null) {
            esPath = true;
            if (esPath && inputLine.startsWith("GET")) {
                System.out.println("entro al if");
                System.out.println("Path: " + inputLine.split(" ")[1].substring(1));
                path = inputLine.split(" ")[1].substring(1);
                esPath = false;
            }
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
        return path;
    }

    private String errors(int tipo) {
        String respuesta = "";
        if (tipo == 404) {
            respuesta = "HTTP/1.1 404 Not Found\r\n\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<h1>404 Not Found</h1>"
                    + "<br></br>"
                    + "<img src=https://i.pinimg.com/originals/a2/2c/8a/a22c8a42037722a26a050c92e0908312.jpg>"
                    + "</html>";
        }
        return respuesta;
    }

    private int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }

}
