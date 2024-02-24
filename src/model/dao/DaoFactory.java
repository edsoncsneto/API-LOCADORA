package model.dao;

import db.DB;
import model.dao.implementation.VeiculoDaoJDBC;

public class DaoFactory {
	
	public static GenericDao createVeiculoDao() {
		return new VeiculoDaoJDBC(DB.getConnection());
	}

}
