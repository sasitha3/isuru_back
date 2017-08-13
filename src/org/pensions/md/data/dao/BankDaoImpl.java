package org.pensions.md.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.pensions.md.data.interfaces.BankDao;
import org.pensions.md.exceptions.MysqlException;
import org.pensions.md.model.pojo.Bank;
import org.pensions.md.model.pojo.Branch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankDaoImpl extends BaseDao implements BankDao {
	
	private Logger logger = LoggerFactory.getLogger(BankDaoImpl.class);

	private static final String ALL_BANKS = "SELECT * FROM bank";
	private static final String ALL_BRANCHES = "SELECT * FROM branch where bankId=?";
	private static final String BANK = "SELECT * FROM bank where bank_id=?";
	private static final String BRANCH = "SELECT * FROM branch where branch_id=?";
	
	/**
	 * get list of branches
	 * if @param withBranches == true ---> the returned object will contain branches of each bank
	 * @param withBranches
	 * @return
	 */
	@Override
	public List<Bank> getBanks() {
		
		Connection dbConn = getConnection();
		List<Bank> banks = new ArrayList<Bank>();
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(ALL_BANKS);
			logger.info(ALL_BANKS);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Bank bank = new Bank();				
				bank.setId(result.getInt(1));
				bank.setName(result.getString(2));
				banks.add(bank);
			}
			
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}

		return banks;
	}
	

	/**
	 * Get a bank using the bank Id
	 * @param bankId
	 * @return
	 */
	@Override
	public Bank getBank(int bankId) {
		
		Connection dbConn = getConnection();
		Bank bank = null;
		try {
			PreparedStatement ps = dbConn.prepareStatement(BANK);
			ps.setInt(1, bankId);
			
			logger.info(BANK);
			
			ResultSet result = ps.executeQuery();
			bank = new Bank();	
			while(result.next()){
				bank.setId(result.getInt(1));
				bank.setName(result.getString(2));
			}
			
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}
		return bank;
	}
	
	/**
	 * Get list of branches of a particular bank
	 * @param bankId
	 * @return
	 */
	@Override
	public List<Branch> getBranches(int bankId) {
		
		Connection dbConn = getConnection();
		List<Branch> branches = new ArrayList<Branch>();
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(ALL_BRANCHES);
			ps.setInt(1, bankId);
			logger.info(ALL_BRANCHES);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Branch branch = new Branch();
				branch.setId(result.getInt(1));
				branch.setName(result.getString(3));
				branch.setCode(result.getInt(4));
				branches.add(branch);
			}
			
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}

		
		return branches;
	}
	
	/**
	 * Get a single branch
	 * @param branchId
	 * @return
	 */
	@Override
	public Branch getBranch(int branchId) {
		Connection dbConn = getConnection();
		Branch branch = null;
		Bank bank = null;
		System.out.println(branchId);
		try {
			PreparedStatement ps = dbConn.prepareStatement(BRANCH);
			ps.setInt(1, branchId);
			logger.info(BRANCH);
			ResultSet result = ps.executeQuery();
			branch = new Branch();	
			bank = new Bank();
			while(result.next()){
				branch.setId(result.getInt(1));
				branch.setAddress(result.getString(2));
				branch.setName(result.getString(3));
				bank = new BankDaoImpl().getBank(result.getInt(4));
				branch.setBank(bank);
				branch.setCode(result.getInt(5));
			}
			
		} catch(Exception e){
			
			throw new MysqlException(e);
			
		} finally{
			closeConnection(dbConn);
			
		}
		return branch;
	}
	
		
}//all queries type here
