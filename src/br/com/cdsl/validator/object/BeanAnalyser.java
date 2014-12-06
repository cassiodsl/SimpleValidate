package br.com.cdsl.validator.object;

import java.util.List;

public interface BeanAnalyser {

	public List<Message> validate() throws Exception;
}
