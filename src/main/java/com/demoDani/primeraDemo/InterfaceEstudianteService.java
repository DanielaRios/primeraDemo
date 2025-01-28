package com.demoDani.primeraDemo;

import java.util.ArrayList;

public interface InterfaceEstudianteService {

    public ArrayList<Estudiante> getEstudiantes();
    public void agregarEstudiantes(Estudiante estudiante) throws Exception;
}
