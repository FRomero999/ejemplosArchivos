package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsoJackson {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();


        Alumno alumno = new Alumno("Laura", "Gómez", "12345678A");
        System.out.println("Objeto original:");
        System.out.println(alumno);

        var alumnos = new ArrayList<Alumno>();
        alumnos.add(alumno);
        alumnos.add(alumno);
        alumnos.add(alumno);

        try {
            mapper.writeValue(new File("alumnado.json"), alumnos);
            System.out.println("\nObjeto serializado a JSON y guardado en 'alumno.json'.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Alumno alumnoLeido = mapper.readValue(new File("alumno.json"), Alumno.class);

            /*
            //si quisiera leer una lista de alummnos:
             List<Alumno> alumnosLeidos = mapper.readValue(
                    new File("alumnos.json"),
                    new TypeReference<List<Alumno>>() {}
            );
             */
            System.out.println("\nObjeto leído desde JSON:");
            System.out.println(alumnoLeido);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
