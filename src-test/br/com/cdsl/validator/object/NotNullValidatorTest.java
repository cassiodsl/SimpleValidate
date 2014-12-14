package br.com.cdsl.validator.object;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.cdsl.validator.validate.Message;
import br.com.cdsl.validator.validate.Validator;

public class NotNullValidatorTest{

	public NotNullValidatorTest() {
		super();
	}

	@Test
	public void notNullDeveAcionarException(){
		
		PessoaComException p = new PessoaComException();
		p.setNome(null);

		boolean excecaoCorreta = false;
		String mensagemRetorno = "";
		try {
			Validator.validate(p);
		}catch (Exception x){
			excecaoCorreta = true;
			mensagemRetorno = x.getMessage();
			x.printStackTrace();
		}
		
		assertEquals(excecaoCorreta && mensagemRetorno.equals("br.com.cdsl.validator.object.PessoaComException.nome: Campo obrigatorio não preenchido"), true);
	}
	
	@Test
	public void notNullNaoDeveAcionarException(){
		
		PessoaComException p = new PessoaComException();
		p.setNome("Cássio");

		boolean excecaoCorreta = false;
		try {
			Validator.validate(p);
		}catch (CampoVazioException x){
			excecaoCorreta = true;
			x.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		assertEquals(!excecaoCorreta, true);
	}
	
	@Test
	public void notNullNaoDeveAcionarExceptionERetornarListaErros(){
		
		PessoaSemException p = new PessoaSemException();
		p.setNome(null);

		boolean excecaoCorreta = false;
		List<Message> validar = null;
		try {
			validar = Validator.validate(p);
		}catch (CampoVazioException x){
			excecaoCorreta = true;
			x.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		for (Message message : validar) {
			System.out.println(message.getMessage());
		}
		
		assertEquals(!excecaoCorreta && (validar!=null&&!validar.isEmpty()), true);
	}
	
	@Test
	public void notNullNaoDeveAcionarExceptionENaoRetornarListaErros(){
		
		PessoaSemException p = new PessoaSemException();
		p.setNome("Cassio");
		Endereco endereco = new Endereco();
		endereco.setRua("Teste");
		p.setEndereco(endereco);

		boolean excecaoCorreta = false;
		List<Message> validar = null;
		try {
			validar = Validator.validate(p);
		}catch (CampoVazioException x){
			excecaoCorreta = true;
			x.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		

		
		assertEquals(!excecaoCorreta && (validar!=null&&validar.isEmpty()), true);
	}
	
	public void testNotNullWithNotEmptyImplicitNotOk(){
		
		PessoaTest pessoa = new PessoaTest();
		StringBuilder strBuilder = new StringBuilder();
		try {
			List<Message> validate = Validator.validate(pessoa);
			for (Message message : validate) {
				strBuilder.append(message.getMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String str = strBuilder.toString();
		boolean containsValid1 = !str.contains("Validação_1");//erro
		boolean containsValid2 = !str.contains("Validação_2");//erro
		boolean containsValid3 = str.contains("Validação_3");//ok
		boolean containsValid4 = str.contains("Validação_4");//ok
		
		Assert.assertEquals(containsValid1 && containsValid2 && containsValid3 && containsValid4, true);
		
	}
	
	
	
}
