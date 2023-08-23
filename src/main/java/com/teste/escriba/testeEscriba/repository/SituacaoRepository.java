package com.teste.escriba.testeEscriba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.escriba.testeEscriba.entity.SituacaoCartorio;

@Repository
public interface SituacaoRepository extends JpaRepository<SituacaoCartorio, Integer> {

}
