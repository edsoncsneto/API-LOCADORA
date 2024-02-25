package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.GenericDao;
import model.entities.Cliente;
import service.ClienteService;

public class ClienteDaoJDBC implements GenericDao<Cliente, String>{
	
	public Connection conn;
	
	public ClienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Cliente obj) {

		PreparedStatement st = null;
		try {
			st=conn.prepareStatement(
					"INSERT INTO cliente "
					+ "(cpf, nome, cnh, bairro, numero, logradouro, cidade, uf, cep) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			st.setString(1, obj.getCpf());
			st.setString(2, obj.getNome());
			st.setString(3, obj.getCnh());
			st.setString(4, obj.getBairro());
			st.setString(5, obj.getNumero());
			st.setString(6, obj.getLogradouro());
			st.setString(7, obj.getCidade());
			st.setString(8, obj.getUf());
			st.setString(9, obj.getCep());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected==0) {
				throw new DbException("Unexpect error! No rows affected!");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Cliente obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE cliente "
					+ "SET nome = ?, cnh = ?, bairro = ?, numero = ?, logradouro = ?, cidade = ? "
					+ "WHERE cpf = ?");
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCnh());
			st.setString(3, obj.getBairro());
			st.setString(4, obj.getNumero());
			st.setString(5, obj.getLogradouro());
			st.setString(6, obj.getCidade());
			st.setString(7, obj.getCpf());
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(String id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"DELETE FROM cliente "
					+ "WHERE cpf = ?");
			
			st.setString(1, id);
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected==0) {
				throw new DbException("Não há nenhum cliente com esse CPF");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Cliente findById(String id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM cliente "
					+ "WHERE cpf = ?");
			
			st.setString(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				return ClienteService.instatiateCliente(rs);
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
	public List<Cliente> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM cliente");
			
			rs = st.executeQuery();
			List<Cliente> list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(ClienteService.instatiateCliente(rs));
			}
			
			return list;
			
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

}
