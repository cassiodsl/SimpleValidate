package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Cassio Lemos
 *
 */
class NotEmptyValidator extends AbstractValidator {

	public NotEmptyValidator(Class<?> clazz, Annotation annotation,
			Field field, Object o, Class<? extends Exception> exception,
			String messageException) {
		super(clazz, annotation, field, o, exception, messageException);
	}

	@Override
	public List<Message> validate() throws Exception {
		List<Message> mensagens = new ArrayList<Message>();

		field.setAccessible(true);

		try {
			boolean notValid = false;

			if (object instanceof String) {
				if ("".equals(object)) {
					notValid = true;
				}
			} else if (object instanceof Collection<?>) {
				Collection<?> list = (Collection<?>) object;
				if (list.isEmpty()) {
					notValid = true;
				}
			} else if (object instanceof Object[]) {
				Object[] list = (Object[]) object;
				if (list.length < 1) {
					notValid = true;
				}
			}

			if (notValid) {
				whenValueIsNotValid(mensagens);
			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

		return mensagens;
	}

}
