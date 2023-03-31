import java.util.*;


public class div_n_conq_mm {
    public static void main(String[] args){
        System.out.print("Enter dimensions (2^x): ");
        Scanner kb = new Scanner(System.in);
        int dim = (int)Math.pow(2, kb.nextInt());
        int[][] m_cust = new int[dim][dim];
        int count = 1;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                m_cust[i][j] = count;
                count++;
            }
        }
        System.out.println("Initial Array: " + Arrays.deepToString(m_cust));
        System.out.println("Divide and Conquer array:" +
            Arrays.deepToString(div_n_conq(m_cust, m_cust)));
    }
    
    public static int[][] div_n_conq(int[][] mat_1, int[][] mat_2){
        int[][] ans;
            if ((mat_1.length == 2) && (mat_1[0].length == 2)) {
                ans = two_by_two(mat_1, mat_2);
            }
            else {
                ans = new int[mat_1.length][mat_2.length];
                int mid = mat_1.length/2;
                int mat_1_11[][] = new int[mid][mid];
                int mat_1_12[][] = new int[mid][mid];
                int mat_1_21[][] = new int[mid][mid];
                int mat_1_22[][] = new int[mid][mid];

                int mat_2_11[][] = new int[mid][mid];
                int mat_2_12[][] = new int[mid][mid];
                int mat_2_21[][] = new int[mid][mid];
                int mat_2_22[][] = new int[mid][mid];
                
                for (int i = 0; i < mid; i++) {
                    for (int j = 0; j < mid; j++) {
                        mat_1_11[i][j] = mat_1[i][j];
                        mat_1_12[i][j] = mat_1[i][j+mid];
                        mat_1_21[i][j] = mat_1[i+mid][j];
                        mat_1_22[i][j] = mat_1[i+mid][j+mid];
                        mat_2_11[i][j] = mat_2[i][j];
                        mat_2_12[i][j] = mat_2[i][j+mid];
                        mat_2_21[i][j] = mat_2[i+mid][j];
                        mat_2_22[i][j] = mat_2[i+mid][j+mid];
                    }
                }
                int[][] ans_11 = add(
                        div_n_conq(mat_1_11, mat_2_11),
                        div_n_conq(mat_1_12, mat_2_21)
                    );
                int[][] ans_12 = add(
                        div_n_conq(mat_1_11, mat_2_12),
                        div_n_conq(mat_1_12, mat_2_22)
                    );
                int[][] ans_21 = add(
                        div_n_conq(mat_1_21, mat_2_11),
                        div_n_conq(mat_1_22, mat_2_21)
                    );
                int[][] ans_22 = add(
                        div_n_conq(mat_1_21, mat_2_12),
                        div_n_conq(mat_1_22, mat_2_22)
                    );

                for (int i = 0; i < mid; i++) {
                    for (int j = 0; j < mid; j++) {
                        ans[i][j] = ans_11[i][j];
                        ans[i][j+mid] = ans_12[i][j];
                        ans[i+mid][j] = ans_21[i][j];
                        ans[i+mid][j+mid] = ans_22[i][j];
                    }
                }
                           
            }
        return ans;
        
    }

    public static int[][] add(int [][] mat_1, int[][] mat_2){
        int [][] comb = new int[mat_1.length][mat_2[0].length];
        for (int i = 0; i < mat_1.length; i++){
            for (int j = 0; j < mat_1.length; j++){
                comb[i][j] = mat_1[i][j] + mat_2[i][j];
            }
        }
        return comb;
    }

    public static int[][] two_by_two(int[][] mat_1, int[][] mat_2){
        int[][] ans = new int[2][2];
        if ((mat_1.length == mat_1[0].length) && (mat_1.length == 2)){
            if ((mat_1.length == mat_1[0].length) && (mat_1.length == 2)) {
                ans[0][0] = (mat_1[0][0] * mat_2[0][0]) + (mat_1[0][1] * mat_2[1][0]);
                ans[0][1] = (mat_1[0][0] * mat_2[0][1]) + (mat_1[0][1] * mat_2[1][1]);
                ans[1][0] = (mat_1[1][0] * mat_2[0][0]) + (mat_1[1][1] * mat_2[1][0]);
                ans[1][1] = (mat_1[1][0] * mat_2[0][1]) + (mat_1[1][1] * mat_2[1][1]);
            }
        }
        return ans;
    }

}
