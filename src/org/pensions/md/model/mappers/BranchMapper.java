package org.pensions.md.model.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.pensions.md.enumarations.MappingLevel;
import org.pensions.md.model.pojo.Branch;
import org.pensions.md.model.dto.BranchDTO;

public class BranchMapper extends Mapper<Branch, BranchDTO>{

	/*
	 * Map Branch model to the BranchDTO
	 */
	@Override
	public BranchDTO toDto(Branch model, MappingLevel level) {
		ModelMapper mapper = new ModelMapper();
		BranchDTO map = null;
		try {
			map = mapper.map(model, BranchDTO.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
		map.setBank(new BankMapper().toDto(model.getBank(), level));
		map.setCode(model.getCode());
		System.out.println("toDto");
		return map;
	}

	/*
	 * Map BranchDTO to the Branch Model
	 */
	@Override
	public Branch toModel(BranchDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	class LevelOne extends PropertyMap<Branch, BranchDTO>{

		@Override
		protected void configure() {
			skip(destination.getBank());
		}

	}
}
