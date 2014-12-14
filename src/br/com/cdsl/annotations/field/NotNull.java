package br.com.cdsl.annotations.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.cdsl.annotations.exception.NonException;
/**
 * 
 * @author Cassio Lemos
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface NotNull{
	
	Class<? extends Exception> exception() default NonException.class;
	String messageException() default "";
	/**
	 * Quando um valor for considerado vazio � poss�vel selecionar se ser� considerado nulo, ser� como adicionar {@link NotEmpty} ao objeto.
	 * @return
	 */
	boolean emptyIsNull() default false;
}
