package factory.data.calculate.implementation;

import java.util.List;
import java.util.Vector;
import factory.data.Data;
import factory.data.read.implementation.A8Strategy;
import factory.interfaces.CalculateInterface;

public class Mnozenje  implements CalculateInterface<Data, Data>{
	
public static void main(String[] args) {
		
		List<Data> lista=new A8Strategy().readFile("files/data_a8_mnozenje2.txt");
		List<Data> calculated = new Vector<>();
		Mnozenje m = new Mnozenje();
		calculated=m.calculate(lista);
		for(Data d : calculated) {
			System.out.println(d.getKey()+" "+ d.getValue());
		}}
	
	@Override
	public List<Data> calculate(List<Data> data) {
		
		int k=5, brojac=1;
		List<Data> calculated = new Vector<>();
		List<Double> doubleList = this.conversion(data);
		
		for(int i=0 ; i<=12 ; i+=3) {
			
			double a = Math.pow(doubleList.get(i)+doubleList.get(i+1), doubleList.get(i+2));
			double b = Math.pow(doubleList.get(i+15)+doubleList.get(i+16), doubleList.get(i+17));
			double c= doubleList.get(doubleList.size()-k);
			k--;
			double n =a * b *c;
			calculated.add(new Data("n"+brojac,n));
			brojac++;
		}
		
		return calculated;
	}
	
	private List<Double> conversion (List<Data> data) {
		List<Double> doubleList = new Vector<>();
		for(Data d : data) {
			doubleList.add(Double.valueOf(d.getValue().toString()));
		}
		return doubleList;
	}

}
