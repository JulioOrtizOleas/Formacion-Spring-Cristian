package org.jortiz.springcloud.msvc.cursos.services;

import org.jortiz.springcloud.msvc.cursos.entity.Curso;

import java.util.*;

public interface CursoService {
    List<Curso> listar();
    Optional<Curso> porId(Long id);
    Curso guardar(Curso curso);
    void eliminar(Long id);
}
