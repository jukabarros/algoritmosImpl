package dynamicProgramming2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ficha referente ao assunto Algoritmo Guloso - Selecao de Atividades
 *
 * Questao 02: Inserir um novo parametro na selecao de atividades, o valor monetário
 * que é composto por tempo de inicio + tempo de fim. Agora o objetivo eh 
 * maximizar o valor monetário
 *
 * @author juccelino.barros
 *
 */
public class GreedyAlgorithm {

	/**
	 * Algoritmo que gera o maior numero de atividade consecutiva
	 * de acordo com o tempo de inicio e o tempo de fim. O tempo de fim
	 * deve esta ordenado. Com isso o primeiro elemento (k=1) da lista A
	 * eh a atividade a qual queremos utilizar como heuristica para identificar
	 * as demais.
	 * 
	 * @param s tempo de inicio
	 * @param f tempo de fim
	 */
	public void greedyActivitySelector(List<Integer> s, List<Integer> f, List<Integer> v) {
		int n = s.size();
		List<String> A = new ArrayList<String>(); 
		A.add("a"+1);
		int k = 1;
		for (int m = 0; m < n; m++) {
			if (s.get(m) >= f.get(k)) {
				int x = 0;
				for (int i = m; i < n; i++) {
					// Capturando o maior index do valor monetario
					if (v.get(i) > v.get(x)) {
						x = i;
					}
				}
				// Verifica se a atividade pode ser add
				if (s.get(x) >= f.get(k)) {
					k = x;
					A.add("a"+(k+1));
				}
			}
		}
		System.out.println(A);
	}
	
	public static void main(String[] args) {

		GreedyAlgorithm q2 = new GreedyAlgorithm();
		List<Integer> s = Arrays.asList(1,3,0,5,3,5,6,8,8,2,12);
		// Array F deve esta ORDENADO
		List<Integer> f = Arrays.asList(4,5,6,7,8,9,10,11,12,14,16);

		List<Integer> v = Arrays.asList(0,2,2,3,4,1,8,5,10,6,9);

		System.out.println("s: "+ s);
		System.out.println("f: "+ f);
		System.out.println("------------------------------------------------");
		System.out.println("v: "+v);

		q2.greedyActivitySelector(s, f, v);

	}

}
