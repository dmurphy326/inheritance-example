package com.dmurphy.parents;

public class LivingBeing {

	public LivingBeing(boolean eatsMeat, boolean eatsInsects, String type) {
		this.eatsMeat = eatsMeat;
		this.eatsInsects = eatsInsects;
		this.type = type;
		this.isAlive = true;
	}
	
	public boolean isAlive;
	public boolean eatsMeat;
	public boolean eatsInsects;
	public String type;
	
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
}
