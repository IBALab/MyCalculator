package MyMath;
import java.util.ArrayList;
import java.util.Collections;


public class MyMath {
	
	public Integer sum (ArrayList <Integer> allValuesList ){
		if (allValuesList.isEmpty())
			return null ;
		else {
			int sum = 0;
			for (int i = 0; i < allValuesList.size(); i++) {
				sum+=allValuesList.get(i);
			}
			return intToInteger(sum);	
		}	
	}
	
	public Integer intToInteger(int value) {
		Integer Int=new Integer(value);
		return Int;
	}

	public Integer max (ArrayList <Integer> allValuesList ){
		if (allValuesList.isEmpty())
			return null;
		else {
			int tempmax = 0;
			for (int i = 0; i < allValuesList.size(); i++) {
				int curr=allValuesList.get(i);
				if (curr>tempmax)
					tempmax=curr;
			}
			return intToInteger(tempmax);	
			}	
		
	}
	
	public Integer min (ArrayList <Integer> allValuesList ){
		if (allValuesList.isEmpty())
			return null;
		else {
			int tempmin = 0;
			for (int i = 0; i < allValuesList.size(); i++) {
				int curr=allValuesList.get(i);
				if (curr<tempmin)
					tempmin=curr;
			}
			return intToInteger(tempmin);	
		}	
	}

	public Integer EvenMinusOdd  (ArrayList <Integer> allValuesList ){
		if (allValuesList.isEmpty())
			return null;
		else {
			int evenSum=0, oddSum=0;
			for (int i = 0; i < allValuesList.size(); i++) {
				int currElement=allValuesList.get(i);
				if (currElement%2==0)
					evenSum+=currElement;
				else oddSum+=currElement;
			}
			return intToInteger(evenSum-oddSum);	
		}
	}
	
	public Integer Mean (ArrayList <Integer> allValuesList ){
		if (allValuesList.isEmpty())
			return null;
		else
			return intToInteger(sum(allValuesList)/allValuesList.size());
	}
	

}
