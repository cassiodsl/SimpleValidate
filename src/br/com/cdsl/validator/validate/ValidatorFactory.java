package br.com.cdsl.validator.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import br.com.cdsl.annotations.field.NonSpecialChar;
import br.com.cdsl.annotations.field.NotEmpty;
import br.com.cdsl.annotations.field.NotNull;
import br.com.cdsl.annotations.field.Range;
import br.com.cdsl.annotations.field.Size;
import br.com.cdsl.annotations.type.RollBack;
import br.com.cdsl.annotations.type.Trigger;
import br.com.cdsl.annotations.value.CNPJ;
import br.com.cdsl.annotations.value.CPF;
import br.com.cdsl.annotations.value.Decimal;
import br.com.cdsl.annotations.value.Email;
import br.com.cdsl.annotations.value.InscricaoEstadual;
import br.com.cdsl.annotations.value.Int;
/**
 * 
 * @author Cassio Lemos
 *
 */
class ValidatorFactory {
	
	
	
	public static BeanAnalyser getValidator(Class<?> clazz, Field field, Object o, Annotation annotation){
		String name = annotation.annotationType().getSimpleName();
		
		Class<? extends Exception> exception = null;
		String messageException = null;
		
		if(NotNull.class.getSimpleName().equals(name)){
			NotNull simpleAnnotation = (NotNull) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			NotNullValidatorType notNullValidatorType = new NotNullValidatorType(clazz, annotation, field, o, exception, messageException);
			if(simpleAnnotation.emptyIsNull()){
				notNullValidatorType.setBeanAnalyser( new NotEmptyValidator(clazz, annotation, field, o, exception, messageException));
			}
			return notNullValidatorType;
		} 
		
		if(NonSpecialChar.class.getSimpleName().equals(name)){
			NonSpecialChar simpleAnnotation = (NonSpecialChar) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new NonSpecialCharValidator(clazz, annotation, field, o, exception, messageException);
		} 
		if(NotEmpty.class.getSimpleName().equals(name)){
			NotEmpty simpleAnnotation = (NotEmpty) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new NotEmptyValidator(clazz, annotation, field, o, exception, messageException);
		
		} 
		if(Range.class.getSimpleName().equals(name)){
			Range simpleAnnotation = (Range) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new RangeValidator(clazz, annotation, field, o, exception, messageException);
		} 
		if(Size.class.getSimpleName().equals(name)){
			Size simpleAnnotation = (Size) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new SizeValidator(clazz, annotation, field, o, exception, messageException);
		} 
		
		if(RollBack.class.getSimpleName().equals(name)){
			RollBack simpleAnnotation = (RollBack) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new RollBackValidator(clazz, annotation, field, o, exception, messageException);
		} 
		if(Trigger.class.getSimpleName().equals(name)){
			Trigger simpleAnnotation = (Trigger) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new TriggerValidator(clazz, annotation, field, o, exception, messageException);
		} 
		
		if(CNPJ.class.getSimpleName().equals(name)){
			CNPJ simpleAnnotation = (CNPJ) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new CNPJValidator(clazz, annotation, field, o, exception, messageException);
		} 

		if(CPF.class.getSimpleName().equals(name)){
			CPF simpleAnnotation = (CPF) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new CPFValidator(clazz, annotation, field, o, exception, messageException);
		} 
		if(Decimal.class.getSimpleName().equals(name)){
			Decimal simpleAnnotation = (Decimal) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new DecimalValidator(clazz, annotation, field, o, exception, messageException);
		} 
		if(Email.class.getSimpleName().equals(name)){
			Email simpleAnnotation = (Email) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new EmailValidator(clazz, annotation, field, o, exception, messageException);
		} 
		if(InscricaoEstadual.class.getSimpleName().equals(name)){
			InscricaoEstadual simpleAnnotation = (InscricaoEstadual) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new InscricaoEstadualValidator(clazz, annotation, field, o, exception, messageException);
		} 
		if(Int.class.getSimpleName().equals(name)){
			Int simpleAnnotation = (Int) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new IntValidator(clazz, annotation, field, o, exception, messageException);
		} 
		
		
		return null;
	}
	

}
