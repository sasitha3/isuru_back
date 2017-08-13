package org.pensions.md.services;

import java.util.List;

import org.pensions.md.data.dao.DaoManager;
import org.pensions.md.data.interfaces.BankDao;
import org.pensions.md.enumarations.MappingLevel;
import org.pensions.md.exceptions.DataNotFoundException;
import org.pensions.md.model.pojo.Bank;
import org.pensions.md.model.pojo.Branch;
import org.pensions.md.model.dto.BankDTO;
import org.pensions.md.model.dto.BranchDTO;
import org.pensions.md.model.mappers.BranchMapper;
import org.pensions.md.model.response.lists.BankList;
import org.pensions.md.model.response.lists.BranchList;

public class BankService {

	/**
	 * get all banks
	 * returns banks
	 * @return
	 */
	public BankList getAllBanks() {
		BankDao dao = DaoManager.bankDao();
		List<Bank> banks = dao.getBanks();
		if(banks.isEmpty()) {		
			throw new DataNotFoundException("No banks found");
		}
		BankList list = new BankList();
		banks.stream().forEach(bank -> {
			BankDTO dto = new BankDTO();
			dto.setId(bank.getId());
			dto.setName(bank.getName());
			list.getList().add(dto);
		});
		return list;
	}
	
	/**
	 * get a bank
	 * returns only the bank
	 * @param bankId
	 * @return
	 */
	public BankDTO getBank(int bankId) {
		
		BankDao dao = DaoManager.bankDao();
		
		Bank bank = dao.getBank(bankId);
		
		if(bank == null) throw new DataNotFoundException("No Bank found for id: " + bankId);
		
		BankDTO dto = new BankDTO();
		dto.setId(bank.getId());
		dto.setName(bank.getName());
		
		return dto;
		
	}


	/**
	 * get all the branches of the bank 
	 * @param bankId
	 * @return
	 */
	public BranchList getBranches(int bankId) {
		BankDao dao = DaoManager.bankDao();
		List<Branch> branches = dao.getBranches(bankId);
		BranchList list = new BranchList();
		
		for(Branch branch : branches) {
			BranchDTO dto = new BranchDTO();

			dto.setId(branch.getId());
			dto.setName(branch.getName());
			if(branch.getCode() != null) dto.setCode(branch.getCode());
			
			list.getBranchs().add(dto);
		}
		
		return list;
	}
	
	/**
	 * get a branch of the bank according to the branch id
	 * @param bankId
	 * @return
	 */
	public BranchDTO getBranch(int branchId) {
		BankDao dao = DaoManager.bankDao();
		Branch branch = dao.getBranch(branchId);
		
		if(branch == null) throw new DataNotFoundException("No branch detail found for id: " + branchId);
		
		return new BranchMapper().toDto(branch, MappingLevel.ONE);
	}

//	/**
//	 * 
//	 * @param branchCount
//	 * @return boolean @updatesAvalable 
//	 * true -> updates available
//	 * false -> no updates yet
//	 */
//	/*private boolean isUpdatesAvailable(int bankCount, int branchCount) {
//		BankDAO dao = DaoManager.bankDao();
//		boolean updatesAvailable = false;
//
//		int dbBankCount = dao.getBankCount();
//		int dbBranchCount = dao.getBranchCount();
//
//		if(bankCount == dbBankCount && branchCount == dbBranchCount) updatesAvailable = false;
//		else updatesAvailable = true;
//
//		return updatesAvailable;
//	}*/
//
//	/**
//	 * check for updates
//	 * returns BankList if it has updates
//	 * if no updates retuen null
//	 * @param bankCount
//	 * @param branchCount
//	 * @return BankList
//	 */
//	public BankList checkForUpdates(int bankCount, int branchCount) {
//		/*BankList list = null;
//		if(isUpdatesAvailable(bankCount, branchCount)) {
//			BankDAO dao = new BankDAO();
//			list = new BankList();
//
//			//Mapper mapper = new Mapper();
//			
//			for(Bank bank : dao.getBanks(true)) {
//				list.getList().add(mapper.convertToDTO(bank, true));
//			}
//		}
//		return list;*/
//		return null;
//	}


}