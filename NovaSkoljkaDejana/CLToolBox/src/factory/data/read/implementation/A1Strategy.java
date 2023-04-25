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

public class A1Strategy implements ReadFileStrategyInterface<Data> {

public static void main(String[] args) {
		
		List<Data> p_lista=new A1Strategy().readFile("files/data_a1_sabiranje.txt");
		for (Data data : p_lista) {
			System.out.println(data.getKey()+" = "+data.getValue());
		}
		}
	@Override
	public List<Data> readFile(String path) {
		
		List<Data> lista = new Vector<>();
		File file = new File(path);
		BufferedReader reader = null;
		BufferedReader reader1 = null;
		if(file.exists() && file.canRead()) {
			
			try {
				reader = new BufferedReader(new FileReader(file));
				Matcher matcher=null;
				Pattern pattern = Pattern.compile("(\\w\\d)\\{\\[(\\d)\\];\\[(\\d)\\];\\[(\\d)\\]\\}:");
				
					while(reader.ready()) {
						 matcher = pattern.matcher(reader.readLine());
						while(matcher.find()) {
							lista.add(new Data(matcher.group(1) + "[0]", Double.parseDouble(matcher.group(2))));
							lista.add(new Data(matcher.group(1) + "[1]", Double.parseDouble(matcher.group(3))));
							lista.add(new Data(matcher.group(1) + "[2]", Double.parseDouble(matcher.group(4))));
							
						} }
					
					reader1 = new BufferedReader(new FileReader(file));
					
					while(reader1.ready()) {
						matcher = pattern.matcher(reader1.readLine());
						pattern = Pattern.compile("(\\w\\d)\\{\\[(\\d.\\d)\\];\\[(\\d.\\d)\\];\\[(\\d.\\d)\\]\\}:");
					while(matcher.find())  {
						lista.add(new Data(matcher.group(1)+"[0]", Double.parseDouble(matcher.group(2))));
						lista.add(new Data(matcher.group(1)+"[1]", Double.parseDouble(matcher.group(3))));
						lista.add(new Data(matcher.group(1)+"[2]", Double.parseDouble(matcher.group(4))));
						
					}}
			 } catch (FileNotFoundException e1) {
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
