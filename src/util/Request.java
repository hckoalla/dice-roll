package util;

import java.util.Random;

class Request {
	
	private Long quantity = 1l;
	private String dice;
	private Long modifier = 0l;
	
	Request(String dice){
		this.dice = dice; 
	}
	
	Request(Long quantity, String dice){
		this.quantity = quantity;
		this.dice = dice; 
	}
	
	Request(String dice, Long modifier){
		this.dice = dice;
		this.modifier = modifier;
	}
	
	Request(Long quantity, String dice, Long modifier){
		this.quantity = quantity;
		this.dice = dice;
		this.modifier = modifier;
	}
	
	Long getQuantity() {
		return quantity;
	}
	
	String getDice() {
		return dice;
	}
	
	Long getModifier() {
		return modifier;
	}
	
	int roll(){
		Integer sideNumber = Integer.parseInt( dice.replaceAll("[^0-9]", "") );
		Random random = new Random();
		int result = random.nextInt( sideNumber );
		while( result == 0 ){
			result = random.nextInt( sideNumber );
		}
		return result;
	}
	
}