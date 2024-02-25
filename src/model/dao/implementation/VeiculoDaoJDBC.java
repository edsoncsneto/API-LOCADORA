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
import model.entities.Veiculo;
import service.VeiculoService;

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
					+ "VALUES (?,?,?,?,?,?)");
			
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
					+ "SET cor = ?, marca = ?, categoria = ?, chassi = ?, modelo =? "
					+ "WHERE placa=?");
			
			st.setString(1, obj.getCor());
			st.setString(2, obj.getMarca());
			st.setString(3, obj.getCategoria());
			st.setString(4, obj.getChassi());
			st.setString(5, obj.getModelo());
			st.setString(6, obj.getPlaca());
			st.executeUpdate();
			
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void deleteById(String id) {
		PreparedStatement st = null;
		try {
			st=conn.prepareStatement(
					"DELETE FROM veiculo "
					+ "WHERE placa = ?");
			
			st.setString(1, id);
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected==0) {
				throw new DbException("Não há nenhum veículo com essa placa no sistema");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Veiculo findById(String id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * "
					+ "FROM veiculo "
					+ "WHERE placa = ?;");
			
			st.setString(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				return VeiculoService.instatiateVeiculo(rs);
			}
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Veiculo> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Veiculo> list = new ArrayList<>();
		
		try {
			st = conn.prepareStatement("SELECT * FROM veiculo");
			rs = st.executeQuery();
			
			while (rs.next()) {
				list.add(VeiculoService.instatiateVeiculo(rs));
			}
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
