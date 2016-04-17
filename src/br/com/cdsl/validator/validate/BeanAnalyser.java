package br.com.cdsl.validator.validate;

import java.util.List;
/**
 * 
 * @author Cassio Lemos
 *
 */
interface BeanAnalyser {

	public List<Message> validate(boolean throwsException) throws Exception;
}
