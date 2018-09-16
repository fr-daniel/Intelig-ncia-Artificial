package br.ufc.romaniaMap.test;

import java.util.Scanner;

import br.ufc.romaniaMap.model.Model;
import br.ufc.romaniaMap.search.BuscaEmProfundidade;

public class TestBuscaProfundidade {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
			
		System.out.print("Nome do estado atual: ");
		String nameCurrentState = scan.nextLine();
		
		System.out.print("Nome do estado destino: ");
		String nameDestinationState = scan.nextLine();
		
		System.out.println();
		
		Model model = new Model();
		BuscaEmProfundidade emProfundidade = new BuscaEmProfundidade(model);
		
		long tempoInicio = System.currentTimeMillis();
		
		emProfundidade.showRoute(nameCurrentState, nameDestinationState);
		
		long diferencaTempo = (System.currentTimeMillis() - tempoInicio);
		System.out.printf("Tempo Total: %02d segundos e %02d milisegundos\n", diferencaTempo/60, diferencaTempo%60);
		
	}
	
}
