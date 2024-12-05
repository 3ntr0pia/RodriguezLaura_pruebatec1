package org.pruebaTecnica1;

import org.pruebaTecnica1.logica.Empleado;
import org.pruebaTecnica1.persistencia.ControladoraPersistencia;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ControladoraPersistencia controlador = new ControladoraPersistencia();

        Empleado empleado = new Empleado("Juan", "Gala", "Jefe", 10000, new Date());

        controlador.createEmpleado(empleado);

        System.out.println("Empleado creado");
    }
}