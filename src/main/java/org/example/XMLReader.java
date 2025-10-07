package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;

public class XMLReader {
    public static void main(String[] args) {
        ArrayList<Alumno> lista = new ArrayList<>();

        try {
            File archivo = new File("alumnos.xml");
            var factory = DocumentBuilderFactory.newInstance();
            var builder = factory.newDocumentBuilder();
            Document doc = builder.parse(archivo);

            NodeList alumnos = doc.getElementsByTagName("alumno");

            for (int i = 0; i < alumnos.getLength(); i++) {
                Element alumno = (Element) alumnos.item(i);

                String nombre = alumno.getElementsByTagName("nombre").item(0).getTextContent();
                String apellido = alumno.getElementsByTagName("apellido").item(0).getTextContent();
                String dni = alumno.getElementsByTagName("dni").item(0).getTextContent();

                lista.add(new Alumno(nombre, apellido, dni));
            }

            System.out.println("Alumnos leídos del XML:");
            for (Alumno a : lista) {
                System.out.println(a);
            }

        } catch (Exception e) {
            System.err.println("Error al leer el XML: " + e.getMessage());
        }
    }
}
