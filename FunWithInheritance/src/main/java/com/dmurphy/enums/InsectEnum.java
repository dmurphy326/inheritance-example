package com.dmurphy.enums;

public enum InsectEnum {
	ANT(1, false, false),
	DRAGONFLY(2, false, true),
	MOSQUITO(3, true, false);
	
	InsectEnum(int id, boolean eatsMeat, boolean eatsInsects) {
		this.id = id;
		this.eatsMeat = eatsMeat;
		this.eatsInsects = eatsInsects;
	}
	
	int id;
	public boolean eatsMeat; 
	public boolean eatsInsects;
	
	public static InsectEnum getInsectById(int id) {
		for(InsectEnum insect: InsectEnum.values()) {
			if(insect.id == id) {
				return insect;
			}
		}
		return null;
	}
}
