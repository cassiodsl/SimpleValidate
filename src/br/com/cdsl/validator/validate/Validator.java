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
	
	private static boolean throwsException;

	/**
	 * 
	 * @param obj Objeto a ser validado
	 * @return List {@link Message}
	 * @throws Exception
	 */
	public static List<Message> validate(Object obj) throws Exception {

		List<Message> erros = new ArrayList<Message>();
		Class<?> type = obj.getClass();

		// Analisar atributos
		fieldAnalyse(obj, erros, type, throwsException);

		return erros;
	}
	
	/**
	 * 
	 * @param obj Objeto a ser validado
	 * @param lancar Exceção
	 * @return List {@link Message}
	 * @throws Exception
	 */
	public static List<Message> validate(Object obj, boolean throwsException) throws Exception {
		List<Message> erros = new ArrayList<Message>();
		Class<?> type = obj.getClass();

		// Analisar atributos
		fieldAnalyse(obj, erros, type, throwsException);

		return erros;
	}

	private static void annotationsAnalyseField(Field field, Object obj,
			List<Message> erros, List<Annotation> listAnnotations, Class<?> type, boolean throwsException)
			throws Exception {
		for (Annotation annotation : listAnnotations) {
			if(!annotation.annotationType().getName().startsWith("br.com.cdsl.")){
				continue;
			}
			BeanAnalyser validator = ValidatorFactory.getValidator(type, field, obj,
					annotation);
			List<Message> mensagensErro = validator.validate(throwsException);
			if (mensagensErro != null) {
				for (Message message : mensagensErro) {
					erros.add(message);
				}
			}
		}
	}

	private static void fieldAnalyse(Object obj, List<Message> erros,
			Class<?> type, boolean throwsException) throws Exception {
		for (Field f : type.getDeclaredFields()) {
			f.setAccessible(true);
			Annotation[] fieldAnnotation = f.getAnnotations();
			List<Annotation> listAnnotations = new ArrayList<Annotation>();
			for (Annotation annotation : fieldAnnotation) {
				listAnnotations.add(annotation);
			}
			for (Annotation annotation : obj.getClass().getAnnotations()) {
				listAnnotations.add(annotation);
			}
			annotationsAnalyseField(f, f.get(obj), erros, listAnnotations, type, throwsException);
			//Não entrar no Enum
			if(f.getType().isEnum()){
				continue;
			}

			if (!f.getType().getName().startsWith("java") && f.get(obj) != null) {
				fieldAnalyse(f.get(obj), erros, f.getType(), throwsException);
			}
		}
	}

}
