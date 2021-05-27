import java.io.*;
import java.util.*;
public class nqueen {
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n=scn.nextInt();
        int[][]chessBoard=new int[n][n];
        nqueen(chessBoard,"",0);
    }
    public static void nqueen(int[][]chessBoard,String qsf,int row){
        if(row==chessBoard.length){
            System.out.println(qsf+".");
            return;
        }
        else if(row<chessBoard.length){
            int i=row;
            for(int j=0;j<chessBoard.length;j++){
                if(chessBoard[i][j]==0){
                    row++;==
                    String qsfPrev=qsf;
                    qsf=qsf+i+"-"+j+",";
                    int min=i<=j ? i : j;
                    int max=i+j>=chessBoard.length ? i+j : chessBoard.length;
                    for(int x=0;x<max;x++){
                        if(x<chessBoard.length && chessBoard[i][x]==0)chessBoard[i][x]=row;
                        if(x<chessBoard.length && chessBoard[x][j]==0)chessBoard[x][j]=row;
                        if(i-min+x<chessBoard.length && j-min+x<chessBoard.length && chessBoard[i-min+x][j-min+x]==0)chessBoard[i-min+x][j-min+x]=row;
                        if(i-x>=0 && j+x<chessBoard.length && chessBoard[i-x][j+x]==0)chessBoard[i-x][j+x]=row;
                        if(j-x>=0 && i+x<chessBoard.length && chessBoard[i+x][j-x]==0)chessBoard[i+x][j-x]=row;
                    }
                    nqueen(chessBoard,qsf,row);
                    for(int x=0;x<max;x++){
                        if(x<chessBoard.length && chessBoard[i][x]==row)chessBoard[i][x]=0;
                        if(x<chessBoard.length && chessBoard[x][j]==row)chessBoard[x][j]=0;
                        if(i-min+x<chessBoard.length && j-min+x<chessBoard.length && chessBoard[i-min+x][j-min+x]==row)chessBoard[i-min+x][j-min+x]=0;
                        if(i-x>=0 && j+x<chessBoard.length && chessBoard[i-x][j+x]==row)chessBoard[i-x][j+x]=0;
                        if(j-x>=0 && i+x<chessBoard.length && chessBoard[i+x][j-x]==row)chessBoard[i+x][j-x]=0;
                    }
                    row--;
                    qsf=qsfPrev;
                }
            }
        }
    }
}