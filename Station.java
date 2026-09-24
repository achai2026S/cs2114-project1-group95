public class Station
{
    // ~ Fields ................................................................
    Station rightStation;
    Station leftStation;
    String name;
    Train current;
    boolean isOccupied;

    // ~ Constructors ..........................................................

    public Station(Station right, Station left, String station)
    {
        this.rightStation = right;
        this.leftStation = left;
        this.name = station;
        this.current = null;
        this.isOccupied = false;
    }


    // ~Public Methods ........................................................
    public Station incomingTrain(Train incoming)
    {
        if (isOccupied)
        {
            return null;
        }
        current = incoming;
        isOccupied = true;
        if (current != null)
        {
            current.setStation(this);
            current.unload();
        }
        return this;
    }


    public Station departingTrain()
    {
        Station nextStation = null;
        if (current == null)
        {
            return nextStation;
        }

        Train leavingTrain = current;

        // direction: false means moving right, true means moving left
        if (!leavingTrain.getDirection())
        {
            if (rightStation == null)
            {
                leavingTrain.setDirection(true); // Flip direction
                nextStation = leftStation;
            }
            else
            {
                nextStation = rightStation;
            }
        }
        else
        {
            if (leftStation == null)
            {
                leavingTrain.setDirection(false); // Flip direction
                nextStation = rightStation;
            }
            else
            {
                nextStation = leftStation;
            }
        }
        if (nextStation.isOccupied)
        {
            return null;
        }
        isOccupied = false;
        current = null;
        return nextStation;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String newName)
    {
        this.name = newName;
    }


    public void setLeft(Station left)
    {
        this.leftStation = left;
    }


    public void setRight(Station right)
    {
        this.rightStation = right;
    }

}
