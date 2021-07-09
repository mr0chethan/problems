import java.io.*;
import java.util.*;

public class Main {
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

   static class Pair implements Comparable<Pair> {
      int wsf;
      String psf;

      Pair(int wsf, String psf){
         this.wsf = wsf;
         this.psf = psf;
      }

      public int compareTo(Pair o){
         return this.wsf - o.wsf;
      }
   }
   public static class PathWeightPair{
        String pathSoFar;
        int weightSoFar;
        PathWeightPair(String pathSoFar,int weightSoFar){
            this.pathSoFar=pathSoFar;
            this.weightSoFar=weightSoFar;
        }
    }
   
   public static PathWeightPair heaviestPath(ArrayList<Edge>[]graph,int source,int destination,boolean[]visited){
        if(source==destination){
            String str=""+source;
            return new PathWeightPair(str,0);
        }
        visited[source]=true;
        PathWeightPair pathWeightPair=new PathWeightPair("",-(int)1e9);
        for(int i=0;i<graph[source].size();i++){
            Edge edge=graph[source].get(i);
            if(!visited[edge.nbr]){
                PathWeightPair recPathWeightPair=heaviestPath(graph,edge.nbr,destination,visited);
                if(recPathWeightPair.weightSoFar>-(int)1e9 && recPathWeightPair.weightSoFar+edge.wt>pathWeightPair.weightSoFar){
                    pathWeightPair.weightSoFar=recPathWeightPair.weightSoFar+edge.wt;
                    pathWeightPair.pathSoFar=source+recPathWeightPair.pathSoFar;
                }
            }
        }
        visited[source]=false;
        return pathWeightPair;
    }
    
    public static PathWeightPair lightestPath(ArrayList<Edge>[]graph,int source,int destination,boolean[]visited){
        if(source==destination){
            String str=""+source;
            return new PathWeightPair(str,0);
        }
        visited[source]=true;
        PathWeightPair pathWeightPair=new PathWeightPair("",(int)1e9);
        for(int i=0;i<graph[source].size();i++){
            Edge edge=graph[source].get(i);
            if(!visited[edge.nbr]){
                PathWeightPair recPathWeightPair=lightestPath(graph,edge.nbr,destination,visited);
                if(recPathWeightPair.weightSoFar<(int)1e9 && recPathWeightPair.weightSoFar+edge.wt<pathWeightPair.weightSoFar){
                    pathWeightPair.weightSoFar=recPathWeightPair.weightSoFar+edge.wt;
                    pathWeightPair.pathSoFar=source+recPathWeightPair.pathSoFar;
                }
            }
        }
        visited[source]=false;
        return pathWeightPair;
    }
    public static class CeilFloorPathClass{
        int ceilWeightSoFar;
        int floorWeightSoFar;
        String ceilPathSoFar;
        String floorPathSoFar;
        CeilFloorPathClass(int ceilWeightSoFar,int floorWeightSoFar,String ceilPathSoFar, String floorPathSoFar ){
            this.ceilWeightSoFar=ceilWeightSoFar;
            this.floorWeightSoFar=floorWeightSoFar;
            this.ceilPathSoFar=ceilPathSoFar;
            this.floorPathSoFar=floorPathSoFar;
        }
    }
    // public static CeilFloorPathClass ceilFloorPaths(ArrayList<Edge>[]graph, int source,boolean[]visited,int data){
    //     visited[source]=true;
    //     CeilFloorPathClass ceilFloorPathObject=new CeilFloorPathClass((int)1e9,0,"","");
    //     int edgeCallCount=0;
    //     for(Edge edge: graph[source]){
    //         if(!visited[edge.nbr]){
    //             edgeCallCount++;
    //             CeilFloorPathClass edgeCeilFloorPathObject=ceilFloorPaths(graph,edge.nbr,visited,data-edge.wt);
    //             if(edgeCeilFloorPathObject.ceilWeightSoFar+edge.wt>data && edgeCeilFloorPathObject.ceilWeightSoFar+edge.wt<ceilFloorPathObject.ceilWeightSoFar){
    //                 ceilFloorPathObject.ceilWeightSoFar=edgeCeilFloorPathObject.ceilWeightSoFar+edge.wt;
    //                 ceilFloorPathObject.ceilPathSoFar=edgeCeilFloorPathObject.ceilPathSoFar;
    //             }
    //             if(edgeCeilFloorPathObject.floorWeightSoFar+edge.wt<data && edgeCeilFloorPathObject.floorWeightSoFar+edge.wt>ceilFloorPathObject.floorWeightSoFar){
    //                 ceilFloorPathObject.floorWeightSoFar=edgeCeilFloorPathObject.floorWeightSoFar+edge.wt;
    //                 ceilFloorPathObject.floorPathSoFar=edgeCeilFloorPathObject.floorPathSoFar;
    //             }
    //         }
    //     }
    //     visited[source]=false;
    //     if(edgeCallCount==0){
    //         ceilFloorPathObject.ceilWeightSoFar=0;
    //         ceilFloorPathObject.floorWeightSoFar=0;
    //     }
    //     ceilFloorPathObject.ceilPathSoFar=source+ceilFloorPathObject.ceilPathSoFar;
    //     ceilFloorPathObject.floorPathSoFar=source+ceilFloorPathObject.floorPathSoFar;
    //     return ceilFloorPathObject;
    // }
    public static void ceilFloorPaths(ArrayList<Edge>[]graph,int source, int destination,boolean[]visited,int data,PathWeightPair pathWeightPair,CeilFloorPathClass ceilFloorPathObject){
        if(source==destination){
            if(pathWeightPair.weightSoFar>data && pathWeightPair.weightSoFar<ceilFloorPathObject.ceilWeightSoFar){
                ceilFloorPathObject.ceilWeightSoFar=pathWeightPair.weightSoFar;
                ceilFloorPathObject.ceilPathSoFar=pathWeightPair.pathSoFar;
            }
            if(pathWeightPair.weightSoFar<data && pathWeightPair.weightSoFar>ceilFloorPathObject.floorWeightSoFar){
                ceilFloorPathObject.floorWeightSoFar=pathWeightPair.weightSoFar;
                ceilFloorPathObject.floorPathSoFar=pathWeightPair.pathSoFar;
            }
        }
        visited[source]=true;
        for(int i=0;i<graph[source].size();i++){
            Edge edge=graph[source].get(i);
            if(!visited[edge.nbr]){
                PathWeightPair edgePathWeightPair=new PathWeightPair(pathWeightPair.pathSoFar+edge.nbr,pathWeightPair.weightSoFar+edge.wt);
                ceilFloorPaths(graph,edge.nbr,destination,visited,data,edgePathWeightPair,ceilFloorPathObject);
            }
        }
        visited[source]=false;
    }
    
