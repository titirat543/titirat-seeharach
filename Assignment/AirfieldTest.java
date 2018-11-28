import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
* Please provide your student ID below.

* 
* 	Student ID: 2636568
*/

/**
 * The AirfieldTest class provides different methods of checking the behaviour
 * of the AirfieldManager class and the objects that it uses. It maintains a
 * reference to a AirfieldManager object called 'manager' and populates it via
 * the loadAirfield method. 
 * 
 * If you run this class via a call to main, main will create
 * a AirfieldTest object and call the go method which produces some useful output that
 * you can analyse. AirfieldTest also contains the following test methods that 
 * you should implement to confirm that your tree walks are working as intended. At
 * present they only print out the results of a tree walk - you need to convert this
 * to use a valid assertion test.
 * 
 * 	public void preOrderTest()
 * 	public void inOrderTest()
 * 	public void postOrderTest()
 *  
 */
public class AirfieldTest {
	AirfieldManager manager = new AirfieldManager();
	
	public static void main(String[] args) {
		AirfieldTest test = new AirfieldTest();
		test.go();
	}

	@Before
	public void loadAirfield() {
		manager.clear();
		Aircraft a1 = new Helicopter("EurocopterEC135", 7, 395, false);
		a1.setDepartureTime(10);
		manager.addAircraft(a1);
		Aircraft a2 = new PropPlane("Cessna140", 1, 1);
		a2.setDepartureTime(5);
		manager.addAircraft(a2);
		Aircraft a3 = new Helicopter("SA330Puma", 16, 360, true);
		a3.setDepartureTime(14);
		manager.addAircraft(a3);
		Aircraft a4 = new JetPlane("Concorde", 120, 4);
		a4.setDepartureTime(16);
		manager.addAircraft(a4);
		Aircraft a5 = new PropPlane("BombardierDash8", 50, 2);
		a5.setDepartureTime(18);
		manager.addAircraft(a5);
		Aircraft a6 = new JetPlane("Boeing707", 300, 4);
		a6.setDepartureTime(1);
		manager.addAircraft(a6);
		Aircraft a7 = new JetPlane("Boeing737", 200, 2);
		a7.setDepartureTime(22);
		manager.addAircraft(a7);
		
		
		// Uncomment the following lines when you have built the Balloon class
		 Aircraft a8 = new Balloon("Branson1", 1, false);
		 a8.setDepartureTime(20);
		 manager.addAircraft(a8);
		 Aircraft a9 = new Balloon("80Days", 3, true);
		 a9.setDepartureTime(25);
		 manager.addAircraft(a9);
	}
	
	/**
	 * Print the contents of the ArrayList 'list' to standard output.
	 * @param list The list to print
	 */
	public void printArrayList(ArrayList<Aircraft> list) {
		for (Aircraft v:list)
			System.out.println(v.toString());
	}
	
	@Test
	/**
	 * 'go' produces a useful set of output that allows you to see the
	 * initial state transport list and tree, the results of doing the
	 * three tree walks, an attempt at finding an object in the tree and 
	 * the results of doing an insertion sort and a quicksort. Initially,
	 * only the state of the transport list will be correct. As you add
	 * further functionality, you should see the correct output being
	 * printed via this method. You do not need to modify it but you may
	 * want to add your own checks to confirm your code is working as intended. 
	 */
	public void go() {
		loadAirfield();
		System.out.println("--Airfield List--");
		manager.describeAirfieldList();
		System.out.println();
		
		System.out.println("--Airfield Tree--");
		manager.describeAirfieldTree();	
		System.out.println();
		
		System.out.println("\n--Pre Order Walk--\n" + manager.preWalk());
		System.out.println("\n--In Order Walk--\n" + manager.inWalk());
		System.out.println("\n--Post Order Walk--\n" + manager.postWalk());
		
		System.out.println("\n--Find--");
		Aircraft mf = manager.find("Concorde"); // should be found
		if (mf != null) 
			System.out.println("Found: " + mf);
		else
			System.out.println("Could not find Concorde");
		Aircraft aw = manager.find("AirWolf"); // should not be found
		if (aw != null) 
			System.out.println("Found: " + aw);
		else
			System.out.println("Could not find AirWolf");
		
		ArrayList<Aircraft> sorted;
		
    	System.out.println("\n--Merge Sort ascending--");
    	// Reload the transport list, otherwise it will still be sorted...
    	loadAirfield();
    	sorted = manager.mergeSort(true);
    	printArrayList(sorted);	
    	
    	System.out.println("\n--Merge Sort descending--");
    	// Reload the transport list, otherwise it will still be sorted...
    	loadAirfield();
    	sorted = manager.mergeSort(false);
    	printArrayList(sorted);	
    	
	}
	
	@Test
	/**
	 * A test for the pre-order walk
	 */
	public void preOrderTest() {	
		// Ensure the transport list has been loaded into the two data structures
		loadAirfield();
		
		// Now conduct an assertion test...
		System.out.println("\n--In Order Walk--\n" + manager.preWalk());
	}
	
	@Test
	/**
	 * A test for the in-order walk
	 */
	public void inOrderTest() {	
		// Ensure the transport list has been loaded into the two data structures
		loadAirfield();
		
		// Now conduct an assertion test...
		System.out.println("\n--In Order Walk--\n" + manager.inWalk());
	}
	
	@Test
	/**
	 * A test for the post-order walk
	 */
	public void postOrderTest() {	
		// Ensure the transport list has been loaded into the two data structures
		loadAirfield();
		
		// Now conduct an assertion test...
		System.out.println("\n--Post Order Walk--\n" + manager.postWalk());
	}
	
	@Test
	public void checkAircraftCapacity() {
		Aircraft a = new Helicopter("EurocopterEC135", 7, 395, false);
		
		assertEquals(a.getPassengers(), 0);
		assertTrue(a.addPassengers(2));
		assertEquals(a.getPassengers(), 2);
		assertTrue(a.addPassengers(2));
		assertEquals(a.getPassengers(), 4);
		assertTrue(a.addPassengers(2));
		assertEquals(a.getPassengers(), 6);
		assertFalse(a.addPassengers(2));
		assertEquals(a.getPassengers(), 6);
		assertTrue(a.addPassengers(1));
		assertEquals(a.getPassengers(), 7);
		
	}
}
