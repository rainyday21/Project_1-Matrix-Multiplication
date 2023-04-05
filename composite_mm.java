import java.util.*;


public class composite_mm {
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
            System.out.println("Classical array:" + Arrays.deepToString(m_cust));
            System.out.println("Divide and Conquer array:" +
                    Arrays.deepToString(m_cust));
            System.out.println("Strassen array: " + Arrays.deepToString(m_cust));
        }
        else {
            int count = 1;
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    m_cust[i][j] = count;
                    count++;
                }
            }
            //long[][] m_1 = {{1, 2, 3, 4}, {5, 6, 7}};
            //long[][] m_2 = {{1,2}, {3,4}};
            System.out.println("Initial Array: " + Arrays.deepToString(m_cust));
            System.out.println("Classical array:" + Arrays.deepToString(classical(m_cust, m_cust)));
            System.out.println("Divide and Conquer array:" +
                    Arrays.deepToString(div_n_conq(m_cust, m_cust)));
            System.out.println("Strassen array: " + Arrays.deepToString(strassen(m_cust, m_cust)));
        }
    }

    public static long[][] classical(long[ ][] mat_1, long[ ][] mat_2){
        int rows = mat_1.length;
        int cols = mat_2[0].length;
        long[ ][] mat_f = new long[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                mat_f[i][j] = 0;
                for (int k = 0; k < mat_f.length; k++)
                    mat_f[i][j] += mat_1[i][k] * mat_2[k][j];
            }
        }
        return mat_f;
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

    public static long[][] two_by_two(long[ ][] mat_1, long[ ][] mat_2){
        long[ ][] ans = new long[ 2][2];
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

    public static long[][] strassen(long[][] m_1, long[ ][] m_2) {
        long[][] mat_fin = new long[m_1.length][m_2[0].length];
        if (m_1.length == 2 && m_2.length == 2){
            mat_fin = mult(m_1, m_2);
        }
        else {
            int mid = m_1.length/2;
            long[][] a_11 = new long[mid][mid];
            long[][] a_12 = new long[mid][mid];
            long[][] a_21 = new long[mid][mid];
            long[][] a_22 = new long[mid][mid];
            long[][] b_11 = new long[mid][mid];
            long[][] b_12 = new long[mid][mid];
            long[][] b_21 = new long[mid][mid];
            long[][] b_22 = new long[mid][mid];

            for (int i = 0; i < mid; i++){
                for (int j = 0; j < mid; j++){
                    a_11[i][j] = m_1[i][j];
                    a_12[i][j] = m_1[i][j+mid];
                    a_21[i][j] = m_1[i+mid][j];
                    a_22[i][j] = m_1[i+mid][j+mid];
                    b_11[i][j] = m_2[i][j];
                    b_12[i][j] = m_1[i][j+mid];
                    b_21[i][j] = m_1[i+mid][j];
                    b_22[i][j] = m_1[i+mid][j+mid];
                }
            }

            long[][] p = strassen(
                    add(a_11, a_22),
                    add(b_11, b_22)
            );
            long[][] q = strassen(
                    add(a_21, a_22),
                    b_11
            );
            long[][] r = strassen(
                    a_11,
                    sub(b_12,b_22)
            );
            long[][] s = strassen(
                    a_22,
                    sub(b_21, b_11)
            );
            long[][] t = strassen(
                    add(a_11, a_12),
                    b_22
            );
            long[][] u = strassen(
                    sub(a_21, a_11),
                    add(b_11, b_12)
            );
            long[][] v = strassen(
                    sub(a_12, a_22),
                    add(b_21, b_22)
            );

            long[][] fin_11 = add(sub(add(p,s),t),v);
            long[][] fin_12 = add(r,t);
            long[][] fin_21 = add(q,s);
            long[][] fin_22 = add(sub(add(p,r),q),u);

            for (int i = 0; i < mid; i++){
                for (int j = 0; j < mid; j++) {
                    mat_fin[i][j] = fin_11[i][j];
                    mat_fin[i][j+mid] = fin_12[i][j];
                    mat_fin[i+mid][j] = fin_21[i][j];
                    mat_fin[i+mid][j+mid] = fin_22[i][j];

                }
            }
        }

        return mat_fin;

    }

    public static long[][] mult(long[][] mat_1, long[][] mat_2){
        long[][] ans = new long[mat_1.length][mat_2[0].length];
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

    public static long[][] sub(long [][] mat_1, long[][] mat_2){
        long [][] comb = new long[mat_1.length][mat_2[0].length];
        for (int i = 0; i < mat_1.length; i++){
            for (int j = 0; j < mat_1.length; j++){
                comb[i][j] = mat_1[i][j] - mat_2[i][j];
            }
        }
        return comb;
    }
}
