package org.pruebaTecnica1.persistencia;

import org.pruebaTecnica1.logica.Empleado;
import org.pruebaTecnica1.persistencia.exceptions.NonexistentEntityException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();

    public void createEmpleado(Empleado empleado) {
        empleadoJPA.create(empleado);
    }

    public List<Empleado> getAllEmpleados () {
        return empleadoJPA.findEmpleadoEntities();
    }

    public void updateEmpleado (Empleado empleado) {
        try {
            empleadoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteEmpleado(Long id) {
        try {
            empleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> getEmpleadoByCargo(String cargo){
        List<Empleado> empleadosCargo = new ArrayList<>();

        for(Empleado empleado : empleadoJPA.findEmpleadoEntities()){
            if(empleado.getCargo().equalsIgnoreCase(cargo)){
                empleadosCargo.add(empleado);
            }
        }
        return empleadosCargo;
    }

}
