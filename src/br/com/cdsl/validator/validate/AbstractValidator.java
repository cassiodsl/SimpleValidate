package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.cdsl.annotations.exception.NonException;
/**
 * 
 * @author Cassio Lemos
 *
 */
abstract class AbstractValidator implements BeanAnalyser {
	
	protected Object object;
	protected Class<? extends Exception> exception;
	protected String messageException;
	protected Annotation annotation;
	protected Field field;
	protected Class<?> clazz;
	private BeanAnalyser beanAnalyser;
	
	
	public AbstractValidator(Class<?> clazz, Annotation annotation, Field field, Object object, Class<? extends Exception> exception, String messageException) {
		this.clazz = clazz;
		this.annotation = annotation;
		this.field = field;
		this.object = object;
		this.exception = exception;
		this.messageException = messageException;

	}
	
	public void setBeanAnalyser(BeanAnalyser beanAnalyser) {
		this.beanAnalyser = beanAnalyser;
	}


	/**
	 * Lança a Exception indicada e adiciona o erro na lista de mensagens
	 * @param messages
	 * @return
	 * @throws Exception
	 */
	protected List<Message> whenValueIsNotValid(List<Message> messages) throws Exception{
		field.setAccessible(true);
		String strField = field.getName();
		StringBuilder strMessage = new StringBuilder();
		strMessage.append(clazz.getName());
		strMessage.append(".");
		strMessage.append(strField);
		strMessage.append(": ");
		strMessage.append(messageException);
		
		
		if (object!=null) {
			strMessage.append("; ");
			if (object instanceof String) {
				strMessage.append(object);
			} else if (object instanceof Collection<?>) {
				strMessage.append("{");
				Collection<?> list = (Collection<?>) object;
				boolean isFirst = true;
				for (Object object : list) {
					if (isFirst) {
						strMessage.append("[");
					}else{
						strMessage.append(", [");
					}
					strMessage.append(object);
					strMessage.append("]");
					
					isFirst = false;
				}
				strMessage.append("}");
			} else if (object instanceof Object[]) {
				Object[] array = (Object[]) object;
				boolean isFirst = true;
				for (Object object : array) {
					if (isFirst) {
						strMessage.append("[");
					}else{
						strMessage.append(", [");
					}
					strMessage.append(object);
					strMessage.append("]");
					
					isFirst = false;
				}
				strMessage.append("}");
			}else{
				strMessage.append(object);
			}
		}
		if (!exception.getName().equals(NonException.class.getName())) {
			Constructor<? extends Exception> constructor = exception
					.getConstructor(String.class);

			Exception e = constructor.newInstance(strMessage.toString());
			throw e;
		}
		ValidateMessage vm = new ValidateMessage(false, strMessage.toString());
		messages.add(vm);
		return messages;
	}

	public List<Message> validate() throws Exception{
		List<Message> messages = new ArrayList<Message>();
		if(beanAnalyser!=null){
			messages = beanAnalyser.validate();
		}
		List<Message> thisMessages = startValidate();
		messages.addAll(thisMessages);
		return messages;
	}
	
	protected abstract List<Message> startValidate() throws Exception;
	
}
