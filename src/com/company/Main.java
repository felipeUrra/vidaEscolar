package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Horario horario = new Horario();
        opciones(horario, scanner);
    }

    public static int mostrarOpciones(Scanner scanner){
        System.out.println("Seleccione una de estas opciones:" + "\n" +
                "1. Ver asignaturas" + "\n" +
                "2. Añadir una asignatura" + "\n" +
                "3. Ver notas de una asignatura" + "\n" +
                "4. Añadir una nota a una asignatura" + "\n" +
                "0. Salir");

        return scanner.nextInt();
    }

    public static void opciones(Horario horario, Scanner scanner) {
        boolean salir = false;

        int idAsig;
        int idContador;

        while (!salir) {
            switch (mostrarOpciones(scanner)){
                case 0: // Salir
                    salir = true;
                    break;
                case 1: // Ver asignaturas
                    horario.verAsignaturas();
                    break;
                case 2: // Añadir asignaturas
                    System.out.println(horario.annadirAsignaturas());
                    break;
                case 3: // Ver notas
                    horario.verAsignaturas();
                    idContador = horario.getAsignaturaList().size();

                    if (horario.getAsignaturaList().isEmpty()) {
                        System.out.println("Por favor, introduzca alguna asignatura." + "\n");
                    } else {
                        System.out.println("Introduzca el id de la asignatura cuyas notas desee ver:");
                        idAsig = scanner.nextInt();

                        for (Asignatura asigAux: horario.getAsignaturaList()) {
                            if (idAsig == asigAux.getId()) {
                                horario.getAsignaturaList().get(idAsig).verNotas(horario);
                            } else {
                                idContador--;
                                if (idContador == 0){
                                    System.out.println("Por favor, introduzca un id correcto" + "\n");
                                }
                            }
                        }
                    }
                    break;
                case 4: // Añadir notas
                    horario.verAsignaturas();
                    idContador = horario.getAsignaturaList().size();

                    if (horario.getAsignaturaList().isEmpty()){
                        System.out.println("Por favor, introduzca alguna asignatura, para que le pueda añadir notas." + "\n");
                    } else {
                        System.out.println("Introduzca el id de la asignatura a la que desea añadirle una nota:");
                        idAsig = scanner.nextInt();

                        for (Asignatura asigAux: horario.getAsignaturaList()) {
                            if (idAsig == asigAux.getId()) {
                                horario.getAsignaturaList().get(idAsig).annadirNota(horario);
                                System.out.println("La nota ha sido añadida" + "\n");
                            } else {
                                idContador--;
                                if (idContador == 0){
                                    System.out.println("Por favor, introduzca un id correcto" + "\n");
                                }
                            }
                        }
                        break;
                    }
                default:
                    System.out.println("Introduzca el numero de una opcion existente, por favor.");
                    break;
            }
        }
    }
}
