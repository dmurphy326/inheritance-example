package com.dmurphy.parents;

import com.dmurphy.enums.InsectEnum;

public class Insect extends LivingBeing {

	public Insect(InsectEnum insect) {
		super(insect.eatsMeat, insect.eatsInsects, insect.name());
	}
	
}
