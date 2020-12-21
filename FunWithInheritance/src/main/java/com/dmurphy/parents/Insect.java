package com.dmurphy.parents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmurphy.enums.InsectEnum;

public class Insect extends LivingBeing {
	private static final Logger log = LoggerFactory.getLogger(Insect.class);

	public Insect(InsectEnum insect) {
		super(insect.eatsMeat, insect.eatsInsects, insect.name());
	}
	
	private int evation;

	public int getEvation() {
		return evation;
	}

	public void setEvation(int evation) {
		log.info(getType() + "'s evation was changed from " + this.evation + " to " + evation);
		this.addToLifeLog(getType() + "'s evation was changed from " + this.evation + " to " + evation);
		this.evation = evation;
	}

	@Override
	public String toString() {
		return super.toString() + " Insect [evation=" + evation + "]";
	}
	
	
	
}
