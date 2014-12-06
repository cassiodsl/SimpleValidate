package br.com.cdsl.validator.type;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.cdsl.validator.object.AbstractValidator;
import br.com.cdsl.validator.object.Message;
import br.com.cdsl.validator.object.NonException;
import br.com.cdsl.validator.object.ValidateMessage;


public class NotNullValidatorType extends AbstractValidator{

	public NotNullValidatorType(Object o, Class<? extends Exception> exception,
			String messageException) {
		super(o, exception, messageException);
	}

	@Override
	public List<Message> validate(Object o, Class<? extends Exception> exception, String messageException) throws Exception {
		Class<?> clazz = o.getClass();
		List<Message> mensagens = new ArrayList<Message>();
		for (Field f : clazz.getDeclaredFields()) {

			f.setAccessible(true);
			String strClasse = clazz.getName();
			String strField = f.getName();
			String mensagem = strClasse + "."
					+ strField + ": "
					+ messageException;
			try {
				if (f.get(o) == null) {
					if(!exception.getName().equals(NonException.class.getName())){
						Constructor<? extends Exception> constructor = exception
								.getConstructor(String.class);
						
						Exception e = constructor.newInstance(mensagem);
						throw e;
					}
					ValidateMessage vm = new ValidateMessage(false, mensagem);
					mensagens.add(vm);
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		return mensagens;
	}


	
}
