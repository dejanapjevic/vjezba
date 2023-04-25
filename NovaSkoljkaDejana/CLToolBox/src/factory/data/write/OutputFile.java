package factory.data.write;

import java.util.List;
import java.util.Scanner;

import factory.data.Data;
import factory.data.read.implementation.A4Strategy;
import factory.data.write.implementation.WriteB3Strategy;
import factory.data.write.implementation.WriteB4Strategy;
import factory.data.write.interfaces.WriteFileStrategyInterface;
import factory.interfaces.OutputFileInterface;
import helper.HelperClass;
import helper.TitlePosition;
import property.data.PropertyDataStructure;

public class OutputFile implements OutputFileInterface<Data>
{
	Scanner scanner;
	PropertyDataStructure property = null;

	WriteFileStrategyInterface<Data> dataWriteStrategy = null;

	public OutputFile(Scanner scanner, PropertyDataStructure property)
	{
		this.scanner = scanner;
		this.property = property;

		// TODO: Da li ovdje koristiti classLoader (dinamicko kreiranje objekata)?
		// Moze se koristi i HashMapa sa unaprijed definisanim objektima
		switch (property.writeStrategy())
		{
		case "b1":
			// TODO: izvrsiti upis eksternog fajla sa strategijom b1
			break;
		case "b2":
			// TODO: izvrsiti upis eksternog fajla sa strategijom b2
			break;
		case "b3":
			// TODO: izvrsiti upis eksternog fajla sa strategijom b3
			dataWriteStrategy = new WriteB3Strategy();
			break;
		case "b4":
			// TODO: izvrsiti upis eksternog fajla sa strategijom b4
			dataWriteStrategy = new WriteB4Strategy();
			break;
		case "b5":
			// TODO: izvrsiti upis eksternog fajla sa strategijom b5
			break;
		case "b6":
			// TODO: izvrsiti upis eksternog fajla sa strategijom b6
			break;
		case "b7":
			// TODO: izvrsiti upis eksternog fajla sa strategijom b7
			break;
		case "b8":
			// TODO: izvrsiti upis eksternog fajla sa strategijom b8
			break;
		case "b9":
			// TODO: izvrsiti upis eksternog fajla sa strategijom b9
			break;
		case "b10":
			// TODO: izvrsiti upis eksternog fajla sa strategijom b10
			break;
		case "b11":
			// TODO: izvrsiti upis eksternog fajla sa strategijom b10
			break;
		default:
			break;
		}
	}

	@Override
	public void writeData(List<Data> data)
	{
		menu: while (true)
		{
			System.out.println(HelperClass.headerLine(30, this.property.name(), TitlePosition.LEFT));
			System.out.println("[1] Ispis na konzolu");
			System.out.println("[2] Ispis u fajl");
			System.out.println("[0] Izlazak iz potprograma");
			System.out.println(HelperClass.footerLine(30));
			System.out.print("Unesite vrijednost: ");
			String s = scanner.nextLine();

			switch (s)
			{
			case "1":
				dataWriteStrategy.writeToScreen(data);
				break;
			case "2":
				dataWriteStrategy.writeToFile(scanner, data);
				break;
			case "0":
				break menu;
			default:
				System.out.println("Izabrana vrijednost ne postoji!");
				break;
			}

			System.out.println();
		}
	}
}
