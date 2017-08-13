package org.pensions.md.services;

import java.util.Date;
import java.util.List;

import org.pensions.md.data.dao.DaoManager;
import org.pensions.md.data.interfaces.SalarayDao;
import org.pensions.md.exceptions.DataNotFoundException;
import org.pensions.md.model.dto.SalaryDTO;
import org.pensions.md.model.pojo.Salary;
import org.pensions.md.model.pojo.SalaryScale;
import org.pensions.md.model.response.lists.SalaryList;

/**
 * Control the Salary services
 * @author Dinesh Liyanage
 *
 */
public class SalaryService {

	/**
	 * get salary details for a particular scale, grade and a circular
	 * @param scale
	 * @param grade
	 * @param circular
	 * @return
	 */
	public SalaryDTO getSalaryFor(String scale, String grade, String circular, double salary, String target, Date retirementDate, Date lastIncrementDate) {
		
		SalarayDao dao = DaoManager.salarayDao();
		
		SalaryScale scaleModel = new SalaryScale(scale, grade, circular);
		
		Salary firstModel = dao.getSalary(scaleModel.getCode(), salary);//scale-circular-grade
		System.out.println(firstModel);
		//if firstModel == null
		//the salary may be higher than the salary scale
		
		if(firstModel == null) {
			
			firstModel = dao.getFinalSalaryStep(scaleModel.getCode());
			
			if(firstModel.getBasicSalary() > salary) { //
				throw new DataNotFoundException("Salary you provided seems to be invalid");
			}else {
				SalaryDTO finalModel = new SalaryDTO();
				
				Salary previousSalary = dao.getSalary(scaleModel.getCode(), firstModel.getStep() - 1); //get the previous salary tuple
				double salaryGap = firstModel.getBasicSalary() - previousSalary.getBasicSalary();
				
				if((salary - firstModel.getBasicSalary()) % salaryGap != 0) throw new DataNotFoundException("Salary you provided seems to be invalid");
				
				//calculate the firstIncrement
				finalModel.setFirstAllowance(getincrementAllowance(salaryGap, retirementDate, lastIncrementDate, circular));
				
				int incrementCount = (int) ((int) (salary - firstModel.getBasicSalary()) / salaryGap);
				
				scaleModel.setCircular(target);
				firstModel = dao.getFinalSalaryStep(scaleModel.getCode());
				previousSalary = dao.getSalary(scaleModel.getCode(), firstModel.getStep() - 1);
				
				salaryGap = firstModel.getBasicSalary() - previousSalary.getBasicSalary();
				finalModel.setSecondAllowance(getincrementAllowance(salaryGap, retirementDate, lastIncrementDate, circular));
				
				finalModel.setBasicSalary(firstModel.getBasicSalary() + (incrementCount * salaryGap));
				finalModel.setStep(firstModel.getStep() + incrementCount);
				
				return finalModel;
			}
		}
		
		//calculating the increment
		//the firstModel is still in base
		SalaryDTO finalModel = new SalaryDTO();
		System.out.println("-->" + scaleModel.getCode());
		System.out.println("check salary " + firstModel.getScale().getCode());
		Salary secondModel = dao.getSalary(scaleModel.getCode(), getPreviousStep(firstModel.getStep(), firstModel.getScale().getCode()));
		
		finalModel.setFirstAllowance(getincrementAllowance(firstModel.getBasicSalary() - secondModel.getBasicSalary(), retirementDate, lastIncrementDate, circular));
		
		//after setting the target to the requested circular target
		scaleModel.setCircular(target);
		secondModel = dao.getSalary(scaleModel.getCode(), firstModel.getStep());
		firstModel = dao.getSalary(scaleModel.getCode(), getPreviousStep(firstModel.getStep(), firstModel.getScale().getCode()));
		
		if(secondModel == null) {
			throw new DataNotFoundException("Something went wrong while tring to calculate the salary details for 2020. please contact system admin");
		}
		
		//calculating the target circular increment
		
		finalModel.setSecondAllowance(getincrementAllowance(secondModel.getBasicSalary() - firstModel.getBasicSalary(), retirementDate, lastIncrementDate, circular));
		finalModel.setBasicSalary(secondModel.getBasicSalary());
		
		return finalModel;
	}
	
	/*
	 * get increment allowance
	 */
	private double getincrementAllowance(double gap, Date retirementDate, Date lastIncrementDate, String circular) {
		
		double devider = 365.0;
		
		if(Double.valueOf(circular) % 4 == 0) devider = 366.0;
		if(gap < 0) gap = -gap;
		
		double amountPerDay = (gap * 12) / devider;

		int daysInBetween = (int) ((retirementDate.getTime() - lastIncrementDate.getTime()) / (1000 * 60 * 60 * 24));
		System.out.println("GAP: " + gap);
		System.out.println("AMT PER DAY: " + amountPerDay);
		System.out.println("DAYS IN BETWEEN: " + daysInBetween);
		
		return amountPerDay * daysInBetween;
	}
	
	/*
	 * Get the previous step
	 */
	private int getPreviousStep(int currentStep, String code) {
		
		int finalStep = DaoManager.salarayDao().getFinalSalaryStep(code).getStep();
		if(currentStep == finalStep) {
			return finalStep - 1;
		} else {
			return currentStep + 1;
		}
	}
	
	public SalaryList getSalaries(String scale, String grade, String circular) {
		SalarayDao dao = DaoManager.salarayDao();
		List<Salary> modelList = dao.getSalaries(new SalaryScale(scale, grade, circular).getCode());
		
		if(modelList == null || modelList.isEmpty()) {
			throw new DataNotFoundException("no salaries found for the provided salary code");
		}
		
		SalaryList list = new SalaryList();
		
		modelList.stream().forEach(model -> {
			list.getSalaries().add(model.getBasicSalary());
		});
		
		return list;
	}
}
