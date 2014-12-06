package br.com.cdsl.validator.object;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import br.com.cdsl.annotations.field.NotEmpty;
import br.com.cdsl.annotations.field.NotNull;
import br.com.cdsl.validator.type.NotNullValidatorType;

public class Validator {

	public static List<String> validar(Object obj) throws Throwable {

		List<String> erros = new ArrayList<String>();
		Class<?> clazz = obj.getClass();
		
		Annotation[] annotations = clazz.getAnnotations();
		
		//Class annotations
		for (Annotation annotation : annotations) {
			System.out.println(annotation.annotationType().getName());
			//fabrica de validadores
			//saber o que vou precisar pra por na abstract
			
			//annotation, aqui tenho as variaveis pra lançar a exceção
			
			List<Message> validate = new NotNullValidatorType().validate(obj);
			
			//verificar se o retorno está validado
			//jogar mensagem pra fora (local)
			
			Method[] declaredFields = annotation.annotationType().getMethods();
			try {
				Method methodException = annotation.annotationType().getMethod("exception", null);
				System.out.println(methodException.getName());
			} catch (Exception e) {
				throw new MethodNotFoundException("method 'exception()' not found in " + annotation.annotationType().getName());
			}
			
			for (Method method : declaredFields) {
				
				if (method.getName().equals("exception") || method.getName().equals("messageException") ) {
					Object invoke = method.invoke(annotation, null);
					System.out.println("return: " + invoke);
				}
				
			}
			
			
			
		}

		for (Field f : clazz.getDeclaredFields()) {

			f.setAccessible(true);

			if (f.isAnnotationPresent(NotNull.class)) {
				// VALIDAR_TAMANHO_TEXTO(f, obj);
				try {
					if (f.get(obj) == null) {
						erros.add("Campo '" + f.getName() + "' vazio");
						NotNull annotation = f.getAnnotation(NotNull.class);
						Class<? extends Throwable> exception = annotation
								.exception();
						Constructor<? extends Throwable> constructor = exception
								.getConstructor(String.class);
						String strClasse = clazz.getName();
						String strField = f.getName();
						Throwable e = constructor.newInstance(strClasse + "."
								+ strField + ": "
								+ annotation.messageException());
						throw e;
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			if (f.isAnnotationPresent(NotEmpty.class)) {
				erros.add("A encontrada");
			}
		}

		return erros;
	}

}
