package factory.data.calculate.implementation;

import java.util.List;
import java.util.Vector;

import factory.data.Data;
import factory.data.calculate.interfaces.CalculateStrategyInterface;
import factory.data.read.implementation.A3Strategy;






public class Potencije implements CalculateStrategyInterface<Data, Data> {
	
public static void main(String[] args) {
		
		List<Data> p_lista=new A3Strategy().readFile("files/data_a3_potencije.txt");
		List<Data> calculated = new Potencije().calculate(p_lista);
		for(Data d : calculated)
			System.out.println(d.getKey()+" "+d.getValue());
		}
		
	
	


	@Override
	public List<Data> calculate(List<Data> data) {
		
		List<Data> list = new Vector<>();
		int j=1;
		for(int i=0 ; i<=data.size()-3 ; i+=3) {
			
			double aDouble = (double) data.get(i).getValue();
			double bDouble=(double) data.get(i+1).getValue();
			double cDouble = (double) data.get(i+2).getValue();
			double nDouble = Math.pow(aDouble, bDouble+cDouble) + Math.pow(bDouble,aDouble+cDouble) +
					Math.pow(cDouble,aDouble+bDouble);
			list.add(new Data("n"+j, nDouble));
			j++;
		}
		
		return list;
	}

}
