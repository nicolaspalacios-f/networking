package edu.escuelaing.arsw.ASE.app.frameworkWeb.resources;

import edu.escuelaing.arsw.ASE.app.frameworkWeb.Output;

public class Imagen implements Resource {

    private String path = "";

    public Imagen(String path) {
        this.path = path;
    }

    @Override
    public void add(Output output) {
        output.print("Content-Type", "image/" + path.substring(path.lastIndexOf(".") + 1));
        output.print("X-File", path);
        output.add(1);
    }

}