public class Helicopter extends Aircraft
{
	protected double range;
	protected boolean winch;
	
	public Helicopter(String n, int maxPax, double range, boolean hasWinch) {
		super(n, maxPax);
		this.range = range;
		this.winch = hasWinch;
	}
	
	public String toString()
	{
		return "Prop - " + name + " : Range " + range + "; " + (winch ? "hasWinch" : "noWinch") + "; DepartureTime " + getDepartureTime(); 
	}
}
