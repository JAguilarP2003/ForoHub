package com.aluracursos.challenges.foroHub.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topicos, Long> {
    Page<Topicos> findByEstatusTrue(Pageable pageable);
}
