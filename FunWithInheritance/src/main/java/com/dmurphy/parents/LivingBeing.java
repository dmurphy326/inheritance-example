package com.dmurphy.parents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LivingBeing {
	private static final Logger log = LoggerFactory.getLogger(LivingBeing.class);

	public LivingBeing(boolean eatsMeat, boolean eatsInsects, String type) {
		this.eatsMeat = eatsMeat;
		this.eatsInsects = eatsInsects;
		this.type = type;
		this.isAlive = true;
		
		log.info(type + " was created");
	}
	
	private boolean isAlive;
	private boolean eatsMeat;
	private boolean eatsInsects;
	private String type;
	
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public boolean isEatsMeat() {
		return eatsMeat;
	}
	public boolean isEatsInsects() {
		return eatsInsects;
	}
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "LivingBeing [isAlive=" + isAlive + ", eatsMeat=" + eatsMeat + ", eatsInsects=" + eatsInsects + ", type="
				+ type + "]";
	}
	
	
}
