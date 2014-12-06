package br.com.cdsl.validator.object;

import br.com.cdsl.annotations.field.NotNull;


@NotNull(exception = CampoVazioException.class, messageException = "Campo obrigatorio não preenchido")
public class PessoaComException {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
