package br.com.cdsl.validator.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.cdsl.annotations.field.NotEmpty;
import br.com.cdsl.annotations.field.NotNull;

public class NotNullValidatorField {

	public static List<String> validar(Object obj) throws Throwable{
		 
        List<String> erros = new ArrayList<String>();
        Class<?> classe = obj.getClass();
 
        for (Field f : classe.getDeclaredFields()) {
 
            f.setAccessible(true);
 
            if (f.isAnnotationPresent(NotNull.class)) {
            	//VALIDAR_TAMANHO_TEXTO(f, obj);
            	try {
					if(f.get(obj)==null){
						erros.add("Campo '" + f.getName() + "' vazio");
						NotNull annotation = f.getAnnotation(NotNull.class);
						Class<? extends Throwable> exception = annotation.exception();
						Constructor<? extends Throwable> constructor = exception.getConstructor(String.class);
						String strClasse = classe.getName();
						String strField = f.getName();
						Throwable e = constructor.newInstance(strClasse + "." + strField + ": " + annotation.messageException());
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
