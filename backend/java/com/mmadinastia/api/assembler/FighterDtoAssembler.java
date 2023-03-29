package com.mmadinastia.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.mmadinastia.api.dto.FighterDTO;
import com.mmadinastia.api.dto.FighterStratsDTO;
import com.mmadinastia.domain.entities.Fighter;

@Component
public class FighterDtoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public FighterDTO toDTO(Fighter fighter) {
		return modelMapper.map(fighter, FighterDTO.class);
	}

	public FighterStratsDTO toStratsDTO(Fighter fighter) {
		return modelMapper.map(fighter, FighterStratsDTO.class);
	}

	
	public List<FighterDTO> toCollectionDTO(List<Fighter> fighters) {
		return fighters.stream().map(fighter -> toDTO(fighter)).collect(Collectors.toList());

	}

	public Page<FighterDTO> toCollectionDTO(Page<Fighter> fighters) {
		return fighters.map(fighter -> toDTO(fighter));

	}

}
