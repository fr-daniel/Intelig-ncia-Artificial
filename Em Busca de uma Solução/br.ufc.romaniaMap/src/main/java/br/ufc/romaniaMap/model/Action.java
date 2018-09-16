package br.ufc.romaniaMap.model;

public class Action {

	private State toState;
	private Integer cost;

	public Action() {
	}

	public Action(State toState, Integer cost) {
		super();
		this.toState = toState;
		this.cost = cost;
	}

	public State getToState() {
		return toState;
	}

	public void setToState(State toState) {
		this.toState = toState;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "(" + toState.getName() + ", " + cost + ")";
	}

}
