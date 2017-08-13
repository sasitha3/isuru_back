package org.pensions.md.model.mappers;

import org.pensions.md.enumarations.MappingLevel;

public abstract class Mapper<S, D> {
	
	public abstract D toDto(S model, MappingLevel level);
	
	public abstract S toModel(D dto);

}
