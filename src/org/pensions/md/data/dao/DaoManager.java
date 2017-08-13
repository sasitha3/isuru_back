/*
 * Manage All DAOs
 */

package org.pensions.md.data.dao;

import org.pensions.md.data.interfaces.BankDao;
import org.pensions.md.data.interfaces.DSOfficeDao;
import org.pensions.md.data.interfaces.DistrictDao;
import org.pensions.md.data.interfaces.SalarayDao;
import org.pensions.md.data.interfaces.VillageOfficeDao;

public class DaoManager {

	public static SalarayDao salarayDao() {
		return new SalaryDaoImpl();
	}
	
	public static BankDao bankDao() {
		return new BankDaoImpl();
	}
	
	public static DistrictDao districtDao() {
		return new DistrictDaoImpl();
	}
	
	public static DSOfficeDao dsofficeDao() {
		return new DSOfficeDaoImpl();
	}
	
	public static VillageOfficeDao villageOfficeDao() {
		return new VillageOfficeDaoImpl();
	}
}
