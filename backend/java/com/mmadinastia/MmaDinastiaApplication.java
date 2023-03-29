package com.mmadinastia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mmadinastia.domain.entities.Fighter;
import com.mmadinastia.domain.enums.WeightClass;
import com.mmadinastia.domain.repositories.FighterRepository;

@SpringBootApplication
public class MmaDinastiaApplication implements CommandLineRunner {

	@Autowired
	private FighterRepository fighterRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MmaDinastiaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Fighter f1 = new Fighter(1L, "Khabib", "Nurmagomedov", "The Eagle", 26, WeightClass.LEVE, 14.0, 12.0, 13.0,
				17.0, 15.0, 16.0, 13.0, 16.0, 18.0, 16.0, 16.0, 15.0, 14.0, 17.0, 15.0, 15.0, 16.0, 16.0, 16.0);

		f1.setStratPunching(20);
		f1.setStratKicking(19);
		f1.setStratClinching(27);
		f1.setStratTakedowns(34);

		f1.setStratDirtyBoxing(20);
		f1.setStratThaiClinch(18);
		f1.setStratClinchTakedowns(55);
		f1.setStratAvoidClinch(7);

		f1.setStratGNP(42);
		f1.setStratSub(13);
		f1.setStratPositioning(19);
		f1.setStratLNP(8);
		f1.setStratStandUp(18);
		
		
		Fighter f2 = new Fighter(2L, "B.J", "Penn", "The Prodigy", 31, WeightClass.LEVE, 15.0, 14.0, 14.0, 14.0, 13.0,
				16.0, 15.0, 15.0, 14.0, 18.0, 13.0, 15.0, 17.0, 16.0, 15.0, 17.0, 17.0, 13.0, 17.0);

		f2.setStratPunching(45);
		f2.setStratKicking(17);
		f2.setStratClinching(18);
		f2.setStratTakedowns(20);

		f2.setStratDirtyBoxing(30);
		f2.setStratThaiClinch(26);
		f2.setStratClinchTakedowns(26);
		f2.setStratAvoidClinch(18);

		f2.setStratGNP(14);
		f2.setStratSub(52);
		f2.setStratPositioning(28);
		f2.setStratLNP(3);
		f2.setStratStandUp(3);
		
		
		Fighter f3 = new Fighter(3L, "Georges", "St. Pierre", "Rush", 31, WeightClass.MEIO_MEDIO, 14.0, 14.0, 16.0,
				17.0, 14.0, 18.0, 15.0, 15.0, 18.0, 17.0, 15.0, 15.0, 13.0, 14.0, 15.0, 14.0, 18.0, 14.0, 13.0);

		f3.setStratPunching(22);
		f3.setStratKicking(15);
		f3.setStratClinching(21);
		f3.setStratTakedowns(42);

		f3.setStratDirtyBoxing(22);
		f3.setStratThaiClinch(22);
		f3.setStratClinchTakedowns(49);
		f3.setStratAvoidClinch(7);

		f3.setStratGNP(36);
		f3.setStratSub(18);
		f3.setStratPositioning(36);
		f3.setStratLNP(4);
		f3.setStratStandUp(6);
		
		
		Fighter f4 = new Fighter(4L, "Kamaru", "Usman", "The Nigerian Nightmare", 25, WeightClass.MEIO_MEDIO, 14.0,
				11.0, 14.0, 18.0, 15.0, 17.0, 14.0, 15.0, 18.0, 18.0, 16.0, 15.0, 14.0, 12.0, 17.0, 16.0, 16.0, 15.0,
				13.0);

		f4.setStratPunching(16);
		f4.setStratKicking(5);
		f4.setStratClinching(23);
		f4.setStratTakedowns(56);

		f4.setStratDirtyBoxing(19);
		f4.setStratThaiClinch(16);
		f4.setStratClinchTakedowns(52);
		f4.setStratAvoidClinch(13);

		f4.setStratGNP(65);
		f4.setStratSub(11);
		f4.setStratPositioning(11);
		f4.setStratLNP(6);
		f4.setStratStandUp(7);
		
		
		Fighter f5 = new Fighter(5L, "Anderson", "Silva", "Spider", 37, WeightClass.MEDIO, 18.0, 18.0, 18.0, 14.0, 13.0,
				18.0, 18.0, 16.0, 13.0, 12.0, 15.0, 14.0, 14.0, 15.0, 17.0, 16.0, 18.0, 15.0, 17.0);

		f5.setStratPunching(47);
		f5.setStratKicking(20);
		f5.setStratClinching(27);
		f5.setStratTakedowns(6);

		f5.setStratDirtyBoxing(42);
		f5.setStratThaiClinch(42);
		f5.setStratClinchTakedowns(10);
		f5.setStratAvoidClinch(6);

