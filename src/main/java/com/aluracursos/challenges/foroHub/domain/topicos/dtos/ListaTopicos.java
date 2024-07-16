package com.aluracursos.challenges.foroHub.domain.topicos.dtos;

import com.aluracursos.challenges.foroHub.domain.topicos.Topicos;

public record ListaTopicos(
        Long id,
        String titulo,
        String mensaje,
        String fecha) {
    public ListaTopicos (Topicos topicos) {
        this(
                topicos.getId(),
                topicos.getTitulo(),
                topicos.getMensaje(),
                topicos.getFecha()
        );
    }
}