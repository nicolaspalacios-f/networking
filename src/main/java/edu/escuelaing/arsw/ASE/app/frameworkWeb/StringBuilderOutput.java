package edu.escuelaing.arsw.ASE.app.frameworkWeb;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class StringBuilderOutput implements Output {
    private final StringBuilder buffer;
    private final Socket clientSocket;
    private File file;

    public StringBuilderOutput(StringBuilder buf, Socket clientSocket) {
        this.buffer = buf;
        this.clientSocket = clientSocket;
    }

    public StringBuilder getBuffer() {
        return buffer;
    }

    @Override
    public void print(String name, String value) {
        if (this.buffer.length() == 0) {
            if (name.equals("X-Response")) {
                this.buffer.append(value + "\r\n");
            } else {
                this.buffer.append("HTTP/1.1 200 OK\r\n");
            }
        }
        if (name.equals("X-Body")) {
            this.buffer.append("\r\n").append(value);
        } else if (name.equals("X-File")) {
            this.file = new File(value);
            this.buffer.append("\r\n");
        } else {
            this.buffer.append(name).append(": ").append(value).append("\r\n");
        }
    }

    @Override
    public void add(int opt) {
        try {
            switch (opt) {
                case 0:
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    if (this.file != null) {
                        this.buffer.append(leerArchivo(this.file));
                    }
                    out.print(buffer.toString());
                    out.close();
                    break;
                case 1:
                    DataOutputStream binaryOut = new DataOutputStream(clientSocket.getOutputStream());
                    binaryOut.writeBytes(buffer.toString());
                    binaryOut.write(lectorImagen(this.file));
                    binaryOut.close();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo que lee un archivo de tipo texto
     * 
     * @param archivo Archivo a buscar
     * @return String del contenido del archivo
     * @throws FileNotFoundException
     */
    private static String leerArchivo(File archivo) {
        try {
            Scanner scanne = new Scanner(archivo);
            String lista = new String();
            while (scanne.hasNextLine()) {
                lista += (scanne.nextLine());
            }
            return (lista);
        } catch (NumberFormatException e) {
            String lista = new String();
            return (lista);
        } catch (FileNotFoundException e) {
            String lista = new String();
            return (lista);
        }
    }

    /**
     * Metodo que lee un archivo de tipo imagen
     * 
     * @param archivo Archivo a buscar
     * @return Array de bytes de la imagen
     * @throws IOException
     */
    private static byte[] lectorImagen(File archivo) {
        byte[] imagen = new byte[0];
        FileInputStream inputImage;
        try {
            inputImage = new FileInputStream(archivo);
            byte[] bytes = new byte[(int) archivo.length()];
            inputImage.read(bytes);
            inputImage.close();
            imagen = bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imagen;
    }
}