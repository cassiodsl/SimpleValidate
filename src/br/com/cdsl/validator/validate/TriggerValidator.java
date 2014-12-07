package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

class TriggerValidator extends AbstractValidator {

	public TriggerValidator(Class<?> clazz, Annotation annotation, Field field,
			Object o, Class<? extends Exception> exception,
			String messageException) {
		super(clazz, annotation, field, o, exception, messageException);
	}

	@Override
	public List<Message> validate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	// TODO: Dispara uma classe apontada no atributo

}
