package edu.escuelaing.arsw.frameworkWeb;

public class StringBuilderOutput implements Output {
    private final StringBuilder buffer;

    StringBuilderOutput(StringBuilder buf) {
        this.buffer = buf;
    }

    @Override
    public void print(String name, String value) {
        if (this.buffer.length() == 0) {
            this.buffer.append("HTTP/1.1 200 OK\r\n");
        }
        if (name.equals("X-Body")) {
            this.buffer.append("\r\n").append(value);
        } else {
            this.buffer.append(name).append(": ").append(value).append("\r\n");
        }
    }
}