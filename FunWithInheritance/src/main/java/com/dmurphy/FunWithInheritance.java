package com.dmurphy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.dmurphy.enums.AnimalEnum;
import com.dmurphy.enums.InsectEnum;
import com.dmurphy.parents.Animal;
import com.dmurphy.parents.Insect;
import com.dmurphy.parents.LivingBeing;

public class FunWithInheritance {

	public List<LivingBeing> generateList() {
		List<LivingBeing> list = new ArrayList<LivingBeing>();
		
		Random random = new Random();
		int listSize = random.nextInt(15) + 1;
		for(int i = 0; i < listSize; i++) {
			// generate animal
			Animal a = new Animal(AnimalEnum.getAminalById(random.nextInt(3) + 1));
			list.add(a);
			
			//generate insect
			Insect b = new Insect(InsectEnum.getInsectById(random.nextInt(1) + 1));
			list.add(b);
		}
		
		return list;
	}
}
