import java.util.Random;


// Pritpal Garcha Sorting Comparision - 2018.

// SELECTION SORT - O(N^2) VS. QUICK SORT - O(N*LOGN)

public class SortComparison {
	
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		double[] ArrayToBeSorted_Selection = new double[1000000];	
		double[] ArrayToBeSorted_Quick = new double[10000000]; 
		
		//Initializing The Unsorted Array's
		for(int i=0; i<ArrayToBeSorted_Selection.length; i++) {
			ArrayToBeSorted_Selection[i] = rand.nextDouble()*100;
			ArrayToBeSorted_Quick[i] = rand.nextDouble()*100;
		}
		
		System.out.println("\nSelection Sort Took " +selectionSort(ArrayToBeSorted_Selection) + " Milliseconds.");
		System.out.println("-----------------------------------------");
		System.out.println();
		System.out.println("Quick Sort Took " +quickSort(ArrayToBeSorted_Quick, 0, ArrayToBeSorted_Quick.length-1) + " Milliseconds.");
		System.out.println("-----------------------------------------");

	}
	
	
	//Returns time it will take
	public static long selectionSort(double[] ArrayToBeSorted){  
		
		long start = System.currentTimeMillis();
		//Outer Loop To Change First Element To Smallest Element 
        for (int i=0;i<ArrayToBeSorted.length-1;i++) {  
        		//Value That Will Hold The Position Of The Smallest Element
            int position = i;  
            //Inner Loop Will Search Array For Smallest Element
            for (int j = i + 1; j < ArrayToBeSorted.length; j++){ 
            		//Will Check If Each Element Is Smaller Than The Last Iterations' Smallest
                if (ArrayToBeSorted[j] < ArrayToBeSorted[position]){ 
                    position = j; 
                }  
            }
            //Place Holder For Smallest Value During Swap
            double smallerNumber = ArrayToBeSorted[position];   
            //Moves The Current First Element To The Position Of The Smallest ELement
            ArrayToBeSorted[position] = ArrayToBeSorted[i];  
            //Sets The Current First Element To Be The Smallest 
            ArrayToBeSorted[i] = smallerNumber;  
        }
        long end = System.currentTimeMillis();
        //Returns Time It took (In Milliseconds)
        return end - start;
    }  
	
	
	//Returns Time It Will Take
	public static long quickSort(double[] arr, int low, int high) {
		
		long start = System.currentTimeMillis();
		long end;
		
		//Base Case - If Empty Return Time It Took
		if (arr == null || arr.length == 0){
			end = System.currentTimeMillis();
			return end - start;
		}
		//Base Case - If The Entire Array Has Been Sorted
		if (low >= high){
			end = System.currentTimeMillis();
			return end - start;
		}
		//Picks The Pivot
		int middle = low + (high - low) / 2;
		double pivot = arr[middle];
		int i = low, j = high;
		//Outer Loop Iterating From Start To End Of Array
		while (i<= j) {
			//Compares Each Element In The First Half To The Pivot 
			while (arr[i]<pivot) {
				i++;
			}
			//Compares Each Element In The Second Half To The Pivot
			while (arr[j]>pivot) {
				j--;
			}
			//If Front And Back Index Meet, Swap The Elements Where They Met
			if (i<=j) {
				double temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		//Recursively Calls Sort On First Half 
		if (low < j) {
			quickSort(arr, low, j);
		}
		//Recursively Calls Sort On Second Half
		if (high > i) {
			quickSort(arr, i, high);
		}
		
		end = System.currentTimeMillis();
		return end - start;
	}
	
	
}
