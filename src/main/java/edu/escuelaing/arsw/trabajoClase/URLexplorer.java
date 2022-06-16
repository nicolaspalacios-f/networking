package edu.escuelaing.arsw.trabajoClase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class URLexplorer {
    public static void main(String[] args) {
        try {
            URL myURL = new URL("https://www.motor.com.co/seccion/precios/:80/index.hmtl");
            System.out.println("Protoclo : " + myURL.getProtocol());
            System.out.println("Host : " + myURL.getHost());
            System.out.println("Port : " + myURL.getPort());
            System.out.println("Path : " + myURL.getPath());
            System.out.println("Ref : " + myURL.getRef());
            System.out.println("Authority : " + myURL.getAuthority());
            System.out.println("Query : " + myURL.getQuery());
        } catch (MalformedURLException e) {
            Logger.getLogger(URLexplorer.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
