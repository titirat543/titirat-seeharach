/**
 * Please provide your student ID below.

 * 
 * 	Student ID: 2636568
 */

/**
 * Aircraft is the base class for all Aircraft types.
 * 
 */

public class Aircraft implements Comparable<Aircraft> {
	protected String name;			// The name of the aircraft
	protected int maxPassengers;	// The maximum number of passengers on the aircraft 
	protected int passengers;		// The number of passengers on the aircraft
	protected String destination;	// The destination of the aircraft
	protected int departureTime ;  // Set up the departure Time

	/**
	 * Default Constructor 
	 */
	public Aircraft() {
		name = "?";
		maxPassengers = 0;
		passengers = 0;
		destination = "?";
	}
	
	/**
	 * Constructs a aircraft based on its name
	 * 
	 * @param nm The name to give to the aircraft
	 */
	public Aircraft(String nm) {
		this();
		name = nm;
	}

	/**
	 * Constructs an aircraft based on its name and maximum speed
	 * 
	 * @param nm The name to give to the aircraft
	 * @param maxP The maximum number of passengers for the aircraft
	 */
	public Aircraft(String nm, int maxP) {
		this();
		name = nm;
		maxPassengers = maxP;
	}

	/**
	 * @return The name of aircraft
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param weight - add this many passengers the aircraft
	 * @return true if the passengers were added successfully
	 */
	public boolean addPassengers(int pax) {
		passengers = (passengers + pax);
		boolean weight = true;
        if(passengers > maxPassengers ) // check the number of passenger
        {
            passengers = (passengers-pax);
            weight = false;
        }
        
        return weight;
	}
	
	/**
	 * @return the number of passengers allocated to this aircraft
	 */
	public int getPassengers() {
		return passengers;
	}

	/**
	 * @param destination - set the destination of the aircraft
	 */
	public void setDestination(String dest) {
		destination = dest;
	}
	
	/**
	 * @return the destination of this aircraft
	 */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * @return the departureTime of this aircraft (minutes from opening time) 
	 */
	public int getDepartureTime() {
		// TODO
		 return departureTime;
	}
	
	/**
	 * @param departureTime of this aircraft (minutes from midnight) 
	 */
	public void setDepartureTime(int time) {
		// TODO
		if(time > 25)
        {
            time = time % 24;
        }
        departureTime = time;
		
	}

	/**
	 * Get a description of the Aircraft as a String
	 */
	public String toString()
	{
		return "Aircraft - " + name + ": MaxSpeed " + maxPassengers + "; Weight " + passengers + "; Destination " + destination;
	}
	
	/**
	 * @return true if this Aircraft is the same at "that" Aircraft
	 * (that is, the two aircraft have the same name)
	 */
	@Override
	public boolean equals(Object that) {
		return this.compareTo(((Aircraft)that)) == 0;
	}

	/**
	 * Compare the current Aircraft with the Aircraft 'that' and return a negative
	 * value if the current Aircraft is less than 'that', 0 if it is the same and
	 * a positive value if it is greater.
	 */
	@Override
	public int compareTo(Aircraft that) {
		return name.compareTo(that.name);
	}
	
}
