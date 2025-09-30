package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import java.io.OutputStream;

public class LeerScanner {
    public static void main(String[] args) {
        Path origen = Paths.get("pom.xml");
        Path destino = Paths.get("pom_mayusculas.xml");


        try (InputStream in = Files.newInputStream(origen);
             Scanner scanner = new Scanner(in);
             BufferedWriter out = Files.newBufferedWriter(destino,StandardOpenOption.CREATE)) {

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().toUpperCase();
                out.write(linea + System.lineSeparator());
            }

            System.out.println("Archivo creado: " + destino.getFileName());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

