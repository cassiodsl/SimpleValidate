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
}
