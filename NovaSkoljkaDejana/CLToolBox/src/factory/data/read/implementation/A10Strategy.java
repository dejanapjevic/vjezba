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

public class A10Strategy implements ReadFileStrategyInterface<Data>{

public static void main(String[] args) {
		
		List<Data> p_lista=new A10Strategy().readFile("files/data_a10_suma2.txt");
		for (Data data : p_lista) {
			System.out.println(data.getKey()+" = "+data.getValue());
		}
		}
	
	
	
	@Override
	public List<Data> readFile(String path) {
		List<Data> list = new Vector<>();
		File file = new File (path);
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;
		Matcher matcher =null;
		if(file.canRead() && file.exists()) {
			
			try {
				
				reader1 = new BufferedReader(new FileReader(file));
				Pattern pattern = Pattern.compile("(\\w\\d)\\{(\\d)/(\\d)/(\\d)\\}>?");
				while(reader1.ready()) {
					 matcher = pattern.matcher(reader1.readLine());
					while(matcher.find()) {
						
						list.add(new Data(matcher.group(1)+"[0) ", matcher.group(2)));
						list.add(new Data(matcher.group(1)+"[1) ", matcher.group(3)));
						list.add(new Data(matcher.group(1)+"[2) ", matcher.group(4)));
					}
				}
				reader2 = new BufferedReader(new FileReader(file));
				pattern = Pattern.compile("(\\w\\d)\\{(\\d.\\d)/(\\d.\\d)/(\\d.\\d)\\}>?");
				while(reader2.ready()) {
					matcher = pattern.matcher(reader2.readLine());
					while(matcher.find()) {
						list.add(new Data(matcher.group(1)+"[0) ", matcher.group(2)));
						list.add(new Data(matcher.group(1)+"[1) ", matcher.group(3)));
						list.add(new Data(matcher.group(1)+"[2) ", matcher.group(4)));
					
						
					}
				
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}

}
