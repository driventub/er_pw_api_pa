package uce.edu.er_pw_api_pa.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.er_pw_api_pa.model.Profesor;
import uce.edu.er_pw_api_pa.service.IProfesorService;
import uce.edu.er_pw_api_pa.service.to.ProfesorTO;


@RestController
@RequestMapping("/profesores")
@CrossOrigin
public class ProfesorController {
    
    @Autowired
    private IProfesorService profesorService;

    @PostMapping
    public void insertar(@RequestBody Profesor profesor ){
        this.profesorService.insertar(profesor);
    }

    @GetMapping
    public ResponseEntity<List<ProfesorTO>> buscarTodos() {
        List<ProfesorTO> lista = this.profesorService.buscarTodos();
        System.out.println(lista);
        for (ProfesorTO prof : lista) {
            Link myLink = linkTo(methodOn(ProfesorController.class).consultarProfesor(prof.getId())).withSelfRel();
            prof.add(myLink);
        }
        return new ResponseEntity<List<ProfesorTO>>(lista, null, 200);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProfesorTO> consultarProfesor(@PathVariable Integer id) {
        return  new ResponseEntity<ProfesorTO>(this.profesorService.buscarPorId(id), null, 200);
    }

    @DeleteMapping(path = "/{id}")
    public void borrarProfesor(@PathVariable Integer id){
        this.profesorService.eliminar(id);
    }


}
