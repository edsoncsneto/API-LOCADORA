package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.GenericDao;
import model.entities.Veiculo;

public class VeiculoDaoJDBC implements GenericDao<Veiculo, String>{
	
	public Connection conn;
	
	public VeiculoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Veiculo obj) {
		PreparedStatement st = null;
		try {
			st=conn.prepareStatement(""
					+ "INSERT INTO veiculo "
					+ "(placa, cor, marca, categoria, chassi, modelo) "
					+ "VALUES (?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getPlaca());
			st.setString(2, obj.getCor());
			st.setString(3, obj.getMarca());
			st.setString(4, obj.getCategoria());
			st.setString(5, obj.getChassi());
			st.setString(6, obj.getModelo());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected==0) {
				throw new DbException("Unexpect error! No rows affected!");
			}
			
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Veiculo obj) {
		PreparedStatement st = null;
		try {
			st=conn.prepareStatement(""
					+ "UPDATE veiculo "
					+ "WHERE placa=? "
					+ "SET cor = ?, marca = ?, categoria = ?, chassi = ?, modelo =?");
			
			st.setString(1, obj.getPlaca());
			st.setString(2, obj.getCor());
			st.setString(3, obj.getMarca());
			st.setString(4, obj.getCategoria());
			st.setString(5, obj.getChassi());
			st.setString(6, obj.getModelo());
			st.executeUpdate();
			
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Veiculo findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
