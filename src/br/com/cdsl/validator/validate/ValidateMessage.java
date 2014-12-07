package br.com.cdsl.validator.validate;

class ValidateMessage implements Message {

	private boolean validate;
	private String message;
	
	

	public ValidateMessage(boolean validate, String message) {
		super();
		this.validate = validate;
		this.message = message;
	}

	@Override
	public boolean isValidate() {
		return validate;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
