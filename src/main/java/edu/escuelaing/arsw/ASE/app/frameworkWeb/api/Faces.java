package edu.escuelaing.arsw.ASE.app.frameworkWeb.api;

public class Faces {
    public static void Add(String method, String path, Controller value) {
        Routes.getInstance().Add(method + path, value);
    };
}
