package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.cdsl.annotations.exception.NonException;
import br.com.cdsl.annotations.field.Range;

class RangeValidator extends AbstractValidator {

	public RangeValidator(Class<?> clazz, Annotation annotation, Field field,
			Object o, Class<? extends Exception> exception,
			String messageException) {
		super(clazz, annotation, field, o, exception, messageException);
	}

	public List<Message> validate() throws Exception {
		List<Message> mensagens = new ArrayList<Message>();

		Range annotationField = (Range) annotation;
		String max = annotationField.max();
		String min = annotationField.min();

		field.setAccessible(true);
		String strClasse = clazz.getName();
		String strField = field.getName();
		String mensagem = strClasse + "." + strField + ": " + messageException;
		try {
			// Object local = f.get(o);
			// TODO; implementar comparator
			if ((max.contains("/") || max.contains("-"))
					|| (min.contains("/") || min.contains("-"))) {
				// tipo data
				throw new UnsupportedOperationException("Versao alpha, não aceita tipo Data");

			} else if (max.contains(".") || min.contains(".")) {
				// tipo decimal
				double intMax = Double.parseDouble(max);
				double intMin = Double.parseDouble(min);
				Number number = (Number) object;
				if (number.doubleValue() > intMax
						|| number.doubleValue() < intMin) {
					if (!exception.getName().equals(
							NonException.class.getName())) {
						Constructor<? extends Exception> constructor = exception
								.getConstructor(String.class);

						Exception e = constructor.newInstance(mensagem);
						throw e;
					}
					ValidateMessage vm = new ValidateMessage(false, mensagem);
					mensagens.add(vm);
				}
			} else {
				int intMax = Integer.parseInt(max);
				int intMin = Integer.parseInt(min);
				Number number = (Number) object;
				if (number.intValue() > intMax || number.intValue() < intMin) {
					if (!exception.getName().equals(
							NonException.class.getName())) {
						Constructor<? extends Exception> constructor = exception
								.getConstructor(String.class);

						Exception e = constructor.newInstance(mensagem);
						throw e;
					}
					ValidateMessage vm = new ValidateMessage(false, mensagem);
					mensagens.add(vm);
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
