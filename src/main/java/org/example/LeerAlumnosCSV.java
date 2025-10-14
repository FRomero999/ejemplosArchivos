package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerAlumnosCSV {

    private static final String ARCHIVO = "alumnos.csv";

    public static void main(String[] args) {

        List<Alumno> alumnado = new ArrayList<Alumno>();

        try(BufferedReader bfr = new BufferedReader( new FileReader( ARCHIVO ))){

            String s;
            while((s = bfr.readLine()) != null){
                String[] trozos = s.split(",");
                Alumno a = new Alumno(trozos[0],trozos[1],trozos[2]);
                alumnado.add(a);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Alumnado de U-TAD");
        for(Alumno a : alumnado){
            System.out.println(a);
        }

    }
}
