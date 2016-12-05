package br.jus.tjdft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.jus.tjdft.exception.DAOException;
import br.jus.tjdft.pojo.Funcionario;


public class FuncionarioDAO {
	
	private static final String SQL_INSERT = "insert into funcionarios (nome, usuario, senha) values (?,?,?)";
	private static final String SQL_DELETE = "delete from funcionarios where id = ?";
	private static final String SQL_SELECT_ID = "select * from funcionarios where id = ?";
	private static final String SQL_SELECT_NOME = "select * from funcionarios where nome like ?";
	private static final String SQL_SELECT = "select * from funcionarios ";
	private static final String SQL_UPDATE = "update funcionarios set nome = ?,  usuario = ?,  senha= ? where id = ?";
	
	private Connection conexao;
	
	public FuncionarioDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public boolean inserir(Funcionario funcionario){
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(SQL_INSERT);
			
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getUsuario());
			ps.setString(3, funcionario.getSenha());

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
	
	public boolean atualizar(Funcionario funcionario){
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(SQL_UPDATE);
			
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getSenha());
			ps.setString(3, funcionario.getUsuario());

			ps.setLong(4, funcionario.getId());

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
	
	public boolean remover(Funcionario funcionario){
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(SQL_DELETE);
			
			ps.setLong(1, funcionario.getId());

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
	
	private Funcionario getFuncionario(ResultSet rs) throws Exception{
		Funcionario funcionario = new Funcionario();

		funcionario.setId(rs.getLong("id"));
		funcionario.setNome(rs.getString("nome"));
		funcionario.setUsuario(rs.getString("usuario"));
		funcionario.setSenha(rs.getString("senha"));
		
		return funcionario;
	}
	
	public Funcionario buscarFuncionario(Long id){
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement(SQL_SELECT_ID);
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return getFuncionario(rs);
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

	
	public List<Funcionario> buscarFuncionarios(String nome){
		List<Funcionario> funcionariosList = new ArrayList<Funcionario>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conexao.prepareStatement(SQL_SELECT_NOME);
			
			ps.setString(1, "%"+nome+"%");
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				funcionariosList.add(getFuncionario(rs));
			}
			rs.close();

			return funcionariosList;

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

	public List<Funcionario> buscarFuncionarios(){
		List<Funcionario> funcionariosList = new ArrayList<Funcionario>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conexao.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				funcionariosList.add(getFuncionario(rs));
			}
			return funcionariosList;

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
