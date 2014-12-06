package br.com.cdsl.validator.object;

import java.util.List;

public abstract class AbstractValidator {

	public abstract List<Message> validate(Object o);
	
}
