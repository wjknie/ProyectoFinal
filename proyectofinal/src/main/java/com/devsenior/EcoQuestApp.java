package com.devsenior;

import java.util.Scanner;
import java.time.LocalDate;
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
                System.out.println("Ingrese ID del Voluntario: ");
                String idVoluntario = sc.nextLine();
                System.out.println("Ingrese el nombre del Voluntario: ");
                String nombreVoluntario = sc.nextLine();
                System.out.println("Ingrese las habilidades del voluntario separadas por comas: ");
                String habilidades = sc.nextLine();
                List<String> habilidadesTexto = List.of(habilidades.split(","));
                Voluntario voluntario = new Voluntario(idVoluntario, nombreVoluntario, habilidadesTexto);
                service.registrarVoluntario(voluntario);
                break;

            case 2:
                System.out.println("Ingrese el ID de la misión: ");
                String idMision = sc.nextLine();
                System.out.println("Ingrese la descripción de la misión: ");
                String descripcionMision = sc.nextLine();
                System.out.println("Ingrese la ubicación de la misión: ");
                String ubicacionMision = sc.nextLine();
                System.out.println("Ingrese la fecha de la misión: ");
                String fechaMision = sc.nextLine();
                LocalDate fecha = LocalDate.parse(fechaMision);
                System.out.println("Ingrese el nivel de dificultad: ");
                String nivelDificultad = sc.nextLine();
                Mision mision = new Mision(idMision, descripcionMision, ubicacionMision, fecha, nivelDificultad);
                service.agregarMision(mision);
                break;

            case 3:
                System.out.println("Ingrese el ID del punto ecológico: ");
                String idPuntoEco = sc.nextLine();
                System.out.println("Ingrese el nombre del punto ecológico: ");
                String nombrePuntoEco = sc.nextLine();
                System.out.println("Ingrese el tipo del punto ecológico: ");
                String tipoPuntoEco = sc.nextLine();
                System.out.println("Ingrese las coordenadas del punto ecológico: ");
                String coordenadasPuntoEco = sc.nextLine();
                PuntoEco puntoEco = new PuntoEco(idPuntoEco, nombrePuntoEco, tipoPuntoEco, coordenadasPuntoEco);
                service.agregarPuntoEco(puntoEco);
                break;

            case 4:
                System.out.println("Ingrese el ID del voluntario: ");
                idVoluntario = sc.nextLine();
                System.out.println("Ingrese el ID de la misión: ");
                idMision = sc.nextLine();
                service.asignarMisionVoluntario(idVoluntario, idMision);
                break;
            
            case 5:
                System.out.println("Ingrese el ID de la misión completada: ");
                idMision = sc.nextLine();
                service.completarMision(idMision);
                break;

            case 6:
                System.out.println("Ingrese la habilidad que desea buscar: ");
                habilidades = sc.nextLine();
                String habilidadNormalizada = EcoQuestService.normalizarTexto(habilidades);
                service.voluntarioPorHabilidades(habilidadNormalizada);
                break;
            }
            sc.close();
        } while (opcion != 8);
    }
}
