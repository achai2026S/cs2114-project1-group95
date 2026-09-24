public class Seat
{
    // ~ Fields ................................................................
    private String name;
    private Station destination;

    // ~ Constructors ..........................................................
    public Seat(String passenger, Station desti)
    {
        if (passenger != null && passenger.length() > 10000)
        {
            throw new IllegalArgumentException(
                "input over 10000 character is not accepted");
        }
        this.name = passenger;
        this.destination = desti;
    }


    // ~Public Methods ........................................................
    public String getName()
    {
        return name;
    }


    public Station getDestination()
    {
        return destination;
    }


    public void setName(String newName)
    {
        if (newName != null && newName.length() > 10000)
        {
            throw new IllegalArgumentException(
                "input over 10000 character is not accepted");
        }
        this.name = newName;
    }
    
    public void setDestination(Station newDest) {
        this.destination = newDest;
    }
}
