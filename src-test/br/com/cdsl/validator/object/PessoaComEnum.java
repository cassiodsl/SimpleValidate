package br.com.cdsl.validator.object;

import br.com.cdsl.annotations.field.NotNull;

class PessoaComEnum {


	@NotNull(exception=CampoVazioException.class, emptyIsNull=true)
	private String nome;
	
	@NotNull(exception=CampoVazioException.class, emptyIsNull=true)
	private TipoPessoa tipoPessoa;

	public PessoaComEnum(String nome, TipoPessoa tipoPessoa) {
		super();
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	
	
	
	
}
