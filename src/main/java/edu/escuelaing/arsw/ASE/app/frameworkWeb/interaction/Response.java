package edu.escuelaing.arsw.ASE.app.frameworkWeb.interaction;

import java.io.IOException;
import java.net.Socket;

import edu.escuelaing.arsw.ASE.app.frameworkWeb.StringBuilderOutput;
import edu.escuelaing.arsw.ASE.app.frameworkWeb.api.Routes;
import edu.escuelaing.arsw.ASE.app.frameworkWeb.resources.ApiResource;
import edu.escuelaing.arsw.ASE.app.frameworkWeb.resources.Html;
import edu.escuelaing.arsw.ASE.app.frameworkWeb.resources.Imagen;
import edu.escuelaing.arsw.ASE.app.frameworkWeb.resources.NoEncontrado;
import edu.escuelaing.arsw.ASE.app.frameworkWeb.resources.Resource;
import edu.escuelaing.arsw.ASE.app.frameworkWeb.resources.js;

public class Response {

    public static void response(String method, String path, Socket clientSocket) throws IOException {
        Resource resource = tipoArchivo(method, path, clientSocket);
        StringBuilder buf = new StringBuilder();
        resource.add(new StringBuilderOutput(buf, clientSocket));
    }

    private static Resource tipoArchivo(String method, String path, Socket clientSocket) throws IOException {
        Resource rs;
        if (path.endsWith(".js")) {
            rs = new js(path);
        } else if (path.endsWith(".html")) {
            rs = new Html(path);
        } else if (path.endsWith(".jpg") || path.endsWith(".png") || path.endsWith(".gif") || path.endsWith(".jpeg")) {
            rs = new Imagen(path);
        } else if (path.contains("?")) {
            String key = path.substring(0, path.indexOf("?"));
            key = key.replace("resources", "");
            System.out.println("key: " + key);
            rs = Routes.getInstance().exists(method + key) ? new ApiResource(method,
                    method + key, path) : new NoEncontrado();
        } else {
            rs = new NoEncontrado();
        }
        return rs;

    }
}
