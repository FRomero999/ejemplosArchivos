package org.example;
import java.io.*;
import java.util.List;

// POJO de Alumno

class Alumno implements Serializable {
    private String nombre;
    private String apellido;
    private String dni;

    public Alumno(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - DNI: " + dni;
    }
}


 class ListaAlumnos {
    private List<Alumno> alumnos;
}


public class ObjectWriter {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Ana", "García", "12345678A");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("alumno.bin"))) {
            out.writeObject(alumno);
            System.out.println("Objeto Alumno guardado en alumno.bin");
        } catch (IOException e) {
            System.err.println("Error al escribir el objeto: " + e.getMessage());
        }
    }
}

