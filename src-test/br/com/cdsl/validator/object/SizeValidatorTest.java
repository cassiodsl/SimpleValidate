package br.com.cdsl.validator.object;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.cdsl.validator.validate.Message;
import br.com.cdsl.validator.validate.Validator;

public class SizeValidatorTest {
	
	public SizeValidatorTest() {
		super();
	}

	@Test
	public void tamanhoMaxEMinStringOK() {
		Endereco r = buildEnderecoOk();

		List<Message> listaErros = null;
		try {
			listaErros = Validator.validate(r);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (listaErros!=null) {
			for (Message message : listaErros) {
				System.out.println(message.getMessage());
			}
		}
		Assert.assertEquals(listaErros!=null && listaErros.isEmpty(), true);
	}



	private Endereco buildEnderecoOk() {
		Endereco r = new Endereco();
		r.setRua("12");
		List<String> contatos = new ArrayList<String>();
		contatos.add("Teste1");
		contatos.add("Teste2");
		r.setContatos(contatos);
		String[] nomes = new String[] { "Cassio", "Lemos" };
		r.setNomes(nomes);
		return r;
	}

	private Endereco buildEnderecoNotOk() {
		Endereco r = new Endereco();
		r.setRua("1234567891011");
		List<String> contatos = new ArrayList<String>();
		contatos.add("Teste1");
		contatos.add("Teste2");
		contatos.add("Teste2");
		contatos.add("Teste2");
		contatos.add("Teste2");
		contatos.add("Teste2");
		contatos.add("Teste2");
		contatos.add("Teste2");
		contatos.add("Teste2");
		contatos.add("Teste2");
		contatos.add("Teste2");
		r.setContatos(contatos);
		String[] nomes = new String[] { "Cassio", "Lemos", "Lemos", "Lemos",
				"Lemos", "Lemos", "Lemos", "Lemos", "Lemos", "Lemos", "Lemos" };
		r.setNomes(nomes);
		return r;
	}

	@Test
	public void tamanhoMaxEMinStringNotOK() {
		Endereco r = buildEnderecoNotOk();

		List<Message> listaErros = null;
		try {
			listaErros = Validator.validate(r);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (listaErros!=null) {
			for (Message message : listaErros) {
				System.out.println(message.getMessage());
			}
		}
		Assert.assertEquals(listaErros != null && listaErros.size() == 3, true);
	}

}
