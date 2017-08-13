package org.pensions.md.data.dao;

public interface DAO<S>{
	
	public S create(S s);
	public S update(S s);
	public boolean delete(S s);
	public S get(long id);
	
}

abstract class DaoImplAbstract<T> implements DAO<T>{
	
	public DaoImplAbstract() {
		
	}
	
}