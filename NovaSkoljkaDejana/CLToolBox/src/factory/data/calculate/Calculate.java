package factory.data.calculate;

import java.util.List;

import factory.data.Data;
import factory.data.calculate.implementation.Dijeljenje;
import factory.data.calculate.implementation.Potencije;
import factory.data.calculate.interfaces.CalculateStrategyInterface;
import factory.interfaces.CalculateInterface;
import property.data.PropertyDataStructure;

public class Calculate implements CalculateInterface<Data, Data>
{

	PropertyDataStructure property = null;
	CalculateStrategyInterface<Data, Data> calculateStrategy = null;

	public Calculate(PropertyDataStructure property)
	{
		this.property = property;

		switch (property.name().toLowerCase())
		{
		case "sabiranje":
			// TODO: izvrsiti inicijalizaciju algoritma za sabiranje
			break;
		case "racun":
			// TODO: izvrsiti inicijalizaciju algoritma za racun
			break;
		case "potencije":
			// TODO: izvrsiti inicijalizaciju algoritma za potencije
			calculateStrategy = new Potencije();
			break;
		case "dijeljenje":
			// TODO: izvrsiti inicijalizaciju algoritma za djeljenje
			calculateStrategy = new Dijeljenje();
			break;
		case "oduzimanje":
			// TODO: izvrsiti inicijalizaciju algoritma za proracun
			break;
		case "mnozenje":
			// TODO: izvrsiti inicijalizaciju algoritma za proracun
			break;
		case "suma":
			// TODO: izvrsiti inicijalizaciju algoritma za proracun
			break;
		case "mnozenje2":
			// TODO: izvrsiti inicijalizaciju algoritma za proracun
			break;
		case "sabiranje2":
			// TODO: izvrsiti inicijalizaciju algoritma za proracun
			break;
		case "potencije2":
			// TODO: izvrsiti inicijalizaciju algoritma za proracun
			break;
		default:
			break;
		}
	}

	@Override
	public List<Data> calculate(List<Data> data)
	{
		return calculateStrategy.calculate(data);
	}

}
