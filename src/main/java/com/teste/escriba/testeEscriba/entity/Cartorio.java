package com.teste.escriba.testeEscriba.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_cartorio")
public class Cartorio {

	@Id()
	@SequenceGenerator(name = "SeqA", sequenceName = "sq_tipo_a")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqA")
	@Column(name = "ID_CARTORIO", nullable = false)
	private int id_cartorio;

	@Column(name = "NOME_CARTORIO", length = 150, nullable = false)
	private String nome_cartorio;

	@Column(name = "OBSERVACAO", length = 250)
	private String observacao;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private SituacaoCartorio situacaoCartorio;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private AtribuicoesCartorio atribuicoesCartorio;
}
