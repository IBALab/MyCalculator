package MyMath;
import java.util.ArrayList;
import java.util.Collections;


public class MyMath {
	
	public Integer sum (ArrayList <Integer> allFilesList ){
		if (allFilesList.isEmpty())
			return null ;
		else {
			int sum = 0;
			for (int i = 0; i < allFilesList.size(); i++) {
				sum+=allFilesList.get(i);
			}
			return intToInteger(sum);	
		}	
	}
	
	public Integer intToInteger(int value) {
		Integer Int=new Integer(value);
		return Int;
	}

	public Integer max (ArrayList <Integer> allFilesList ){
		if (allFilesList.isEmpty())
			return null;
		else {
			int tempmax = 0;
			for (int i = 0; i < allFilesList.size(); i++) {
				int curr=allFilesList.get(i);
				if (curr>tempmax)
					tempmax=curr;
			}
			return intToInteger(tempmax);	
			}	
		
	}
	
	public Integer min (ArrayList <Integer> allFilesList ){
		if (allFilesList.isEmpty())
			return null;
		else {
			int tempmin = 0;
			for (int i = 0; i < allFilesList.size(); i++) {
				int curr=allFilesList.get(i);
				if (curr<tempmin)
					tempmin=curr;
			}
			return intToInteger(tempmin);	
		}	
	}

	public Integer EvenMinusOdd  (ArrayList <Integer> allFilesList ){
		if (allFilesList.isEmpty())
			return null;
		else {
			int evenSum=0, oddSum=0;
			for (int i = 0; i < allFilesList.size(); i++) {
				int currElement=allFilesList.get(i);
				if (currElement%2==0)
					evenSum+=currElement;
				else oddSum+=currElement;
			}
			return intToInteger(evenSum-oddSum);	
		}
	}
	
	public Integer Mean (ArrayList <Integer> allFilesList ){
		if (allFilesList.isEmpty())
			return null;
		else
			return intToInteger(sum(allFilesList)/allFilesList.size());
	}
	

}
