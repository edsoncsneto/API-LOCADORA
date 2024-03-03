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
import model.entities.TelefoneCliente;
import model.service.TelefoneClienteService;

public class TelefoneClienteDaoJDBC implements GenericDao<TelefoneCliente, String>{
	
	public Connection conn;

	public TelefoneClienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(TelefoneCliente obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO telefone_cliente "
					+ "(cpf_cliente, telefone) "
					+ "VALUES (?, ?);");
			
			st.setString(1, obj.getCliente().getCpf());
			st.setString(2, obj.getTelefone());
			
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
	public void update(TelefoneCliente obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE telefone_cliente "
					+ "SET telefone = ? "
					+ "WHERE cpf_cliente = ?;");
			
			st.setString(1, obj.getTelefone());
			st.setString(2, obj.getCliente().getCpf());
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
					"DELETE FROM telefone_cliente "
					+ "WHERE cpf_cliente = ?;");
			
			st.setString(1, id);
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected==0) {
				throw new DbException("Não há nenhum cliente com esse CPF!");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public TelefoneCliente findById(String id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * from telefone_cliente "
					+ "WHERE cpf_cliente = ?;");
			st.setString(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				return TelefoneClienteService.instatiateTelefoneCliente(rs);
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
	public List<TelefoneCliente> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM telefone_cliente;");
			
			rs = st.executeQuery();
			List<TelefoneCliente> list = new ArrayList<>();
			while(rs.next()) {
				list.add(TelefoneClienteService.instatiateTelefoneCliente(rs));
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
