package com.mmadinastia.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.mmadinastia.api.dto.FightDTO;
import com.mmadinastia.domain.entities.Fight;

@Component
public class FightDtoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public FightDTO toDTO(Fight fight) {
		return modelMapper.map(fight, FightDTO.class);
	}
	
	public List<FightDTO> toCollectionDTO(List<Fight> fights) {
		return fights.stream().map(fight -> toDTO(fight)).collect(Collectors.toList());

	}

	public Page<FightDTO> toCollectionDTO(Page<Fight> fights) {
		return fights.map(fight -> toDTO(fight));

	}

}
