package hello_world;

import java.util.Scanner;

public class TestClass {
		
	
	
			

		//////////////////////
			public static int [] getInput(int numOfValus) {
				Scanner inpute = new Scanner(System.in);
				int list[] = new int[numOfValus];
				for(int i = 0 ;i < numOfValus ;i++) {
					list[i] = inpute.nextInt();
				}
				return list ;
			}
		/** Generate a random character between ch1 and ch2 */
		  public static char getRandomCharacter(char ch1, char ch2) {
		    return (char)(ch1 + Math.random() * (ch2 - ch1 + 1));
		  }

		  /** Generate a random lowercase letter */
		  public static char getRandomLowerCaseLetter() {
		    return getRandomCharacter('a', 'z');
		  }

		  /** Generate a random uppercase letter */
		  public static char getRandomUpperCaseLetter() {
		    return getRandomCharacter('A', 'Z');
		  }

		  /** Generate a random digit character */
		  public static char getRandomDigitCharacter() {
		    return getRandomCharacter('0', '9');
		  }

		  /** Generate a random character */
		  public static char getRandomCharacter() {
		    return getRandomCharacter('\u0000', '\uFFFF');
		  }
	
		  ///////////////////////////////////////////////
		  //
		  public static int linearSearch(int [] val , int key) {
			  for(int i =0;i<val.length;i++) {
			  if(key == val[i])
				  return i;
			  }
			  return -1;
		  }
		  //linear search
		  public static int linearSearch(int [] val , int key ,int endOfSearch) {
			  for(int i =0;i<endOfSearch;i++) {
			  if(key == val[i])
				  return i;
			  }
			  return -1;
		  }
		  //binary search
		  public static int binarySearch(int [] list , int key) {
				int low =0 ;
				int high = list.length - 1;
				int mid ;
				while(high >=low) {
					mid = (low + high) / 2 ;

				if(key > list[mid] ) {
					low = mid + 1;				
				}
				
				else if(key < list[mid]) {
					high = mid -1;		
				}
				else 
					 return mid;
				
				}	
				return -low-1; //return position of un matched key + 1

			}	
		  public static void SelectionSort(int [] list ) {
			 
			 int min = 0 , indexOfMin = 0;
			 for(int i = 0 ; i < list.length -1  ; i++) {				
				 min = list[i];
				 indexOfMin = i;
				 				 
				 for( int j = i  + 1 ; j < list.length ; j++) {					  
					 if (min > list[j]) {
						  indexOfMin = j;						  
						 min = list[j];
					 }
					 
				 }
				        //SWAP  if necessary
				 if(indexOfMin != i) {
				 list[indexOfMin] = list[i];
				 list[i] = min;				 
				 }
				 

			 }
			
		}
		  public static void InsertionSort(int [] list ) {
			  
			  for(int i = 1 ; i < list.length ; i++) {
				  // put list[i] in correct position
				  int cureentElement = list[i];
				  int j;
				  for( j = i - 1 ; j >= 0 && list[j] > list[i]; j--) {
						 //shifting
					  list[j+1] =list[j];		 
					  
				  }
				  list[j + 1] = cureentElement;		  
			  }
			
		}
		 
}
