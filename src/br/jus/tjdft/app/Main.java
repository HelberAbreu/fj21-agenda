package br.jus.tjdft.app;
import java.sql.Connection;
import java.util.GregorianCalendar;

import br.jus.tjdft.dao.ContatoDAO;
import br.jus.tjdft.factory.ConnectionFactory;
import br.jus.tjdft.pojo.Contato;


public class Main {
	
	public static void main(String[] args) {		
		Connection conexao = ConnectionFactory.getConexao();
		System.out.println("Conetado com sucesso!");
		
		ContatoDAO contatoDAO = new ContatoDAO(conexao);
		
//		Contato contato = new Contato();
//
//		contato.setNome("Helber de Oliveira Abreu");
//		contato.setEmail("hehelber@gmail.com");
//		contato.setEndereco("QNL 14");
//		contato.setDataNascimento(new GregorianCalendar());
//		
//		contatoDAO.inserir(contato);
		
		for(Contato c : contatoDAO.buscarContatos("Abreu")){
			System.out.println(c);
		}

		
		try{
			conexao.close();			
		}catch(Exception e){
			System.out.println("Erro ao fechar conexao!!");
		}
	}

}
