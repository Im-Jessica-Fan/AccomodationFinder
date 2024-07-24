import java.text.NumberFormat;

public class Flat extends Dwelling{
   private String description;
   private double rentPerMonth;
   
   public Flat(String address, int roomsFree, String description, double rentPerMonth){
      super(address, roomsFree);
      this.description = description;
      this.rentPerMonth = rentPerMonth;
   }
   
   public void display(){
      NumberFormat fmt = NumberFormat.getCurrencyInstance();
      String a = "*";
      System.out.println(a.repeat(75));
      System.out.println("Flat");
      super.display();
      System.out.println("Description: " + description + "\nRent Per Month: " + fmt.format(rentPerMonth));
   }
   
   public double calcRoomPerMonth(){
      return rentPerMonth;
   }
}