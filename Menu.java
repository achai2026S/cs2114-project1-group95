import java.util.ArrayList;
import java.util.Scanner;

public class Menu
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Station stationA = new Station(null, null, "Station A");
        Station stationB = new Station(null, null, "Station B");
        Station stationC = new Station(null, null, "Station C");
        Station stationD = new Station(null, null, "Station D");
        Station stationE = new Station(null, null, "Station E");
        Station stationF = new Station(null, null, "Station F");

        stationA.setRight(stationB);

        stationB.setLeft(stationA);
        stationB.setRight(stationC);

        stationC.setLeft(stationB);
        stationC.setRight(stationD);
        
        stationD.setLeft(stationC);
        stationD.setRight(stationE);
        
        stationE.setLeft(stationD);
        stationE.setRight(stationF);

        stationF.setLeft(stationE);
        stationF.setRight(stationA);
        
        stationA.setLeft(stationF);

        ArrayList<Train> trains = new ArrayList<>();
        Train train1 = new Train(3, stationA);
        stationA.incomingTrain(train1);
        Train train2 = new Train(5, stationC);
        stationC.incomingTrain(train2);
        trains.add(train1);
        trains.add(train2);
        int end = trains.size() + 1;

        int choice = 0;
        while (choice != end)
        {
            for (int i = 0; i < trains.size(); i++)
            {
                System.out.println((i + 1) + ". Train " + (i + 1));
            }
            System.out.println(end + ". exit");
            if (!scanner.hasNextInt())
            {
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == end)
            {
                break;
            }
            if (choice < 1 || choice > trains.size())
            {
                continue;
            }
            Train selected = trains.get(choice - 1);
            int innerChoice = 0;
            while (innerChoice != 6)
            {
                System.out.println("1. Add Passenger");
                System.out.println("2. Move Train to Next Station");
                System.out.println("3. Check Specific Seat");
                System.out.println("4. List All Passengers");
                System.out.println("5. Turn the Train Around");
                System.out.println("6. Go Back to Train Selection Menu");

                if (!scanner.hasNextInt())
                {
                    scanner.nextLine();
                    continue;
                }
                innerChoice = scanner.nextInt();
                scanner.nextLine();

                if (innerChoice == 1)
                {
                    System.out.println("Enter passenger name:");
                    String name = scanner.nextLine().trim();
                    System.out.println(
                        "Select destination (1. Station A, 2. Station B, 3. Station C, 4. Station D");
                    String destChoice = scanner.nextLine().trim();
                    Station destStation = null;

                    if (destChoice.equals("1"))
                    {
                        destStation = stationA;
                    }
                    else if (destChoice.equals("2"))
                    {
                        destStation = stationB;
                    }
                    else if (destChoice.equals("3"))
                    {
                        destStation = stationC;
                    }
                    else if (destChoice.equals("4"))
                    {
                        destStation = stationD;
                    }
                    if (destStation != null)
                    {
                        try
                        {
                            Seat newSeat = new Seat(name, destStation);
                            if(!selected.addPassenger(newSeat)) {
                                System.out.println("Passenger was not added");
                            }
                        }
                        catch (IllegalArgumentException e)
                        {

                        }
                    }
                }
                else if (innerChoice == 2)
                {
                    if(selected.goNext()) {
                        System.out.println("Train arrived at " + selected.getCurrentStation().getName());
                    }
                    else {
                        System.out.println("Failed to reach station");
                    }
                }
                else if (innerChoice == 3)
                {
                    System.out.println("Enter seat index:");
                    if (scanner.hasNextInt())
                    {
                        int seatIndex = scanner.nextInt();
                        scanner.nextLine();
                        Seat search = selected.getSeat(seatIndex);
                        if (search == null || search.getName() == null)
                        {
                            System.out
                                .println("No one is sitting in this seat");
                        }
                        else
                        {
                            System.out.println(
                                "Passenger: " + search.getName()
                                    + " is seated here");
                        }
                    }
                }
                else if (innerChoice == 4)
                {
                    ArrayList<Seat> passengerList = selected.getPassengerList();
                    if (passengerList.isEmpty())
                    {
                        System.out
                            .println("There are no passengers on this train.");
                    }
                    else
                    {
                        System.out.println("--- Passengers on Board ---");
                        for (int i = 0; i < passengerList.size(); i++)
                        {
                            Seat s = passengerList.get(i);
                            System.out.println(
                                "Seat " + i + ": " + s.getName()
                                    + " -> Destination: "
                                    + s.getDestination().getName());
                        }
                    }
                }
                else if (innerChoice == 5) {
                    selected.turnAround();
                }
                else if (innerChoice > 5)
                {
                    System.out.println("Please select a valid choice.");

                }
            }
            choice = 0;
        }
        scanner.close();
    }

}
