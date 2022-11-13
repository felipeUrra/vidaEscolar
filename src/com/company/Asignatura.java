package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Asignatura {
    private String nombre;
    private ArrayList<Nota> notaList = new ArrayList<Nota>();
    private int id;
    private static int idSiguiente = 0;

    public Asignatura(String nombre){
        this.nombre = nombre;
        this.id = Asignatura.idSiguiente;
        Asignatura.idSiguiente += 1;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Nota> getNotaList() {
        return notaList;
    }
    public void setNotaList(ArrayList<Nota> notaList) {
        this.notaList = notaList;
    }

    public void verNotas(Horario horario) {
        if (horario.getAsignaturaList().get(this.id).getNotaList().isEmpty()) {
            System.out.println("Esta asignatura no tiene notas." + "\n");
        } else {
            System.out.println(horario.getAsignaturaList().get(this.id).getNombre() + ":");
            for (Nota notaAux : horario.getAsignaturaList().get(this.id).getNotaList()) {
                System.out.println("Tipo de evaluacion: " + notaAux.getTipoDeEvaluacion() + "\n" + "Nota: " + notaAux.getPuntuacion());
            }
            System.out.println("\n");
        }
    }

    public void annadirNota(Horario horario){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca el tipo de evaluacion (ACS, TCP o PF):");
        String tipoDeEvaluacion = scanner.nextLine().toUpperCase();

        if (tipoDeEvaluacion.equals("ACS") || tipoDeEvaluacion.equals("TCP") || tipoDeEvaluacion.equals("PF")){
            Nota.TipoDeEvaluacion tipoEvaluacion = Enum.valueOf(Nota.TipoDeEvaluacion.class, tipoDeEvaluacion);

            System.out.println("Introduzca la nota:");
            float nuevaNota = scanner.nextFloat();

            horario.getAsignaturaList().get(this.id).getNotaList().add(new Nota(nuevaNota, this.nombre, tipoEvaluacion));
        } else {
            System.out.println("Por favor, introduzca los datos correctamente");
            Main.mostrarOpciones(scanner);
        }

    }

}
