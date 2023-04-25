package factory.data.calculate.implementation;

import java.util.List;
import java.util.Vector;

import factory.data.Data;
import factory.data.calculate.interfaces.CalculateStrategyInterface;
import factory.data.read.implementation.A4Strategy;

public class Dijeljenje implements CalculateStrategyInterface<Data, Data> {
	
/**
 * Ovo je pomoćna main metoda koja služi za provjeru algoritma za izračunavanje
 * @author Dejana Pjević
 * 
 */

	public static void main(String[] args) {
		
		Dijeljenje d = new Dijeljenje();
		A4Strategy a4 = new A4Strategy();
		List<Data> list = d.calculate(a4.readFile("files/data_a4_dijeljenje.txt"));
		for(Data x : list)
			System.out.println(x.getKey()+" "+x.getValue());

	}

	/**
	 * Ova metoda računa vrijednosti po zadatom algoritmu
	 * @param List<Data> data - lista podataka na osnovu koje se vrši računanje
	 * @return calculated - lista koja sadrži izračunate vrijednosti
	 * @author Dejana Pjević
	 */
	@Override
	public List<Data> calculate(List<Data> data) {
		
	    List<Data> calculated = new Vector<>();
	    for(int i=0 ; i<6; i++) {
	    	double a= Double.valueOf(data.get(i).getValue().toString());
	    	double b=Double.valueOf(data.get(i+6).getValue().toString());
	    	double c = Double.valueOf(data.get(i+12).getValue().toString());
	    	double n = a/b/c;
	    	
	    	calculated.add(new Data("n"+(i+1), n));
	    	
	    }
		return calculated;
	}

}
