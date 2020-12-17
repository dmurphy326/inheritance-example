package com.dmurphy.enums;

public enum AnimalEnum {
	BIRD(1, 3, false, true),
	DOG(2, 5, true, true),
	PERSON(3, 10, true, false),
	TIGER(4, 8, true, false),
	FROG(5, 2, false, true),
	BEAR(6, 9, true, true);
	
	AnimalEnum(int id, int foodChainLevel, boolean eatsMeat, boolean eatsInsects) {
		this.id = id;
		this.foodChainLevel = foodChainLevel;
		this.eatsMeat = eatsMeat;
		this.eatsInsects = eatsInsects;
	}
	
	int id;
	public int foodChainLevel;
	public boolean eatsMeat; 
	public boolean eatsInsects;
	
	public static AnimalEnum getAminalById(int id) {
		for(AnimalEnum animal: AnimalEnum.values()) {
			if(animal.id == id) {
				return animal;
			}			
		}
		return null;
	}
}
