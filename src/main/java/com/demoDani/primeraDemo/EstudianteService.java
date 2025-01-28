package com.demoDani.primeraDemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EstudianteService implements InterfaceEstudianteService {

    private ArrayList<Estudiante> estudiantes=new ArrayList<>();

    @Override
    public ArrayList<Estudiante> getEstudiantes(){
        return estudiantes;
    }

    @Override
    public void agregarEstudiantes(Estudiante estudiante) throws Exception{
        this.buscarEstudiante(estudiante);
        estudiantes.add(estudiante);
    }

    private Estudiante buscarEstudiante(Estudiante estudiante) throws Exception {
        Estudiante estudianteEncontrado= null;
        int pos=0;
        while (pos<estudiantes.size() &&  estudianteEncontrado==null ){
            if ( estudiantes.get(pos).esElMismo(estudiante)){
                estudianteEncontrado=estudiantes.get(pos);
            }
            pos++;
        }
        if(estudianteEncontrado != null) {
            throw new Exception("Error");
        }
        return estudianteEncontrado;
    }

}
