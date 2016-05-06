package dynamicProgramming1;

public class MatrixMultiply {
	
	public int[][] matrixChainMultiply(int[][] A, int[][] s, int i, int j){
		if (i == j){
			// 0;
			return null;
		}else{
			return multiplySimpleMatrix(matrixChainMultiply(A, s, i, s[i][j]),	
					matrixChainMultiply(A, s, s[i][j]+1, j));
		}
		
		// Metodo deve retornar algo
	}
	
	public int[][] multiplySimpleMatrix(int[][] a, int[][] b){
		if (a[0].length != b.length) {
			System.out.println("Error: Dimensoes invalidas");
			return null;
		}else{
			int[][] result = new int[ a.length ][ b[0].length ];

			for (int i = 0; i < a.length; i++){

				for (int j = 0; j < b[0].length; j++) {
					int somatoria = 0;
					for (int k = 0; k < a[0].length; k++) {
						int produto = a[i][k] * b[k][j];
						somatoria += produto;
					}
					result[i][j] = somatoria ;
				}
			}
			System.out.println("\n****** RESULT");
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[0].length; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.print("\n");
			}
			return result;
		}
	}
	
	public void costMultiplyMatrix(int[][] a, int [][] b){
		if (a[0].length != b.length) {
			System.out.println("Error: Dimensoes invalidas");
		}else{
//			int[][] result = new int[ a.length ][ b[0].length ];
			int count = 0;
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
//					result[i][j] = 0;
					for (int k = 0; k < a[0].length; k++) {
						count++; // Contador de Multiplicacao
//						result[i][j] = result[i][j] + a[i][k]*b[k][j]; 
					}
				}
				
			}
			System.out.println("Quantidade de Op de Multiplicacao: "+count);
		}
		
	}
	
	public void matrixChainOrder(int [] p){
		int n = p.length - 1;
		int [][] m = new int [n][n];
		int [][] s = new int [n][n];
		
		for (int i = 0; i < n; i++) {
			m[i][i] = 0;
		}
		for (int l = 1; l < n; l++) {
			for (int i = 0; i < n-l; i++) {
				int j = i + l;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int q = m[i][k] + m[k+1][j] + p[i]*p[k+1]*p[j+1];
					if (q < m[i][j]){
						m[i][j] = q;
						s[i][j] = k + 1;
					}
				}
			}
			
		}
		System.out.println("M");
		printMatrix(m);
		System.out.println("S");
		printMatrix(s);
		System.out.println(printOptmalParents(s, 0, s.length-1));
		
	}
	
	public String printOptmalParents(int [][] s, int i, int j) {
		if (i == j) {
			 return "A[" + (i+1) + "]";
		} else {
			return "("+printOptmalParents(s, i, s[i][j] - 1)+
            printOptmalParents(s, s[i][j], j)+")";
		}
	}
	
	public void printMatrix(int [][] a){
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		MatrixMultiply q2 = new MatrixMultiply();
		q2.matrixChainOrder(new int[]{ 30, 35, 15, 5, 10, 20, 25 });
		
	}

}
