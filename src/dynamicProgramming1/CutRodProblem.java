package dynamicProgramming1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutRodProblem {
	
	/**
	 * Imprime a receita maxima de acordo com o primeiro corte
	 * @param p Lista de preco
	 * @param n tamanho do corte
	 */
	public void extendedBottonUpCutRod(List<Integer> p, int n) {
		List<Integer> r = new ArrayList<>();
		r.add(0); // Receita maxima
		List<Integer> s = new ArrayList<>();
		for (int j = 0; j < n+1; j++) {
			s.add(0);
			int q = Integer.MIN_VALUE;
			for (int i = 0; i < j+1; i++) {
				if (q < p.get(i) + r.get(j-i)){
					q = p.get(i) + r.get(j-i);
					s.set(j, i);
				}
			}
			r.add(q);
		}
		System.out.println("R: "+r); // Receita
		System.out.println("S: "+s); // Local primeiro Corte
		
	}
	
	
	/**
	 * CUT ROD usando Prog Dinamica
	 * @param p valor de cada corte
	 * @param n local do corte
	 * 
	 * print Receita maxima de acordo com o tamanho do corte
	 */
	public void bottomUpCutRod(List<Integer> p, int n) {
		List<Integer> r = new ArrayList<Integer>(p.size());
		r.add(0);
		for (int j = 0; j < n; j++) {
			int q = Integer.MIN_VALUE;
			for (int i = 0; i < j; i++) {
				q = Math.max(q, p.get(i) + r.get(j-i));
				
			}
			r.add(j, q);
		}
		System.out.println(r.get(n));
	}
	
	
	public void extendedBottonUpCutRodCost(List<Integer> p, int n, int c){
		List<Integer> r = new ArrayList<>();
		r.add(0); // Receita maxima
		List<Integer> s = new ArrayList<>();
		s.add(0); // Tamanho otimo do primeiro corte
		for (int j = 1; j < n+1; j++) {
			s.add(0);
			int q = Integer.MIN_VALUE;
			for (int i = 1; i < j+1; i++) {
				if (q < p.get(i) + r.get(j-i)){
					q = p.get(i) + r.get(j-i);
					s.set(j, i);
					if (s.get(j) < j){
						q = q - c;
					}
				}
			}
			r.add(q);
		}
		System.out.println("R: "+r); // Receita
		System.out.println("S: "+s); // Primeiro Corte
	}
	
	/**
	 * CUT ROD tradicional, sem utilizar prog dinamica.
	 * Custo Exponencial
	 * @param p haste
	 * @param n corte
	 * @return q receita maxima
	 */
	public Integer cutRod(List<Integer> p, int n) {
		if (n == 0) {
			return 0;
		}
		int q = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			q = Math.max(q, (p.get(i) + cutRod(p, n-i)) );
		}
		return q;
	}
	
	public static void main(String[] args) {
		
		CutRodProblem q1 = new CutRodProblem();
		// valor de cada corte
		List<Integer> p = Arrays.asList(1,5,8,9,10,17,17,20,24,30); 
		q1.extendedBottonUpCutRod(p, 9);
		//		q1.extendedBottonUpCutRodCost(p, 9, 2);
		


	}

}
