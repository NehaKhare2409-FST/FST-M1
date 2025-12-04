package NehaActivity1;

public class Activity6 {
 public static void main(String[] args) {

     Plane plane = new Plane(10);


     plane.onboard("Sean");
     plane.onboard("John");
     plane.onboard("Mini");


  
     plane.takeOff();

     System.out.println("Passengers on board: " + plane.getPassengers());

     try {
    
         Thread.sleep(5000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }


     plane.land();
     System.out.println("Landing time: " + plane.getLastTimeLanded());
 }
}