    public static void kthLargestPath(ArrayList<Edge>[]graph,int source,int destination,int k, boolean[] visited,PathWeightPair pathWeightPair, PriorityQueue<PathWeightPair>priorityQ){
        if(source==destination){
            if(priorityQ.size()<k){
                priorityQ.add(pathWeightPair);
            }
            else if(priorityQ.peek().weightSoFar<pathWeightPair.weightSoFar){
                priorityQ.remove();
                priorityQ.add(pathWeightPair);
            }
        }
        visited[source]=true;
        for(int i=0;i<graph[source].size();i++){
            Edge edge=graph[source].get(i);
            if(!visited[edge.nbr]){
                PathWeightPair edgePathWeightPair=new PathWeightPair(pathWeightPair.pathSoFar+edge.nbr,pathWeightPair.weightSoFar+edge.wt);
                kthLargestPath(graph,edge.nbr,destination,k,visited,edgePathWeightPair,priorityQ);
            }
        }
        visited[source]=false;
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

      int criteria = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      boolean[] visited = new boolean[vtces];
    //   multisolver(graph, src, dest, visited, criteria, k, src + "", 0);
    PathWeightPair smallestPair=lightestPath(graph,src,dest,visited);
    PathWeightPair largestPair=heaviestPath(graph,src,dest,visited);
    // CeilFloorPathClass ceilFloorPathObject=ceilFloorPaths(graph,src,visited,criteria);
    CeilFloorPathClass ceilFloorPathObject=new CeilFloorPathClass((int)1e9,-(int)1e9,"","");
    ceilFloorPaths(graph,src,dest,visited,criteria,new PathWeightPair(""+src,0),ceilFloorPathObject);
    PriorityQueue<PathWeightPair>priorityQ=new PriorityQueue<>((a,b)->{
                return a.weightSoFar-b.weightSoFar;
            }
        );
        PathWeightPair pathWeightPair=new PathWeightPair(""+src,0);
        kthLargestPath(graph,0,6,4,visited,pathWeightPair,priorityQ);
    
      
      System.out.println("Smallest Path = " + smallestPair.pathSoFar + "@" + smallestPair.weightSoFar);
      System.out.println("Largest Path = " + largestPair.pathSoFar + "@" + largestPair.weightSoFar);
      System.out.println("Just Larger Path than " + criteria + " = " + ceilFloorPathObject.ceilPathSoFar+"@" + ceilFloorPathObject.ceilWeightSoFar);
      System.out.println("Just Smaller Path than " + criteria + " = " +ceilFloorPathObject.floorPathSoFar+ "@" + ceilFloorPathObject.floorWeightSoFar);
      System.out.println(k + "th largest path = " + priorityQ.peek().pathSoFar + "@" + priorityQ.peek().weightSoFar);
   }



//   static String spath;
//   static Integer spathwt = Integer.MAX_VALUE;
//   static String lpath;
//   static Integer lpathwt = Integer.MIN_VALUE;
//   static String cpath;
//   static Integer cpathwt = Integer.MAX_VALUE;
//   static String fpath;
//   static Integer fpathwt = Integer.MIN_VALUE;
//   static PriorityQueue<Pair> pq = new PriorityQueue<>();
   public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
      
   }
}