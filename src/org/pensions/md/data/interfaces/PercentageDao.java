package org.pensions.md.data.interfaces;

import org.pensions.md.model.pojo.Percentage;

public interface PercentageDao {

	Percentage getPercentage(int years, int months, int salary, String circular);

	Percentage getPercentage(int years, int months, int salary, String circular, String type);

	Percentage getPercentage(int years, String offer, String post, String circular);

}