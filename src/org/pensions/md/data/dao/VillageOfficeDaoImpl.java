package org.pensions.md.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.pensions.md.data.interfaces.VillageOfficeDao;
import org.pensions.md.exceptions.MysqlException;
import org.pensions.md.model.pojo.DSOffice;
import org.pensions.md.model.pojo.VillageOffice;

public class VillageOfficeDaoImpl extends BaseDao implements VillageOfficeDao{

	private static final String ALL_VILLAGEOFFICE = "SELECT * FROM villeage_office where ds_id=?";
	private static final String VILLAGEOFFICE = "SELECT * FROM villeage_office where village_office_id=?";
	
	/* (non-Javadoc)
	 * @see org.pensions.md.data.dao.VillageOfficeDao#create(org.pensions.md.model.pojo.VillageOffice)
	 */
	@Override
	public VillageOffice create(VillageOffice s) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.pensions.md.data.dao.VillageOfficeDao#update(org.pensions.md.model.pojo.VillageOffice)
	 */
	@Override
	public VillageOffice update(VillageOffice s) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.pensions.md.data.dao.VillageOfficeDao#delete(org.pensions.md.model.pojo.VillageOffice)
	 */
	@Override
	public boolean delete(VillageOffice s) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.pensions.md.data.dao.VillageOfficeDao#get(long)
	 */
	@Override
	public List<VillageOffice> getVillageOffice(int dsofficeId) {
		Connection dbConn = getConnection();
		List<VillageOffice> vo = new ArrayList<VillageOffice>();
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(ALL_VILLAGEOFFICE);
			ps.setInt(1, dsofficeId);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				VillageOffice village = new VillageOffice();				
				village.setId(result.getInt(1));
				village.setName(result.getString(2));
				vo.add(village);
			}
			
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}

		return vo;
	}
	
	/* (non-Javadoc)
	 * @see org.pensions.md.data.dao.VillageOfficeDao#getFullDetailsOf(long)
	 */
	@Override
	public VillageOffice getFullDetailsOf(long officeId) {
		Connection dbConn = getConnection();
		VillageOffice office = new VillageOffice();
		DSOffice ds = new DSOffice();
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(VILLAGEOFFICE);
			ps.setLong(1, officeId);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				office.setId(result.getLong(1));
				office.setName(result.getString(2));
				ds = new DSOfficeDaoImpl().getDistrict(result.getLong(3));
				office.setDsOffice(ds);
			}
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}
		return office;
	}

	
}
