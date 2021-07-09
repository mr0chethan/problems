import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.ArrayList;

public class heap_sir {
    public static void Int_minPQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default min Priority Queue
        for (int i = 10; i >= 1; i--)
            pq.add(i * 10);

        while (pq.size() != 0)
            System.out.println(pq.remove());
    }

    public static void Int_maxPQ() {
        // this - other, default behaviour.
        // other - this, reverse of default behaviour.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int i = 10; i >= 1; i--)
            pq.add(i * 10);

        while (pq.size() != 0)
            System.out.println(pq.remove());
    }

    public static void matrixPQ(int[][] arr) {
        PriorityQueue<int[]> priorityQ=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        for(int i=0;i<arr.length;i++){
            priorityQ.add(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=priorityQ.remove();
        }
    }

    public static class mobilePhone {
        String Company = "";
        String Model = "";
        int Ram = 0;
        int Storage = 0;
        int BatteryBackup = 0;

        mobilePhone(String Company, String Model, int Ram, int Storage, int BatteryBackup) {
            this.Company = Company;
            this.Model = Model;
            this.Ram = Ram;
            this.Storage = Storage;
            this.BatteryBackup = BatteryBackup;
        }

        mobilePhone(){

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            
            sb.append("Company: " + this.Company + "\n");
            sb.append("Model: " + this.Model + "\n");
            sb.append("Ram: " + this.Ram + "GB\n");
            sb.append("Storage: " + this.Storage + "GB\n");
            sb.append("BatteryBackup: " + this.BatteryBackup + "mAH\n");
            
            return sb.toString();
        }
    }
    public static void mobilePhonePQ(ArrayList<mobilePhone>phones){
        int size=phones.size();
        PriorityQueue<mobilePhone> priorityQ=new PriorityQueue<>((a,b)->{
            if(a.Ram!=b.Ram){
                return b.Ram-a.Ram;
            }
            else if(a.Storage!=b.Storage){
                return b.Storage-a.Storage;
            }
            else{
                return b.BatteryBackup-a.BatteryBackup;
            }
        });
        for(int i=size-1;i>=0;i--){
            priorityQ.add(phones.remove(i));
        }
        for(int i=0;i<size;i++){
            phones.add(priorityQ.remove());
        }
    }
    public static Scanner scn= new Scanner(System.in);
    public static void input(int[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=scn.nextInt();
            }
        }
    }
    public static void display(int[][]arr){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<arr.length;i++){
            sb.append("[");
            for(int j=0;j<arr[0].length;j++){
                sb.append(arr[i][j]+", ");
            }
            sb.append("]");
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // Int_minPQ();
        // Int_maxPQ();
        // mobilePhone ph = new mobilePhone();
        // System.out.println(ph);
        // int[][]arr=new int[4][4];

        // int[][]arr={{2,6,11,3},{8,5,16,4},{9,7,11,13},{8,3,12,11}};
        // input(arr);
        // matrixPQ(arr);
        // display(arr);
        ArrayList<mobilePhone>phones=new ArrayList<>();
        phones.add(new mobilePhone("samsung","1",8,64,5000));
        phones.add(new mobilePhone("samsung","1",12,32,3000));
        phones.add(new mobilePhone("samsung","1",8,128,4000));
        phones.add(new mobilePhone("samsung","1",8,64,6000));
        mobilePhonePQ(phones);
        System.out.println(phones);
    }
}