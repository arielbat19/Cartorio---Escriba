package com.teste.escriba.testeEscriba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.escriba.testeEscriba.entity.AtribuicoesCartorio;

@Repository
public interface AtribuicaoRepository extends JpaRepository<AtribuicoesCartorio, Integer> {

}
