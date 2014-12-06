package br.com.cdsl.validator.object;

import br.com.cdsl.annotations.field.NotNull;

public class Endereco {
	
	@NotNull
	private String rua;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
