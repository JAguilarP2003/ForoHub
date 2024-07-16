package com.aluracursos.challenges.foroHub.controller;


import com.aluracursos.challenges.foroHub.domain.topicos.*;
import com.aluracursos.challenges.foroHub.domain.topicos.dtos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    private final TopicoRepository topicoRepository;

    public TopicosController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @PostMapping
    public ResponseEntity<CrearTopico> crearTopico(@RequestBody @Valid DtoTopico dtoTopico) {
        Topicos topico = new Topicos(dtoTopico);
        topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CrearTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<ListaTopicos>> obtenerTopicos(@PageableDefault (size = 10, sort = "fecha", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Topicos> topicos = topicoRepository.findByEstatusTrue(pageable);
        return ResponseEntity.ok(topicos.map(ListaTopicos::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrearTopico> obtenerTopico(@PathVariable Long id) {
        Optional<Topicos> topicoOpcional = topicoRepository.findById(id);
        if(topicoOpcional.isPresent()){
            return ResponseEntity.ok(new CrearTopico(topicoOpcional.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CrearTopico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid ActualizarTopico actualizarTopico) {
        Optional<Topicos> topicoOpcional = topicoRepository.findById(id);
        if(topicoOpcional.isPresent()){
            Topicos topico = topicoOpcional.get();
            topico.actualizarTopico(actualizarTopico);
            topicoRepository.save(topico);
            return ResponseEntity.ok(new CrearTopico(topico));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        Optional<Topicos> topicoOpcional = topicoRepository.findById(id);
        if(topicoOpcional.isPresent()){
            Topicos topico = topicoOpcional.get();
            topico.eliminarTopico();
            topicoRepository.save(topico);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}