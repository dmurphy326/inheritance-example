package com.dmurphy.parents;

import com.dmurphy.enums.AnimalEnum;

public class Animal extends LivingBeing {

	public Animal(AnimalEnum animal) {
		super(animal.eatsMeat, animal.eatsInsects, animal.name());
	}
	
	public int strength;

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	
	
}
