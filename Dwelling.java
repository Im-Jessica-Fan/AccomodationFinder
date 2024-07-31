import java.util.*;

public abstract class Dwelling{
    protected Room[] roomList;
    protected TreeMap<String, Integer> dwelling = new TreeMap<>();
    protected String address;
    protected int roomsFree;
    static int totalFreeRooms;
    public abstract double calcRoomPerMonth();
    
    public Dwelling(String address, int roomsFree){
      this.address = address;
      this.roomsFree = roomsFree;
      dwelling.put(address, roomsFree);       
      roomList = new Room[roomsFree];
       for (int i = 0; i < roomsFree; i++){
          roomList[i] = new Room();
       }
       totalFreeRooms += roomsFree;
    }
    
    public void display(){
       System.out.println("Address: " + address + "\nNumber of rooms: " + roomList.length);
       int r = 0;
       for (Room room: roomList){
          System.out.println("Room " + r + " " + room);
          r++;
       } 
       int roomUsed = roomList.length - roomsFree;
       System.out.println("Rooms in use: " + roomUsed);
    }
    
    public void addTenant(){
       if (roomsFree > 0){
          roomsFree--;
          totalFreeRooms--;
          System.out.println("Done\n");
       } else {
          System.out.println("Sorry, this one is full!\n");
       }
    }
 }