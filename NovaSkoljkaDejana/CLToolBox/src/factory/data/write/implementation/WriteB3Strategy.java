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
import factory.data.calculate.implementation.Potencije;
import factory.data.read.implementation.A3Strategy;
import factory.data.write.interfaces.WriteFileStrategyInterface;

public class WriteB3Strategy implements WriteFileStrategyInterface<Data> {
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		WriteB3Strategy b3 = new WriteB3Strategy();
		Potencije p = new Potencije();
		A3Strategy a3 = new A3Strategy();
		b3.writeToFile(s,  p.calculate(a3.readFile("files/data_a3_potencije.txt")));
	}
	
	
	private String writeToString (List<Data> resultData) 
	{
		String string = "data\nb3";
		for(int i=0 ; i<resultData.size() ; i++) {
			string+="\n" + "rezultat(" + (i+1)+ ") = " + resultData.get(i).getValue();
		}
		return string;
	}

	@Override
	public void writeToFile(Scanner scanner, List<Data> data) {

		BufferedWriter writer = null;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Unesite lokaciju na kojoj je vaš fajl: ");
		String doFajla=s.nextLine();
		Path putanjaDoFoldera= Paths.get(doFajla);
		if(!Files.exists(putanjaDoFoldera)) {
			try {
				Files.createDirectories(putanjaDoFoldera);
				System.out.println("Kreirani su direktorijumi koji su nedostajali...\n");
						
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Unesite naziv fajla: ");
		String nazivFajla=s.nextLine();
		Path putanjaDoFajla=Paths.get(doFajla+"\\"+nazivFajla);
		s.close();
		
		if(!Files.exists(putanjaDoFajla) && Files.isWritable(putanjaDoFajla)) {
			try {
				Files.createFile(putanjaDoFajla);
				System.out.println("Fajl nije postojao, ali je sada kreiran..\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			writer = new BufferedWriter(new FileWriter(putanjaDoFajla.toFile()));
			
			
			writer.write(this.writeToString(data));
				writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public void writeToScreen(List<Data> data) {
		System.out.println(this.writeToString(data));
		
	}

}
