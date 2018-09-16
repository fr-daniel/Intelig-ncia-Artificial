package br.ufc.romaniaMap.model;

public class Node implements Comparable<Node> {

	private State state;
	private Node father;
	private Action action;
	private Integer cost;
	
	public Node(State state, Node father, Action action, Integer cost) {
		super();
		this.state = state;
		this.father = father;
		this.action = action;
		this.cost = cost;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Node getFather() {
		return father;
	}

	public void setFather(Node father) {
		this.father = father;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	public int compareTo(Node node) {
		return this.cost.compareTo(node.getCost());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nocle [state=" + state + ", father=" + father + ", action=" + action + ", cost=" + cost + "]";
	}
	
}
