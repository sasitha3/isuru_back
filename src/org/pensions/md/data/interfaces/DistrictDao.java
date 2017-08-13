package org.pensions.md.data.interfaces;

import java.util.List;

import org.pensions.md.model.pojo.District;

public interface DistrictDao {

	/**
	 *get all districts
	 * @return
	 */
	List<District> getDistricts();

}