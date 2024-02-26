package model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import model.entities.Funcionario;

public class FuncionarioService {
	
	public static Funcionario instatiateFuncionario(ResultSet rs) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf(rs.getString("cpf"));
		funcionario.setMatricula(rs.getInt("matricula"));
		funcionario.setNome(rs.getString("nome"));
		funcionario.setQuantidade_locacoes(rs.getInt("quantidade_locacoes"));
		return funcionario;
	}
	
	public static boolean verifyCpf(String cpf, Connection conn) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT cpf FROM funcionario");
			rs = st.executeQuery();
			
			while(rs.next()) {
				if (cpf.equals(rs.getString("cpf"))) {
					return false;
				}
			}
			return true;
			
		} catch (SQLException e) {
			throw new DbException("Erro ao verificar CPFs da base de dados!");
			
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

}