		f5.setStratGNP(37);
		f5.setStratSub(26);
		f5.setStratPositioning(26);
		f5.setStratLNP(5);
		f5.setStratStandUp(6);

		
		Fighter f6 = new Fighter(6L, "Israel", "Adesanya", "The Last Stylebender", 28, WeightClass.MEDIO, 17.0, 17.0,
				18.0, 10.0, 12.0, 17.0, 18.0, 16.0, 10.0, 16.0, 13.0, 10.0, 12.0, 14.0, 15.0, 17.0, 16.0, 17.0, 17.0);

		f6.setStratPunching(35);
		f6.setStratKicking(32);
		f6.setStratClinching(27);
		f6.setStratTakedowns(6);

		f6.setStratDirtyBoxing(42);
		f6.setStratThaiClinch(42);
		f6.setStratClinchTakedowns(10);
		f6.setStratAvoidClinch(6);

		f6.setStratGNP(37);
		f6.setStratSub(26);
		f6.setStratPositioning(26);
		f6.setStratLNP(5);
		f6.setStratStandUp(6);

		Fighter f7 = new Fighter(7L, "Jon", "Jones", "Bones", 22, WeightClass.MEIO_PESADO, 14.0, 13.0, 18.0, 18.0, 15.0,
				17.0, 16.0, 18.0, 18.0, 18.0, 18.0, 15.0, 13.0, 16.0, 15.0, 15.0, 15.0, 16.0, 15.0);

		f7.setStratPunching(17);
		f7.setStratKicking(12);
		f7.setStratClinching(25);
		f7.setStratTakedowns(46);

		f7.setStratDirtyBoxing(19);
		f7.setStratThaiClinch(23);
		f7.setStratClinchTakedowns(45);
		f7.setStratAvoidClinch(13);

		f7.setStratGNP(35);
		f7.setStratSub(9);
		f7.setStratPositioning(23);
		f7.setStratLNP(10);
		f7.setStratStandUp(23);

		
		
		Fighter f8 = new Fighter(8L, "Mauricio", "Rua", "Shogun", 24, WeightClass.MEIO_PESADO, 15.0, 16.0, 14.0, 14.0,
				15.0, 14.0, 14.0, 13.0, 16.0, 13.0, 14.0, 15.0, 14.0, 13.0, 13.0, 16.0, 15.0, 16.0, 17.0);


		f8.setStratPunching(38);
		f8.setStratKicking(28);
		f8.setStratClinching(20);
		f8.setStratTakedowns(14);

		f8.setStratDirtyBoxing(27);
		f8.setStratThaiClinch(32);
		f8.setStratClinchTakedowns(22);
		f8.setStratAvoidClinch(19);

		f8.setStratGNP(43);
		f8.setStratSub(21);
		f8.setStratPositioning(21);
		f8.setStratLNP(6);
		f8.setStratStandUp(9);
		
		Fighter f9 = new Fighter(9L, "Fedor", "Emelianenko", "The Last Emperor", 29, WeightClass.PESADO, 15.0, 12.0,
				15.0, 15.0, 15.0, 15.0, 15.0, 18.0, 16.0, 16.0, 18.0, 17.0, 16.0, 18.0, 16.0, 16.0, 18.0, 15.0, 17.0);

		f9.setStratPunching(41);
		f9.setStratKicking(7);
		f9.setStratClinching(22);
		f9.setStratTakedowns(30);

		f9.setStratDirtyBoxing(31);
		f9.setStratThaiClinch(19);
		f9.setStratClinchTakedowns(37);
		f9.setStratAvoidClinch(13);

		f9.setStratGNP(42);
		f9.setStratSub(23);
		f9.setStratPositioning(32);
		f9.setStratLNP(2);
		f9.setStratStandUp(1);
		

		Fighter f10 = new Fighter(10L, "Fabricio", "Werdum", "Vai Cavalo", 29, WeightClass.PESADO, 14.0, 13.0, 13.0,
				14.0, 13.0, 14.0, 13.0, 14.0, 13.0, 12.0, 12.0, 18.0, 18.0, 18.0, 15.0, 14.0, 14.0, 15.0, 14.0);

		f10.setStratPunching(22);
		f10.setStratKicking(24);
		f10.setStratClinching(20);
		f10.setStratTakedowns(34);

		f10.setStratDirtyBoxing(10);
		f10.setStratThaiClinch(14);
		f10.setStratClinchTakedowns(26);
		f10.setStratAvoidClinch(50);

		f10.setStratGNP(4);
		f10.setStratSub(39);
		f10.setStratPositioning(52);
		f10.setStratLNP(3);
		f10.setStratStandUp(2);
		
		
		
		fighterRepository.saveAll(Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10));

	}
	
}
