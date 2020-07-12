package org.example.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.json.simple.JSONObject;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Environment {

	private static Environment instance = new Environment();

	private DocumentContext jsonContext;

	private Environment() {
		try (InputStream inputStream = new FileInputStream("config.json")) {
			Reader fileReader = new InputStreamReader(inputStream);
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(fileReader);
			jsonContext = JsonPath.parse(jsonObject);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static Environment getInstance() {
		return instance;
	}

	public String getValue(String keyJsonPath) {
		return jsonContext.read(keyJsonPath);
	}

}
