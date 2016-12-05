package br.jus.tjdft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.jus.tjdft.exception.DAOException;
import br.jus.tjdft.factory.ConnectionFactory;
import br.jus.tjdft.pojo.Contato;


public class ContatoDAO {
	
	private static final String SQL_INSERT = "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";
	private static final String SQL_DELETE = "delete from contatos where id = ?";
	private static final String SQL_SELECT_ID = "select * from contatos where id = ?";
	private static final String SQL_SELECT_NOME = "select * from contatos where nome like ?";
	private static final String SQL_SELECT = "select * from contatos ";
	private static final String SQL_UPDATE = "update contatos set nome = ?,  email = ?,  endereco= ?,  dataNascimento=? where id = ?";
	
	private Connection conexao;

	public ContatoDAO(Connection conexao) {
		this.conexao = conexao;
	}

//	public ContatoDAO() {
//		this.conexao = ConnectionFactory.getConexao();
//	}

	public boolean inserir(Contato contato){
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(SQL_INSERT);
			
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getEndereco());
			ps.setDate(4, new java.sql.Date(contato.getDataNascimento().getTime().getTime()));

			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}	
	}
	
	public boolean atualizar(Contato contato){
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(SQL_UPDATE);
			
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getEndereco());
			ps.setDate(4, new java.sql.Date(contato.getDataNascimento().getTime().getTime()));
			ps.setLong(5, contato.getId());

			return ps.execute();

		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}	
	}
	
	public boolean remover(Contato contato){
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(SQL_DELETE);
			
			ps.setLong(1, contato.getId());

			return ps.execute();

		} catch (SQLException e) {
			throw new DAOException(e);
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}	
	}
	
	private Contato getContato(ResultSet rs) throws Exception{
		Contato contato = new Contato();
		Calendar data =  new GregorianCalendar();

		contato.setId(rs.getLong("id"));
		contato.setNome(rs.getString("nome"));
		contato.setEndereco(rs.getString("endereco"));
		contato.setEmail(rs.getString("email"));
		data.setTime(rs.getDate("dataNascimento"));
		
		contato.setDataNascimento(data);
		
		return contato;
	}
	
	public Contato buscarContato(Long id){
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement(SQL_SELECT_ID);
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return getContato(rs);
			}
		} catch (Exception e) {
			throw new DAOException(e);
		}finally{
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return null;
	}

	
	public List<Contato> buscarContatos(String nome){
		List<Contato> contatosList = new ArrayList<Contato>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conexao.prepareStatement(SQL_SELECT_NOME);
			
			ps.setString(1, "%"+nome+"%");
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				contatosList.add(getContato(rs));
			}
			rs.close();

			return contatosList;

		} catch (Exception e) {
			throw new DAOException(e);
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}	
	}

	public List<Contato> buscarContatos(){
		List<Contato> contatosList = new ArrayList<Contato>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conexao.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				contatosList.add(getContato(rs));
			}
			return contatosList;

		} catch (Exception e) {
			throw new DAOException(e);
		}finally{
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}	
	}

}
