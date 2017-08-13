package org.pensions.md.services;

import org.pensions.md.data.dao.PercentageDaoImpl;
import org.pensions.md.data.interfaces.PercentageDao;
import org.pensions.md.exceptions.DataNotFoundException;
import org.pensions.md.model.pojo.Percentage;

public class PercentageService {
	
	/*
	 * percentage service 
	 */
	public Percentage getPercentage(int years, int months, double salary, String circular) {
		PercentageDao dao = new PercentageDaoImpl();
		if(years < 25) months = 0;
		Percentage p = dao.getPercentage(years <= 25 ? 25 : years , months < 6 ? 0 : 6, (int)salary, circular);
		
		if(p == null) {
			throw new DataNotFoundException("No percentage details found");
		}
		return p;
	}
	
	/*
	 * percentage service 
	 */
	public Percentage getPercentage(int years, String offer, String post, String circular) {
		PercentageDao dao = new PercentageDaoImpl();
		Percentage p = dao.getPercentage(years, offer, post, circular);
		
		if(p == null) {
			throw new DataNotFoundException("No percentage details found");
		}
		return p;
	}
	
	/*
	 * judge perecentages
	 */
	public Percentage getPercentageForJudge(int years, int months, double salary, String circular) {
		PercentageDao dao = new PercentageDaoImpl();
		if(years < 25) months = 0;
		Percentage p = dao.getPercentage(years , months < 6 ? 0 : 6, (int)salary, circular, "judge");
		
		if(p == null) {
			throw new DataNotFoundException("No percentage details found");
		}
		return p;
	}
	
}
