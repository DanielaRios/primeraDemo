package com.demoDani.primeraDemo;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping
public class EstudiantesController {

    @Autowired // magia que va instanciar un estudiante service
    private EstudianteService estudianteService;

    @GetMapping("/estudiantes")
    public ResponseEntity<ArrayList<Estudiante>>  getEstudiantes(){
        ArrayList<Estudiante> listaEstudiantes = estudianteService.getEstudiantes();
        ResponseEntity<ArrayList<Estudiante>> respuesta = new ResponseEntity<>(listaEstudiantes, HttpStatus.OK);
    return respuesta;
    }

    @PostMapping("/estudiantes")
    public ResponseEntity<String> agregarEstudiantes(@RequestBody Estudiante estudiante) {
        ResponseEntity<String> respuesta;
        try {
            estudianteService.agregarEstudiantes(estudiante);
            return new ResponseEntity<>("Se agrego correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Ya existe", HttpStatus.BAD_REQUEST);
        }
    }
    /*@RequestBody lo uso para indicarle a Spring boot que tiene que agregar el estudiante*/

    }