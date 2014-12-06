package br.com.cdsl.annotations.value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.cdsl.validator.object.NonException;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Int {

	Class<? extends Exception> exception() default NonException.class;
	String messageException() default "";
}
