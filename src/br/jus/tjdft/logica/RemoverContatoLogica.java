package br.jus.tjdft.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.jus.tjdft.dao.ContatoDAO;
import br.jus.tjdft.pojo.Contato;

public class RemoverContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ContatoDAO dao = new ContatoDAO(((Connection)req.getAttribute("conexao")));
		
		Contato c = new Contato();
		
		try{
			c.setId(Long.parseLong(req.getParameter("id")));			

			dao.remover(c);
			List<Contato> list = dao.buscarContatos();
			
			req.setAttribute("contatos", list);
		}catch(Exception e){
			e.printStackTrace();
			return "erro.jsp";
		}
		
		return "lista-contatos-jstl-2.jsp";
	}

}
