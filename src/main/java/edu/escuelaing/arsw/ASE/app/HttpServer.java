package edu.escuelaing.arsw.ASE.app;

import java.net.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class HttpServer {

    private static HttpServer instance = new HttpServer();
    private static String bandera = "false";

    public static HttpServer getInstance() {
        return (instance);
    }

    public void start() throws IOException {
        ServerSocket serverSocket = iniciarServidor();
        ExecutorService pool = Executors.newFixedThreadPool(7);
        while (bandera != "exit") {
            Socket clientSocket = activarSocket(serverSocket);
            RequestProcessor processor = new RequestProcessor(clientSocket, bandera);
            pool.execute(processor);

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

    private int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }

}
