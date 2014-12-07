package br.com.cdsl.validator.object;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import br.com.cdsl.validator.validate.Message;
import br.com.cdsl.validator.validate.Validator;

class RangeValidatorTest {

	@Test
	public void testarRangeNumerico(){
		
		Valor valor = new Valor();
		valor.setBigDecimal(new BigDecimal(0.1));
		
		
		valor.setIntValue(2);
		
		
		
		List<Message> validar = null;
		try {
			validar = Validator.validar(valor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Message message : validar) {
			System.out.println(message.getMessage());
		}
		
	}
	
}
