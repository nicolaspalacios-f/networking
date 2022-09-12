package edu.escuelaing.arsw.ASE.app.frameworkWeb.api;

import edu.escuelaing.arsw.ASE.app.frameworkWeb.interaction.Request;

@FunctionalInterface
public interface Controller {
    public String response(Request req, String value);
}
