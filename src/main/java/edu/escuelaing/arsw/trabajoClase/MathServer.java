package edu.escuelaing.arsw.trabajoClase;

import java.net.*;
import java.io.*;

public class MathServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
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
        int operacion = 0;
        while (((inputLine = in.readLine()) != null)) {
            outputLine = "Cambio a " + inputLine;
            if (inputLine.equals("fun:cos")) {
                operacion = 0;
            } else if (inputLine.equals("fun:sin")) {
                operacion = 1;
            } else if (inputLine.equals("fun:tan")) {
                operacion = 2;
            } else {
                if (operacion == (0)) {
                    outputLine = String.valueOf(Math.cos(Double.valueOf(inputLine)));
                } else if (operacion == (1)) {
                    outputLine = String.valueOf(Math.sin(Double.valueOf(inputLine)));
                } else if (operacion == (2)) {
                    outputLine = String.valueOf(Math.tan(Double.valueOf(inputLine)));
                }
            }

            System.out.println("Mensaje: " + inputLine);
            out.println(outputLine);
            if (outputLine.equals("A mi tambien  exit"))
                break;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
