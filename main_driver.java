import java.util.*;
public class main_driver {

    public static long[][] mat_gen(int x, int y){
        Random ran = new Random();
        long[][] mat = new long[x][y];
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                mat[i][j] = ran.nextLong(20);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int option;
        long[][] m1,m2, ans;
        long time,startTime,endTime;
        if (args.length > 2) {
            m1 = mat_gen(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            m2 = mat_gen(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            System.out.println("Matrix 1: " + Arrays.deepToString(m1));
            System.out.println("Matrix 2: " + Arrays.deepToString(m2));
            option = Integer.parseInt(args[2]);
        } else if (args.length == 2) {
            m1 = mat_gen(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            m2 = mat_gen(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            System.out.println("Matrix 1: " + Arrays.deepToString(m1));
            System.out.println("Matrix 2: " + Arrays.deepToString(m2));
            System.out.println("Enter the matrix you wish to test: ");
            System.out.println("""
                    Classical(0)
                    Divide and Conquer(1)
                    Straseen(2)
                    All(3)
                    Enter:\s""");
            Scanner kb = new Scanner(System.in);
            option = kb.nextInt();
            kb.close();
        } else {
            int x,y;
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter amount of rows: ");
            x = kb.nextInt();
            System.out.println("Enter amount of cols: ");
            y = kb.nextInt();
            m1 = mat_gen(x, y);
            m2 = mat_gen(x, y);
            System.out.println("Matrix 1: " + Arrays.deepToString(m1));
            System.out.println("Matrix 2: " + Arrays.deepToString(m2));
            System.out.println("Enter the matrix you wish to test: ");
            System.out.println("""
                    Classical(0)
                    Divide and Conquer(1)
                    Strassen(2)
                    All(3)
                    Enter:\s""");
            option = kb.nextInt();
            kb.close();
        }
        switch (option){
            case 0:
                startTime = System.nanoTime();
                ans = composite_mm.classical(m1,m2);
                endTime = System.nanoTime();
                time = (endTime - startTime);
                System.out.println("Classical: " + Arrays.deepToString(ans));
                System.out.println("Time: " + time);
                break;
            case 1:
                startTime = System.nanoTime();
                ans = composite_mm.div_n_conq(m1,m2);
                endTime = System.nanoTime();
                time = (endTime - startTime);
                System.out.println("Divide and Conquer: " + Arrays.deepToString(ans));
                System.out.println("Time: " + time);
                break;
            case 2:
                startTime = System.nanoTime();
                ans = composite_mm.strassen(m1,m2);
                endTime = System.nanoTime();
                time = (endTime - startTime);
                System.out.println("Strassen: " + Arrays.deepToString(ans));
                System.out.println("Time: " + time);
                break;
            case 3:
                startTime = System.nanoTime();
                ans = composite_mm.classical(m1,m2);
                long[][] ans2 = composite_mm.div_n_conq(m1,m2);
                long[][] ans3 = composite_mm.strassen(m1,m2);
                endTime = System.nanoTime();
                time = (endTime - startTime);
                System.out.println("Classical: " + Arrays.deepToString(ans));
                System.out.println("Divide and Conquer: " + Arrays.deepToString(ans2));
                System.out.println("Strassen: " + Arrays.deepToString(ans3));
                System.out.println("Time: " + time);
                break;

        }
    }
}

