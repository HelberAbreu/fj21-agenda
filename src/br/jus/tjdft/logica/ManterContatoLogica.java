package br.jus.tjdft.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.jus.tjdft.dao.ContatoDAO;
import br.jus.tjdft.pojo.Contato;
import br.jus.tjdft.util.Util;

public class ManterContatoLogica implements Logica{
	

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ContatoDAO dao = new ContatoDAO(((Connection)req.getAttribute("conexao")));
		
		Contato contato = new Contato();
		
		try{
			GregorianCalendar gc = new GregorianCalendar();
			
			try {
				gc.setTime(Util.parse(req.getParameter("dtNascimento")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			String id = req.getParameter("id");
			
			if(id != null){
				contato.setId(Long.parseLong(id));
			}
			contato.setNome(req.getParameter("nome"));
			contato.setEmail(req.getParameter("email"));
			contato.setEndereco(req.getParameter("endereco"));
			contato.setDataNascimento(gc);
			
			if(contato.getId() == null){
				dao.inserir(contato);
			}else{
				dao.atualizar(contato);
			}
			List<Contato> list = dao.buscarContatos();
			
			req.setAttribute("contatos", list);
			
		}catch(Exception e){
			e.printStackTrace();
			return "erro.jsp";
		}
		
		return "lista-contatos-jstl-2.jsp";
	}

}
