package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
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
	
	
	public AbstractValidator(Class<?> clazz, Annotation annotation, Field field, Object object, Class<? extends Exception> exception, String messageException) {
		this.clazz = clazz;
		this.annotation = annotation;
		this.field = field;
		this.object = object;
		this.exception = exception;
		this.messageException = messageException;

	}

	public abstract List<Message> validate() throws Exception;
}
