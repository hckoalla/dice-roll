package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.EmptyDiceRollRequest;
import exceptions.InvalidDiceRollRequest;

public class DiceRollUtil {
	
	public static String roll(String requestAsString) throws InvalidDiceRollRequest, EmptyDiceRollRequest{
		System.out.println("Request: "+requestAsString);
		
		Request request = createRequest(requestAsString);
		StringBuilder response = new StringBuilder("("); 
		
		int total = 0;
		boolean first = true;
		for(int x = 1; x <= request.getQuantity(); x++) {
			int currentRoll = request.roll();
			total = total + currentRoll;
			if(first){
				first = false;
				response.append(currentRoll);
			} else {
				response.append(" + "+currentRoll);
			}
		}
		
		response.append(") + "+request.getModifier());
		
		total = total + request.getModifier().intValue();
		
		response =  new StringBuilder(total + " = " + response.toString());
		
		System.out.println("Response: "+response);
		return response.toString();
	}
	
	private static Request createRequest(String requestAsString) throws InvalidDiceRollRequest, EmptyDiceRollRequest {
		if ( requestAsString == null || requestAsString.isEmpty() ) {
			throw new EmptyDiceRollRequest("A requisição não pode estar vazia");
		}
		
		requestAsString = requestAsString.toUpperCase();
		
		Request request = null;
		
		try {
			// For pattern 1D20+5
			Pattern p = Pattern.compile("([0-9]{1,9999})(D[0-9]{0,3})(\\+[0-9]{1,9999})");
			Matcher m = p.matcher( requestAsString );
			if( m.find() ){
				System.out.println("Using if: 1D20+5");
				request = new Request( Long.parseLong(m.group(1)), m.group(2), Long.parseLong(m.group(3) ) );
			}
			
			if( request == null ){
				// For pattern 1D20
				p = Pattern.compile("([0-9]{1,9999})(D[0-9]{0,3})");
				m = p.matcher( requestAsString );
				if( m.find() ){
					System.out.println("Using if: 1D20");
					request = new Request( Long.parseLong(m.group(1)), m.group(2) );
				}
			}
			
			if( request == null ){
				// For pattern D20+5
				p = Pattern.compile("(D[0-9]{0,3})(\\+[0-9]{1,9999})");
				m = p.matcher( requestAsString );
				if( m.find() ){
					System.out.println("Using if: D20+5");
					request = new Request( m.group(1), Long.parseLong(m.group(2)) );
				}
			}
			
			if( request == null ){
				// For pattern D20
				p = Pattern.compile("(D[0-9]{0,3})");
				m = p.matcher( requestAsString );
				if( m.find() ){
					System.out.println("Using if: d20");
					request = new Request( m.group(1) );
				}
			}
		} catch (Exception e) {
			System.out.println("Houve um erro ("+ e.getClass().getName() + " " + e.getMessage() +") ao interpretar a requisição: "+ requestAsString);
			e.printStackTrace();
		}
		
		if( request == null ){
			throw new InvalidDiceRollRequest("Não foi possivel interpretar a requisição: "+requestAsString);
		}
		
		return request;
	}
	
}