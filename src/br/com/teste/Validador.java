package br.com.teste;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.cdsl.annotations.field.NotEmpty;
import br.com.cdsl.annotations.field.NotNull;

public class Validador {

	
	public static List<String> validar(Object obj) {
		 
        List<String> erros = new ArrayList<String>();
        Class<?> classe = obj.getClass();
 
        for (Field f : classe.getDeclaredFields()) {
 
            f.setAccessible(true);
 
            if (f.isAnnotationPresent(NotNull.class)) {
            	//VALIDAR_TAMANHO_TEXTO(f, obj);
            	try {
					if(f.get(obj)==null){
						erros.add("Campo '" + f.getName() + "' vazio");
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
