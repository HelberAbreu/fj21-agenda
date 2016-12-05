package br.jus.tjdft.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.jus.tjdft.factory.ConnectionFactory;
import br.jus.tjdft.pojo.Contato;

@WebFilter("/*")
public class FiltroControleTransacao implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Abrindo conexao");
		Connection connection = ConnectionFactory.getConexao();
		
		request.setAttribute("conexao", connection);
		
		chain.doFilter(request, response);

		try {
			System.out.println("Fechando conexao");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	
}
