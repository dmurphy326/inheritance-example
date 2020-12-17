package com.dmurphy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmurphy.enums.AnimalEnum;
import com.dmurphy.enums.InsectEnum;
import com.dmurphy.parents.Animal;
import com.dmurphy.parents.Insect;
import com.dmurphy.parents.LivingBeing;

public class FunWithInheritance {
	private static final Logger log = LoggerFactory.getLogger(FunWithInheritance.class);
	static Random random = new Random();

	public static List<LivingBeing> generateList() {
		List<LivingBeing> list = new ArrayList<LivingBeing>();
		
		int listSize = random.nextInt(15) + 1; 
		for(int i = 0; i < listSize; i++) {
			// generate animal
			AnimalEnum animalEnum = AnimalEnum.getAminalById(random.nextInt(AnimalEnum.values().length) + 1);
			Animal a = new Animal(animalEnum);
			a.setStrength(random.nextInt(25) * animalEnum.foodChainLevel);
			list.add(a);
			log.info("Animal added");
			
			// generate insect
			Insect b = new Insect(InsectEnum.getInsectById(random.nextInt(InsectEnum.values().length) + 1));
			b.setEvation(random.nextInt(25) * 5);
			list.add(b);
			log.info("Insect added");
		}
		
		return list;
	}
	
	public static void nature(List<LivingBeing> list, int interactions) {
		for(int i=0; i < interactions; i++) {
			LivingBeing a = list.get(random.nextInt(list.size()));
			LivingBeing b = list.get(random.nextInt(list.size()));
			if(a.isAlive() && b.isAlive()) {
				clashOfBeings(a, b);
			}
		}
	}
	
	private static void clashOfBeings(LivingBeing a, LivingBeing b) {
		if(a instanceof Animal) {
			if(b instanceof Animal) {
				animalVsAnimal((Animal) a, (Animal) b); 
			} else if (b instanceof Insect) {
				animalVsInsect((Animal) a, (Insect) b);
			}
		} else if(a instanceof Insect) {
			if(b instanceof Animal) {
				animalVsInsect((Animal) b, (Insect) a);
			} else if (b instanceof Insect) {
				insectVsInsect((Insect) a, (Insect) b);
			}	
		}
	}

	private static void animalVsAnimal(Animal a, Animal b) {
		if(a.isEatsMeat() && !b.isEatsMeat()) {
			if(a.getStrength() > b.getStrength()) {
				log.info(a.getType() + " ate " + b.getType());
				a.setStrength(a.getStrength() + b.getStrength());
				b.setAlive(false);
			} else {
				log.info(b.getType() + " had to kill " + a.getType());
				a.setStrength(a.getStrength() + b.getStrength());
				a.setAlive(false);
			}
		} else if(!a.isEatsMeat() && b.isEatsMeat()) {
			if(b.getStrength() > a.getStrength()) {
				log.info(b.getType() + " ate " + a.getType());
				a.setStrength(b.getStrength() + a.getStrength());
				a.setAlive(false);
			} else {
				log.info(a.getType() + " had to kill " + b.getType());
				a.setStrength(b.getStrength() + a.getStrength());
				b.setAlive(false);
			}
		} else if(a.isEatsMeat() && b.isEatsMeat()) {
			if(a.getStrength() > b.getStrength()) {
				log.info(a.getType() + " ate " + b.getType());
				a.setStrength(a.getStrength() + b.getStrength());
				b.setAlive(false);
			} else {
				log.info(b.getType() + " ate " + a.getType());
				b.setStrength(a.getStrength() + b.getStrength());
				a.setAlive(false);
			}			
		} else if(!a.isEatsMeat() && !b.isEatsMeat()) {
			log.info(b.getType() + " decided to walk away peacefully from " + a.getType());
		}
	}
	
	private static void insectVsInsect(Insect a, Insect b) {
		if(a.isEatsInsects() && !b.isEatsInsects()) {
			if(a.getEvation() > b.getEvation()) {
				log.info(a.getType() + " ate " + b.getType());
				a.setEvation(b.getEvation() + a.getEvation());
				b.setAlive(false);
			} else {
				log.info(b.getType() + " escaped " + a.getType());
				b.setEvation(b.getEvation() + a.getEvation());
			}
		} else if(!a.isEatsInsects() && b.isEatsInsects()) {
			if(b.getEvation() > a.getEvation()) {
				log.info(b.getType() + " ate " + a.getType());
				b.setEvation(b.getEvation() + a.getEvation());
				a.setAlive(false);
			} else {
				log.info(a.getType() + " escaped " + b.getType());
				a.setEvation(b.getEvation() + a.getEvation());
			}
			
		} else if(a.isEatsInsects() && b.isEatsInsects()) {
			if(b.getEvation() > a.getEvation()) {
				log.info(b.getType() + " ate " + a.getType());
				b.setEvation(b.getEvation() + a.getEvation());
				a.setAlive(false);
			} else {
				log.info(a.getType() + " ate " + b.getType());
				a.setEvation(b.getEvation() + a.getEvation());
				b.setAlive(false);
			}
		} else if(!a.isEatsInsects() && !b.isEatsInsects()) {
			log.info(a.getType() + " flew past " + b.getType());
		}
	}
	
	private static void animalVsInsect(Animal a, Insect b) {
		if(a.isEatsInsects()) {			
			if(a.getStrength() > b.getEvation()) {
				log.info(a.getType() + " ate " + b.getType());
				a.setStrength(a.getStrength() + b.getEvation());
				b.setAlive(false);
			} else {
				log.info(b.getType() + " escaped " + a.getType());
				b.setEvation(b.getEvation() * 2);
				a.setStrength(a.getStrength() / 2);
			}
			
			if(b.isEatsMeat() && b.isAlive()) {
				log.info(b.getType() + " took a bite out of " + a.getType());
				b.setEvation(b.getEvation() * 2);
				a.setStrength(a.getStrength() - 5);
			}
		}
		
	}
	
	
}
