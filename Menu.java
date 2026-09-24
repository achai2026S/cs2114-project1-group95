import java.util.ArrayList;
import java.util.Scanner;
public class Menu
{
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Station stationA = new Station(null, null, "Station A");
       Station stationB = new Station(null, null, "Station B");
       Station stationC = new Station(null, null, "Station C");
       Station stationD = new Station(null, null, "Station D");
       
       stationA.setRight(stationB);
       
       stationB.setLeft(stationA);
       stationB.setRight(stationC);
       
       stationC.setLeft(stationB);
       stationC.setRight(stationD);
       
       stationD.setLeft(stationC);
       
       ArrayList<Train> trains = new ArrayList<>();
       Train train1 = new Train(3, stationA);
       stationA.incomingTrain(train1);
       Train train2 = new Train(5, stationC);
       stationC.incomingTrain(train2);
       trains.add(train1);
       trains.add(train2);
       int end = trains.size()+1;
       
       int choice = 0;
       while(choice != end) {
           for(int i = 0; i < trains.size(); i++) {
               System.out.println((i + 1) + ". Train " + (i + 1));
           }
           System.out.println(end + ". exit");
           if(!scanner.hasNextInt()) {
               scanner.nextLine();
               continue;
           }
           choice = scanner.nextInt();
           scanner.nextLine();
           if(choice == end) {
               break;
           }
           if(choice < 1 || choice > trains.size()) {
               continue;
           }
           Train selected = trains.get(choice - 1);
           int innerChoice = 0;
           while(innerChoice != 4) {
               System.out.println("1. Add Passenger");
               System.out.println("2. Move Train to Next Station");
               System.out.println("3. Check Specific Seat");
               System.out.println("4. Go Back to Train Selection Menu");
               
               if(!scanner.hasNextInt()) {
                   scanner.nextLine();
                   continue;
               }
               innerChoice = scanner.nextInt();
               scanner.nextLine();
               
           }
       }
   }

}
