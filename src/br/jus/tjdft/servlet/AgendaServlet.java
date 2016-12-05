package br.jus.tjdft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.jws.soap.InitParam;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.jus.tjdft.dao.ContatoDAO;
import br.jus.tjdft.factory.ConnectionFactory;
import br.jus.tjdft.pojo.Contato;
import br.jus.tjdft.util.Util;


@WebServlet(name="agenda", urlPatterns= {"/agenda"})
public class AgendaServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Inicializando servelt");
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8348292911790775047L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		ContatoDAO dao = new ContatoDAO(ConnectionFactory.getConexao());
		
		Contato contato = new Contato();


		GregorianCalendar gc = new GregorianCalendar();
		

		gc.setTime(Util.parse(req.getParameter("dtNascimento")));
		
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		contato.setDataNascimento(gc);

		PrintWriter pw = res.getWriter();
		
//		if(dao.inserir(contato)){
//			pw.println("<html>");
//			pw.println("<body>");
//			pw.println(++count);
//			pw.println("</body>");
//			pw.println("</html>");
//		}else{
//			pw.println("<html>");
//			pw.println("<body>");
//			pw.println("Erro!!!");
//			pw.println("</body>");
//			pw.println("</html>");
//			
//		}
		dao.inserir(contato);
		
		RequestDispatcher rd = req.getRequestDispatcher("/lista-contatos-jstl.jsp");
		
//		req.setAttribute("teste", "HElber Abreu!");
		
		rd.forward(req, res);
		
//		res.sendRedirect("/agenda/lista-contatos.jsp");
	}
	
	

}
