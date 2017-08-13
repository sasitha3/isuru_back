package org.pensions.md.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.pensions.md.data.interfaces.DSOfficeDao;
import org.pensions.md.exceptions.MysqlException;
import org.pensions.md.model.pojo.DSOffice;
import org.pensions.md.model.pojo.District;

public class DSOfficeDaoImpl extends BaseDao implements DSOfficeDao {
	private static final String ALL_DSOFFICE = "SELECT * FROM ds_office where district_id=?";
	private static final String DS_OFFICE = "SELECT * FROM ds_office where ds_id=?";
	
	/* 
	 * List of DS office
	 * @param districtId
	 */
	@Override
	public List<DSOffice> getDSOffice(int districtId) {
		Connection dbConn = getConnection();
		List<DSOffice> dsoffice = new ArrayList<DSOffice>();
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(ALL_DSOFFICE);
			ps.setInt(1, districtId);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				DSOffice dis = new DSOffice();				
				dis.setId(result.getInt(1));
				dis.setName(result.getString(2));
				dis.setDsCode(result.getInt(4));
				dsoffice.add(dis);
			}
			
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}

		return dsoffice;
	}
	
	/*
	 * Get DS Office 
	 */
	public DSOffice getDistrict(long id){
		DSOffice ds = new DSOffice();
		Connection dbConn = getConnection();
		
		District district = new District();
		try{
			PreparedStatement ps = dbConn.prepareStatement(DS_OFFICE);
			ps.setLong(1, id);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				ds.setId(result.getLong(1));
				ds.setName(result.getString(2));
				district = new DistrictDaoImpl().getDistrict(result.getInt(3));
				ds.setDistrict(district);
				ds.setDsCode(result.getInt(4));
				ds.setVillageOffices(null);
			}
		} catch(Exception e){
		
			throw new MysqlException(e);
		
		} finally{
			closeConnection(dbConn);
		
		}
		return ds;
	}
}
