import java.util.*;


public class div_n_conq_mm {
    public static void main(String[] args){
        int dim;
        if (args.length <= 0){
            System.out.print("Enter dimensions (2^x): ");
        Scanner kb = new Scanner(System.in);
        dim = (int)Math.pow(2, kb.nextInt());
        kb.close();
        }
        else{
            dim = (int)Math.pow(2, Integer.valueOf(args[0]));
        }
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
            System.out.println("Divide and Conquer array:" +
                    Arrays.deepToString(div_n_conq(m_cust, m_cust)));
        }
    }
    
    public static long[][] div_n_conq(long[][] mat_1, long[][] mat_2){
        long[][] ans;
            if ((mat_1.length < 2) && mat_2[0].length < 2) {
                ans = new long[mat_1.length][mat_2[0].length];
                ans[0][0] = mat_1[0][0] * mat_2[0][0];
            }
            else if ((mat_1.length == 2) && (mat_2[0].length == 2)) {
                ans = two_by_two(mat_1, mat_2);
            }
            else {
                ans = new long[mat_1.length][mat_2.length];
                int mid = mat_1.length/2;
                long[][] mat_1_11 = new long[mid][mid];
                long[][] mat_1_12 = new long[mid][mid];
                long[][] mat_1_21 = new long[mid][mid];
                long[][] mat_1_22 = new long[mid][mid];

                long[][] mat_2_11 = new long[mid][mid];
                long[][] mat_2_12 = new long[mid][mid];
                long[][] mat_2_21 = new long[mid][mid];
                long[][] mat_2_22 = new long[mid][mid];
                
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
                long[][] ans_11 = add(
                        div_n_conq(mat_1_11, mat_2_11),
                        div_n_conq(mat_1_12, mat_2_21)
                    );
                long[][] ans_12 = add(
                        div_n_conq(mat_1_11, mat_2_12),
                        div_n_conq(mat_1_12, mat_2_22)
                    );
                long[][] ans_21 = add(
                        div_n_conq(mat_1_21, mat_2_11),
                        div_n_conq(mat_1_22, mat_2_21)
                    );
                long[][] ans_22 = add(
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

    public static long[][] add(long [][] mat_1, long[][] mat_2){
        long [][] comb = new long[mat_1.length][mat_2[0].length];
        for (int i = 0; i < mat_1.length; i++){
            for (int j = 0; j < mat_1.length; j++){
                comb[i][j] = mat_1[i][j] + mat_2[i][j];
            }
        }
        return comb;
    }

    public static long[][] two_by_two(long[][] mat_1, long[][] mat_2){
        long[][] ans = new long[2][2];
        if ((mat_1.length == mat_1[0].length) && (mat_1.length == 2)){
            if ((mat_2.length == mat_2[0].length) && (mat_2.length == 2)) {
                ans[0][0] = (mat_1[0][0] * mat_2[0][0]) + (mat_1[0][1] * mat_2[1][0]);
                ans[0][1] = (mat_1[0][0] * mat_2[0][1]) + (mat_1[0][1] * mat_2[1][1]);
                ans[1][0] = (mat_1[1][0] * mat_2[0][0]) + (mat_1[1][1] * mat_2[1][0]);
                ans[1][1] = (mat_1[1][0] * mat_2[0][1]) + (mat_1[1][1] * mat_2[1][1]);
            }
        }
        return ans;
    }

}
