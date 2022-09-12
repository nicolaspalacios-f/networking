package edu.escuelaing.arsw.ASE.app;

import edu.escuelaing.arsw.ASE.app.frameworkWeb.api.Faces;

public class HttpServerController {
    public static void main(String[] args) {
        HttpServer servidor = HttpServer.getInstance();
        Faces.Add("GET", "/hello", (req, res) -> {
            return "Hello, " + req.getParameter("name");
        });
        Faces.Add("POST", "/hello", (req, res) -> {
            return "Hello, " + req.getParameter("name");
        });
        try {
            servidor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
