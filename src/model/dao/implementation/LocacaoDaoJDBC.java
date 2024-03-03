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
import model.entities.Locacao;
import model.service.LocacaoService;

public class LocacaoDaoJDBC implements GenericDao<Locacao, Integer>{
	
	private Connection conn;
	
	public LocacaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Locacao obj) {
		PreparedStatement st = null;
//		PreparedStatement st2 = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO locacao "
					+ "(data_inicio, data_fim, cpf_cliente, mat_funcionario) "
					+ "VALUES (?, ?, ?, ?); ",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getDataFim().toString());
			st.setString(2, obj.getDataFim().toString());
			st.setString(3, obj.getCliente().getCpf());
			st.setInt(4, obj.getFuncionario().getMatricula());
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected>0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					obj.setCodLocacao(rs.getInt(1));
					DB.closeResultSet(rs);
				}
			
				PreparedStatement st2 = conn.prepareStatement(
						"UPDATE funcionario "
						+ "SET quantidade_locacoes = quantidade_locacoes+1 "
						+ "WHERE matricula = ?;");
				st2.setInt(1, obj.getFuncionario().getMatricula());
				st2.executeUpdate();
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
	public void update(Locacao obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE locacao "
					+ "SET data_inicio = ?, data_fim = ?, cpf_cliente = ?, mat_funcionario = ? "
					+ "WHERE cod_locacao = ?;");
			
			st.setString(1, obj.getDataInicio().toString());
			st.setString(2, obj.getDataFim().toString());
			st.setString(3, obj.getCliente().getCpf());
			st.setInt(4, obj.getFuncionario().getMatricula());
			st.setInt(5, obj.getCodLocacao());
			st.executeUpdate();
			
		} catch (SQLException e) {
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
					"DELETE FROM locacao "
					+ "WHERE cod_locacao = ?;");
			st.setInt(1, id);
			
			PreparedStatement st2 = conn.prepareStatement(
					"DELETE FROM locacao_veiculo WHERE cod_locacao = ?;");
			
			st2.setInt(1, id);
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected==0) {
				throw new DbException("Não há nenhuma locação com esse código!");
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Locacao findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM locacao "
					+ "WHERE cod_locacao = ?;");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				return LocacaoService.instatiateLocacao(rs);
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
	public List<Locacao> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM locacao;");
			
			rs = st.executeQuery();
			List<Locacao> list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(LocacaoService.instatiateLocacao(rs));
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
