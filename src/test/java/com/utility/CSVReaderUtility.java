package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {

		//File file = new File(System.getProperty("user.dir") + "//Test Data//"+fileName);
		File file = new File("./Test Data/"+fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] csvRow;
		List<User> userList = null;
		User userData;
		
		try {
			fileReader = new FileReader(file);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext(); // This line will read first line in csv file which is column names.However, it
									// will skips it since we are not storing it in String array.
			userList = new ArrayList<User>();
			
			while ((csvRow = csvReader.readNext()) != null) {// This will start from line 2, where test data starts.
				userData = new User(csvRow[0], csvRow[1]);
				userList.add(userData);

			}
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (CsvValidationException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return userList.iterator();
	}
	
}
