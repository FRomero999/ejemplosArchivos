package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.ArrayList;

public class SimuladorDirNIO {
    public static void main(String[] args) {

        Path ruta = Path.of("pom.xml"); // Cambia la ruta según tu sistema

        try {
            ArrayList<String> contenido = (ArrayList<String>) Files.readAllLines(ruta);
            for(String str : contenido){
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       /*
        File archivo = new File("pom.xml");

        try(BufferedReader bfr = new BufferedReader( new FileReader(archivo))){
            String s;
            while( (s = bfr.readLine()) != null ){
                System.out.println(s);
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */

/*
        try {

            var archivos =  Files.list(ruta).toList();

            for (Path entrada : archivos) {
                String tipo = Files.isDirectory(entrada) ? "<DIR>" : "ARCHIVO";
                long tamaño = Files.isRegularFile(entrada) ? Files.size(entrada) : 0;

                System.out.printf("%-30s %-10s %10d bytes%n",
                        entrada.getFileName(), tipo, tamaño);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }*/

    }
}
