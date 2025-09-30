package org.example;

import java.io.*;

public class CifrarTexto {
    public static void main(String[] args) {
        String origen = "pom.xml";
        String destino = "pom_cifrado.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(origen));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destino))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                String lineaCifrada = "";
                for (int i = 0; i < linea.length(); i++) {
                    char c = linea.charAt(i);
                    if (c >= 'a' && c <= 'z') {
                        lineaCifrada += (c == 'z') ? 'a' : (char)(c + 1);
                    } else if (c >= 'A' && c <= 'Z') {
                        lineaCifrada += (c == 'Z') ? 'A' : (char)(c + 1);
                    } else {
                        lineaCifrada += c;
                    }
                }
                writer.write(lineaCifrada);
                writer.newLine();
            }

            System.out.println("Archivo cifrado creado: " + destino);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
