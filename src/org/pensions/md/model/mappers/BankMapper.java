package org.pensions.md.model.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.pensions.md.enumarations.MappingLevel;
import org.pensions.md.model.pojo.Bank;
import org.pensions.md.model.dto.BankDTO;

public class BankMapper extends Mapper<Bank, BankDTO>{

	/*
	 * Map Bank model to the BankDTO
	 */
	@Override
	public BankDTO toDto(Bank model, MappingLevel level) {
		ModelMapper mapper = new ModelMapper();
		
		return mapper.map(model, BankDTO.class);
	}

	@Override
	public Bank toModel(BankDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	class LevelOne extends PropertyMap<Bank, BankDTO>{

		@Override
		protected void configure() {
			
		}

	}
}
