package com.utility;

import java.io.*;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {
	
	public static Environment readJSON(Env env) {
		
		Gson gson = new Gson();
		//File jsonFile = new File(System.getProperty("user.dir")+"\\config\\config.json");
		File jsonFile = new File("./config/config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment = config.getEnvironments().get("QA");
		return environment;
	}

}
