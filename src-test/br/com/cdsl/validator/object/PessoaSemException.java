package br.com.cdsl.validator.object;

import br.com.cdsl.annotations.field.NotNull;


@NotNull(messageException = "Campo obrigatorio não preenchido")
public class PessoaSemException {

	private String nome;
	
	private Endereco endereco;
	
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
