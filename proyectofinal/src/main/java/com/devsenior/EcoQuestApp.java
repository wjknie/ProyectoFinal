package com.devsenior;

import java.util.Scanner;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EcoQuestApp {
    public void ejecutar() {
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
                    try {
                    System.out.println("Ingrese el nombre del Voluntario: ");
                    String nombreVoluntario = sc.nextLine();
                    
                    System.out.println("Ingrese ID del Voluntario: ");
                    String idVoluntario = sc.nextLine();

                    System.out.println("Ingrese las habilidades del voluntario separadas por comas: ");
                    String habilidades = sc.nextLine();

                    List<String> habilidadesTexto = List.of(habilidades.split(","));
                    Voluntario voluntario = new Voluntario(nombreVoluntario, idVoluntario, habilidadesTexto);

                    service.registrarVoluntario(voluntario);
                    System.out.println("Voluntario registrado.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                    break;

                case 2:
                    try{
                        System.out.println("Ingrese el ID de la misión: ");
                    String idMision = sc.nextLine();
                    System.out.println("Ingrese la descripción de la misión: ");
                    String descripcionMision = sc.nextLine();
                    System.out.println("Ingrese la ubicación de la misión: ");
                    String ubicacionMision = sc.nextLine();

                    LocalDate fecha = null;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    while(fecha == null){
                        System.out.println("Ingrese la fecha de la misión (DD/MM/AAAA): ");
                        String fechaMision = sc.nextLine();

                    try{
                        fecha = LocalDate.parse(fechaMision, formatter);
                    }catch (DateTimeParseException e){
                        System.out.println("Formato de fecha incorrecto. Use el formato DD/MM/AAAA");
                    }
                }

                String nivelDificultad = null;

                    while (nivelDificultad == null) {
                        System.out.println("Ingrese el nivel de dificultad (baja/media/alta): ");
                        String entradaDificultad = sc.nextLine();

                        if(EcoQuestService.dificultadValida(entradaDificultad)){
                        nivelDificultad = EcoQuestService.normalizarTexto(entradaDificultad);
                    }else{
                        System.out.println("Nivel de dificultad inválido. Usa: baja, media o alta.");
                    }
                    }
                    
                    Mision mision = new Mision(idMision, descripcionMision, ubicacionMision, fecha, nivelDificultad);
                    service.agregarMision(mision);
                    } catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    
                    break;

                case 3:
                    try{
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
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try{
                        System.out.println("Ingrese el ID del voluntario: ");
                        String idVoluntario = sc.nextLine();

                        System.out.println("Ingrese el ID de la misión: ");
                        String idMision = sc.nextLine();

                        service.asignarMisionVoluntario(idVoluntario, idMision);
                        System.out.println("Voluntario asignado a la misión.");
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try{
                        System.out.println("Ingrese el ID de la misión completada: ");
                        String idMision = sc.nextLine();

                        service.completarMision(idMision);
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Ingrese la habilidad que desea buscar: ");
                    String habilidades = sc.nextLine();

                    String habilidadNormalizada = EcoQuestService.normalizarTexto(habilidades);
                    
                    List<Voluntario> resultados = service.voluntarioPorHabilidades(habilidadNormalizada);
                    
                    if(resultados.isEmpty()){
                        System.out.println("No se encontraron voluntarios con esa habilidad.");
                    } else {
                        for(Voluntario v : resultados){
                            System.out.println(v);
                        }
                    }
                    break;

                case 7:
                    System.out.println("=== REPORTES ===");
                    System.out.println("1. Top voluntarios");
                    System.out.println("2. Listar voluntarios");
                    System.out.println("3. Misiones completadas");
                    System.out.println("4. Misiones pendientes");
                    int rep = sc.nextInt();
                    sc.nextLine();

                    switch (rep) {
                        case 1:
                            service.mostrarTopVoluntarios();
                            break;
                        case 2:
                            service.mostrarVoluntarios();
                            break;
                        case 3:
                            service.mostrarMisionesCompletadas();
                            break;
                        case 4:
                            service.mostrarMisionesPendientes();
                            break;
                        default:
                            break;
                    }

                    break;
                case 8:
                    System.out.println("Cerrando el programa...");
            }
        } while (opcion != 8);
        sc.close();
    }
}
