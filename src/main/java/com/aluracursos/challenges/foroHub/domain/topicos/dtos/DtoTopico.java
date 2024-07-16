package com.aluracursos.challenges.foroHub.domain.topicos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        int autor,
        @NotBlank
        String curso
) {
}
