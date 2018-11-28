/**
 * Please provide your student ID below.

 * 
 * 	Student ID: 2636568
 */

import java.util.ArrayList;

/**
 * AirfieldManager maintains two data structures containing a set of Aircraft objects.
 * The first is an ArrayList called aircraftList and the second is a binary tree called
 * aircraftTree. Your task is to correctly implement the method bodies for
 * 
 *  protected ArrayList<Aircraft> insertionSort(ArrayList<Aircraft> list)
 *	protected ArrayList<Aircraft> quickSort(ArrayList<Aircraft> list)
 *  
 *  The above methods are called via public methods of the same name which supply 
 *  the local aircraftList object as a parameter. You can observe calls to these public
 *  methods in the go methods of AirfieldTest.java.  
 */
public class AirfieldManager
{
	private ArrayList<Aircraft>	aircraftList;
	private BinaryTree			aircraftTree;
	
	public AirfieldManager()
	{
		aircraftList = new ArrayList<Aircraft>();
		aircraftTree = new BinaryTree();
	}
	
	public void clear()
	{
		aircraftList.clear();
		aircraftTree.clear();
	}
	public void addAircraft(Aircraft v)
	{
		aircraftList.add(v);
		aircraftTree.addNode(v);
	}
	
	public void describeAirfieldList()
	{
		for (Aircraft v : aircraftList)
		{
			System.out.println(v.toString());
		}
	}
	
	public void describeAirfieldTree()
	{	
		aircraftTree.printTree();
	}
	
	public String preWalk()
	{
		return aircraftTree.preOrderTraversal();
	}
	
	public String inWalk()
	{
		return aircraftTree.inOrderTraversal();
	}

	public String postWalk()
	{
		return aircraftTree.postOrderTraversal();
	}

	public Aircraft find(String name)
	{
		return aircraftTree.find(name);
	}
	    
	/**
	 * This method should use a merge sort approach to rearrange
	 * the references in the ArrayList 'aircraftList' such that they are in 
	 * order of departure time. If asc is true, this should be ascending time,
	 * if asc is false, this should be descending time 
	 * 
	 * You should not modify this code.
	 * 
	 * @param asc True if the list should be ascending order, false for descending
	 * @return	The ArrayList 'aircraft' that has been sorted using merge sort
	 */
    public ArrayList<Aircraft> mergeSort(boolean asc)
    {	
    	return mergeSort(aircraftList, asc);
    }
    
	/**
	 * This method should use a merge sort approach to rearrange
	 * the references in the ArrayList 'list' such that they are in 
	 * order of departure time (ascending if asc is true, descending otherwise).
	 * 
     * @param list An ArrayList of Aircraft objects that need sorting
     * @param ascending True if the list should be ascending order, false for descending 
 	 * @return	The ArrayList of Aircrafts that has been sorted using quick sort
	 */
    protected ArrayList<Aircraft> mergeSort(ArrayList<Aircraft> list, boolean ascending)
    {
		// Use the merge sort algorithm to sort 'aircrafts' and then 
		// return it. Initially this method just returns an empty
    	// list - you need to fix this.
    	
    	ArrayList<Aircraft> sorted = new ArrayList<Aircraft>();

    	// TODO
    	if(list.size()<=1) 
    	{
    		return list;
    	}
    	    
    	    int middleIndex = list.size()/2; //find the middle index
    	    
    	    ArrayList<Aircraft> sortedL = new ArrayList<Aircraft>(middleIndex); //create new Empty array at left
    	    ArrayList<Aircraft> sortedR; // initialized new Array at Right 
    	    
    	    
    	    if(list.size()%2 == 0) //create new Right Empty array has the same of Left empty array
    	    {
    	        sortedR = new ArrayList<Aircraft>(middleIndex); 
    	    }else
    	    {
    	        sortedR = new ArrayList<Aircraft>(middleIndex+1);
    	    }
    	    
    	    for(int i = 0;i<middleIndex;i++)
    	    {
    	        sortedL.add(list.get(i)); //get index list with lest than middle index
    	    }
    	    
    	    for(int j = middleIndex ;j < list.size();j++)
    	    {
    	        sortedR.add(list.get(j)); //get index list with more than middle index
    	    }
    	    
    	
    	    
    	    if(ascending == true) {
    	    sortedL = mergeSort(sortedL,true); // split elements in the left side;
    	    sortedR = mergeSort(sortedR,true); // split element in the right side;
    	    
    	    sorted= Merge(sortedL,sortedR,true);
    	   
    	    
    	    }else  // for descending
    	    { 
    	   
    	    sortedL = mergeSort(sortedL,false); // split elements in the left side;
    	    sortedR = mergeSort(sortedR,false); // split element in the right side;
    	    
    	    sorted= Merge(sortedL,sortedR,false);
    	   
    	    }
    	return sorted;
		
    	
		
    	
    }
    
    protected ArrayList<Aircraft> Merge(ArrayList<Aircraft> sortedL, ArrayList<Aircraft> sortedR,boolean ascending)
    
    {
        int NewIndexL = 0; //create new index for new left array 
        int NewIndexR= 0 ; //create new index for new right array 
        int MergedIndex = 0; //create new index for new  array which we use merge
        ArrayList<Aircraft> Merged = new ArrayList<Aircraft>(sortedL.size()+sortedR.size()); //create new array list for merged
        while(NewIndexL < sortedL.size() || NewIndexR<sortedR.size()) 
        {
            if(NewIndexL < sortedL.size() && NewIndexR<sortedR.size()) //check about index both array before compare
            {
            	if(ascending == true){ //for ascending
            		if((sortedL.get(NewIndexL)).getDepartureTime()<(sortedR.get(NewIndexR)).getDepartureTime())
            		{
            			Merged.add(MergedIndex,sortedL.get(NewIndexL)); //put departure time in new merged array
            			MergedIndex++;
            			NewIndexL++;
            		}else
            		{
            			Merged.add(MergedIndex,sortedR.get(NewIndexR));
            			MergedIndex++;
            			NewIndexR++;
            		}
            	}else if(ascending == false){ //for descending
            		if((sortedL.get(NewIndexL)).getDepartureTime()>(sortedR.get(NewIndexR)).getDepartureTime())
            		{
            			Merged.add(MergedIndex,sortedL.get(NewIndexL)); //put departure time in new merged array
            			MergedIndex++;
            			NewIndexL++;
            		}else
            		{
            			Merged.add(MergedIndex,sortedR.get(NewIndexR));
            			MergedIndex++;
            			NewIndexR++;
            		}
            	}
            
            }else if(NewIndexL<sortedL.size()) // check the side of array until it's empty in sortedLeft array
            {
                Merged.add(MergedIndex,sortedL.get(NewIndexL));
                MergedIndex++;
                NewIndexL++;
            }else if(NewIndexR<sortedR.size())// check the side of array until it's empty in sortedRight array
            {
                Merged.add(MergedIndex,sortedR.get(NewIndexR));
                MergedIndex++;
                NewIndexR++;
            }
        }
        
        return Merged;
    }
}
