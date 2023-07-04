package service;

import java.util.List;

public interface IService<T, E> {
	List<T> getAll();
	
	void save(T element);
	
	void delete(E id);
	
	T findById(E id);
	
	E getNewId();
}
