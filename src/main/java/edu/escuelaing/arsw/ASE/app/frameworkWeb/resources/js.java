package edu.escuelaing.arsw.ASE.app.frameworkWeb.resources;

import edu.escuelaing.arsw.ASE.app.frameworkWeb.Output;

public class js implements Resource {

    private String path = "";

    public js(String path) {
        this.path = path;
    }

    @Override
    public void add(Output output) {
        output.print("Content-Type", "application/javascript");
        output.print("X-File", path);
        output.add(0);
    }

}
