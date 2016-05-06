package dynamicProgramming2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Ficha referente ao assunto LCS
 *
 * Questao 01: Melhorar o algoritmo da LCS, tirar a tabela B
 *
 * @author juccelino.barros
 *
 */
public class LCSAlgorithm {

    public void lcsLength(List<String> x, List<String> y) {
       
        int m = x.size();
        int n = y.size();
        int[][] c = new int [m+1][n+1]; // linha x colunas
       
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.get(i-1) == y.get(j-1)){
                    c[i][j] = c[i-1][j-1] + 1;
                }else if (c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                }else{
                    c[i][j] = c[i][j-1];
                }
            }
        }
        this.printMatrix(c);
        this.printLCSWithoutB(c, x, y);
    }
   
    public void printLCSWithoutB(int [][] c, List<String> x, List<String> y) {
    	int i = x.size();
    	int j = y.size();
    	List<String> lcs = new ArrayList<String>();
    	while (c[i][j] > 0){
    		if (c[i][j] > c[i-1][j] & c[i][j] > c[i][j-1]) {
    			lcs.add(x.get(i-1));
    			i--;
    			j--;
    		}else if (c[i-1][j] > c[i][j-1]) {
    			i--;
    		}else{
    			j--;
    		}
    	}
    	Collections.reverse(lcs);
    	System.out.println(lcs);
    	
    }
    
    public void printMatrix(int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
   
   
    public static void main(String[] args) {
       
        LCSAlgorithm q1 = new LCSAlgorithm();
       
        List<String> x = Arrays.asList("A","B", "C", "B", "D", "A", "B");
        List<String> y = Arrays.asList("B", "D", "C","A","B", "A");
       
        q1.lcsLength(x, y);

    }

}
