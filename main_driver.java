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
        int x,y;
        long[][] m1,m2, ans;
        long startTime,endTime;
        algo_time time;
        if (args.length > 2) {
            x = (int)Math.pow(2, Integer.parseInt(args[0]));
            y = (int)Math.pow(2, Integer.parseInt(args[1]));
            m1 = mat_gen(x,y);
            m2 = mat_gen(x,y);
            System.out.println("Matrix 1: " + Arrays.deepToString(m1));
            System.out.println("Matrix 2: " + Arrays.deepToString(m2));
            option = Integer.parseInt(args[2]);
        } else if (args.length == 2) {
            x = (int)Math.pow(2, Integer.parseInt(args[0]));
            y = (int)Math.pow(2, Integer.parseInt(args[1]));
            m1 = mat_gen(x,y);
            m2 = mat_gen(x,y);
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
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter amount of rows(2^x): ");
            x = (int)Math.pow(2,kb.nextInt());
            System.out.println("Enter amount of cols(2^x): ");
            y = (int)Math.pow(2,kb.nextInt());
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
                time = new algo_time(startTime, endTime);
                System.out.println("Classical: " + Arrays.deepToString(ans));
                System.out.println("Time(Classical): " + time.toString());
                break;
            case 1:
                startTime = System.nanoTime();
                ans = composite_mm.div_n_conq(m1,m2);
                endTime = System.nanoTime();
                time = new algo_time(startTime, endTime);
                System.out.println("Divide and Conquer: " + Arrays.deepToString(ans));
                System.out.println("Time(Div_n_Conq): " + time.toString());
                break;
            case 2:
                startTime = System.nanoTime();
                ans = composite_mm.strassen(m1,m2);
                endTime = System.nanoTime();
                time = new algo_time(startTime, endTime);
                System.out.println("Strassen: " + Arrays.deepToString(ans));
                System.out.println("Time(Strassen): " + time.toString());
                break;
            case 3:
                long[][] ans2;
                long[][] ans3;
                startTime = System.nanoTime();
                ans = composite_mm.classical(m1,m2);
                endTime = System.nanoTime();
                time = new algo_time(startTime, endTime);
                System.out.println("Classical: " + Arrays.deepToString(ans));
                System.out.println("Time(classical): " + time.toString()); // Classical
                startTime = System.nanoTime();
                ans2 = composite_mm.div_n_conq(m1,m2);
                endTime = System.nanoTime();
                time = new algo_time(startTime, endTime);
                System.out.println("Divide and Conquer: " + Arrays.deepToString(ans2));
                System.out.println("Time(div_n_conq): " + time.toString()); // Div and Conq
                startTime = System.nanoTime();
                ans3 = composite_mm.strassen(m1,m2);
                endTime = System.nanoTime();
                time = new algo_time(startTime, endTime);
                System.out.println("Strassen: " + Arrays.deepToString(ans3));
                System.out.println("Time(strassen): " + time.toString()); // Strassen
                break;

        }
    }
}

class algo_time {
    private double elapsed;
    private int option;
    public algo_time (double st_tm, double end_tm){
        elapsed = end_tm - st_tm;
        option = 0;
    }
    
    public algo_time(){elapsed = 0;} 
    
    public double at_raw(){
        return elapsed;
    }
    
    public void setOption(){
        while (elapsed > 1000 && option < 2) {
            elapsed/=1000;
            option+=1;
            setOption();
        }

    }
    public String toString() {
        String ret = elapsed + " nanoseconds";;
        setOption();
        if (option == 1)
            ret = elapsed + " microseconds";
        else if (option == 2)
                ret = elapsed + " seconds";
        return ret;
    }
}

