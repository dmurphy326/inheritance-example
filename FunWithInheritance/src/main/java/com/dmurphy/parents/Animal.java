package com.dmurphy.parents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmurphy.enums.AnimalEnum;

public class Animal extends LivingBeing {
	private static final Logger log = LoggerFactory.getLogger(Animal.class);

	public Animal(AnimalEnum animal) {
		super(animal.eatsMeat, animal.eatsInsects, animal.name());
	}
	
	private int strength;

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		log.info(getType() + "'s strength changed from " + this.strength + " to " + strength);
		this.strength = strength;
		
		if(this.strength < 0) {
			log.info(getType() + " died from lack of strength");
			setAlive(false);
		}
	}

	@Override
	public String toString() {
		return super.toString() + " Animal [strength=" + strength + "]";
	}
	
	
	
}
