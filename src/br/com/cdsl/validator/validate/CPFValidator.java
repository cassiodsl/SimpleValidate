package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
/**
 * 
 * @author Cassio Lemos
 *
 */
class CPFValidator extends AbstractValidator {

	public CPFValidator(Class<?> clazz, Annotation annotation, Field field,
			Object o, Class<? extends Exception> exception,
			String messageException) {
		super(clazz, annotation, field, o, exception, messageException);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Message> validate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	// TODO: Implementar validação de CPF com modulo do DV
}
