package test;

import exceptions.EmptyDiceRollRequest;
import exceptions.InvalidDiceRollRequest;
import util.DiceRollUtil;

public class Main {
	
	public static void main(String[] args) throws InvalidDiceRollRequest, EmptyDiceRollRequest{
		DiceRollUtil.roll("2d21+2");
	}
	
}