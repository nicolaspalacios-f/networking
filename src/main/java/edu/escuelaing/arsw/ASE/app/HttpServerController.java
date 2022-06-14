package edu.escuelaing.arsw.ASE.app;

public class HttpServerController {
    public static void main(String[] args) {
        HttpServer server = HttpServer.getInstance();
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
