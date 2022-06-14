package edu.escuelaing.arsw.ASE.app;

import java.net.*;
import java.io.*;

public class HttpServer {
    private static HttpServer instance = new HttpServer();

    public static HttpServer getInstance() {
        return (instance);
    }

    public void start() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        String bandera = "a";
        while (bandera != "exit") {
            Socket clientSocket = null;

            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine, outputLine;
            boolean path = true;
            while ((inputLine = in.readLine()) != null) {
                if (path) {
                    System.out.println("Path: " + inputLine.split(" ")[1]);
                    path = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }
            outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Title of the document</title>\n" + "</head>"
                    + "<body>"
                    + "My Web Site"
                    + "<br></br>"
                    + "<img src=https://i.pinimg.com/736x/a3/03/c6/a303c67498dff59b29466dba1aafc6b2.jpg>"
                    + "</body>"
                    + "</html>" + inputLine;

            out.println(outputLine);

            out.close();

            in.close();

            clientSocket.close();
        }
        serverSocket.close();

    }
}
