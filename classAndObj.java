public class classAndObj{
    public static class phone{
        String brand;
        String model;
        String color;
        int ram;
        int storage;
        int battery;
        phone(String brand,String model,String color,int ram, int storage,int battery){
            this.brand=brand;
            this.model=model;
            this.color=color;
            this.ram=ram;
            this.storage=storage;
            this.battery=battery;
        }
        phone(String brand,String model,String color, int storage,int battery){
            this.brand=brand;
            this.model=model;
            this.color=color;
            this.storage=storage;
            this.battery=battery;
        }
        {
            System.out.println(this);
        }
        phone(){

        }
        void display(){
            StringBuilder sb=new StringBuilder();
            sb.append("Brand: "+this.brand+"\n");
            sb.append("Model: "+this.model+"\n");
            sb.append("Color: "+this.color+"\n");
            sb.append("Ram: "+this.ram+"GB\n");
            sb.append("Storage: "+this.storage+"GB\n");
            sb.append("Battery: "+this.battery+"mAh\n");
            sb.append("\n");
            return sb.toString();
        }
        
    }
    // Run|Debug
    public static void main(String[] args){
        // phone ph1=new phone();
        // ph1.ram=10;
        // System.out.println(ph1.ram);
        // phone ph2=new phone();
        // System.out.println(ph2.ram);
        // System.out.println(ph2.brand);

        phone ph1=new phone("one plus", "9 pro", "lake blue", 8, 128, 4500);
        System.out.println(ph1);


    }

}