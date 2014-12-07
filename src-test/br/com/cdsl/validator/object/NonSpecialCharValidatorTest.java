package br.com.cdsl.validator.object;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.cdsl.validator.validate.Message;
import br.com.cdsl.validator.validate.Validator;

class NonSpecialCharValidatorTest {
	
	@Test
	public void naoAceitarCharEspecial(){
		
		PessoaComException p = new PessoaComException();
		p.setNome("Cássio");
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
		Assert.assertEquals(!validar.isEmpty(), true);
		
	}

}
