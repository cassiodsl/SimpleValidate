package br.com.cdsl.validator.object;

import br.com.cdsl.annotations.field.NonSpecialChar;
import br.com.cdsl.annotations.field.NotEmpty;
import br.com.cdsl.annotations.field.NotNull;


@NotNull(exception = CampoVazioException.class, messageException = "Campo obrigatorio não preenchido")
class PessoaComException {

	@NonSpecialChar(messageException="Campo nome com caracter especial")
	@NotEmpty(messageException="Campo nome vazio")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
