import java.io.*;
import java.util.*;

public class min_cost_maze_traversal{
    public static Scanner scn=new Scanner(System.in);

    public static input(int[][]maze){
        for(int row=0;row<maze.length;row++){
            for(int col=0;col<maze[0].length;col++){
                maze[row][col]=scn.nextInt();
            }
        }
    }

    public static void minSumPath(int[][]maze,int startRow,int startCol,int[][]visited){
        visited[startRow][startCol]=true;
        for(int dir=0;dir<dirVector.length;dir++){

        }
    }
    
    

    public static void main(String[] args){
        int numRows=scn.nextInt();
        int numCols=scn.nextInt();

        int[][]maze=new int[numRows][numCols];
        input(maze);
        boolean[][]visited=new boolean[numRows][numCols];
        int[][]dirVectors={{},{},{},{}}
        String[]dirStrings=new String[4];
        minSumPath(maze,0,0,visited);

    }
}