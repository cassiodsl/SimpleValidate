package br.com.cdsl.annotations.type;

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
@Target(ElementType.TYPE)
public @interface RollBack {

	/*
	 * Padrão Memento
	 */
	int qty() default 1;
	Class<? extends Exception> exception() default java.lang.Exception.class;
	String messageException() default "";
}
