package factory.data.read;

import java.util.List;

import factory.data.Data;
import factory.data.read.implementation.A3Strategy;
import factory.data.read.implementation.A4Strategy;
import factory.data.read.interfaces.ReadFileStrategyInterface;
import factory.interfaces.InputFileInterface;
import property.data.PropertyDataStructure;

public class InputFile implements InputFileInterface<Data>
{
	private List<Data> data = null;
	
	@Override
	public List<Data> readData(PropertyDataStructure property)
	{
		ReadFileStrategyInterface<Data> readFileStrategy = null;
		
		// TODO: Da li ovdje koristiti classLoader (dinamicko kreiranje objekata)?
		// Moze se koristi i HashMapa sa unaprijed definisanim objektima
		switch (property.readStrategy())
		{
		case "a1":
			//TODO: izvrsiti parsiranje/citanje eksternog fajla sa strategijom citanja "a1"
			break;
		case "a2":
			//TODO: izvrsiti parsiranje/citanje eksternog fajla sa strategijom citanja "a2"
			break;
		case "a3":
			//TODO: izvrsiti parsiranje/citanje eksternog fajla sa strategijom citanja "a3"
			readFileStrategy= new A3Strategy();
			break;
		case "a4":
			//TODO: izvrsiti parsiranje/citanje eksternog fajla sa strategijom citanja "a4"
			readFileStrategy = new A4Strategy();
			break;
		case "a5":
			//TODO: izvrsiti parsiranje/citanje eksternog fajla sa strategijom citanja "a5"
			break;
		case "a6":
			//TODO: izvrsiti parsiranje/citanje eksternog fajla sa strategijom citanja "a6"
			break;
		case "a7":
			//TODO: izvrsiti parsiranje/citanje eksternog fajla sa strategijom citanja "a7"
			break;
		case "a8":
			//TODO: izvrsiti parsiranje/citanje eksternog fajla sa strategijom citanja "a8"
			break;
		case "a9":
			//TODO: izvrsiti parsiranje/citanje eksternog fajla sa strategijom citanja "a9"
			break;
		case "a10":
			//TODO: izvrsiti parsiranje/citanje eksternog fajla sa strategijom citanja "a10"
			break;
		case "a11":
			//TODO: izvrsiti parsiranje/citanje eksternog fajla sa strategijom citanja "a10"
			break;
		default:
			break;
		}
		
		this.data = readFileStrategy.readFile(property.path().toString());
		
		return this.data;
	}

	@Override
	public List<Data> getData()
	{
		return data;
	}
}
