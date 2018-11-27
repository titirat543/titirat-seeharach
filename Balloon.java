public class Balloon extends Aircraft
{
    // instance variables - replace the example below with your own
    protected boolean hotAir;
    protected boolean inflated; 

    /**
     * Constructor for objects of class Balloon
     */
    public Balloon(String n ,int maxPax,boolean hotAir)
    {
        // initialise instance variables
        super(n,maxPax);
        this.hotAir = hotAir;
        

    }

    public boolean inflated()
    {
        return this.inflated = inflated; // set up inflated 
    }
    
    
    public boolean deflated()
    {
        return inflated = false; // set up deflated
    }
    
    public boolean isHotAir()
    {
        return hotAir = true; // check hot air
    }
    
    public boolean isInflated() 
    {
        return inflated(); // check inflated vs deflated
    }
    
    public String toString()
	{
		return "Balloon - " + name +  "; Air " + isHotAir() + "; DepartureTime " + getDepartureTime(); 
	}
     
}