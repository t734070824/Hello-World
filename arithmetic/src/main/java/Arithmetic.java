/**
 * @author 734070824@qq.com
 * @date 2024/4/2 14:37
 */
public class Arithmetic {

    /**
     * 打印一个M行N列的二维数组的转置(交换行和列)。
     */
    public static void printTranspose(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        printTranspose(arr);
//    }

    public static int mystery(int a, int b)
    {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }

    /**
     * 静态方法lg(),接受一个整型参数N,返回不大于 log2(N) 的最大整数
     * @param args
     */



    public static long F(int N)
    {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }
    public static void main(String[] args)
    {
        long[] memo = new long[100];
        for (int N = 0; N < 100; N++)
            System.err.println((N + " " + F(N, memo)));
    }


    public static long F(int N, long[] memo)
    {
        if (N == 0) {
            memo[N] = 0;
            return 0;
        }
        if (N == 1) {
            memo[N] = 1;
            return 1;
        }
        long exis = memo[N];
        if(exis != 0){
            return exis;
        }else{
            long f = F(N-1, memo) + F(N-2, memo);
            memo[N] = f;
            return f;
        }

    }


}
