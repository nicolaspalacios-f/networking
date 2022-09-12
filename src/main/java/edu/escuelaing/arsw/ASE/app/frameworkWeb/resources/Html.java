package edu.escuelaing.arsw.ASE.app.frameworkWeb.resources;

import edu.escuelaing.arsw.ASE.app.frameworkWeb.Output;

public class Html implements Resource {

    private String path = "";

    public Html(String path) {
        this.path = path;
        System.out.println("path resource: " + path);
    }

    @Override
    public void add(Output output) {
        output.print("Content-Type", "text/html");
        output.print("X-File", path);
        output.add(0);
    }

}
