package br.com.cdsl.validator.object;

import java.lang.annotation.Annotation;

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
import br.com.cdsl.validator.field.NonSpecialCharValidator;
import br.com.cdsl.validator.field.NotEmptyValidator;
import br.com.cdsl.validator.field.RangeValidator;
import br.com.cdsl.validator.field.SizeValidator;
import br.com.cdsl.validator.type.NotNullValidatorType;
import br.com.cdsl.validator.type.RollBackValidator;
import br.com.cdsl.validator.type.TriggerValidator;
import br.com.cdsl.validator.value.CNPJValidator;
import br.com.cdsl.validator.value.CPFValidator;
import br.com.cdsl.validator.value.DecimalValidator;
import br.com.cdsl.validator.value.EmailValidator;
import br.com.cdsl.validator.value.InscricaoEstadualValidator;
import br.com.cdsl.validator.value.IntValidator;

public class ValidatorFactory {
	
	
	
	public static BeanAnalyser getValidator(Object o, Annotation annotation){
		String name = annotation.annotationType().getSimpleName();
		
		Class<? extends Exception> exception = null;
		String messageException = null;
		
		if(NotNull.class.getSimpleName().equals(name)){
			NotNull simpleAnnotation = (NotNull) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new NotNullValidatorType(o, exception, messageException);
		} 
		
		if(NonSpecialChar.class.getSimpleName().equals(name)){
			NonSpecialChar simpleAnnotation = (NonSpecialChar) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new NonSpecialCharValidator(o, exception, messageException);
		} 
		if(NotEmpty.class.getSimpleName().equals(name)){
			NotEmpty simpleAnnotation = (NotEmpty) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new NotEmptyValidator(o, exception, messageException);
		
		} 
		if(Range.class.getSimpleName().equals(name)){
			Range simpleAnnotation = (Range) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new RangeValidator(o, exception, messageException);
		} 
		if(Size.class.getSimpleName().equals(name)){
			Size simpleAnnotation = (Size) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new SizeValidator(o, exception, messageException);
		} 
		
		if(RollBack.class.getSimpleName().equals(name)){
			RollBack simpleAnnotation = (RollBack) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new RollBackValidator(o, exception, messageException);
		} 
		if(Trigger.class.getSimpleName().equals(name)){
			Trigger simpleAnnotation = (Trigger) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new TriggerValidator(o, exception, messageException);
		} 
		
		if(CNPJ.class.getSimpleName().equals(name)){
			CNPJ simpleAnnotation = (CNPJ) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new CNPJValidator(o, exception, messageException);
		} 

		if(CPF.class.getSimpleName().equals(name)){
			CPF simpleAnnotation = (CPF) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new CPFValidator(o, exception, messageException);
		} 
		if(Decimal.class.getSimpleName().equals(name)){
			Decimal simpleAnnotation = (Decimal) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new DecimalValidator(o, exception, messageException);
		} 
		if(Email.class.getSimpleName().equals(name)){
			Email simpleAnnotation = (Email) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new EmailValidator(o, exception, messageException);
		} 
		if(InscricaoEstadual.class.getSimpleName().equals(name)){
			InscricaoEstadual simpleAnnotation = (InscricaoEstadual) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new InscricaoEstadualValidator(o, exception, messageException);
		} 
		if(Int.class.getSimpleName().equals(name)){
			Int simpleAnnotation = (Int) annotation;
			exception = simpleAnnotation.exception();
			messageException = simpleAnnotation.messageException();
			return new IntValidator(o, exception, messageException);
		} 
		
		
		return null;
	}
	

}
