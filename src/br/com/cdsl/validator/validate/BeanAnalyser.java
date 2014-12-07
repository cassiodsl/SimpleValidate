package br.com.cdsl.validator.validate;

import java.util.List;

interface BeanAnalyser {

	public List<Message> validate() throws Exception;
}
