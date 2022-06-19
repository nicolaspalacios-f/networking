package edu.escuelaing.arsw.ASE.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiHilosProcessor implements Runnable {

    private int port;

    public MultiHilosProcessor(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        Socket echoSocket = reconexion();
        PrintWriter out = null;
        try {
            echoSocket = new Socket("localhost", port);
            out = new PrintWriter(echoSocket.getOutputStream());

        } catch (Exception e) {
            System.out.println(echoSocket);

        }
        out.close();
    }

    private Socket reconexion() {
        Socket echoSocket = null;
        try {
            echoSocket = new Socket("127.0.0.1", port);
        } catch (UnknownHostException e) {
            System.err.println("Error en el host");
            System.exit(1);
        } catch (IOException e) {
            return reconexion();
        }
        return echoSocket;
    }
}
