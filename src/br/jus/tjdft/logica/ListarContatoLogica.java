package br.jus.tjdft.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.jus.tjdft.dao.ContatoDAO;
import br.jus.tjdft.pojo.Contato;

public class ListarContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		ContatoDAO dao = new ContatoDAO(((Connection)req.getAttribute("conexao")));
		
		Long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();
		
		try{
		 	contato = dao.buscarContato(id);
			
			req.setAttribute("contato", contato);

		}catch(Exception e){
			e.printStackTrace();
			return "erro.jsp";
		}
		
		return "altera-contato.jsp";
	}

}
