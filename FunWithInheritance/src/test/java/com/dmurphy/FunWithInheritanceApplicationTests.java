package com.dmurphy;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.dmurphy.enums.InsectEnum;
import com.dmurphy.parents.Insect;
import com.dmurphy.parents.LivingBeing;

@SpringBootTest
class FunWithInheritanceApplicationTests {

	@Test
	void verifyInsectIsLivingBeing() {
		Insect ant = new Insect(InsectEnum.ANT);
		assertNotNull(ant);
		assertTrue(ant instanceof LivingBeing);
		assertTrue(ant instanceof Insect);
	}

}
