package br.com.cdsl.validator.field;

import java.util.List;

import br.com.cdsl.validator.object.AbstractValidator;
import br.com.cdsl.validator.object.Message;

public class NotEmptyValidator  extends AbstractValidator{

	public NotEmptyValidator(Object o, Class<? extends Exception> exception,
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

}
