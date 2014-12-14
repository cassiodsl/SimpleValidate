package br.com.cdsl.validator.object;

import br.com.cdsl.annotations.field.NotNull;

public class PessoaTest {

	@NotNull(exception=CampoVazioException.class, messageException="Valida��o_1", emptyIsNull=true)
	private String nomeVazio = "";
	@NotNull(exception=CampoVazioException.class, messageException="Valida��o_2", emptyIsNull=true)
	private String nomeNulo = null;
	@NotNull(exception=CampoVazioException.class, messageException="Valida��o_3", emptyIsNull=true)
	private String nomeOk = "C�ssio";
	@NotNull(exception=CampoVazioException.class, messageException="Valida��o_4", emptyIsNull=false)
	private String nomeVazioNaoValidar = "";
	
	
	public PessoaTest() {

		
	}

}
