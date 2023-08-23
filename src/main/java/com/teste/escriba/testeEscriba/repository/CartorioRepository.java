package com.teste.escriba.testeEscriba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teste.escriba.testeEscriba.entity.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {


	@Query("from Cartorio where nome_cartorio = :nome_cartorio")
	List<Cartorio> findByNOME_CARTORIO(@Param("nome_cartorio") String nome_cartorio);

}
