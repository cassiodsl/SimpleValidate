package br.com.cdsl.validator.type;

import java.util.List;

import br.com.cdsl.validator.object.AbstractValidator;
import br.com.cdsl.validator.object.Message;

public class TriggerValidator  extends AbstractValidator {

	public TriggerValidator(Object o, Class<? extends Exception> exception,
			String messageException) {
		super(o, exception, messageException);
	}

	@Override
	public List<Message> validate(Object o,
			Class<? extends Exception> exception, String messageException)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	//TODO: Dispara uma classe apontada no atributo

}
