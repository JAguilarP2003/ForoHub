package com.aluracursos.challenges.foroHub.domain.topicos.dtos;

import com.aluracursos.challenges.foroHub.domain.topicos.Topicos;

public record CrearTopico(
        Long id,
        String titulo,
        String mensaje,
        String fecha,
        Integer autor,
        String curso
) {
    public CrearTopico(Topicos topicos) {
        this(
                topicos.getId(),
                topicos.getTitulo(),
                topicos.getMensaje(),
                topicos.getFecha(),
                topicos.getAutor(),
                topicos.getCurso()
        );
    }
}