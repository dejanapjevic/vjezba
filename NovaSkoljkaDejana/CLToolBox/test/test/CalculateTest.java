package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import factory.data.Data;
import factory.data.calculate.Calculate;
import factory.data.read.implementation.A3Strategy;
import property.PropertyParser;
import property.data.PropertyDataStructure;

class CalculateTest
{
	private static HashMap<String,PropertyDataStructure> property = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		property = PropertyParser.parseToHashMap();
		
	}
	
	void djeljenjeTest()
	{
		
		System.out.println("cao");
		//List<?> list=  property .get("djeljenje").testData();
		
	}
	@Test
	void potencijeTest() {
		
		Calculate c = new Calculate(property.get("potencije"));
		A3Strategy a = new A3Strategy();
		List<Data> calculated = c.calculate(a.readFile(property.get("potencije").path().toString()));
		List<Data> lista = property.get("potencije").testData();
		
		for(int i=0 ; i<lista.size(); i++) {
			assertEquals((double)lista.get(i).getValue(),(double)calculated.get(i).getValue());
		}
		
		
	}

	
}
