package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

class CNPJValidator extends AbstractValidator {

	public CNPJValidator(Class<?> clazz, Annotation annotation, Field field,
			Object o, Class<? extends Exception> exception,
			String messageException) {
		super(clazz, annotation, field, o, exception, messageException);
	}

	@Override
	public List<Message> validate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	// TODO: Implementar validador de CNPJ com modulo DV
}
