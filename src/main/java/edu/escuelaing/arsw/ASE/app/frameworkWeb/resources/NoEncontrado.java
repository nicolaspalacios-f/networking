package edu.escuelaing.arsw.ASE.app.frameworkWeb.resources;

import edu.escuelaing.arsw.ASE.app.frameworkWeb.Output;

public class NoEncontrado implements Resource {

    @Override
    public void add(Output output) {
        output.print("X-Response", "HTTP/1.1 404 Not Found");
        output.print("X-Body", "<!DOCTYPE html>" + "<html>"
                + "<h1>Error 404</h1>"
                + "<img src =https://play-lh.googleusercontent.com/6e12kIL0JGGDYTH-8nEl23GzXwKC4b-_UFWwJCycgLs7RGuIbFbvh7zPD7bic58Gz2ok >"
                + "</html>");
        output.add(0);
    }

}
