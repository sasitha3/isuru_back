package org.pensions.md.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.pensions.md.exceptions.MysqlException;
import org.pensions.md.data.interfaces.DistrictDao;
import org.pensions.md.model.pojo.District;

public class DistrictDaoImpl extends BaseDao implements DistrictDao {

	private static final String ALL_DISTRICTS = "SELECT * FROM district";
	private static final String DISTRICT_OFFICE = "SELECT * FROM district where district_id=?";

	/**
	 * get districts from the database
	 */	
	@Override
	public List<District> getDistricts() {
		Connection dbConn = getConnection();
		List<District> districts = new ArrayList<District>();
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(ALL_DISTRICTS);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				District dis = new District();				
				dis.setId(result.getInt(1));
				dis.setName(result.getString(2));
				districts.add(dis);
			}
			
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}

		return districts;
	}
	
	/*
	 * Get district details
	 */
	public District getDistrict(int id){
		District district = new District();
		Connection dbConn = getConnection();
		
		try{
			PreparedStatement ps = dbConn.prepareStatement(DISTRICT_OFFICE);
			ps.setLong(1, id);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				district.setId(result.getInt(1));
				district.setName(result.getString(2));
			}
		} catch(Exception e){
		
			throw new MysqlException(e);
		
		} finally{
			closeConnection(dbConn);
		
		}
		return district;
	}
}
