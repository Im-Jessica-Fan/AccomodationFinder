import java.text.NumberFormat;

public class Studio extends Dwelling{
   private String description;
   private double rentPerMonth;
   
   public Studio(String address, String description, double rentPerMonth){
      super(address, 1);
      this.description = description;
      this.rentPerMonth = rentPerMonth;
   }
   
   public void display(){
      NumberFormat fmt = NumberFormat.getCurrencyInstance();
      String a = "*";
      System.out.println(a.repeat(75));
      System.out.println("Studio");
      super.display();
      System.out.println("Description: " + description + "\nRent Per Month: " + fmt.format(rentPerMonth));
   }
   
   public double calcRoomPerMonth(){
      return rentPerMonth;
   }
}