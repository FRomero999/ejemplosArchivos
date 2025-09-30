package org.example;
import java.io.*;
import java.nio.file.*;

public class CopyTextFile {
    public static void main(String[] args) {
        // Ruta original y nueva
        String origen = "pom.xml";
        String destinoIO = "pom_io.xml";
        String destinoNIO = "pom_nio.xml";

        // --- Usando java.io ---
        try (BufferedReader reader = new BufferedReader(new FileReader(origen));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinoIO))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }
            System.out.println("Archivo copiado con IO: " + destinoIO);
        } catch (IOException e) {
            System.err.println("Error con IO: " + e.getMessage());
        }

        // --- Usando java.nio ---
        try {
            Path origenPath = Paths.get(origen);
            Path destinoPath = Paths.get(destinoNIO);
            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado con NIO: " + destinoNIO);
        } catch (IOException e) {
            System.err.println("Error con NIO: " + e.getMessage());
        }
    }
}
