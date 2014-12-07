package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.cdsl.annotations.exception.NonException;
import br.com.cdsl.annotations.field.Size;
/**
 * 
 * @author Cassio Lemos
 *
 */
class SizeValidator extends AbstractValidator {

	public SizeValidator(Class<?> clazz, Annotation annotation, Field field,
			Object o, Class<? extends Exception> exception,
			String messageException) {
		super(clazz, annotation, field, o, exception, messageException);
	}

	@Override
	public List<Message> validate() throws Exception {
		List<Message> mensagens = new ArrayList<Message>();

		field.setAccessible(true);
		String strField = field.getName();
		String mensagem = clazz.getName() + "." + strField + ": "
				+ messageException;

		Size sizeAnnotation = (Size) annotation;
		int max = sizeAnnotation.max();
		int min = sizeAnnotation.min();

		try {
			if (object == null) {
				return mensagens;
			}
			boolean notValid = false;
			if (object instanceof String) {
				String localString = object.toString();
				if (localString.length() > max || localString.length() < min) {
					notValid = true;
				}
			} else if (object instanceof Collection<?>) {
				Collection<?> list = (Collection<?>) object;
				if (list.size() > max || list.size() < min) {
					notValid = true;
				}
			} else if (object instanceof Object[]) {
				Object[] array = (Object[]) object;
				if (array.length > max || array.length < min) {
					notValid = true;
				}
			}

			if (notValid) {
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
