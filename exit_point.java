import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class exit_point{
    public static Scanner scn=new Scanner(System.in);
    public static void input(int[][]a)  { 
        int n=a.length;
        int m=a[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                a[i][j]=scn.nextInt();
            }
        }
    }
    public static int turn(int dir){
        return (dir+1)%4;
    }

    // public static void wait(int ms){
    //     try
    //     {
    //     Thread.sleep(ms);
    //     }
    // catch(InterruptedException ex)
    //     {
    //     Thread.currentThread().interrupt();
    //     }
    // }
    
    
    public static void main(String args[]) throws Exception {
        int[][]a=new int[scn.nextInt()][scn.nextInt()];
        input(a);
        int n=a.length;
        int m=a[0].length;

        int dir=0, i=0, j=0;
    

        while(true){
            if(dir==0){
                while(j<=m){
                    // System.out.println(dir);
                    // System.out.println("a["+i+"]["+j+"]"+a[i][j]);
                    // wait(1000);
                    if(j<m && a[i][j]==0)
                    j++;
                    if(j<m && a[i][j]==1){
                        dir=(dir+1)%4;
                        i++;
                        break;
                    }
                    if(j==m){
                        System.out.println(i);
                        System.out.println(m-1);
                        return;
                    }
                }
            }
    
            if(dir==1){
                while(i<=n){
                    // System.out.println(dir);
                    // System.out.println("a["+i+"]["+j+"]"+a[i][j]);
                    // wait(1000);
                    if(i<n && a[i][j]==0)
                    i++;
                    if(i<n && a[i][j]==1){
                        dir=(dir+1)%4;
                        j--;
                        break;
                    }
                    if(i==n){
                        System.out.println(n-1);
                        System.out.println(j);
                        return;
                    }
                }
            }
            if(dir==2){
                while(j>=-1){
                    // System.out.println(dir);
                    // System.out.println("a["+i+"]["+j+"]"+a[i][j]);
                    // wait(1000);
                    if(-1<j && a[i][j]==0)
                    j--;
                    if(-1<j && a[i][j]==1){
                        dir=(dir+1)%4;
                        i--;
                        break;
                    }
                    if(j==-1){
                        System.out.println(i);
                        System.out.println(0);
                        return;
                    }
                }
            }
            if(dir==3){
                // System.out.println(dir);
                // System.out.println("a["+i+"]["+j+"]"+a[i][j]);
                // wait(1000);
                while(i>=-1){
                    if(-1<i && a[i][j]==0)
                    i--;
                    if(-1<i && a[i][j]==1){
                        dir=(dir+1)%4;
                        j++;
                        break;
                    }
                    if(i==-1){
                        System.out.println(0);
                        System.out.println(j);
                        return;
                    }
                }
            }

        }
    }
}