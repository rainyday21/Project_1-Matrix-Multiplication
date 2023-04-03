import java.util.*;


public class classic_mm {
    public static void main(String[] args){
        int dim;
        if (args.length <= 0){
            System.out.print("Enter dimensions (2^x): ");
            Scanner kb = new Scanner(System.in);
            dim = (int)Math.pow(2, kb.nextInt());
            kb.close();
        }
        else
            dim = (int)Math.pow(2, Integer.valueOf(args[0]));
        long[][] m_cust = new long[dim][dim];
        if (dim <= 0) {
            System.out.println("Initial Array: " + Arrays.deepToString(m_cust));
            System.out.println("Divide and Conquer array:" +
                    Arrays.deepToString(m_cust));
        }
        else {
            int count = 1;
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    m_cust[i][j] = count;
                    count++;
                }
            }
            System.out.println("Initial Array: " + Arrays.deepToString(m_cust));
            System.out.println("Classical array:" +
                    Arrays.deepToString(classical(m_cust, m_cust)));
        }
    }
    
    public static long[][] classical(long[][] mat_1, long[][] mat_2){
        int rows = mat_1.length;
        int cols = mat_2[0].length;
        long[][] mat_f = new long[rows][cols];
        for (int i  = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                mat_f[i][j] = 0;
                for (int k = 0; k < mat_f.length; k++) {
                    mat_f[i][j] += mat_1[i][k] * mat_2[j][k];
                }
            }
        }
        return mat_f;
    }

}
