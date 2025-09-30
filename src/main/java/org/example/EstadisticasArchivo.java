package org.example;
import java.io.*;
import java.nio.file.*;
import java.util.List;

public class EstadisticasArchivo {
    public static void main(String[] args) {
        String archivo = "pom.xml";

        // --- Usando java.io ---
        int lineasIO = 0;
        int caracteresIO = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineasIO++;
                caracteresIO += linea.length();
            }
            System.out.println("Usando IO:");
            System.out.println("Líneas: " + lineasIO);
            System.out.println("Caracteres: " + caracteresIO);
        } catch (IOException e) {
            System.err.println("Error con IO: " + e.getMessage());
        }

        // --- Usando java.nio ---
        try {
            List<String> lineas = Files.readAllLines(Paths.get(archivo));
            int lineasNIO = lineas.size();

            int caracteresNIO = 0;
            for (String linea : lineas) {
                caracteresNIO += linea.length();
            }

            System.out.println("\nUsando NIO:");
            System.out.println("Líneas: " + lineasNIO);
            System.out.println("Caracteres: " + caracteresNIO);
        } catch (IOException e) {
            System.err.println("Error con NIO: " + e.getMessage());
        }
    }
}
