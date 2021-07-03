import java.util.ArrayList;
public class Graph{
    public int numberOfVertices;
    public class Edge{
        public int source;
        public int neighbour;
        public int weight;
        public Edge(int source,int neighbour,int weight){
            this.source=source;
            this.neighbour=neighbour;
            this.weight=weight;
        }
    }
    public class CeilFloorPair{
        int ceil;
        int floor;
        public CeilFloorPair(int ceil,int floor){
            this.ceil=ceil;
            this.floor=floor;
        }
    }
    public class PathWeightPair{
        String pathSoFar;
        int weightSoFar;
        PathWeightPair(String pathSoFar,int weightSoFar){
            this.pathSoFar=pathSoFar;
            this.weightSoFar=weightSoFar;
        }
    }
    public void addUndirectedEdge(int u,int v,int w){
        this.addDirectedEdge(u,v,w);
        this.addDirectedEdge(v,u,w);
    }
    public void addDirectedEdge(int u,int v,int w){
        this.adjacencyList.get(u).add(new Edge(u,v,w));
        this.adjacencyMatrix.get(u).get(v).add(w);
    }
    public void addUndirectedEdge(int u,int v){
        this.addUndirectedEdge(u,v,1);
    }
    public void addDirectedEdge(int u,int v){
        this.addDirectedEdge(u,v,1);
    }
    public Graph(int numberOfVertices){
        this.numberOfVertices=numberOfVertices;
        this.adjacencyList=new ArrayList<>();
        this.adjacencyMatrix=new ArrayList<>();
        for(int i=0;i<this.numberOfVertices;i++){
            this.adjacencyList.add(new ArrayList<>());
        }
        for(int i=0;i<this.numberOfVertices;i++){
            this.adjacencyMatrix.add(new ArrayList<>());
            for(int j=0;j<this.numberOfVertices;j++){
                this.adjacencyMatrix.get(i).add(new ArrayList<>());
            }
        }
    }
    public ArrayList<Edge> removeUndirectedEdges(int u,int v, int w){
        ArrayList<Edge>ret=new ArrayList<>();
        for(Edge edge:removeDirectedEdges(u,v,w)){
            ret.add(edge);
        }
        for(Edge edge:removeDirectedEdges(v,u,w)){
            ret.add(edge);
        }
        return ret;
    }
    public ArrayList<Edge> removeUndirectedEdges(int u,int v){
        ArrayList<Edge>ret=new ArrayList<>();
        for(Edge edge:removeDirectedEdges(u,v)){
            ret.add(edge);
        }
        for(Edge edge:removeDirectedEdges(v,u)){
            ret.add(edge);
        }
        return ret;
    }
    public ArrayList<Edge> removeDirectedEdges(int u,int v, int w){
        ArrayList<Edge>ret=new ArrayList<>();
        for(int i=this.adjacencyList.get(u).size()-1;i>=0;i--){
            Edge edge=this.adjacencyList.get(u).get(i);
            if(edge.neighbour==v && edge.weight==w){
                ret.add(this.adjacencyList.get(u).remove(i));
            }
        }
        for(int i=this.adjacencyMatrix.get(u).get(v).size()-1;i>=0;i--){
            int weight=this.adjacencyMatrix.get(u).get(v).get(i);
            if(weight==w){
                this.adjacencyMatrix.get(u).get(v).remove(i);
            }
        }
        return ret;
    }
    public ArrayList<Edge> removeDirectedEdges(int u,int v){
        ArrayList<Edge>ret=new ArrayList<>();
        for(int i=this.adjacencyList.get(u).size()-1;i>=0;i--){
            Edge edge=this.adjacencyList.get(u).get(i);
            if(edge.neighbour==v){
                ret.add(this.adjacencyList.get(u).remove(i));
            }
        }
        this.adjacencyMatrix.get(u).set(v,new ArrayList<>());
        return ret;
    }
    public void removeVertex(int u){
        for(int i=0;i<this.numberOfVertices;i++){
            for(int j=this.adjacencyList.get(i).size()-1;j>=0;j--){
                Edge edge=this.adjacencyList.get(i).get(j);
                if(edge.neighbour==u){
                    this.adjacencyList.get(i).remove(j);
                }
            }
        }
        for(int i=this.adjacencyList.get(u).size()-1;i>=0;i--){
            this.adjacencyList.get(u).remove(i);
        }
        for(int i=0;i<this.numberOfVertices;i++){
            this.adjacencyMatrix.get(u).set(i,new ArrayList<>());
        }
        for(int i=0;i<this.numberOfVertices;i++){
            this.adjacencyMatrix.get(i).set(u,new ArrayList<>());
        }
    }
    public void addVertex(){
        this.adjacencyList.add(new ArrayList<>());
        this.adjacencyMatrix.add(new ArrayList<>());
        for(int i=0;i<this.numberOfVertices;i++){
            this.adjacencyMatrix.get(i).add(new ArrayList<>());
        }
        this.numberOfVertices++;
        for(int i=0;i<this.numberOfVertices;i++){
            this.adjacencyMatrix.get(this.numberOfVertices-1).add(new ArrayList<>());
        }
    }
    public void preOrderPrintPathTraversal(int source,boolean[]visited,String path,int weightSoFar){
        System.out.println(source+"->"+path+source+"@"+weightSoFar);
        visited[source]=true;
        for(int i=0;i<this.adjacencyList.get(source).size();i++){
            Edge edge=this.adjacencyList.get(source).get(i);
            if(!visited[edge.neighbour]){
                preOrderPrintPathTraversal(edge.neighbour,visited,path+source,weightSoFar+edge.weight);
            }
        }
        visited[source]=false;
    }
    public void postOrderPrintPathTraversal(int source,boolean[]visited,String path,int weightSoFar){
        visited[source]=true;
        for(int i=0;i<this.adjacencyList.get(source).size();i++){
            Edge edge=this.adjacencyList.get(source).get(i);
            if(!visited[edge.neighbour]){
                postOrderPrintPathTraversal(edge.neighbour,visited,path+edge.neighbour,weightSoFar+edge.weight);
            }
        }
        visited[source]=false;
        System.out.println(source+"->"+path+"@"+weightSoFar);
    }
    public boolean hasPath(int source, int destination,boolean[] visited){
        if(source==destination){
            return true;
        }
        visited[source]=true;
        for(int i=0;i<this.adjacencyList.get(source).size();i++){
            Edge edge=this.adjacencyList.get(source).get(i);
            if(!visited[edge.neighbour]){
                boolean hasPath=hasPath(edge.neighbour,destination,visited);
                if(hasPath)return true;
            }
        }
        return false;
    }
    public int printAllPaths(int source, int destination,boolean[] visited,String path){
        if(source==destination){
            System.out.println(path+source);
            return 1;
        }
        visited[source]=true;
        int count=0;
        for(int i=0;i<this.adjacencyList.get(source).size();i++){
            Edge edge=this.adjacencyList.get(source).get(i);
            if(!visited[edge.neighbour]){
                count+=printAllPaths(edge.neighbour,destination,visited,path+source);
            }
        }
        visited[source]=false;
        return count;
    }
    public int heaviestEdgeWeight(int source,int destination,boolean[]visited){
        if(source==destination){
            return -(int)1e9;
        }
        visited[source]=true;
        int heaviestEdgeWeight=-(int)1e9;
        for(int i=0;i<this.adjacencyList.get(source).size();i++){
            Edge edge=this.adjacencyList.get(source).get(i);
            if(!visited[edge.neighbour]){
                heaviestEdgeWeight=Math.max(heaviestEdgeWeight,edge.weight);
                heaviestEdgeWeight=Math.max(heaviestEdgeWeight,heaviestEdgeWeight(edge.neighbour,destination,visited));
            }
        }
        visited[source]=false;
        return heaviestEdgeWeight;
    }
    
