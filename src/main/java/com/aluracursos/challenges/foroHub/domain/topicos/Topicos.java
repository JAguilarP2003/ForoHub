package com.aluracursos.challenges.foroHub.domain.topicos;

import com.aluracursos.challenges.foroHub.domain.topicos.dtos.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity(name = "Topicos")
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha;
    private Boolean estatus;
    private Integer autor;
    private String curso;

    public Topicos(DtoTopico dtoTopico) {
        this.titulo = dtoTopico.titulo();
        this.mensaje = dtoTopico.mensaje();

        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        this.fecha = fechaActual.format(formato);
        this.estatus = true;
        this.autor = dtoTopico.autor();
        this.curso = dtoTopico.curso();
    }
    public void actualizarTopico(ActualizarTopico actualizarTopico) {
        if(actualizarTopico.titulo() != null) this.titulo = actualizarTopico.titulo();
        if(actualizarTopico.mensaje() != null) this.mensaje = actualizarTopico.mensaje();
    }
    public void eliminarTopico() {
        this.estatus = false;
    }

}
