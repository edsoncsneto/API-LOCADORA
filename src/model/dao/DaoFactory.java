package model.dao;

import db.DB;
import model.dao.implementation.ClienteDaoJDBC;
import model.dao.implementation.FuncionarioDaoJDBC;
import model.dao.implementation.LocacaoDaoJDBC;
import model.dao.implementation.TelefoneClienteDaoJDBC;
import model.dao.implementation.VeiculoDaoJDBC;

public class DaoFactory {
	
	public static GenericDao createVeiculoDao() {
		return new VeiculoDaoJDBC(DB.getConnection());
	}
	
	public static GenericDao createClienteDao() {
		return new ClienteDaoJDBC(DB.getConnection());
	}

	public static GenericDao createFuncionarioDao() {
		return new FuncionarioDaoJDBC(DB.getConnection());
	}
	
	public static GenericDao createTelefoneClienteDao() {
		return new TelefoneClienteDaoJDBC(DB.getConnection());
	}
	
	public static GenericDao createLocacaoDao() {
		return new LocacaoDaoJDBC(DB.getConnection());
	}
	
}
