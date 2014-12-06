package br.com.cdsl.validator.value;

import java.util.List;

import br.com.cdsl.validator.object.AbstractValidator;
import br.com.cdsl.validator.object.Message;

public class InscricaoEstadualValidator  extends AbstractValidator{

	public InscricaoEstadualValidator(Object o,
			Class<? extends Exception> exception, String messageException) {
		super(o, exception, messageException);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Message> validate(Object o,
			Class<? extends Exception> exception, String messageException)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
//TODO: Implementar validação de Inscrição Estadual
}
