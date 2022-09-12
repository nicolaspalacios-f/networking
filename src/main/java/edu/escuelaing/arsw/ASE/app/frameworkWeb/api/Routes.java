package edu.escuelaing.arsw.ASE.app.frameworkWeb.api;

import java.util.HashMap;

public class Routes {
    private HashMap<String, Controller> rutas = new HashMap<String, Controller>();
    private static Routes _instance = new Routes();

    private Routes() {
    }

    public static Routes getInstance() {
        return _instance;
    }

    public void Add(String key, Controller res) {
        rutas.put(key, res);
    }

    public Controller Get(String key) {
        return rutas.get(key);
    }

    public boolean exists(String key) {
        return rutas.containsKey(key);
    }
}
