package br.ufc.romaniaMap.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import br.ufc.romaniaMap.exception.FinaleStateNotFoundException;
import br.ufc.romaniaMap.model.Action;
import br.ufc.romaniaMap.model.Model;
import br.ufc.romaniaMap.model.Node;
import br.ufc.romaniaMap.model.State;

public class BuscaCustoUniforme {

	private Queue<Node> borda = new PriorityQueue<Node>();
	private ArrayList<State> explorados = new ArrayList<State>();

	private Model model;

	private State currentState;
	private State destinationState;

	private Node lastNode;

	private LinkedList<State> route = new LinkedList<State>();

	public BuscaCustoUniforme(Model model) {
		this.model = model;
	}

	public LinkedList<State> getRoute(String nameCurrentState, String nameDestinationState) {
		currentState = model.getState(nameCurrentState);
		destinationState = model.getState(nameDestinationState);

		try {
			searchLastNode();
		} catch (FinaleStateNotFoundException e) {
			System.out.println(e.getMessage());
		}

		createRoute();
		return this.route;
	}

	public void showRoute(String nameCurrentState, String nameDestinationState) {
		System.out.println("---------- Rota ----------\n");

		for (State state : getRoute(nameCurrentState, nameDestinationState)) {
			System.out.println(state.getName());
		}

		System.out.println("\nCusto da Rota: " + lastNode.getCost());
		System.out.println("----------------------------\n");
	}

	private void searchLastNode() throws FinaleStateNotFoundException {
		Node startingNode = new Node(currentState, null, null, 0);
		borda.add(startingNode);

		while (!borda.isEmpty()) {
			Node parentNode = borda.poll();
			
			if(parentNode.getState().equals(destinationState)) {
				this.lastNode = parentNode;
				break;
			}
			
			explorados.add(parentNode.getState());

			createChildNodes(parentNode);
		}
		
		if(this.lastNode == null)
			throw new FinaleStateNotFoundException("Estado final não encontrado!");
	}

	private void createChildNodes(Node parentNode) {
		for (Action action : parentNode.getState().getActions()) {
			
			State childNodeState = action.getToState();
			Integer childNodeCost = parentNode.getCost() + action.getCost();
			Node childNode = new Node(childNodeState, parentNode, action, childNodeCost);
			
			if (!explorados.contains(childNode.getState()) && !borda.contains(childNode)) {
				borda.add(childNode);
			} else if(borda.contains(childNode)) {
				changeNodeIfCostIsGreater(childNode);
			}
		}
	}

	private void changeNodeIfCostIsGreater(Node childNode) {
		List<Node> temporaryNodelist = new ArrayList<Node>();
		
		while (!borda.peek().equals(childNode)) {
			temporaryNodelist.add(borda.poll());
		}

		if (borda.peek().getCost() > childNode.getCost()) {
			borda.poll();
			borda.add(childNode);
		}

		borda.addAll(temporaryNodelist);
	}

	private void createRoute() {
		Node previousNode = this.lastNode;

		while (previousNode.getFather() != null) {
			route.addFirst(previousNode.getState());
			previousNode = previousNode.getFather();
		}

		route.addFirst(previousNode.getState());
	}

}
