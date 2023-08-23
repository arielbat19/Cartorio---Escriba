package com.teste.escriba.testeEscriba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_situacao")
public class SituacaoCartorio {

	@Id()
	@SequenceGenerator(name= "SeqB", sequenceName= "sq_tipo_b")         
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SeqB")
	@Column(name = "ID_SITUACAO", length = 20, nullable = false)
	private int id_situacao;
	
	@Column(name = "NOME_SITUACAO", length = 50, nullable = false)
	private String nome_situacao;
	
	@Column(name = "SITUACAO", nullable = false)
	private String situacao;
}
