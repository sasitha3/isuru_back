package org.pensions.md.data.interfaces;

import java.util.List;

import org.pensions.md.model.pojo.VillageOffice;

public interface VillageOfficeDao {

	VillageOffice create(VillageOffice s);

	VillageOffice update(VillageOffice s);

	boolean delete(VillageOffice s);

	List<VillageOffice> getVillageOffice(int dsofficeId);

	VillageOffice getFullDetailsOf(long officeId);

}