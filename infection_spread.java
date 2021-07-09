import java.io.*;
import java.util.*;

public class infection_spread {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   public static class BreadthFirstClass{
        int vertex;
        int edgesSoFar;
        String pathSoFar;
        BreadthFirstClass(int vertex,int edgesSoFar,String pathSoFar){
            this.vertex=vertex;
            this.edgesSoFar=edgesSoFar;
            this.pathSoFar=pathSoFar;
        }
    }

    public static int breadthFirstTraversal(ArrayList<Edge>[] graph,int source,int t){
        boolean[]visited=new boolean[graph.length];
        Queue<BreadthFirstClass> q=new ArrayDeque<>();
        BreadthFirstClass sourceBreadthFirstClass=new BreadthFirstClass(source,0,""+source);
        q.add(sourceBreadthFirstClass);
        int count=0;
        while(q.size()>0){
            BreadthFirstClass removedBreadthFirstClass=q.remove();
            if(!visited[removedBreadthFirstClass.vertex]){
                visited[removedBreadthFirstClass.vertex]=true;
                System.out.println("vertex: "+removedBreadthFirstClass.vertex+" edgesSoFar: "+removedBreadthFirstClass.edgesSoFar+" pathSoFar: "+removedBreadthFirstClass.pathSoFar);
                if(removedBreadthFirstClass.edgesSoFar<t){
                    count++;
                }
                else{
                    return count;
                }
                for(Edge edge:graph[removedBreadthFirstClass.vertex]){
                    if(!visited[edge.nbr]){
                        BreadthFirstClass breadthFirstClass=new BreadthFirstClass(edge.nbr,removedBreadthFirstClass.edgesSoFar+1,removedBreadthFirstClass.pathSoFar+edge.nbr);
                        q.add(breadthFirstClass);
                    }
                }
            }
        }
        return count;
    }
   
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      System.out.println(breadthFirstTraversal(graph,src,t));
      
      // write your code here
   }

}