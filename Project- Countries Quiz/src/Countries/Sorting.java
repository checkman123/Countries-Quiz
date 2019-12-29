package Countries;
import java.util.ArrayList;

/*
 * Country.java
 * <pre>
 *   Project     <b>CountriesGUI Database</b>
 *   Description This class providing all of the sorting methods that are nedded
 *   Platform    Java(TM) SE Runtime Environment 1.8.0_151
 *   System      Windows 10 version 
 *   Course      <i>CS 142 Winter 2018</i>
 * </pre>
 *
 * @author:	Sanyapoom Sirijirakarn and Quynh Duc Vu
 * @version: 	1.00
 */
public class Sorting
{
    /*
     * Method: quickSort(ArrayList <Country> array)
     * Description: This is a quicksort method
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem array
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    protected void quickSort(ArrayList <Country> array)
    {
        if (array == null || array.size() <= 1)
        {
            return;
        }
        quick(array, 0, array.size() - 1);
    }
    /*
     * Method: quick(ArrayList <Country> arrayList, int low, int high)
     * Description: This is a quicksort method
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem arrayList, low, high
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    protected void quick(ArrayList <Country> arrayList, int low, int high)
    {
        int i = low, j = high;
        //get the pivot element from the middle of the list
        float pivot = arrayList.get((low + high)/2).getCountryPop();
        
        //Divide into two lists
        while (i <= j)
        {
            //if the current value from the left list is smaller than the pivot
            //element then get the next element  from the left list
            while(arrayList.get(i).getCountryPop() > pivot)  //<
            {
               i++;
            }
            
            //if the current value from the right list is larger than the pivot
            //element then get the next element from the right list
            while(arrayList.get(j).getCountryPop() < pivot)  //<
            {
               j--;
            }
            
            if(i <= j)
            {
                Country temp = arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j, temp);
                i++;
                j--;
            }
        }
        
        //recursion
        if(low < j)
            quick(arrayList, low, j);
        if(i < high)
            quick(arrayList, i, high);
    }
    
    /*
     * Method: mergeSort(ArrayList<Country> array)
     * Description: This is a mergeSort method
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem array
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    protected static void mergeSort(ArrayList<Country> array)
    {
        if(array == null || array.size() <= 1)
        {
            return;
        }
        merge(array, 0, array.size() - 1);
    }
    /*
     * Method: merge(ArrayList <Country> array, int low, int high)
     * Description: This is a merge method
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem array, low, high
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    protected static void merge(ArrayList <Country> array, int low, int high)
    {
        if(low < high)
        {
            int middle = (low + high) / 2;
            
            merge(array, low, middle);
            
            merge(array, middle + 1, high);
            
            mergedata(array, low, middle, high);
        }
    }
    /*
     * Method: mergedata(ArrayList <Country> arrayList, int low,int middle, int high)
     * Description: This is a class to merge the file
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem array, low, high, middle
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    protected static void mergedata(ArrayList <Country> arrayList, int low,int middle, int high)
    {
        ArrayList<Country> helper = new ArrayList<Country>(arrayList);
        
        int i = low;
        int j = middle + 1;
        int k = low;
        
        while(i <= middle && j <= high)
        {
            if(helper.get(i).getName().compareToIgnoreCase(helper.get(j).getName()) < 0)
            {
                arrayList.set(k, helper.get(i));
                i++;
            }
            else
            {
                arrayList.set(k, helper.get(j));
                j++;
            }
            k++;
        }
        
        while(i <= middle)
        {
           arrayList.set(k, helper.get(i));
           k++;
           i++;
        }
    }
}
