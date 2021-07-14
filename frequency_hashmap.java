import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class frequency_hashmap{
    public static Scanner scn=new Scanner(System.in);

    public static void frequency(String str){
        HashMap<Character,Integer>hashMap=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
            // if(hashMap.containsKey(ch)){
            //     int val=hashMap.get(ch);
            //     hashMap.put(ch,val+1);
            // }
            // else{
            //     hashMap.put(ch,1);
            // }
        }
        for(Character key:hashMap.keySet()){
            System.out.println(key+": "+hashMap.get(key)+"; ");
        }
    }

    public static void indicesList(String str){
        HashMap<Character,ArrayList<Integer>>hashMap=new HashMap<>();
        for(int i=0;i<str.length();i++){
            Character ch=str.charAt(i);
            hashMap.putIfAbsent(ch,new ArrayList<>());
            // if(hashMap.containsKey(ch)){
            //     ArrayList<Integer> val=hashMap.get(ch);
            //     val.add(i);
            //     hashMap.put(ch,val);
            // }
            // else{
            //     ArrayList<Integer>val=new ArrayList<>();
            //     val.add(i);
            //     hashMap.put(ch,val);
            // }
            hashMap.get(ch).add(i);
        }
        for(Character key:hashMap.keySet()){
            System.out.println(key+": "+hashMap.get(key)+"; ");
        }
    }

    public static void main(String[] args){
        String str=scn.nextLine();
        // frequency(str);
        indicesList(str);

    
    }
}