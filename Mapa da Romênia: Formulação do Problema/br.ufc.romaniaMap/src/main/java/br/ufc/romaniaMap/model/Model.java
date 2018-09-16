package br.ufc.romaniaMap.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class Model {

	private Map<String, State> states;

	public Model() {
		this.states = new HashMap<String, State>();
		initialize();
	}
	
	private void initialize() {
		
		URL url = getClass().getResource("states.json");
		File file = new File(url.getPath());
	
		try {
			Reader fileReader = new FileReader(file);
			
			Gson gson = new Gson();
			State[] statesArray = gson.fromJson(fileReader, State[].class);
		
			for (State state : statesArray) {
				states.put(state.getName().toLowerCase(), state);
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	public void printStates() {
		for (State state : this.states.values()) {
			System.out.println(state + " " + state.getActions());
		}
	}
	
	public State getStates(String name) {
		return this.states.get(name.toLowerCase());
	}
	
}
