import java.io.*;
import java.util.HashMap;
import java.util.*;

public class longest_consecutive_sequence {
    public static Scanner scn = new Scanner( System.in );
    public static void input( int[] arr ){
        for( int i = 0; i < arr.length; i++){
            arr[ i ] = scn.nextInt();
        }
    }
    public static void output( ArrayList<Integer>al ){
        for( int i = 0; i < al.size(); i++){
            System.out.println(al.get(i));
        }
    }
    public static ArrayList< Integer > longestConsecutiveSequence( int[] arr ){
        PriorityQueue< ArrayList <Integer> > priorityQ = new PriorityQueue<>(( a, b )->{
            return b.size() - a.size();
        });
        HashMap< Integer, ArrayList< Integer > > hashMap = new HashMap<>();
        for( int i = 0; i < arr.length; i++){
            if( hashMap.containsKey( arr[ i ] ) ){
                continue;
            }
            boolean previousExists = hashMap.containsKey( arr[ i ] - 1 );
            boolean nextExists = hashMap.containsKey( arr[ i ] + 1 );
            if( !previousExists && !nextExists){
                ArrayList< Integer > arrayList = new ArrayList<>();
                arrayList.add( arr[ i ] );
                hashMap.put( arr[ i ], arrayList);
            }
            else if( previousExists && nextExists){
                ArrayList< Integer > previousArrayList = hashMap.get( arr[ i ] - 1);
                ArrayList< Integer > nextArrayList = hashMap.get( arr[ i ] + 1);
                if( previousArrayList != nextArrayList ){
                    previousArrayList.add( arr[ i ] );
                    hashMap.put( arr[ i ], previousArrayList);
                    for( int j = nextArrayList.size() - 1 ; j >= 0; j--){
                        int nextArrayListElement = nextArrayList.get( j );
                        previousArrayList.add( nextArrayListElement );
                        hashMap.put( nextArrayListElement, previousArrayList);
                        nextArrayList.remove( nextArrayList.size() - 1 );
                    }
                }
            }
            else if( previousExists ){
                ArrayList< Integer > arrayList = hashMap.get( arr[ i ] - 1);
                arrayList.add( arr[ i ] );
                hashMap.put( arr[ i ], arrayList );
            }
            else if( nextExists ){
                ArrayList< Integer > arrayList = hashMap.get( arr[ i ] + 1);
                arrayList.add( arr[ i ] );
                hashMap.put( arr[ i ], arrayList );
            }
        }
        for( int i = 0; i < arr.length; i++){
            priorityQ.add( hashMap.get( arr[ i ]));
        }
        return priorityQ.peek();
    }
    
    public static void main(String[] args) throws Exception {
    int size = scn.nextInt();
    
    int[] arr = new int[ size ];
    input( arr );
    ArrayList< Integer > arrayList = longestConsecutiveSequence(arr);
    Collections.sort( arrayList );
    output( arrayList );
    
    
 }

}