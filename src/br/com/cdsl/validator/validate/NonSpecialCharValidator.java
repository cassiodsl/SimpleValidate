package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.cdsl.annotations.field.NonSpecialChar;
/**
 * 
 * @author Cassio Lemos
 *
 */
class NonSpecialCharValidator extends AbstractValidator {

	public NonSpecialCharValidator(Class<?> clazz, Annotation annotation,
			Field field, Object o, Class<? extends Exception> exception,
			String messageException) {
		super(clazz, annotation, field, o, exception, messageException);
	}

	@Override
	public List<Message> validate() throws Exception {
		String rules = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789 ";

		List<Message> mensagens = new ArrayList<Message>();

		field.setAccessible(true);

		NonSpecialChar nonSpecialChar = (NonSpecialChar) annotation;
		String except = nonSpecialChar.except();

		try {
			if (object == null) {
				return mensagens;
			}
			String localString = object.toString();

			for (char c : localString.toCharArray()) {
				String str = new Character(c).toString();
				if (!rules.contains(str) && !except.contains(str)) {
					whenValueIsNotValid(mensagens);
				}
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
