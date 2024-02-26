package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.GenericDao;
import model.entities.Funcionario;
import model.service.FuncionarioService;

public class FuncionarioDaoJDBC implements GenericDao<Funcionario, Integer> {
	
	public Connection conn;
	
	public FuncionarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Funcionario obj) {
		
		if(!FuncionarioService.verifyCpf(obj.getCpf(), conn)) {
			throw new DbException("Já há um funcionário cadastrado com esse CPF!");
		}
		
		PreparedStatement st = null;
		try {		
			st = conn.prepareStatement(
					"INSERT INTO funcionario "
					+ "(nome, cpf, quantidade_locacoes) "
					+ "VALUES (?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setInt(3, obj.getQuantidade_locacoes());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected>0) {
				ResultSet rs = st.getGeneratedKeys(); //pega a matricula gerada
				if(rs.next()) {
					obj.setMatricula(rs.getInt(1)); //seta a matricula no objeto (é auto_increment no banco)
				}
				DB.closeResultSet(rs);
				
			} else {
				throw new DbException("Erro inesperado! Nenhuma linha afetada no banco!");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Funcionario obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE funcionario "
					+ "SET nome = ?, cpf = ?, quantidade_locacoes = ? "
					+ "WHERE matricula = ?");
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setInt(3, obj.getQuantidade_locacoes());
			st.setInt(4, obj.getMatricula());
			st.executeUpdate();
			
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"DELETE FROM funcionario "
					+ "WHERE matricula = ?");
			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();
			if(rowsAffected==0) {
				throw new DbException("Não há nenhum funcionario com essa matricula!");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Funcionario findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM funcionario "
					+ "WHERE matricula = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				return FuncionarioService.instatiateFuncionario(rs);
			}
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Funcionario> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM funcionario");
			rs = st.executeQuery();
			List<Funcionario> list = new ArrayList<Funcionario>();
			
			while(rs.next()) {
				list.add(FuncionarioService.instatiateFuncionario(rs));
			}
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

}
