package org.pruebaTecnica1;

import org.pruebaTecnica1.logica.Empleado;
import org.pruebaTecnica1.persistencia.ControladoraPersistencia;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ControladoraPersistencia controladora = new ControladoraPersistencia();


        String[] opciones = {
                "1. Agregar un nuevo empleado",
                "2. Listar empleados",
                "3. Actualizar información de un empleado",
                "4. Eliminar un empleado",
                "5. Buscar empleados por cargo",
                "6. Salir"
        };
        System.out.println("----------------------------------------");
        System.out.println(" Bienvenido al gestor de Empleados By Laura Rodríguez");
        System.out.println("----------------------------------------");
        Scanner scanner = new Scanner(System.in);
        int opcionSeleccionada = 0;

        while(opcionSeleccionada != 6 ){
            for (String opcion : opciones) {
                System.out.println(opcion);
            }
            System.out.println("Seleccione una opción:");

            opcionSeleccionada = Integer.parseInt(scanner.nextLine());

            if(opcionSeleccionada > 6 || opcionSeleccionada < 0){
                System.out.println("Esa opción es incorrecta.");
            } else{
                System.out.printf("Ha seleccionado: %s \n", opciones[opcionSeleccionada - 1]);

                // Variables que se van a necesitar en el switch

                String nuevoNombre = "";
                String nuevoApellido = "";
                String nuevoCargo = "";
                double nuevoSalario = 0;
                long idEmpleado = 0L;

                switch (opcionSeleccionada){
                    case 1:
                        System.out.println("----------------------------------");
                        System.out.println("Agrege un nuevo empleado a continuación:");
                        System.out.println("Nombre: ");
                        nuevoNombre = scanner.nextLine();
                        if(nuevoNombre.isEmpty()){
                            System.out.println("Valor incorrecto");
                            break;
                        }
                        System.out.println("Apellido: ");
                        nuevoApellido = scanner.nextLine();
                        if(nuevoApellido.isEmpty()){
                            System.out.println("Valor incorrecto");
                            break;
                        }
                        System.out.println("Cargo: ");
                        nuevoCargo = scanner.nextLine();
                        if(nuevoCargo.isEmpty()){
                            System.out.println("Valor incorrecto");
                            break;
                        }
                        System.out.println("Salario: ");
                        nuevoSalario = Double.parseDouble(scanner.nextLine());
                        Empleado nuevoEmpleado = new Empleado(nuevoNombre,nuevoApellido,nuevoCargo,nuevoSalario, new Date());
                        controladora.createEmpleado(nuevoEmpleado);
                        System.out.println("Creado nuevo empleado:");
                        System.out.println(nuevoEmpleado);
                        break;
                    case 2:
                        System.out.println("----------------------------------");
                        System.out.print("\n Empleados registrados __________________________");
                        List<Empleado> empleados = new ArrayList<>();
                        empleados = controladora.getAllEmpleados();
                        for(Empleado empleado : empleados){
                            System.out.println("\n" + empleado);
                        }
                        break;
                    case 3:
                        System.out.println("----------------------------------");
                        System.out.print("\n Cual es la id del empleado que quiere editar?");
                        idEmpleado = Long.parseLong(scanner.nextLine());
                        Empleado empleadoAEditar = controladora.getEmpleadoById(idEmpleado);
                        if (empleadoAEditar == null) {
                            System.out.println("No se encontró un empleado con el ID proporcionado.");
                            break;
                        }
                        System.out.println("----------- Empleado seleccionado: --------------------");
                        System.out.println(empleadoAEditar);
                        String[] opcionesAEditar = {
                                "Nombre",
                                "Apellido",
                                "Cargo",
                                "Salario",
                                "Todos"
                        };
                        System.out.println("¿Que campo desea modificar?");

                        for (int i = 0; i < opcionesAEditar.length; i++) {
                            System.out.printf("%d. %s\n", i + 1, opcionesAEditar[i]);
                        }
                        int opcionEditarSeleccionada = Integer.parseInt(scanner.nextLine());
                        switch (opcionEditarSeleccionada){
                            case 1:
                                System.out.println("Ingrese el nuevo nombre: ");
                                nuevoNombre = scanner.nextLine();
                                empleadoAEditar.setNombre(nuevoNombre);
                                System.out.println("Nombre actualizado correctamente.");
                                break;
                            case 2:
                                System.out.println("Ingrese el nuevo apellido: ");
                                nuevoApellido = scanner.nextLine();
                                empleadoAEditar.setApellido(nuevoApellido);
                                System.out.println("Apellido actualizado correctamente.");
                                break;
                            case 3:
                                System.out.println("Ingrese el nuevo cargo: ");
                                nuevoCargo = scanner.nextLine();
                                empleadoAEditar.setCargo(nuevoCargo);
                                System.out.println("Cargo actualizado correctamente.");
                                break;
                            case 4:
                                System.out.println("Ingrese el nuevo salario: ");
                                nuevoSalario = Double.parseDouble(scanner.nextLine());
                                empleadoAEditar.setSalario(nuevoSalario);
                                System.out.println("Salario actualizado correctamente.");
                                break;
                            case 5:
                                System.out.println("Ingrese el nuevo nombre: ");
                                nuevoNombre = scanner.nextLine();
                                empleadoAEditar.setNombre(nuevoNombre);

                                System.out.println("Ingrese el nuevo apellido: ");
                                nuevoApellido = scanner.nextLine();
                                empleadoAEditar.setApellido(nuevoApellido);

                                System.out.println("Ingrese el nuevo cargo: ");
                                nuevoCargo = scanner.nextLine();
                                empleadoAEditar.setCargo(nuevoCargo);

                                System.out.println("Ingrese el nuevo salario: ");
                                nuevoSalario = Double.parseDouble(scanner.nextLine());
                                empleadoAEditar.setSalario(nuevoSalario);
                                System.out.println("Todos los campos actualizados correctamente.");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }

                        controladora.updateEmpleado(empleadoAEditar);
                        System.out.println("Cambios realizados");
                        break;
                    case 4:
                        System.out.println("----------------------------------");
                        System.out.print("\n Cual es la id del empleado que quiere eliminar?");
                        idEmpleado = Long.parseLong(scanner.nextLine());

                        Empleado empleadoAEliminar = controladora.getEmpleadoById(idEmpleado);
                        if (empleadoAEliminar == null) {
                            System.out.println("No se encontró un empleado con el ID proporcionado.");
                            break;
                        }
                        System.out.printf("Ha elegido la id %d , que corresponde con el empleado %s %s , quiere eliminarlo definitivamente? (S/N)",  idEmpleado, empleadoAEliminar.getNombre() , empleadoAEliminar.getApellido());
                        String verificacion = scanner.nextLine();
                        if(verificacion.equalsIgnoreCase("S")){
                            controladora.deleteEmpleado(idEmpleado);
                            System.out.println("Empleado Eliminado correctamente");
                        } else {
                            System.out.println("Borrado cancelado");
                        }
                        break;
                    case 5:
                        System.out.println("----------------------------------");
                        System.out.print("\n Cual es el cargo que quiere buscar?");
                        String cargoSeleccionado = scanner.nextLine();
                        List<Empleado> empleadosPorCargo = controladora.getEmpleadoByCargo(cargoSeleccionado);
                        System.out.printf("Empleados con el cargo %s :\n", cargoSeleccionado);
                        System.out.println("----------------------------------");
                        if(empleadosPorCargo.isEmpty()){
                            System.out.println("No hay empleados con ese cargo");
                        }else{
                            for(Empleado e : empleadosPorCargo){
                                System.out.println(e);
                            }
                        }
                        break;
                }
                System.out.println("----------------------------------");
                if (opcionSeleccionada != 6 ){
                System.out.println("Y ahora ¿Qué opción desea realizar? : ");}
                else {
                    System.out.println("Tenga un buen dia, cerrando aplicación");
                }
            }
        }
    }
}