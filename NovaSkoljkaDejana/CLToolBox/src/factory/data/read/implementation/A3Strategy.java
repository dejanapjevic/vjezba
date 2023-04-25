package factory.data.read.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import factory.data.Data;
import factory.data.read.interfaces.ReadFileStrategyInterface;

public class A3Strategy implements ReadFileStrategyInterface<Data> {
	
	/**
	 * Ova metoda ispisuje listu rezultujućih podataka i ujedno nam pomaže da provjerimo da li smo pravilno
	 parsirali podatke po strategiji a3
	 * @author Dejana Pjevic
	 */
	
	public static void main(String[] args) {
		
		List<Data> p_lista=new A3Strategy().readFile("files");
		for (Data data : p_lista) {
			System.out.println(data.getKey()+" = "+data.getValue());
		}
		
	}
	/**
	 * Ova metoda vrši parsiranje i čitanje fajla po strategiji a3
	 * @param String path - ovaj parametar predstavlja putanju do fajla iz kojeg vršimo čitanje podataka
	 * @return List<Data> - povratna vrijednost metode je lista koja sadrži parsirane podatke
	 * @author Dejana Pjević
	 */

	@Override
	public List<Data> readFile(String path) {
		
		List<Data> lista = new Vector<>();
		File file = new File(path);
		BufferedReader reader = null;
		if(file.exists() && file.canRead()) {
			
			try {
				reader = new BufferedReader(new FileReader(file));
				Pattern pattern = Pattern.compile("(\\w\\d)\\[(\\d)\\]_(\\w\\d)\\[(\\d)\\]_(\\w\\d)\\[(\\d)\\];");
				
					while(reader.ready()) {
						Matcher matcher = pattern.matcher(reader.readLine());
						while(matcher.find()) {
							lista.add(new Data(matcher.group(1) + "[0]", Double.parseDouble(matcher.group(2))));
							lista.add(new Data(matcher.group(3) + "[0]", Double.parseDouble(matcher.group(4))));
							lista.add(new Data(matcher.group(5) + "[0]", Double.parseDouble(matcher.group(6))));
							
						}
					
			} } catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return lista;
	}

}
