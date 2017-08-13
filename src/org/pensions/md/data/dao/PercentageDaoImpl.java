package org.pensions.md.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.pensions.md.data.interfaces.PercentageDao;
import org.pensions.md.exceptions.MysqlException;
import org.pensions.md.model.pojo.Percentage;

public class PercentageDaoImpl extends BaseDao implements PercentageDao {
	
	private static final String GET_PERCENTAGE_1 = "SELECT 	reduced,unreduced,circular FROM percentages WHERE years=? AND "
																				+ "months=? AND "
																				+ "(? BETWEEN lowerlimit and upperlimit) AND " 
																				+ "circular=?";
	
	private static final String GET_PERCENTAGE_2 = "SELECT reduced,unreduced,circular FROM percentages WHERE years=? AND "
																				+ "months=? AND "
																				+ "(? BETWEEN lowerlimit and upperlimit) AND "
																				+ "circular=? AND "
																				+ "type=?";
	
	private static final String GET_PERCENTAGE_3 = "SELECT reduced,unreduced,circular FROM percentages WHERE years=? AND "
																				+ "offered_to=? AND "
																				+ "post=? AND "
																				+ "circular=?";
	
	public PercentageDaoImpl() { }

	/* 
	 * get percentages from database
	 */
	@Override
	public Percentage getPercentage(int years, int months, int salary, String circular) {
		Connection dbConn = getConnection();
		Percentage percentage = new Percentage();
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(GET_PERCENTAGE_1);
			ps.setInt(1, years);
			ps.setInt(2, months);
			ps.setInt(3, salary);
			ps.setString(4, circular);
			ResultSet result = ps.executeQuery();
			while(result.next()){
				percentage.setReduced(result.getInt(1));
				percentage.setUnreduced(result.getInt(2));
				percentage.setCircular(result.getString(3));
			}
			
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}
		return percentage;
		
	}
	
	/* 
	 * get percentages from database
	 */
	@Override
	public Percentage getPercentage(int years, int months, int salary, String circular, String type) {
		Connection dbConn = getConnection();
		Percentage percentage = new Percentage();
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(GET_PERCENTAGE_2);
			ps.setInt(1, years);
			ps.setInt(2, months);
			ps.setInt(3, salary);
			ps.setString(4, circular);
			ps.setString(5, type);
			ResultSet result = ps.executeQuery();
			while(result.next()){
				percentage.setReduced(result.getInt(1));
				percentage.setUnreduced(result.getInt(2));
				percentage.setCircular(result.getString(3));
			}
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}
		return percentage;
	}

	/* 
	 * get percentages from database
	 */
	@Override
	public Percentage getPercentage(int years, String offer, String post, String circular) {
		Connection dbConn = getConnection();
		Percentage percentage = new Percentage();
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(GET_PERCENTAGE_3);
			ps.setInt(1, years);
			ps.setString(2, offer);
			ps.setString(3, post);
			ps.setString(4, circular);
			ResultSet result = ps.executeQuery();
			while(result.next()){
				percentage.setReduced(result.getInt(1));
				percentage.setUnreduced(result.getInt(2));
				percentage.setCircular(result.getString(3));
			}
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}
		return percentage;
	}

}
