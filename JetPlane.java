public class JetPlane extends Aircraft
{
	protected int numEngines;
	
	public JetPlane(String n, int maxPax, int numEngines) {
		super(n, maxPax);
		this.numEngines = numEngines;
	}
	
	public String toString() {
		return "Prop - " + name + " : Engines " + numEngines + "; DepartureTime " + getDepartureTime(); 
	}
}
