package com.mmadinastia.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mmadinastia.api.dto.FighterDTO;
import com.mmadinastia.domain.entities.Fighter;

@Component
public class FighterDtoDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Fighter toDomainObject(FighterDTO fighterDto) {
		return modelMapper.map(fighterDto, Fighter.class);
	}

	public void copyToDomainObject(FighterDTO fighterDto, Fighter fighter) {
		
		modelMapper.map(fighterDto, fighter);

	}

}
