import java.util.*;
import java.io.*;
public class prob3{
    public static Scanner scn=new Scanner(new InputStreamReader(System.in));
    public static void main(String[]args){
        int t=scn.nextInt();
        while(t-->0){
            int n=scn.nextInt();
            int[]arr=new int[n];
            for(int i=0;i<n;i++){
                int a=scn.nextInt();
                arr[i]=a;
            }
            int[][]dp=new int[n][200];
            int a=solve(arr,new boolean[200],0,dp);
            System.out.println(a);
            // display(dp);
        }
    }
    public static void display(int[][]arr){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static int solve(int[]arr,boolean[]ar,int idx,int [][]dp){
        if(idx == arr.length){
            return 0;
        }
        // if(dp[idx]!=0)
        // return dp[idx];
        int c=1000000;
        int a=0;
        int ii=0;
        for(int i=0;i<ar.length;i++){
            if(!ar[i]){
                ar[i]=true;
                int calc=i+1-arr[idx];
                if(dp[idx][i]!=0)
                a=dp[idx][i];
                else
                a=solve(arr,ar,idx+1,dp)+ (calc>=0?calc:-calc);
                c=Math.min(a,c);
                ar[i]=false;
                dp[idx][i]=c;
            }
        }
        return c;
    }
}