package br.com.cdsl.validator.object;

import java.util.List;

public abstract class AbstractValidator implements BeanAnalyser {
	
	private Object o;
	private Class<? extends Exception> exception;
	private String messageException;
	
	public AbstractValidator(Object o, Class<? extends Exception> exception, String messageException) {
		this.o = o;
		this.exception = exception;
		this.messageException = messageException;

	}

	public List<Message> validate() throws Exception{
		return validate(this.o, this.exception, this.messageException);
	}
	public abstract List<Message> validate(Object o, Class<? extends Exception> exception, String messageException) throws Exception;
}
