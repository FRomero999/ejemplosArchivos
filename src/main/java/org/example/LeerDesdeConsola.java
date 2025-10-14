package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class LeerDesdeConsola {

    public static void main(String[] args) {

        Path destino = Paths.get("consola.txt");

        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter out = Files.newBufferedWriter(destino, StandardOpenOption.CREATE)) {

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().toUpperCase();
                if(linea.equals("Q")) break;
                out.write(linea + System.lineSeparator());
            }

            System.out.println("Archivo creado: " + destino.getFileName());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
