package com.devsenior;

import java.util.Scanner;
import java.util.List;

public class EcoQuestApp {
    public void ejecutar(){
        Scanner sc = new Scanner(System.in);
        EcoQuestService service = new EcoQuestService();
        int opcion;

        do {
            System.out.println("=== ECOQUEST MENU ===");
            System.out.println("1. Registrar Voluntario");
            System.out.println("2. Registrar Misión");
            System.out.println("3. Registrar Punto Ecológico");
            System.out.println("4. Asignar Voluntario a Misión");
            System.out.println("5. Completar Misión");
            System.out.println("6. Buscar Voluntarios por Habilidad");
            System.out.println("7. Mostrar Reportes");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
            case 1:
                System.out.println("Ingrese el nombre del Voluntario: ");
                String nombreVoluntario = sc.nextLine();
                System.out.println("Ingrese ID del Voluntario: ");
                String idVoluntario = sc.nextLine();
                System.out.println("Ingrese las habilidades del voluntario separadas por comas: ");
                String habilidades = sc.nextLine();
                List<String> habilidadesTexto = List.of(habilidades.split(","));
                Voluntario voluntario = new Voluntario(idVoluntario, nombreVoluntario, habilidadesTexto);
                service.registrarVoluntario(voluntario);
                break;
            }
        } while (opcion != 8);
    }
}
