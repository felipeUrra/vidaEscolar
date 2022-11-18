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

    public void verAsignaturas(){
        if (this.asignaturaList.isEmpty()){
            System.out.println("No se ha añadido ninguna asignatura." + "\n");
        }
        else {
            System.out.println("Asignaturas:");
            for (Asignatura asigAux: this.asignaturaList){
                System.out.println(asigAux.getId() + ": " + asigAux.getNombre());
            }
            System.out.println("\n");
        }
    }
    public String annadirAsignaturas(){
        System.out.println("Nombre de la asignatura a añadir:");
        Scanner scanner = new Scanner(System.in);
        String nombreAsig = scanner.nextLine().toUpperCase();
        int contador = this.asignaturaList.size();
        int indice = 0;

        if (this.asignaturaList.isEmpty()) {
            this.asignaturaList.add(new Asignatura(nombreAsig));
            return "Asignatura añadida ;)." + "\n";
        } else if (this.asignaturaList.size() == 1) {
            if (this.asignaturaList.get(0).getNombre().equals(nombreAsig)) {
                return "Esta asignatura ya fue añadida." + "\n";
            } else {
                this.asignaturaList.add(new Asignatura(nombreAsig));
                return "Asignatura añadida ;)." + "\n";
            }

        } else {
            for (Asignatura asigAux: this.asignaturaList){
                indice ++;
                if (asigAux.getNombre().equals(nombreAsig)) {
                    contador -= 1;
                } else {
                    if (contador == this.asignaturaList.size() && indice == this.asignaturaList.size()){
                        this.asignaturaList.add(new Asignatura(nombreAsig));
                        return "Asignatura añadida ;)." + "\n";
                    }
                }
            }
        }
        return "Esta asignatura ya fue añadida." + "\n";
    }

    public void calcularPromedioTodasAsignaturas(){
        float promedioGuardado = 0;
        int contadorPromedio = 0;

        for (Asignatura asigAux: this.getAsignaturaList()) {
            promedioGuardado += asigAux.calcularPromedioAsignaturaEspecifica(this);
            contadorPromedio ++;
        }

        System.out.println("Promedio general de todas las asignaturas: " + promedioGuardado/contadorPromedio);
    }
}
