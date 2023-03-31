import java.util.Arrays;

public class matrix_mult {
    public static void main(String[] args){
        int[][] m_1 = {{1,2}, {3,4}};
        //int[][] m_2 = {{1,2}, {3,4}};
        System.out.println(Arrays.deepToString(classical(m_1, m_1)));
    }
    
    public static int[][] classical(int[][] mat_1, int[][] mat_2){
        int rows = mat_1.length;
        int cols = mat_2[0].length;
        int[][] mat_f = new int[rows][cols];
        for (int i  = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                mat_f[i][j] = 0;
                for (int k = 0; k < mat_f.length-1; k++) {
                    mat_f[i][j] += mat_1[i][k] * mat_2[j][k];
                }
            }
        }
        return mat_f;
    }

    public static int[][] div_n_conq(int[][] mat_1, int[][] mat_2){
        int[][] ans;
            if ((mat_1.length == 2) && (mat_1[0].length == 2)) {
                ans = two_by_two(mat_1, mat_2);
            }
            else {
                int mat_1_11[][] = new int[mat_1.length/2][mat_1[0].length/2];
                int mat_1_12[][] = new int[mat_1.length/2][mat_1[0].length/2];
                int mat_1_21[][] = new int[mat_1.length/2][mat_1[0].length/2];
                int mat_1_22[][] = new int[mat_1.length/2][mat_1[0].length/2];

                int mat_2_11[][] = new int[mat_2.length/2][mat_1[0].length/2];
                int mat_2_12[][] = new int[mat_2.length/2][mat_1[0].length/2];
                int mat_2_21[][] = new int[mat_2.length/2][mat_1[0].length/2];
                int mat_2_22[][] = new int[mat_2.length/2][mat_1[0].length/2];
                
                for (int i = 0; i < mat_1.length/2; i++) {
                    for (int j = 0; j < mat_1[0].length/2; j++) {
                        mat_1_11[i][j] = mat_1[i][j];
                        mat_1_12[i][j] = mat_1[i][j+mat_1.length];
                        mat_1_21[i][j] = mat_1[i+mat_1.length][j];
                        mat_1_22[i][j] = mat_1[i+mat_1.length][j+mat_1.length];
                        mat_2_11[i][j] = mat_2[i][j];
                        mat_2_12[i][j] = mat_1[i][j+mat_1.length];
                        mat_2_21[i][j] = mat_1[i+mat_1.length][j];
                        mat_2_22[i][j] = mat_1[i+mat_1.length][j+mat_1.length];
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
            }
        return null;
        
    }

    public static int[][] add(int [][] mat_1, int[][] mat_2){
        int [][] comb = new int[mat_1.length][mat_2[0].length];
        for (int i = 0; i < mat_1.length; i++){
            for (int j = 0; j < mat_1.length; j++){
                comb[i][j] = mat_1[i][j] + mat[i][j];
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
