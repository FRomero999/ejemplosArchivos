package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeerCSV {
    public static void main(String[] args) {
        String archivo = "numeros.csv"; // Asegúrate de que este archivo exista

        List<Integer> numeros = leerNumerosDesdeCSV(archivo);

        if(!numeros.isEmpty()){
            System.out.println("Números leídos del archivo:");
            for (int numero : numeros) {
                System.out.println(numero);
            }
        }

    }

    public static List<Integer> leerNumerosDesdeCSV(String rutaArchivo) {
        List<Integer> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                for (String parte : partes) {
                    lista.add(Integer.parseInt(parte.trim()));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return lista;
    }
}
