package br.com.cdsl.validator.object;

import br.com.cdsl.annotations.exception.NonException;
import br.com.cdsl.annotations.field.NotNull;

public class PessoaTest {

	@NotNull(exception=NonException.class, messageException="Validação_1", emptyIsNull=true)
	private String nomeVazio = "";
	@NotNull(exception=NonException.class, messageException="Validação_2", emptyIsNull=true)
	private String nomeNulo = null;
	@NotNull(exception=NonException.class, messageException="Validação_3", emptyIsNull=true)
	private String nomeOk = "Cássio";
	@NotNull(exception=NonException.class, messageException="Validação_4", emptyIsNull=false)
	private String nomeVazioNaoValidar = "";
	
	
	public PessoaTest() {

		
	}


	public PessoaTest(String nomeVazio, String nomeNulo, String nomeOk,
			String nomeVazioNaoValidar) {
		super();
		this.nomeVazio = nomeVazio;
		this.nomeNulo = nomeNulo;
		this.nomeOk = nomeOk;
		this.nomeVazioNaoValidar = nomeVazioNaoValidar;
	}
	
	

}
