package org.jortiz.springcloud.msvc.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.jortiz.springcloud.msvc.usuarios.models.entity.Usuario;

import javax.swing.text.html.Option;


public interface UsuarioService {
    List<Usuario> listar();
    Optional<Usuario> porId(Long id);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
}
