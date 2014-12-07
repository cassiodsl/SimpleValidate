package br.com.cdsl.annotations.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.cdsl.validator.validate.AbstractTrigger;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Trigger{

	/*
	 * Como trigger do banco
	 * usar padrao Observer
	 */
	
	Class<? extends AbstractTrigger> clazz();
	Class<? extends Exception> exception() default java.lang.Exception.class;
	String messageException() default "";
}

