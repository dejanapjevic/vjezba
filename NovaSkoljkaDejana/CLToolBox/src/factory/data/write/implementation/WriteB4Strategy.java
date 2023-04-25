package factory.data.write.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import factory.data.Data;
import factory.data.write.interfaces.WriteFileStrategyInterface;

public class WriteB4Strategy implements WriteFileStrategyInterface<Data> {
	
	/**
	 * Meotoda ispisuje rezultate u formatu b4 strategije, koji je prethodno zadat
	 * @param resultData - lista koja sadži izračunate vrijednosti
	 * @return string - novi format ispisa
	 * @author Dejana Pjević
	 */
	private String writeToString (List<Data> resultData) {
		String string = "data\nb4";
		int i=1;
		for(Data d : resultData) {
			string+="\nrez("+i+") = " + d.getValue();
			i++;
			}
		return string;
		
	}
/**
 * Meotda ispisuje izračunate vrijednosti u eksterni fajl
 * @param scanner - skener za učitavanje podataka sa sistemske konzole
 * @param data - lista koja sadrži izračunate podatke
 * @author Dejana Pjević
 */
	@Override
	public void writeToFile(Scanner scanner, List<Data> data) {
		
		BufferedWriter writer = null;
		System.out.println("Unesite lokaciju fajla");
		Path putanjDoFajla = Paths.get(scanner.nextLine());
		
		if(!Files.exists(putanjDoFajla)) {
			try {
				Files.createDirectories(putanjDoFajla.getParent());
				Files.createFile(putanjDoFajla);
				System.out.println("Fajl je kreiran..\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(Files.exists(putanjDoFajla) && Files.isWritable(putanjDoFajla)) {
			
			try {
				writer = new BufferedWriter(new FileWriter(putanjDoFajla.toFile()));
				writer.write(this.writeToString(data));
				System.out.println("Upis je završen...\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(writer!=null)
					try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		}
	
		
		
	}
/**
 * Ova metoda ispisuje izračunate vrijednosti na sistemsku konzolu
 * @param data - lista koja sadrži izračunate vrijednosti
 * @author Dejana Pjević
 */
	@Override
	public void writeToScreen(List<Data> data) {
		for(Data d : data)
			System.out.println(d.getKey()+ " " + d.getValue());
		
	}

}
