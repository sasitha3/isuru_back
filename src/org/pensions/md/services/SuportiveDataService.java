package org.pensions.md.services;

import java.util.List;

import org.pensions.md.data.dao.DaoManager;
import org.pensions.md.data.dao.VillageOfficeDaoImpl;
import org.pensions.md.data.interfaces.DSOfficeDao;
import org.pensions.md.data.interfaces.DistrictDao;
import org.pensions.md.data.interfaces.VillageOfficeDao;
import org.pensions.md.exceptions.DataNotFoundException;
import org.pensions.md.model.dto.DSOfficeDTO;
import org.pensions.md.model.dto.DistrictDTO;
import org.pensions.md.model.dto.VillageOfficeDTO;
import org.pensions.md.model.pojo.DSOffice;
import org.pensions.md.model.pojo.District;
import org.pensions.md.model.pojo.VillageOffice;
import org.pensions.md.model.response.lists.DSList;
import org.pensions.md.model.response.lists.DistrictList;
import org.pensions.md.model.response.lists.VillageOfficeList;

public class SuportiveDataService {
	
	/**
	 * get all Districts
	 * returns Districts
	 * @return
	 */
	public DistrictList getAllDistricts() {
		DistrictDao dao = DaoManager.districtDao();
		List<District> districts = dao.getDistricts();
		if(districts.isEmpty()) {		
			throw new DataNotFoundException("No District found");
		}
		DistrictList list = new DistrictList();
		districts.stream().forEach(district -> {
			DistrictDTO dto = new DistrictDTO();
			dto.setId(district.getId());
			dto.setName(district.getName());
			list.getList().add(dto);
		});
		return list;
	}
	
	/**
	 * get all DS Office
	 * returns DS Office
	 * @return
	 */
	public DSList getAllDsOffice(int districtId) {
		DSOfficeDao dao = DaoManager.dsofficeDao();
		List<DSOffice> dsoffices = dao.getDSOffice(districtId);
		if(dsoffices.isEmpty()) {		
			throw new DataNotFoundException("No banks found");
		}
		DSList list = new DSList();
		dsoffices.stream().forEach(dsoffice -> {
			DSOfficeDTO dto = new DSOfficeDTO();
			dto.setId(dsoffice.getId());
			dto.setName(dsoffice.getName());
			dto.setDsCode(dsoffice.getDsCode());
			list.getList().add(dto);
		});
		return list;
	}
	
	/**
	 * get all Districts
	 * returns Districts
	 * @return
	 */
	public VillageOfficeList getAllVillageOffice(int dsofficeId) {
		VillageOfficeDao dao = DaoManager.villageOfficeDao();
		List<VillageOffice> vo = dao.getVillageOffice(dsofficeId);
		if(vo.isEmpty()) {		
			throw new DataNotFoundException("No banks found");
		}
		VillageOfficeList list = new VillageOfficeList();
		vo.stream().forEach(vos -> {
			VillageOfficeDTO dto = new VillageOfficeDTO();
			dto.setId(vos.getId());
			dto.setName(vos.getName());
			list.getList().add(dto);
		});
		return list;
	}
	
	/**
	 * Get all details regarding the village office
	 * @param officeId
	 * @return
	 */
	public VillageOffice getVillageOfficeDetails(long officeId) {
		
		VillageOffice office = new VillageOfficeDaoImpl().getFullDetailsOf(officeId);
		
		if(office == null) {
			throw new DataNotFoundException("No details found for office id: " + officeId);
		}
	//currently the follow method is not working cause we haven't enter any service to get ds office
//		office.getDsOffice().setVillageOffices(null); //set null for the villageoffice list in ds object to make the json clear for the client
		
		return office;
	}
	
}
