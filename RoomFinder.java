import java.util.*;
import java.text.NumberFormat;

public class RoomFinder {
    private static List<Dwelling> dwellingList = new ArrayList<>(Arrays.asList(            
            new Flat("947 Castle St", 4, "Old villa with modern extension", 2880.0),
            new Flat("951 Castle St", 3, "Refurbished villa, large back lawn", 3360.0),
            new Flat("931 Castle St", 4, "Old villa with second story", 2500.0),
            new Hall("944 Castle St", 10, "Thelwon Hall", 18021.5)
    ));

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "nz"));
        
        System.out.println("Welcome to the Accomodation Finder!");
        int ifPrint;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println(
                    "Accomodation Menu:\n\tEnter 1 to print dwellings\n\tEnter 2 to show total free rooms\n\tEnter 3 to add a tenant to a dwelling");
            System.out.println("\tEnter 4 to show the monthly cost of rooms\n\tEnter 5 to show the smallest rooms\n\tEnter 6 to add a new dwelling\n\tEnter 0 to quit");
            System.out.println("Please enter a number: ");
            ifPrint = sc.nextInt();
            System.out.println();
            if (ifPrint == 1) {
                showHouse();
            } else if (ifPrint == 2) {
                System.out.println("Total free rooms in all dwellings is " + Dwelling.totalFreeRooms + "\n");
            } else if (ifPrint == 3) {
                selectAndAdd();
            } else if (ifPrint == 4) {
                costPerMonth();
            } else if (ifPrint == 5) {
                smallestRoom();
            } else if (ifPrint == 6){
                newDwelling();
            } else if (ifPrint == 0){
                System.out.println("OK, bye.");
            } else {
                System.out.println("Invalid Option.\n");
            }
        } while (ifPrint != 0);

    }

    public static void showHouse() {
        System.out.println("\nLIST OF DWELLINGS");
        for (Dwelling dwelling : dwellingList) {
            dwelling.display();
        }
        System.out.println();
    }

    public static void selectAndAdd() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < dwellingList.size(); i++) {
            System.out.println("Dwelling " + i + " " + dwellingList.get(i).address + " has " + dwellingList.get(i).roomsFree +
                    " rooms free");
        }
        System.out.println();
        int selected;
        int dwellingNum = dwellingList.size() - 1;
        do {
            System.out.println("Which dwelling do you wish to add a tenant to?\nPlease enter an int between 0 and "
                    + dwellingNum + " (inclusive): ");
            selected = sc.nextInt();
            if (selected < dwellingList.size()) {
                dwellingList.get(selected).addTenant();
            } else {
                System.out.println("This dwelling number does not exist!\n");
            }
        } while (selected >= dwellingList.size());
    }

    public static void costPerMonth() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        for (Dwelling dwelling : dwellingList) {
            System.out.println(
                    "The cost per room at " + dwelling.address + " is " + fmt.format(dwelling.calcRoomPerMonth()) +
                            " per month");
        }
    }

    public static void smallestRoom() {
        int sRoom = 0;
        for (Dwelling dwelling : dwellingList) {
            sRoom = 0;
            int sRoomArea = dwelling.roomList[0].getSide1() * dwelling.roomList[0].getSide2();
            for (int i = 0; i < dwelling.roomList.length; i++) {
                if (sRoomArea > (dwelling.roomList[i].getSide1() * dwelling.roomList[i].getSide2())) {
                    sRoomArea = (dwelling.roomList[i].getSide1() * dwelling.roomList[i].getSide2());
                    sRoom = i;
                }
            }

            System.out.println("The smallest room at " + dwelling.address + " is room " + sRoom);
        }
        System.out.println();
    }

    public static void newDwelling(){
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Is this new dwelling a house or a hall?\nEnter 1 if the dwelling is a house.");
            System.out.println("Enter 2 if the dwelling is a hall.\nEnter 0 to Quit.\nPlease enter a number:");
            choice = sc.nextInt();
            if (choice == 0){
                break;
            } else if (choice != 1 && choice != 2){
                System.out.println("Invalid Option.\n");
            }
        } while (choice != 0 && choice != 1 && choice != 2);
        System.out.println();
        
        String address = sc.nextLine();
    }
}