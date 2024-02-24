package model.dao;

import java.util.List;

public interface GenericDao<T, K> {
	//T se refere ao tipo de classe que vai implementar, e K se refere ao tipo do ID da classe
	
	void insert(T obj);
	void update(T obj);
	void deleteById(K id);
	T findById(K id);
	List<T> findAll();

}