    public PathWeightPair heaviestPath(int source,int destination,boolean[]visited){
        if(source==destination){
            String str=""+source;
            return new PathWeightPair(str,0);
        }
        visited[source]=true;
        PathWeightPair pathWeightPair=new PathWeightPair("",-(int)1e9);
        for(int i=0;i<this.adjacencyList.get(source).size();i++){
            Edge edge=this.adjacencyList.get(source).get(i);
            if(!visited[edge.neighbour]){
                PathWeightPair recPathWeightPair=heaviestPath(edge.neighbour,destination,visited);
                if(recPathWeightPair.weightSoFar>-(int)1e9 && recPathWeightPair.weightSoFar+edge.weight>pathWeightPair.weightSoFar){
                    pathWeightPair.weightSoFar=recPathWeightPair.weightSoFar+edge.weight;
                    pathWeightPair.pathSoFar=source+recPathWeightPair.pathSoFar;
                }
            }
        }
        visited[source]=false;
        return pathWeightPair;
    }
    public int lightestEdgeWeight(int source,int destination,boolean[]visited){
        if(source==destination){
            return (int)1e9;
        }
        visited[source]=true;
        int lightestEdgeWeight=(int)1e9;
        for(int i=0;i<this.adjacencyList.get(source).size();i++){
            Edge edge=this.adjacencyList.get(source).get(i);
            if(!visited[edge.neighbour]){
                lightestEdgeWeight=Math.min(lightestEdgeWeight,edge.weight);
                lightestEdgeWeight=Math.min(lightestEdgeWeight,lightestEdgeWeight(edge.neighbour,destination,visited));
            }
        }
        visited[source]=false;
        return lightestEdgeWeight;
    }

