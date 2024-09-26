//a. Given an array size, create an int array that contains random integers in the range [0,100]. All the remaining functionality will operate on this array.
//b. Display the menu options, get the user’s choice, and call the required methods to print out the result. Until the user chooses to exit, you should display the menu again.
//c. Find the minimum and the maximum of the array; these should be implemented as different methods.
//d. Find the average of the array. Display how each element of the array differs from the average. For example, if the array is {2, 6, 9, 3, 5}, and the average is 5, then the differences from the average would be {-3, 1, 4, -2, 0}.
//e. Find the sum of elements with odd- and even-numbered indexes. For example, if the array is {1, 5, 8, 9, 10, 2, 6}, the sum of the odd indexes is 5 + 9 + 2, and the sum of the even indexes is 1 + 8 + 10 + 6, assuming indexes start at 0.


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Assignment02 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        int[] array = createArr(100);
        while(choice != 6){
            System.out.println("1. Find minimum of the array");
            System.out.println("2. Find maximum of the array");
            System.out.println("3. Find the difference of each element from the average");
            System.out.println("4. Find sum of odd elements");
            System.out.println("5. Find sum of even elements");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");  
            choice = scan.nextInt();
            
            if(choice == 1){
                int min = findMin(array);
                System.out.println(min);
            }
            else if(choice == 2){
                int max = findMax(array);
                System.out.println(max);
            }
            else if(choice == 3){
               double[] difference = findDifference(array); 
               System.out.println(Arrays.toString(difference));
            }
            else if(choice == 4){
                int sumOdd = sumOfOddElements(array);
                System.out.println(sumOdd);
            }
            else if(choice == 5){
                int sumEven = sumOfEvenElements(array);
                System.out.println(sumEven);
            }
            else if(choice == 6){
                break;
            }
        }
    }

    /**
     * This method creates an array with the given size and fills with random integers
     * @param size given size from the user
     * @return filled array
     */
    public static int[] createArr(int size) {

        Random generate = new Random(); //creating an random object
        int arr[] = new int[size]; //creating an array with the given size

        for(int i = 0; i < size; i++) { 
            arr[i] = generate.nextInt(101); //filling the array with random numbers
        }

        return arr;

    }

    /**
     * This method is for finding the minimum element in an array
     * @param arr array to search
     * @return minimum elemnt from the array
     */
    public static int findMin(int[] arr) {
        int min = arr[0]; //determining a temporary min value from the array

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) { //changes the min value when it encounters a smaller element
                min = arr[i];
            }
        }

        return min;
    }

    /**
     * This method is for finding the maximum element in an array
     * @param arr array to search
     * @return maximum element from the array
     */
    public static int findMax(int[] arr) {
        int max = arr[0]; //determining a temporary max value from the array

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) { //changes the max value when it encounters a bigger element
                max = arr[i];
            }
        }

        return max;
    }
    
     /**
     * This method first finds the average of all elements in the array and then find the difference between the elements of the array and average
     * @param arr array for calculating average
     * @return an array with differences
     */
    public static double [] findDifference(int[] arr){
        double total = 0; 
        double average = 0;
        double difference[] = new double[arr.length]; //new array which stores differences
        //finds the average of all elements in array
        for (int element : arr){
            total += element; 
        }
        average = total / arr.length;
        //finding the difference between the average and the elements of arr and adding this differences to the new array
        for(int i = 0; i < difference.length; i++){
            difference[i]= arr[i]- average;
        }
        return difference;

    }   
    /**
     * This method is used to find the total ​​of odd indexed elements in an array
     * @param arr array to search
     * @return sum of odd indexed elements
     */
    public static int sumOfOddElements(int[] arr){
        int sumOdds = 0;

        for(int i = 1; i < arr.length; i += 2){
            sumOdds += arr[i];
        }

        return sumOdds;
    }

    /**
     * This method is used to find the total ​​of even indexed elements in an array
     * @param arr array to search
     * @return sum of even indexed elements
     */
    public static int sumOfEvenElements(int[] arr){
        int sumEvens = 0;

        for(int i = 0; i < arr.length; i += 2){
            sumEvens += arr[i];
        }

        return sumEvens;
    }
    
}


