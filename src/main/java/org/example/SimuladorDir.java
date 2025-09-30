package org.example;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Ruta que quieres listar (puedes cambiarla)
        File carpeta = new File(".");

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] elementos = carpeta.listFiles();

            if (elementos != null) {
                for (File elemento : elementos) {
                    String tipo = elemento.isDirectory() ? "<DIR>" : "ARCHIVO";
                    long tamaño = elemento.isFile() ? elemento.length() : 0;

                    System.out.printf("%-30s %-10s %10d bytes%n",
                            elemento.getName(), tipo, tamaño);
                }
            } else {
                System.out.println("No se pudo acceder al contenido de la carpeta.");
            }
        } else {
            System.out.println("La ruta no existe o no es una carpeta.");
        }
    }
}