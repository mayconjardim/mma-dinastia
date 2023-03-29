package com.mmadinastia.fight.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WeightClass {
    
	LEVE(1, "Leves"), MEIO_MEDIO(2, "Meio-Médios"), MEDIO(3, "Médios"),
    MEIO_PESADO(4, "Meio-Pesados"), PESADO(5, "Pesados"), CASADO(6, "Casada");

    private Integer code;
    private String name;

	public static WeightClass toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (WeightClass x : WeightClass.values()) {
            if(cod.equals(x.getCode())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Categoria invalida!");
    }
}
	

