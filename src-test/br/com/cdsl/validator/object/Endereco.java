package br.com.cdsl.validator.object;

import java.util.List;


import br.com.cdsl.annotations.field.NotNull;
import br.com.cdsl.annotations.field.Size;

class Endereco {
	
	@NotNull
	@Size(max=10, min=1, messageException="Campo rua invalido")
	private String rua;
	
	@Size(max=10, min=1, messageException="Campo contatos invalido")
	private List<String> contatos;
	@Size(max=10, min=1, messageException="Campo nomes invalido")
	private String[] nomes;
	
	

	public String[] getNomes() {
		return nomes;
	}

	public void setNomes(String[] nomes) {
		this.nomes = nomes;
	}

	public List<String> getContatos() {
		return contatos;
	}

	public void setContatos(List<String> contatos) {
		this.contatos = contatos;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
