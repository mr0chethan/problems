import java.io.*;
import java.util.*;

public class graph_print_all_paths {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   public static int printAllPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis,String psf) {
        if(src==dest){
            System.out.println(psf+src);
            return 1;
        }
        int count=0;
        vis[src]=true;
        for(Edge edge:graph[src]){
            if(!vis[edge.nbr]){
                count+=printAllPath(graph,edge.nbr,dest,vis,psf+src);
            }
        }
        vis[src]=false;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());
      boolean[]vis=new boolean[vtces];
      for(int i=0;i<vtces;i++){
          vis[i]=false;
      }
      printAllPath(graph,src,dest,vis,"");

      // write all your codes here
   }


}