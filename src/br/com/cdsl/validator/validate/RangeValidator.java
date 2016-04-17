package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import br.com.cdsl.annotations.exception.NonException;
import br.com.cdsl.annotations.field.Range;

/**
 * 
 * @author Cassio Lemos
 *
 */
class RangeValidator extends AbstractValidator {

	public RangeValidator(Class<?> clazz, Annotation annotation, Field field,
			Object o, Class<? extends Exception> exception,
			String messageException) {
		super(clazz, annotation, field, o, exception, messageException);
	}

	public List<Message> startValidate() throws Exception {
		List<Message> mensagens = new ArrayList<Message>();

		Range annotationField = (Range) annotation;
		String max = annotationField.max();
		String min = annotationField.min();

		field.setAccessible(true);
		String strClasse = type.getName();
		String strField = field.getName();
		String mensagem = strClasse + "." + strField + ": " + messageException;
		try {
			// Object local = f.get(o);
			// TODO: implementar comparator
			Number number = (Number) object;
			//TODO: Ao habilitar a função data, validar tipo do objeto "object"
			if(number==null){
				whenValueIsNotValid(mensagens);
				return mensagens;
			}
			if ((max.contains("/") || max.contains("-"))
					|| (min.contains("/") || min.contains("-"))) {
				// tipo data
				throw new UnsupportedOperationException(
						"Versao alpha, não aceita tipo Data");

			} else if (max.contains(".") || min.contains(".")) {
				// tipo decimal
				double intMax = Double.parseDouble(max);
				double intMin = Double.parseDouble(min);
				if (number.doubleValue() > intMax
						|| number.doubleValue() < intMin) {
					whenValueIsNotValid(mensagens);
				}
			} else {
				if("".equals(max) && !"".equals(min)){
					//só minímo
					int intMin = Integer.parseInt(min);
					if (number.intValue() < intMin) {
						whenValueIsNotValid(mensagens);
					}	
				}else if (!"".equals(max) && "".equals(min)){
					//só máximo
					int intMax = Integer.parseInt(max);
					if (number.intValue() > intMax) {
						whenValueIsNotValid(mensagens);
					}
				}else if (!"".equals(max) && !"".equals(min)){
					//minímo e máximo
					int intMin = Integer.parseInt(min);
					int intMax = Integer.parseInt(max);
					if (number.intValue() > intMax || number.intValue() < intMin) {
						whenValueIsNotValid(mensagens);
					}
				}else{
					//não há como validar, retornar erro de validação para usuário
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
