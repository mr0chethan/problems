import java.util.ArrayList;

public class my_graph {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    public static void display(ArrayList<Edge>[] graph, int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.nbr + ", " + e.wt + ") ");
            }
            System.out.println();
        }
    }

    public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {
        ArrayList<Edge> list = graph[u];
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);
            if (e.nbr == v)
                return i;
        }

        return -1;
    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v) {
        int i1 = findEdge(graph, u, v);
        int i2 = findEdge(graph, v, u);

        graph[u].remove(i1);
        graph[v].remove(i2);
    }

    public static void removeVtx(ArrayList<Edge>[] graph, int u) {
        ArrayList<Edge> list = graph[u];
        for (int i = list.size() - 1; i >= 0; i--) {
            Edge e = list.get(i);
            removeEdge(graph, e.src, e.nbr);
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest)
            return true;

        vis[src] = true;
        boolean res = false;
        for (Edge e : graph[src])
            if (!vis[e.nbr])
                res = res || hasPath(graph, e.nbr, dest, vis);

        return res;
    }

    public static void preOrder(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis,int wsf,String psf) {
        System.out.println(src+"->"+psf+src+"@"+wsf);
        // if(src==dest){
        //     return;
        // }
        vis[src]=true;
        for(Edge edge:graph[src]){
            if(!vis[edge.nbr]){
                preOrder(graph,edge.nbr,dest,vis,wsf+edge.wt,psf+src);
            }
        }
        vis[src]=false;
    }
    public static void postOrder(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis,int wsf,String psf) {
        // if(src==dest){
        //     System.out.println(src+"->"+psf+src+"@"+wsf);
        //     return;
        // }
        vis[src]=true;
        for(Edge edge:graph[src]){
            if(!vis[edge.nbr]){
                postOrder(graph,edge.nbr,dest,vis,wsf+edge.wt,psf+src);
            }
        }
        vis[src]=false;
        System.out.println(src+"->"+psf+src+"@"+wsf);
    }

    // public static void preOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf) {
    //     System.out.println(src + " -> " + (psf + src) + " @ " + wsf);
    //     vis[src] = true;
    //     for (Edge e : graph[src]) {
    //         if (!vis[e.nbr])
    //             preOrder(graph, e.nbr, vis, wsf + e.wt, psf + src);
    //     }

    //     vis[src] = false;
    // }

    // public static void postOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf) {
    //     vis[src] = true;
    //     for (Edge e : graph[src]) {
    //         if (!vis[e.nbr])
    //             postOrder(graph, e.nbr, vis, wsf + e.wt, psf + e.nbr);
    //     }

    //     System.out.println(src + " -> " + psf + " @ " + wsf);
    //     vis[src] = false;
    // }


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
        return count;
    }

    // public static pathPair heaviestPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
    //     if (src == dest) {
    //         pathPair base = new pathPair();
    //         base.psf += src;
    //         base.wsf = -1;

    //         return base;
    //     }

    //     vis[src] = true;
    //     pathPair myAns = new pathPair();
    //     for (Edge e : graph[src]) {
    //         if (!vis[e.nbr]) {
    //             pathPair recAns = heaviestPath(graph, e.nbr, dest, vis);
    //             if (recAns.wsf != -1 && recAns.wsf + e.wt > myAns.wsf) {
    //                 myAns.psf = src + recAns.psf;
    //                 myAns.wsf = recAns.wsf + e.wt;
    //             }
    //         }
    //     }
    //     vis[src] = false;
    //     return myAns;
    // }

    // public static pathPair lightestPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
    //     if (src == dest) {
    //         pathPair base = new pathPair();
    //         base.psf += src;
    //         base.wsf = (int)1e9;
    //         return base;
    //     }

    //     vis[src] = true;
    //     pathPair myAns = new pathPair();
    //     for (Edge e : graph[src]) {
    //         if (!vis[e.nbr]) {
    //             pathPair recAns = lightestPath(graph, e.nbr, dest, vis);
    //             if (recAns.wsf != -1 && recAns.wsf + e.wt > myAns.wsf) {
    //                 myAns.psf = src + recAns.psf;
    //                 myAns.wsf = recAns.wsf + e.wt;
    //             }
    //         }
    //     }
    //     vis[src] = false;
    //     return myAns;
    // }

    // public static void heaviestPath(ArrayList<Edge>[] graph, int src, int dest) {
    //     boolean[] vis = new boolean[graph.length];
    //     pathPair ans = heaviestPath(graph, src, dest, vis);

    //     System.out.println("Heaviest Path: " + ans.psf + " of weight: " + ans.wsf);
    // }

    // public static void ceilAndFloor(ArrayList<Edge>[]graph,int src,int data,boolean[]vis,int wsf,ceilFloorPair pair){
    //     if(wsf>data){
    //         pair.ceil=Math.min(pair.ceil,wsf);
    //     }
    //     if(wsf<data){
    //         pair.floor=Math.max(pair.floor,wsf);
    //     }
    //     vis[src]=true;
    //     for(Edge e:graph[src]){
    //         if(!vis[e.nbr]){
    //             ceilAndFloor(graph,e.nbr,data,vis,wsf+e.wt,pair);
    //         }
    //     }
    //     vis[src]=false;
    // }
    

   

    public static void construction(){
        int N = 7;
        ArrayList<Edge>[] graph = new ArrayList[N];
       
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);
        boolean vis[]=new boolean[N];
        // System.out.println(hasPath(graph,0,6,vis));
        preOrder(graph,0,6,vis,0,"");
        // postOrder(graph,0,6,vis,0,"");


    }

    
    public static void main(String[] args){
        construction();
    
    }
}
