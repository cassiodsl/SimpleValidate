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
public class Validator {

	/**
	 * 
	 * @param obj Objeto a ser validado
	 * @return List {@link Message}
	 * @throws Exception
	 */
	public static List<Message> validate(Object obj) throws Exception {

		List<Message> erros = new ArrayList<Message>();
		Class<?> clazz = obj.getClass();

		// Analisar atributos
		fieldAnalyse(obj, erros, clazz);

		return erros;
	}

	private static void annotationsAnalyseField(Field field, Object obj,
			List<Message> erros, List<Annotation> listAnnotations, Class<?> clazz)
			throws Exception {
		for (Annotation annotation : listAnnotations) {
			if(!annotation.annotationType().getName().startsWith("br.com.cdsl.")){
				continue;
			}
			BeanAnalyser validator = ValidatorFactory.getValidator(clazz, field, obj,
					annotation);
			List<Message> mensagensErro = validator.validate();
			if (mensagensErro != null) {
				for (Message message : mensagensErro) {
					erros.add(message);
				}
			}
		}
	}

	private static void fieldAnalyse(Object obj, List<Message> erros,
			Class<?> clazz) throws Exception {
		for (Field f : clazz.getDeclaredFields()) {
			f.setAccessible(true);
			Annotation[] fieldAnnotation = f.getAnnotations();
			List<Annotation> listAnnotations = new ArrayList<Annotation>();
			for (Annotation annotation : fieldAnnotation) {
				listAnnotations.add(annotation);
			}
			for (Annotation annotation : obj.getClass().getAnnotations()) {
				listAnnotations.add(annotation);
			}
			annotationsAnalyseField(f, f.get(obj), erros, listAnnotations, clazz);
			//Não entrar no Enum
			if(f.getType().isEnum()){
				return;
			}

			if (!f.getType().getName().startsWith("java") && f.get(obj) != null) {
				fieldAnalyse(f.get(obj), erros, f.getType());
			}
		}
	}

}
