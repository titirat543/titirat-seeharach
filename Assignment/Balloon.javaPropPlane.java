public class PropPlane extends Aircraft
{
	protected int numEngines;
	
	public PropPlane(String n, int maxPax, int numEngines) {
		super(n, maxPax);
		this.numEngines = numEngines;
	}
	
	public String toString() {
		return "Jet - " + name + " : Engines " + numEngines + "; DepartureTime " + getDepartureTime(); 
	}
}
