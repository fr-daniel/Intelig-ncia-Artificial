package br.ufc.romaniaMap.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Model {

	private Map<String, State> states;

	public Model() {
		this.states = new HashMap<String, State>();
		initializeStates();
		initializeActions();
	}

	public Map<String, State> getStates() {
		return states;
	}

	public State getState(String name) {
		State state = states.get(name.toLowerCase());
		if (state != null) {
			return state;
		}
		throw new IllegalArgumentException("Não existe estado com o nome: " + name);
	}

	public void printStates() {
		System.out.println("Estado / Ações");
		for (State state : this.states.values()) {
			System.out.println(state);
		}
	}

	private void initializeStates() {
		states.put("neamt", new State("Neamt"));
		states.put("oradea", new State("Oradea"));
		states.put("zerind", new State("Zerind"));
		states.put("arad", new State("Arad"));
		states.put("timisoara", new State("Timisoara"));
		states.put("lugoj", new State("Lugoj"));
		states.put("mehadia", new State("Mehadia"));
		states.put("drobeta", new State("Drobeta"));
		states.put("craiova", new State("Craiova"));
		states.put("sibiu", new State("Sibiu"));
		states.put("fagaras", new State("Fagaras"));
		states.put("pitesti", new State("Pitesti"));
		states.put("vaslui", new State("Vaslui"));
		states.put("iasi", new State("Iasi"));
		states.put("rimnicu vilcea", new State("Rimnicu Vilcea"));
		states.put("bucharest", new State("Bucharest"));
		states.put("giurgiu", new State("Giurgiu"));
		states.put("urziceni", new State("Urziceni"));
		states.put("hirsova", new State("Hirsova"));
		states.put("eforie", new State("Eforie"));
	}

	private void initializeActions() {
		states.get("neamt").setActions(Arrays.asList(create("iasi", 87)));
		states.get("oradea").setActions(Arrays.asList(create("zerind", 71), create("sibiu", 151)));
		states.get("zerind").setActions(Arrays.asList(create("arad", 75), create("oradea", 71)));
		states.get("arad")
				.setActions(Arrays.asList(create("zerind", 75), create("sibiu", 140), create("timisoara", 118)));
		states.get("timisoara").setActions(Arrays.asList(create("arad", 118), create("lugoj", 111)));
		states.get("lugoj").setActions(Arrays.asList(create("timisoara", 111), create("mehadia", 70)));
		states.get("mehadia").setActions(Arrays.asList(create("lugoj", 70), create("drobeta", 75)));
		states.get("drobeta").setActions(Arrays.asList(create("mehadia", 75), create("craiova", 120)));
		states.get("craiova")
			.setActions(Arrays.asList(create("drobeta", 120), create("rimnicu vilcea", 146), create("pitesti", 138)));
		states.get("sibiu").setActions(Arrays.asList(create("fagaras", 99), create("rimnicu vilcea", 80),
				create("arad", 140), create("oradea", 151)));
		states.get("fagaras").setActions(Arrays.asList(create("bucharest", 211), create("sibiu", 99)));
		states.get("pitesti")
			.setActions(Arrays.asList(create("bucharest", 101), create("craiova", 138), create("rimnicu vilcea", 97)));
		states.get("vaslui").setActions(Arrays.asList(create("iasi", 92), create("urziceni", 142)));
		states.get("iasi").setActions(Arrays.asList(create("neamt", 87), create("vaslui", 92)));
		states.get("rimnicu vilcea")
				.setActions(Arrays.asList(create("sibiu", 80), create("pitesti", 97), create("craiova", 146)));
		states.get("bucharest").setActions(Arrays.asList(create("giurgiu", 90), create("urziceni", 85),
				create("pitesti", 101), create("fagaras", 211)));
		states.get("giurgiu").setActions(Arrays.asList(create("bucharest", 90)));
		states.get("urziceni")
				.setActions(Arrays.asList(create("hirsova", 98), create("bucharest", 85), create("vaslui", 142)));
		states.get("hirsova").setActions(Arrays.asList(create("urziceni", 98)));
		states.get("eforie").setActions(Arrays.asList(create("hirsova", 86)));
	}

	private Action create(String nameToState, Integer cost) {
		return new Action(states.get(nameToState), cost);
	}
}
