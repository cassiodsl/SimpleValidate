package br.com.teste;

import java.util.List;

import br.com.cdsl.validator.field.NotNullValidatorField;
import br.com.cdsl.validator.object.Validator;

public class Start {

	public static void main(String[] args) {

		Pessoa p = new Pessoa();
		p.setNome(null);

		List<String> validar;
		try {
			validar = Validator.validar(p);
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		
	}

}
