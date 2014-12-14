package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Cassio Lemos
 *
 */
class NotNullValidatorType extends AbstractValidator {

	public NotNullValidatorType(Class<?> clazz, Annotation annotation,
			Field field, Object o, Class<? extends Exception> exception,
			String messageException) {
		super(clazz, annotation, field, o, exception, messageException);
	}

	@Override
	public List<Message> validate() throws Exception {
		List<Message> messages = new ArrayList<Message>();

		field.setAccessible(true);
		try {
			if (object == null) {
				whenValueIsNotValid(messages);
			}
		} catch (Exception e) {
			throw e;
		} 

		return messages;
	}

}
