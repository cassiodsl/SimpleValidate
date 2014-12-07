package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.cdsl.annotations.exception.NonException;
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
		List<Message> mensagens = new ArrayList<Message>();

		field.setAccessible(true);
		String strField = field.getName();
		String mensagem = clazz.getName() + "." + strField + ": " + messageException;
		try {
			if (object == null) {
				if (!exception.getName().equals(NonException.class.getName())) {
					Constructor<? extends Exception> constructor = exception
							.getConstructor(String.class);

					Exception e = constructor.newInstance(mensagem);
					throw e;
				}
				ValidateMessage vm = new ValidateMessage(false, mensagem);
				mensagens.add(vm);
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
