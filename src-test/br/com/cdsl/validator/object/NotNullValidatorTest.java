package br.com.cdsl.validator.object;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.cdsl.validator.validate.Validator;

public class NotNullValidatorTest{

	@Test
	public void notNullDeveAcionarException(){
		
		PessoaComException p = new PessoaComException();
		p.setNome(null);

		boolean excecaoCorreta = false;
		String mensagemRetorno = "";
		try {
			Validator.validar(p);
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
			Validator.validar(p);
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
			validar = Validator.validar(p);
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
			validar = Validator.validar(p);
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
	
}
