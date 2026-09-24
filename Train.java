import java.util.ArrayList;
import java.util.Iterator;

public class Train
{

    private ArrayList<Seat> passengerList;
    private boolean direction;
    private Station currentStation;
    private int maxCap;

    public Train(int maxCap, Station startStation)
    {
        if (maxCap < 0)
        {
            maxCap = 0;
        }
        else
        {
            this.maxCap = maxCap;
        }
        this.passengerList = new ArrayList<>();
        this.direction = false;
        this.currentStation = startStation;
    }


    public Train(int maxCap, Station startStation, boolean goingLeft)
    {
        this(maxCap, startStation);
        this.direction = goingLeft;
    }
    
    public void setDirection(boolean newDirec)
    {
        this.direction = newDirec;
    }


    public boolean getDirection()
    {
        return direction;
    }


    public void turnAround()
    {
        this.direction = !this.direction;
    }


    public void setStation(Station newStation)
    {
        this.currentStation = newStation;
    }


    public Station getCurrentStation()
    {
        return currentStation;
    }


    public int getMaxCap()
    {
        return maxCap;
    }


    public int getPassengerCount()
    {
        return passengerList.size();
    }


    public ArrayList<Seat> getPassengerList()
    {
        return passengerList;
    }
    
    public boolean goNext() {
        Station next = currentStation.departingTrain();
        if(next == null) {
            return false;
        }
        next.incomingTrain(this);
        return true;
    }


    public boolean addPassenger(Seat newPassenger)
    {
        if (newPassenger == null)
        {
            return false;
        }
        if (passengerList.size() >= maxCap)
        {
            return false;
        }

        String name = newPassenger.getName();
        Station dest = newPassenger.getDestination();

        if (name == null || dest == null || name.isEmpty())
        {
            return false;
        }
        if (name.length() > 10000)
        {
            throw new IllegalArgumentException(
                "Passenger name exceeds 10000 characters");
        }
        String cantContain = "@#$%&*_[]\'.<>;/{}()";
        for (int i = 0; i < name.length(); i++)
        {
            if (cantContain.indexOf(name.charAt(i)) != -1)
            {
                return false;
            }
        }

        if (currentStation != null && dest.equals(currentStation))
        {
            return false;
        }

        passengerList.add(newPassenger);
        return true;
    }


    public void unload()
    {
        if (currentStation == null)
        {
            return;
        }
        Iterator<Seat> it = passengerList.iterator();
        while (it.hasNext())
        {
            Seat s = it.next();
            Station dest = s.getDestination();
            if (dest != null && dest.equals(currentStation))
            {
                it.remove();
            }
        }
    }


    public Seat getSeat(int seatNumber)
    {
        if (seatNumber < 0 || seatNumber >= passengerList.size())
        {
            return null;
        }
        return passengerList.get(seatNumber);
    }
}
