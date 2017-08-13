package org.pensions.md.data.interfaces;

import java.util.List;

import org.pensions.md.model.pojo.DSOffice;

public interface DSOfficeDao {

	/**
	 * retrive districts from the database
	 */

	List<DSOffice> getDSOffice(int districtId);

}