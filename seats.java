public class seats
{
    //~ Fields ................................................................
    private String name;
    private String destination;
    
    //~ Constructors ..........................................................
    public seats(String passenger, String desti) {
        name = passenger;
        destination = desti;
    }
    //~Public  Methods ........................................................
    public String getName() {
        return name;
    }
    
    public String getDestination() {
        return destination;
    }
}
