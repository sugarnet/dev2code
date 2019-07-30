package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class CrazyFortuneService implements FortuneService {

	private String messages[];
	
	public CrazyFortuneService() {
		this.loadMessagesFromFile();
	}
	
	@Override
	public String getFortune() {
		
		Random random = new Random();
		return this.messages[random.nextInt(this.messages.length)];

	}
	
	private void loadMessagesFromFile() {
		File file = new File("/home/dscifo/Documentos/Workspace/eclipse/dev2code/spring-demo-annotations/src/com/luv2code/springdemo/fortunes.txt");
		List<String> messages = new ArrayList<String>();
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String read;
			read = bufferedReader.readLine();
			while (read != null) {
				messages.add(read);
				read = bufferedReader.readLine();
			}
			this.messages = messages.toArray(new String[messages.size()]);
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
