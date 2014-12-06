package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import br.com.cdsl.validator.object.BeanAnalyser;
import br.com.cdsl.validator.object.Message;
import br.com.cdsl.validator.object.ValidatorFactory;

public class Validator {

	public static List<Message> validar(Object obj) throws Exception {

		List<Message> erros = new ArrayList<Message>();
		Class<?> clazz = obj.getClass();

		Annotation[] classAnnotations = clazz.getAnnotations();

		// Analisar classes
		annotationsAnalyse(obj, erros, classAnnotations);

		// Analisar atributos
		fieldAnalyse(obj, erros, clazz);

		// Analisar metodos
		for (Method method : clazz.getMethods()) {

			method.setAccessible(true);
			Annotation[] methodAnnotations = method.getAnnotations();
			annotationsAnalyse(obj, erros, methodAnnotations);
		}

		return erros;
	}

	private static void annotationsAnalyse(Object obj, List<Message> erros,
			Annotation[] classAnnotations) throws Exception {
		for (Annotation annotation : classAnnotations) {
			BeanAnalyser validator = ValidatorFactory.getValidator(obj,
					annotation);
			List<Message> mensagensErro = validator.validate();
			if (mensagensErro != null) {
				erros.addAll(mensagensErro);
			}
		}
	}

	private static void fieldAnalyse(Object obj, List<Message> erros,
			Class<?> clazz) throws Exception {
		for (Field f : clazz.getDeclaredFields()) {
			f.setAccessible(true);
			Annotation[] fieldAnnotation = f.getAnnotations();
			annotationsAnalyse(obj, erros, fieldAnnotation);
			if (f.get(obj) != null) {
				fieldAnalyse(f.get(obj), erros, f.getType());
			}
		}
	}

}
