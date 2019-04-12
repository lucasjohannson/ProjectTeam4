https://coderanch.com/t/515213/engineering/JUnit-tests-Getters-Setters


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Enemytest {
	Enemy test1 = new Enemy(null, 0, 0, 0, 0);
	
	//TEST ENEMY NAME SETTER
	@Test
    public void testsetName() {
        Enemy card = new Enemy(null, 0, 0, 0, 0);
        card.setName("test");
        assertTrue(card.getName() == "test");
    }
	
	//TEST ENEMY NAME GETTER 
	@Test
    public void testgetName() {
        Enemy card = new Enemy(null, 0, 0, 0, 0);
        card.setName("test");
        assertTrue(card.getName() == "test");
    }

	//TEST ENEMY SPEED GETTER
	@Test
    public void testgetspeed(){
        Enemy card =  new Enemy(null, 0, 0, 0, 0);
        card.setSpeed(2);
        assertTrue(card.getspeed() == 2);
    }
	
	//TEST ENEMY SPEED SETTER 
	@Test
    public void testsetSpeed(){
        Enemy card = new Enemy(null, 0, 0, 0, 0);
        card.setSpeed(2);
        assertTrue(card.getspeed() == 2);
    }
     

		//TEST ENEMY POWER GETTER
		@Test
	    public void testgetPower(){
	        Enemy card =  new Enemy(null, 0, 0, 0, 0);
	        card.setPower(50);
	        assertTrue(card.getpower() == 50);
	    }
		
		// TEST ENEMY POWER SETTER 
		@Test
	    public void testsetPower(){
	        Enemy card = new Enemy(null, 0, 0, 0, 0);
	        card.setPower(50);
	        assertTrue(card.getpower() == 50);
	    }
		//TEST ENEMY MAX HEALTH GETTER
		@Test
		public void testgetmaxHealth(){
			Enemy card =  new Enemy(null, 0, 0, 0, 0);
			card.setmaxCorHealth(100);
			assertTrue(card.getmaxCorHealth() == 100);
		}
				
		// TEST ENEMY MAX HEALTH SETTER 
				@Test
			    public void testsetMaxHealth(){
			        Enemy card = new Enemy(null, 0, 0, 0, 0);
			        card.setmaxCorHealth(100);
			        assertTrue(card.getmaxCorHealth() == 100);
			    }
				
		//TEST ENEMY CURRENT HEALTH GETTER
		@Test
		public void testgetCurrentHealth(){
			Enemy card =  new Enemy(null, 0, 0, 0, 0);
			card.setcurrentHealth(100);
			assertTrue(card.getcurrentHealth() == 100);
			    }
		
		//TEST ENEMY CURRENT HEALTH SETTER 
		@Test
	    public void testCurrentHealthSetter(){
	        Enemy card = new Enemy(null, 0, 0, 0, 0);
	        card.setcurrentHealth(100);
	        assertTrue(card.getcurrentHealth() == 100);
	    }
}
