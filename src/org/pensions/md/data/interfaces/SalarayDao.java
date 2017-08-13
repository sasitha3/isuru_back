package org.pensions.md.data.interfaces;

import java.util.List;

import org.pensions.md.model.pojo.Salary;

public interface SalarayDao {

	Salary getSalary(String code, double salary);

	Salary getSalary(String code, int step);

	Salary getFinalSalaryStep(String code);

	List<Salary> getSalaries(String code);

}