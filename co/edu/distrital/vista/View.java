package co.edu.distrital.vista;

import java.util.Scanner;

public class View {
    private Scanner sc;

    public View() {
        sc = new Scanner(System.in);
    }

    public void mostrarInformacion(String mensaje) {
        System.out.println(mensaje);
    }

    public String leerCadenaCaracteres(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }

    // Repite la pregunta hasta que el usuario escriba un número válido.
    public int leerEntero(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debes escribir un número entero.");
            }
        }
    }
}