    public PathWeightPair lightestPath(int source,int destination,boolean[]visited){
        if(source==destination){
            String str=""+source;
            return new PathWeightPair(str,0);
        }
        visited[source]=true;
        PathWeightPair pathWeightPair=new PathWeightPair("",(int)1e9);
        for(int i=0;i<this.adjacencyList.get(source).size();i++){
            Edge edge=this.adjacencyList.get(source).get(i);
            if(!visited[edge.neighbour]){
                PathWeightPair recPathWeightPair=lightestPath(edge.neighbour,destination,visited);
                if(recPathWeightPair.weightSoFar<(int)1e9 && recPathWeightPair.weightSoFar+edge.weight<pathWeightPair.weightSoFar){
                    pathWeightPair.weightSoFar=recPathWeightPair.weightSoFar+edge.weight;
                    pathWeightPair.pathSoFar=source+recPathWeightPair.pathSoFar;
                }
            }
        }
        visited[source]=false;
        return pathWeightPair;
    }

    public CeilFloorPair ceilFloor(int source,boolean[]visited,int data){
        visited[source]=true;
        CeilFloorPair ceilFloorPair=new CeilFloorPair((int)1e9,-(int)1e9);
        for(int i=0;i<this.adjacencyList.get(source).size();i++){
            Edge edge=this.adjacencyList.get(source).get(i);
            if(!visited[edge.neighbour]){
                CeilFloorPair recAns=ceilFloor(edge.neighbour,visited,data);
                if(recAns.ceil>data){
                    ceilFloorPair.ceil=Math.min(recAns.ceil,ceilFloorPair.ceil);
                }
                if(edge.weight>data){
                    ceilFloorPair.ceil=Math.min(edge.weight,ceilFloorPair.ceil);
                }
                if(recAns.floor<data){
                    ceilFloorPair.floor=Math.max(recAns.floor,ceilFloorPair.floor);
                }
                if(edge.weight<data){
                    ceilFloorPair.floor=Math.max(edge.weight,ceilFloorPair.floor);
                }
            }
        }
        visited[source]=false;
        return ceilFloorPair;
    }

    public int kthLargestEdge(int source,boolean[]visited,int k){

    }
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[\n");
        for(int i=0;i<this.adjacencyList.size();i++){
            sb.append(i+"->");
            for(Edge edge:this.adjacencyList.get(i)){
               sb.append("("+edge.neighbour+", "+edge.weight+"), ");
            }
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
    public void adjacencyMatrix(){
        System.out.print("\t");
        for(int i=0;i<this.numberOfVertices;i++){
            System.out.print(i+"\t");
        }
        System.out.println();
        for(int i=0;i<this.numberOfVertices;i++){
            System.out.print(i+"\t");
            for(int j=0;j<this.numberOfVertices;j++){
                if(adjacencyMatrix.get(i).get(j).size()==0){
                    System.out.print(0+", ");
                }
                for(Integer weight:adjacencyMatrix.get(i).get(j)){
                    System.out.print(weight+", ");
                }
                System.out.print(";\t");
            }
            System.out.println();
        }
    }
    private ArrayList<ArrayList<Edge>>adjacencyList;
    private ArrayList<ArrayList<ArrayList<Integer>>>adjacencyMatrix;
}