public class bst{
    public class Node{
        int size(Node node){
            return node==null ? 0 : size(node.left) + size(node.right) + 1;
        }
        int sum(Node node){
            return node==null ? 0 : size(node.left) + size(node.right) + node.data;
        }
        int height(Node node){
//??
        }
        int maximum(Node node){
            if(node==null)return -1;
            while(node.right!=null){
                node=node.right;
            }
            return node.data;
        }
        int minimum(Node node){
            if(node==null)return -1;
            while(node.left!=null){
                node=node.left;
            }
            return node.data;
        }
        boolean find(Node node,int data){
            while(node!=null){
                if(data>node.data){
                    node=node.right;
                }
                else if(data<node.data){
                    node=node.left;
                }
                else{
                    return true;
                }
            }
            return false;
        }
        ArrayList<Integer> nodeToRootPath(Node node,int data){
            ArrayList<Integer>ret=new ArrayList<>();
            boolean found=false;
            while(node!=null){
                ret.add(node.data);
                if(data>node.data){
                    node=node.right;
                }
                else if(data<node.data){
                    node=node.left;
                }
                else if(data==node.data){
                    found=true;
                    break;
                }
            }
            if(!flag)ret.clear();
            Collections.reverse(list);
            return ret;
        }
    }
    
}