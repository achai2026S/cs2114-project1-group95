public class station
{
    // ~ Fields ................................................................
    station rightStation;
    station leftStation;
    String name;
    train current;
    boolean isOccupied;

    // ~ Constructors ..........................................................

    public station(station right, station left, String station)
    {
        rightStation = right;
        leftStation = left;
        name = station;
        current = null;
        isOccupied = false;
    }


    // ~Public Methods ........................................................
    public station incomingTrain(train incoming)
    {
        if(isOccupied) {
            return null;
        }
        current = incoming;
        isOccupied = true;
        return this;
    }


    public station deapartingTrain()
    {
        isOccupied = false;

        if (/*current.getDirection()*/)
        {
            if (rightStation == null)
            {
                // current.changeDirection(); *future function in train
                return leftStation;
            }
            else {
                return rightStation;
            }
        }
        else {
            if(leftStation == null) {
                // current.changeDirection(); *future function in train
                return rightStation;
            }
            else {
                return leftStation;
            }
        }
    }
    
    public String getName() {
        return name;
    }
    
    

}
