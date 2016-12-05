package br.jus.tjdft.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.jus.tjdft.logica.Logica;

@WebServlet(name="mvc", urlPatterns= {"/mvc"})
public class ControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String parametro = req.getParameter("logica");
		String nomeDaClasse = "br.jus.tjdft.logica."+parametro;
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			
			Logica logica = (Logica) classe.newInstance();
			
			String pagina = logica.executa(req, res);
			
			req.getRequestDispatcher(pagina).forward(req, res);
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
