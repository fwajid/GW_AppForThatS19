import java.util.Random;

public class Sorting {

	/* Given an int > 0, return an array of random numbers
	 * between [0,100] or [-100,100] - whichever is specified.
	 */
  public static int[] generateRandomArray(int n){
    if(n <= 0){
      System.out.println("Invalid Array Size! Must be greater than 0.");
      return null;
    }
    Random r = new Random();
    int[] values = new int[n];
    for(int i = 0; i < values.length; i++){
      //values[i] = r.nextInt(100)+1;       // Random numbers between [0,100]
      values[i] = r.nextInt(201)-100;       // Random numbers between [-100,100]
      System.out.print(values[i]+" ");
    }
    System.out.println();
    return values;
  }

	/* Given an array, print it's contents */
  public static void printArray(int[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }

	/* Implementation of Selection Sort */
  public static void SelectionSort(int array[]) {
    int n = array.length;

    // One by one move boundary of unsorted subarray
    for (int i = 0; i < n-1; i++) {
      // Find the minimum element in unsorted array
      int minValIndex = i;
      for (int j = i+1; j < n; j++){
        if (array[j] < array[minValIndex]){
          minValIndex = j;
        }
        // Swap the found minimum element with the first element
        int temp = array[minValIndex];
        array[minValIndex] = array[i];
        array[i] = temp;
      }
    }
     printArray(array);
  }

	/* Implementation of Insertion Sort */
  public static void InsertionSort(int array[]){
    int n = array.length;
    for(int i = 1; i < n; i++){
      int key = array[i];
      int j = i-1;
      /*
       * Move elements of array[0..i-1] that are greater than
       * key to one position ahead of their current position
       */
      while(j >= 0 && array[j] > key){
        array[j+1] = array[j];
        j--;
      }
      array[j+1] = key;
    }
    printArray(array);
  }

  /* Linearly scan array iteratively and swap around elements */
  public static void BubbleSort(int[] array) {
    System.out.println("Bubble Sort");
		/* Your Code Here */
    printArray(array);
  }

	/* Main Driver */
  public static void main(String[] args) {
    int[] values = generateRandomArray(10);
    //BubbleSort(values);
    //SelectionSort(values);
    InsertionSort(values);
  }
}
