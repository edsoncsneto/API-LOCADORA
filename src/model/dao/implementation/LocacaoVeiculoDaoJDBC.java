package model.dao.implementation;

import java.sql.Connection;
import java.util.List;

import model.dao.GenericDao;
import model.entities.LocacaoVeiculo;

public class LocacaoVeiculoDaoJDBC implements GenericDao<LocacaoVeiculo, Integer>{
	
	private Connection conn;
	
	public LocacaoVeiculoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(LocacaoVeiculo obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LocacaoVeiculo obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LocacaoVeiculo findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocacaoVeiculo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
