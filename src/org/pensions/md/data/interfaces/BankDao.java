package org.pensions.md.data.interfaces;

import java.util.List;

import org.pensions.md.model.pojo.Bank;
import org.pensions.md.model.pojo.Branch;

public interface BankDao {

	List<Bank> getBanks();

	Bank getBank(int bankId);

	List<Branch> getBranches(int bankId);

	Branch getBranch(int branchId);

}