package br.com.cdsl.annotations.value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * @author Cassio Lemos
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CPF {

	Class<? extends Exception> exception() default java.lang.Exception.class;
	String messageException() default "";
}
