package br.com.cdsl.validator.object;

public class ValidateMessage implements Message {

	private boolean validate;
	private String message;

	@Override
	public boolean isValidate() {
		return validate;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
