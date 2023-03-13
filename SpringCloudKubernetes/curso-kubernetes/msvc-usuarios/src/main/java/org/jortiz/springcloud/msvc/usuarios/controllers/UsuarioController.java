package org.jortiz.springcloud.msvc.usuarios.controllers;

import org.jortiz.springcloud.msvc.usuarios.models.entity.Usuario;
import org.jortiz.springcloud.msvc.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public List<Usuario> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = service.porId(id);
        if(usuarioOptional.isPresent()){
            //Una opción de retornar la respuesta ==>return ResponseEntity.ok().body(usuarioOptional.get());
            //Status 200 Ok
            return ResponseEntity.ok(usuarioOptional.get());
        }
        //Status 404 no encontrado
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    //@ResponseStatus(HttpStatus.CREATED)
    //public Usuario crear(@RequestBody  Usuario usuario){
    //Otra forma de generar el Post con la respuesta es la siguiente:
    public ResponseEntity<?> crear(@RequestBody  Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuario));

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Usuario usuario,@PathVariable Long id){
        Optional<Usuario> usuario1 = service.porId(id);
        if(usuario1.isPresent()){
            Usuario usuarioDb = usuario1.get();
            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setPassword(usuario.getPassword());
            return  ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuarioDb));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Usuario> usuario = service.porId(id);
        if(usuario.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


