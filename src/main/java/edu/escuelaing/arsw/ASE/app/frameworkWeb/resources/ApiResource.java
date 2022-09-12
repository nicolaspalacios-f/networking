package edu.escuelaing.arsw.ASE.app.frameworkWeb.resources;

import edu.escuelaing.arsw.ASE.app.frameworkWeb.Output;
import edu.escuelaing.arsw.ASE.app.frameworkWeb.api.Controller;
import edu.escuelaing.arsw.ASE.app.frameworkWeb.api.Routes;
import edu.escuelaing.arsw.ASE.app.frameworkWeb.interaction.Request;

public class ApiResource implements Resource {

    private String content = "text/plain";
    private int binary = 0;
    private String body = "";

    public ApiResource() {
    }

    public ApiResource(String method, String key, String path) {
        Controller apiRes = Routes.getInstance().Get(key);
        this.body = apiRes.response(new Request(method, path), "");
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public void add(Output output) {
        output.print("Content-Type", content);
        output.print("X-Body", body);
        output.add(binary);
    }

}
