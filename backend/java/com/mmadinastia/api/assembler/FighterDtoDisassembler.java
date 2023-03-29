package com.mmadinastia.api.assembler;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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
	    modelMapper.addMappings(new PropertyMap<FighterDTO, Fighter>() {
	        @Override
	        protected void configure() {
	    		map().setFirstName(fighterDto.getFirstName());
	    		map().setLastName(fighterDto.getLastName());
	    		map().setNickname(fighterDto.getLastName());
	    		map().setAge(fighterDto.getAge());
	    		map().setWeightClass(fighterDto.getWeightClass());
	    		map().setPunching(fighterDto.getPunching());
	    		map().setKicking(fighterDto.getKicking());
	    		map().setClinchStriking(fighterDto.getClinchStriking());
	    		map().setClinchGrappling(fighterDto.getClinchGrappling());
	    		map().setTakedowns(fighterDto.getTakedowns());
	    		map().setGnp(fighterDto.getGnp());
	    		map().setSubmission(fighterDto.getSubmission());
	    		map().setGroundGame(fighterDto.getGroundGame());
	    		map().setDodging(fighterDto.getDodging());
	    		map().setSubDefense(fighterDto.getSubDefense());
	    		map().setTakedownsDef(fighterDto.getTakedownsDef());
	    		map().setAggressiveness(fighterDto.getAggressiveness());
	    		map().setControl(fighterDto.getControl());
	    		map().setMotivation(fighterDto.getMotivation());
	    		map().setStrength(fighterDto.getStrength());
	    		map().setAgility(fighterDto.getAgility());
	    		map().setConditioning(fighterDto.getConditioning());
	    		map().setKoResistance(fighterDto.getKoResistance());
	    		map().setToughness(fighterDto.getToughness());
	        }
	    });
	    modelMapper.map(fighterDto, fighter);
	}

}
