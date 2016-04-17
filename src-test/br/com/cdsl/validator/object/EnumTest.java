package br.com.cdsl.validator.object;

import org.junit.Test;

import br.com.cdsl.validator.validate.Validator;

public class EnumTest {

	@Test
	public void testarAtributoComEnum(){
		
		PessoaComEnum pessoa = new PessoaComEnum("Teste", TipoPessoa.JURIDICA);
		try {
			Validator.validate(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
