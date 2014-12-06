package br.com.teste;

import br.com.cdsl.annotations.field.NonSpecialChar;
import br.com.cdsl.annotations.field.NotNull;
import br.com.cdsl.annotations.type.RollBack;


@NotNull(exception = CampoVazioException.class, messageException = "Campo nome da pessoa vazio")
public class Pessoa {

	@NotNull(messageException = "")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		System.out.println("Chamando set Nome");
		this.nome = nome;
	}
	
	
	
}
