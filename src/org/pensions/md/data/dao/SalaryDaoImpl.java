package org.pensions.md.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.pensions.md.exceptions.MysqlException;
import org.pensions.md.data.interfaces.SalarayDao;
import org.pensions.md.model.pojo.Salary;

public class SalaryDaoImpl extends BaseDao implements SalarayDao {
	
	private static final String SALARY_1 = "SELECT * FROM salary where scale=? AND basic_salary=?";
	private static final String SALARY_2 = "SELECT * FROM salary where scale=? AND step=?";
	private static final String SALARY_3 = "SELECT * FROM salary where scale=?";
	
	/*
	 * method 1 to get the salary
	 */
	@Override
	public Salary getSalary(String code, double salary) {
		Connection dbConn = getConnection();
		try {
			PreparedStatement ps = dbConn.prepareStatement(SALARY_1);
			ps.setString(1, code);
			ps.setDouble(2, salary);
			ResultSet result = ps.executeQuery();
			while(result.next()){
				System.out.println(result.getDouble(2));
			}
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}
		Salary sal = new Salary();
		
		return sal;
	}//how to implement code for salary

	/*
	 * method 2 to get the salary
	 */
	@Override
	public Salary getSalary(String code, int step) {
		Connection dbConn = getConnection();
		try {
			PreparedStatement ps = dbConn.prepareStatement(SALARY_2);
			ps.setString(1, code);
			ps.setInt(2, step);
			ResultSet result = ps.executeQuery();
			while(result.next()){
				System.out.println(result.getDouble(2));
			}
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}
		Salary sal = new Salary();
		
		return sal;
		
	}

	/*
	 * method 3 to get the salary
	 */
	@Override
	public Salary getFinalSalaryStep(String code) {
		Connection dbConn = getConnection();
		try {
			PreparedStatement ps = dbConn.prepareStatement(SALARY_3);
			ps.setString(1, code);
			
			ResultSet result = ps.executeQuery();
			while(result.next()){
				System.out.println(result.getDouble(2));
			}
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}
		Salary sal = new Salary();
		
		return sal;
		
	}

	/*
	 * get all slaries according to the code
	 * @param code
	 */
	@Override
	public List<Salary> getSalaries(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
