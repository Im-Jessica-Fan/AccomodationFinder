import java.text.NumberFormat;

public class Hall extends Dwelling{
   private String name;
   private double roomCostPerYear;
   
   public Hall(String address, int roomsFree, String name, double roomCostPerYear){
      super(address, roomsFree);
      this.name = name;
      this.roomCostPerYear = roomCostPerYear;
   }
   
   public void display(){
      NumberFormat fmt = NumberFormat.getCurrencyInstance();
      String a = "*";
      System.out.println(a.repeat(75));
      System.out.println("Hall");
      super.display();
      System.out.println("Name of Hall: " + name + "\nRoom Cost Per Year: " + fmt.format(roomCostPerYear));
   }
   
   public double calcRoomPerMonth(){
      return roomCostPerYear/12;
   }
}