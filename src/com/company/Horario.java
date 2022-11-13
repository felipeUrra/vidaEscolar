package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Horario {
    private ArrayList<Asignatura> asignaturaList = new ArrayList<Asignatura>();

    public ArrayList<Asignatura> getAsignaturaList() {
        return asignaturaList;
    }
    public void setAsignaturaList(ArrayList<Asignatura> asignaturaList) {
        this.asignaturaList = asignaturaList;
    }

    public static void verAsignaturas(Horario horario){
        if (horario.asignaturaList.isEmpty()){
            System.out.println("No se ha añadido ninguna asignatura." + "\n");
        }
        else {
            System.out.println("Asignaturas:");
            for (Asignatura asigAux: horario.asignaturaList){
                System.out.println(asigAux.getId() + ": " + asigAux.getNombre());
            }
            System.out.println("\n");
        }
    }
    public static String annadirAsignaturas(Horario horario){
        System.out.println("Nombre de la asignatura a añadir:");
        Scanner scanner = new Scanner(System.in);
        String nombreAsig = scanner.nextLine().toUpperCase();
        int contador = horario.asignaturaList.size();
        int indice = 0;

        if (horario.asignaturaList.isEmpty()) {
            horario.asignaturaList.add(new Asignatura(nombreAsig));
            return "Asignatura añadida ;)." + "\n";
        } else if (horario.asignaturaList.size() == 1) {
            if (horario.asignaturaList.get(0).getNombre().equals(nombreAsig)) {
                return "Esta asignatura ya fue añadida." + "\n";
            } else {
                horario.asignaturaList.add(new Asignatura(nombreAsig));
                return "Asignatura añadida ;)." + "\n";
            }

        } else {
            for (Asignatura asigAux: horario.asignaturaList){
                indice ++;
                if (asigAux.getNombre().equals(nombreAsig)) {
                    contador -= 1;
                } else {
                    if (contador == horario.asignaturaList.size() && indice == horario.asignaturaList.size()){
                        horario.asignaturaList.add(new Asignatura(nombreAsig));
                        return "Asignatura añadida ;)." + "\n";
                    }
                }
            }
        }
        return "Esta asignatura ya fue añadida." + "\n";
    }
}
