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

public class A4Strategy implements ReadFileStrategyInterface<Data> {
	/**
	 * Ova main metoda ispisuje listu rezultujućih podataka i ujedno nam pomaže da vidimo jesmo
	   li uspješno izvršili parsiranje po strategiji "a4"
	 * @author Dejana Pjević
	 */

	public static void main(String[] args) {
		A4Strategy a4 = new A4Strategy();
		List<Data> list = a4.readFile("files/data_a4_dijeljenje.txt");
		for(Data d:list)
			System.out.println(d.getKey()+ " "+d.getValue());
	}

	/**
	 * Meotda  vrši čitanje i parsiranje fajla po strategiji "a4"
	 * @param String path - putanja do fajla
	 * @return lista koja sadrži učitane podatke
	 * @author Dejana Pjević
	 */
	@Override
	public List<Data> readFile(String path) {
		
		List<Data> list = new Vector<>();
		File file = new File(path);
		BufferedReader reader = null;
		
		if(file.exists() && file.canRead()) {
			
			try {
				reader = new BufferedReader(new FileReader(file));
				Pattern pattern = Pattern.compile("(\\w\\d)\\((\\d*,?\\d*)\\);?");
				while(reader.ready()) {
					Matcher matcher = pattern.matcher(reader.readLine());
					
					while(matcher.find()) {
						list.add(new Data(matcher.group(1)+"[0]",Double.parseDouble(matcher.group(2).replace(",", "."))));
						
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(reader!=null) {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			
		}
		return list;
	}

}
