package br.com.cdsl.validator.object;

import java.util.List;

import org.junit.Test;

import br.com.cdsl.validator.validate.Message;
import br.com.cdsl.validator.validate.Validator;

class NotEmptyValidatorTest {
	
	@Test
	public void validarCampoVazio(){
		PessoaComException p = new PessoaComException();
		p.setNome("");
		List<Message> validar = null;
		try {
			validar = Validator.validar(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Message message : validar) {
			System.out.println(message.getMessage());
		}
	}
	

}
