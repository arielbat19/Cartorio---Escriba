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
@Table(name = "tbl_atribuicao")
public class AtribuicoesCartorio {

	@Id()
	@SequenceGenerator(name = "SeqC", sequenceName = "sq_tipo_c")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqC")
	@Column(name = "ID_ATRIBUICAO", length = 20, nullable = false)
	private int id_atribuicao;

	@Column(name = "NOME_ATRIBUICAO", length = 50, nullable = false)
	private String nome_atribuicao;

	@Column(name = "SITUACAO", nullable = false)
	private Boolean situacao = Boolean.TRUE;
}
