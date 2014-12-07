package br.com.cdsl.annotations.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.cdsl.annotations.exception.NonException;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NonSpecialChar {

	/**
	 * Remove todos os caracteres especiais exceto esses
	 * 
	 */
	String except() default "";
	/**
	 * 
	 * exception Exception
	 */
	Class<? extends Exception> exception() default NonException.class;
	/**
	 * 
	 * messageException
	 */
	String messageException() default "";
}
