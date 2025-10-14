package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class UsoProperties {
    public static void main(String[] args) {
        String archivo = "configuracion.properties";

        // --- Crear y guardar propiedades ---
        Properties config = new Properties();
        config.setProperty("app.nombre", "MiAplicacion");
        config.setProperty("app.version", "1.0.3");
        config.setProperty("app.modo", "produccion");
        config.setProperty("usuario.predeterminado", "admin");
        config.setProperty("tiempo.espera", "30");

        try (FileWriter out = new FileWriter(archivo)) {
            config.store(out, "Configuración de la aplicación");
            System.out.println("Archivo de configuración guardado.");
        } catch (IOException e) {
            System.err.println("Error al guardar propiedades: " + e.getMessage());
        }

        // --- Leer y mostrar propiedades ---
        Properties leidas = new Properties();
        try (InputStream in = new FileInputStream(archivo)) {
            leidas.load(in);
            System.out.println("\nPropiedades leídas:");
            leidas.forEach((clave, valor) -> System.out.println(clave + " = " + valor));
        } catch (IOException e) {
            System.err.println("Error al leer propiedades: " + e.getMessage());
        }

        // --- Leer propiedades con Load ---
        Properties propiedades = new Properties();
        try {
            propiedades.load( new FileReader(archivo));
            System.out.println( propiedades.getProperty("app.nombre"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
