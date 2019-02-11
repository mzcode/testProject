package hello_world;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//*************************------------------------------****************************-----------------------

//5.34 Simplfy day of week
//fork   6.5 7.13 7.19 8.21(sol)
//Unsolved 6.18 bubble sort  
//easy  6.25 6.26  6.27
//wrong answer ex 7.8
//temp 7.17 19 20
//re implement -->
public class MyProg {
	public static void main(String[] args) {
		
		System.out.println(" test ");
		
	}
	
}
		/*
		// codetip1 ex7.22

		int list[][] = new int[6][6];
		// generate 6*6 random numbers and print them
		for (int row = 0; row < list.length; row++) {
			for (int column = 0; column < list[row].length; column++) {
				list[row][column] = (int) (Math.random() * 2);
				System.out.print(list[row][column] + " ");
			}
			System.out.println("");
		}
		if (check(list)) {
			System.out.println(" every row and every column have an even number of 1s");
		} else
			System.out.println("its not all even");

	}

	// we optimized performance by using 2 for loops instead 4 loops
	// to access each element
	// by change index of array that will be checked
	// list[row][column] -->list[column][row]
	public static boolean check(int[][] list) {
		int count1sInRow = 0, count1sInColumn = 0;
		for (int row = 0; row < list.length; row++) {
			for (int column = 0; column < list[row].length; column++) {
				// check 1s in each row
				count1sInRow += list[row][column];
				// check 1s in each column
				count1sInColumn += list[column][row];
			}
			if (count1sInRow % 2 != 0) {
				System.out.println("row " + row + " is odd = " + count1sInRow);
				return false;
			} else if (count1sInColumn % 2 != 0) {
				System.out.println("column " + row + " is odd = " + count1sInColumn);
				return false;
			}
			count1sInRow = 0;
			count1sInColumn = 0;
		}
		return true;
	}
}*/
		
		
		
		/*//ex7.22 there better solution--> codetip2ex7.22
		int list[][] = new int[6][6];
		for(int row = 0 ; row <list.length;row++ ) {
			for(int column = 0 ; column < list[row].length ; column++){
				list[row][column] = (int)(Math.random() * 2);
				System.out.print(list[row][column]+" ");
			}
			System.out.println("");
		}
		
				 
			
		if(checkRow(list) && checkColumn(list)) {
			System.out.println(" every row and every "
					+ "column have an even number of 1s");
		}
		else
			System.out.println("its not all even");
		
		
		
		
	}
	public static boolean checkRow(int[][] list) {
		int count1s=0;
		for(int row = 0 ; row <list.length;row++ ) {
			for(int column = 0 ; column < list[row].length ; column++){
				if(list[row][column] == 1)
					count1s++;
			}
			if(count1s % 2 !=0) {
				System.out.println("row "+row+"is odd ");
				return false;
			}
			count1s=0;
		}
		return true;
	}
	public static boolean checkColumn(int[][] list) {
		int count1s = 0 ;
		for(int column = 0 ; column <list[0].length;column++ ) {
			for(int row = 0 ; row < list.length ; row++){
				if(list[row][column] == 1)
					count1s++;
			}
			if(count1s % 2 !=0) {
				System.out.println("column "+column+" is odd ");
				return false;
			}
		}
		
		
		return true;
	}
}*/
		
		/*//ex7.21 note7  documentition in image
			//this better than caldes for every point
			 * it take n(n-1) 
			 * my implemntation take numofpossbalities()
			 * ~double speed with half ram 

//		Scanner inpute = new Scanner(System.in);
//	
//		System.out.println("enter number of cites");
//		System.out.println("enter corrdenates of cites");	
//		int a =inpute.nextInt();
//		double [][]cites = new double[a][2];
//		for(int i = 0 ;i<cites.length ;i++) {
//			for(int j = 0 ; j<cites[0].length ; j++) {
//				cites[i][j] = inpute.nextInt();
//			
//			}
//		}
		
		double [][]cites = {{1,1},{2,2},{5,1},{4,2},{3,2}};
		findCentralCity(cites);
	
	}
	
	public static void findCentralCity(double [][] pos) {
		double[] distances = calcDistances(pos);
		//pos.length --> number of points
		double MinSum = sumPoints(0, pos.length , distances);
		int centralCity = 0;
		double sum ;
		for(int point =1;point<pos.length;point++) {
			sum =0;
			sum=sumOtherPoints(point,distances , pos.length, sum);
			if(sum < MinSum) {
				centralCity = point;
				MinSum = sum;
			}
		}
		System.out.println("central city is " +centralCity+" cordinates "+pos[centralCity][0]+" "+pos[centralCity][1]+
				"distance "+MinSum);
			
		
	}
	
 	public static double [] calcDistances(double [][]pos) {
		double distances [] =new double [numOfprobablies(pos.length)];
		for(int i = 0,u=0 ;i<pos.length ;i++) {
			for(int j = i+1 ; j<pos.length  ; j++) {
				distances[u] = getDistance(pos,i,j);
				u++;
			}
			
		}
		return distances;
	}
	public static double getDistance(double [][]pos,int i,int j) {

		double x=0 ,y=0;					
			x =   pos[j][0] - pos[i][0];
			y =   pos[j][1] - pos[i][1];
		
			
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) );
		
	}
	public static double sumPoints(int start,int stop,double[]m) {
		 double sum = 0; 
		for( ; start < stop ; start++ ) {
			sum += m[start];
		}
		
		return sum;
	}
	
	public static double sumOtherPoints(int point,double []m , int numOfPoints,double sum) {
		int shift = point-1;
		int start ;
		int num = numOfPoints;
		for( start = 0 ; shift>= 0 ; start += numOfPoints-- -1) {
			
			sum+=m[start+shift];
			shift--;
		}
		if(point<num-1)
			sum+=sumPoints(start, start+numOfPoints -1 , m);
		return sum;
	}
	public static int numOfprobablies(int numOflVal) {
		//last value will not added
		int numOfProbablities =0;
		for(int i = 0 ; i<numOflVal-1 ;i++ ) {
			for( int j = i + 1 ; j <numOflVal ;j++ ) {
				numOfProbablities++;
			}
			}
		return numOfProbablities;		
	}
}*/
	/*//codetip1 ex7.18	
		int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
		print(m, "before shuffle by row");
		shuffle(m);
		print(m, "after sheffle by row");
	}
	public static void shuffle(int[][] m) {
		for(int row =0 ; row < m.length ; row++) {
			int temp1,temp2;
			int randPos = (int)(Math.random() * m.length);
			
//			temp1 = m[randPos][0];
//			temp2 = m[randPos][1];
//			
//			m[randPos][0] = m[row][0];
//			m[randPos][1] = m[row][1];
//			
//			m[row][0] = temp1;
//			m[row][1] = temp2;
			
			//this from  book
			int temp [] = m[row];
			m[row] = m[randPos];
			m[randPos] = temp;
			
		}
	}
	public static void print(int mat [][] , String str) {
		System.out.println(str);
		for(int row =0 ;row< mat.length;row++) {
			
			for(int column=0;column < mat[0].length ;column++) {
				
				System.out.print(mat[row][column] +" ");
				
			}
				System.out.println("");
		}
		System.out.println("----");
	}
	
}*/
		
	/*	//note 6 
	 * //ex7.16   book solution  faster but if print sort by row then
	 // by column this better 
		int[][] mat = { { 4, 2 }, { 1, 7 }, { 4, 5 }, { 1, 2 }, { 1, 1 }, { 4, 1 } };
		print(mat, "befor sort ");
		
		//false to not use checkColumn()
		//0 1 to sort  list[i][0] by row
		sort(mat,0,1,false);
		print(mat," after sort by row ");
		
		//////////////
		//1 0 to sort  list[i][1] by column

		sort(mat,1,0,true);

		print(mat," after sort by column");
	}

	public static void sort(int list[][],int z,int n,boolean status) {
		//row sort
		 
		 int min = 0 , temp, indexnfMin = 0;
		 for(int i = 0 ; i < list.length -1  ; i++) {				
			 min = list[i][z];
			 indexnfMin = i;
			//if put checkColumn first before j < list.length it will raie erroe
			// as it will be 6 in last j then check 
			 for( int j = i  + n ; j < list.length && checkColumn(status ,i,j,list) ; j++) {					  
				 if (min > list[j][z]) {
					  indexnfMin = j;						  
					 min = list[j][z];
					 
				 }
				 
			 }
			        //SWAP  if necessary
			 if(indexnfMin != i) {
			 list[indexnfMin][z] = list[i][z]; 
			 list[i][z] = min;
			 
			 
			 temp = list[indexnfMin][n];
			 list[indexnfMin][n] = list[i][n];
			 
			 list[i][n] = temp;
			 
			 
			 }
			 

		 }
		
	}
	
	public static void print(int mat [][] , String str) {
		System.out.println(str);
		for(int row =0 ;row< mat.length;row++) {
			
			for(int column=0;column < mat[0].length ;column++) {
				
				System.out.print(mat[row][column] +" ");
				
			}
				System.out.println("");
		}
		System.out.println("----");
	}
	public static boolean checkColumn(boolean status ,int i,int j,int list[][]) {
		if(status && list[i][0]!=list[j][0]) {
			return false;
		}
		
		return true; 
	}
}*/

/*//ex7.14	 book solution better
		Scanner inpute = new Scanner(System.in);
		System.out.println("enter size of matrix");
		int inp = 4;
		int[][]mat=new int[inp][inp];
		
		for(int row =0 ;row < mat.length ; row++) {
			
			for(int column = 0 ; column < mat[0].length ; column++ ) {
				
				mat[row][column] =  (int)(Math.random() * 2) ;
				System.out.print(mat[row][column]);
			}
			System.out.println("");
		}
		findZeroesOnes(mat);
		
		
	}

	public static void findZeroesOnes(int[][] mat) {
		find0s1sInRow(mat);
		find0s1sInColumn(mat);
		find0s1sInMajorDigonal(mat);
		find0s1sInMinorDigonal(mat);
	}
	public static void find0s1sInRow(int[][]mat) {
		int numOfZeros =0;
		int numOfOnes = 0;
		// find all 0s 1s in row
		boolean match =false;
		for (int row = 0; row < mat.length; row++) {
			numOfOnes = 0;
			numOfZeros=0;
			for (int column = 0; column < mat[0].length; column++) {
				if (mat[row][column] == 0) {
					numOfZeros++;
				
					if (numOfZeros == mat.length) {
						System.out.println("all zeroes in row " + row);
						match = true;
					}
				} else {
					numOfOnes++;
					if (numOfOnes == mat.length) {
						System.out.println("all ones in row  " + row);
						match = true;
					}}
			}
		}
		if(!match)
			System.out.println("no same numbers in row");
			
	}
	
	public static void find0s1sInColumn(int[][]mat) {
		int numOfZeros =0;
		int numOfOnes = 0;
		// find all 0s 1s in row
		boolean match =false;
		for (int column = 0; column < mat.length; column++) {
			numOfOnes = 0;
			numOfZeros=0;
			for (int row = 0; row < mat[0].length; row++) {
				if (mat[row][column] == 0) {
					numOfZeros++;
				
					if (numOfZeros == mat.length) {
						System.out.println("all zeroes in column " + column);
						match = true;
					}
				} else {
					numOfOnes++;
					if (numOfOnes == mat.length) {
						System.out.println("all ones in column  " + column);
						match = true;
					}}
			}
		}
		if(!match)
			System.out.println("no same numbers in column");
			
		
	}
	public static void find0s1sInMajorDigonal(int[][]mat) {
		int numOfZeros =0;
		int numOfOnes = 0;
		// find all 0s 1s in row
		boolean match =false;
		int row;
		for ( row = 0; row < mat.length; row++) {
				if (mat[row][row] == 0) {
					numOfZeros++;				
					if (numOfZeros == mat.length) {
						System.out.println("all zeroes in major " );
					}
				} else {
					numOfOnes++;
					if (numOfOnes == mat.length) {
						System.out.println("all ones in major  " );
					}}
			
		}
		if(numOfZeros != mat.length && numOfOnes != mat.length)
			System.out.println("no same numbers in major");
			
	}
	public static void find0s1sInMinorDigonal(int[][]mat) {
		int numOfZeros =0;
		int numOfOnes = 0;
		// find all 0s 1s in row
		boolean match =false;
		
		
		for ( int row = mat.length-1, column = 0; row >= 0; row--,column++) {
				if (mat[row][column] == 0) {
					numOfZeros++;				
					if (numOfZeros == mat.length) {
						System.out.println("all zeroes in minor " );
					}
				} else {
					numOfOnes++;
					if (numOfOnes == mat.length) {
						System.out.println("all ones in minor  " );
					}}
			
		}
		if(numOfZeros != mat.length && numOfOnes != mat.length)
			System.out.println("no same numbers in minor");
			
	}
	// find all 0s 1s in column

}
		
	*/	
		/*//ex7.15
		Scanner input = new Scanner(System.in);

		System.out.println("Enter five points:");
		double[][]points = new double[5][2];
		for(int row =0 ;row<points.length ; row++) {
			for(int column =0 ;column < points[row].length ; column++) {
				points[row][column] = input.nextDouble();
			}
		}
		System.out.println("points have enterd");
		if(onTheSameLine(points))
			System.out.println("all points on same line");
		else
			System.out.println("not on same line ");
			
	}
		public static boolean onTheSameLine(double [][] points ) {
			for(int i = 2 ; i <points.length ;i++) {
			double result =(points[1][0] - points[0][0])*(points[i][1] - points[0][0]) - (points[i][0] - points[0][0])*(points[1][1] - points[0][1]);
			if (result == 0)
			return true;
			}
			return false;
		}
	}
		
		
		
		
		*/
		
		
		
		
		
		/*//ex7.13		
		Scanner inpute = new Scanner(System.in);
		int index[] =new int[2];
		System.out.println("enter number of rows and columns");
		double a [][] =new double [inpute.nextInt()][inpute.nextInt()];
		System.out.println("enter array");
		for(int row = 0 ;row < a.length ;row++) {
			for(int column = 0 ; column < a[row].length ; column++) {			
				 a[row][column] = inpute.nextDouble();		
				}	
			}
		index = locateLargest(a);
		System.out.println("pos of largest element \n"+(index[0]+1)+" "+(index[1]+1));
		
		
		
	}
	public static int[] locateLargest(double[][] a) {
		int indexOfSmallestElement [] = new int [2];
		
		double largestElemnt = a[0][0];
		for(int row = 0 ;row < a.length ;row++) {
			for(int column = 0 ; column < a[row].length ; column++) {
				if(a[row][column] > largestElemnt) {
					largestElemnt = a[row][column] ;
					indexOfSmallestElement[0] = row;
					indexOfSmallestElement[1] =column;
				}	
			}
		}
		
		
		
		return indexOfSmallestElement;
	}

	}*/
/*//ex7.12 note5
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter filing status
		System.out.print("Enter the filing status: ");
		int status = input.nextInt();

		// Prompt the user to enter taxable income
		System.out.print("Enter the taxable income: ");
		double income = input.nextDouble();

		// Display the result
		System.out.println("Tax is " + (int) (computeTax(status, income) * 100) / 100.0);
	}

	public static double computeTax(int status, double income) {

		double[] rates = { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 };

		int[][] brackets = { { 8350, 33950, 82250, 171550, 372950 }, // Single filer
				{ 16700, 67900, 137050, 20885, 372950 }, // Married jointly
				// or qualifying widow(er)
				{ 8350, 33950, 68525, 104425, 186475 }, // Married separately
				{ 11950, 45500, 117450, 190200, 372950 } // Head of household
		};

		double tax = 0, val = 0;
		int i = 0;
		if (income <= brackets[status][0]) {
			tax = income * rates[0];
		} else {
			for (i = 0; i < brackets[status].length && income > brackets[status][i];) {
				tax += (brackets[status][i] - val) * rates[i];
				i++;
				val = brackets[status][i - 1];
			}
			tax += (income - brackets[status][i - 1]) * rates[i];
		}
		return tax;
	}
}*/

		/*//7.11
		Scanner inpute = new Scanner(System.in);
	System.out.println("enter number ");
	char mat[] = new char [9];
	Arrays.fill(mat, '0');
	int number = inpute.nextInt();
	decToBinary(number , mat);
		for(int i = 1 ; i <= mat.length ;i++) {
			if(mat[i-1] =='1')		
				System.out.print("T ");
			else
				System.out.print("H ");
		
			if(i % 3 == 0)
				System.out.println("");
		}
		
		
	}
	
	public static int decToBinary(int number ,char []mat ) {
		
		for(int i = mat.length - 1 ;number >0;number/=2,i--) {
			if(number % 2 == 1) {
				mat[i]='1';
			}
			
				
				
		}
		return 1;
	}
}*/
		/*
		//ex7.10
		int[][]matrix =new int[4][4];
		int indexOfRow = -1;
		int indexOfColumn = -1;
		int maxNumOfOnes=0;
		int countOnes=0;
		for(int row = 0 ; row < matrix.length ; row++) {
			for(int column = 0 ; column < matrix[row].length ; column++) {
				matrix[row][column] = (int)(Math.random() * 2);
				System.out.print(matrix[row][column] + " ");
				//
				if(matrix[row][column] == 1) {
					countOnes++;
					if(countOnes > maxNumOfOnes) {
					maxNumOfOnes = countOnes;
					indexOfRow = row;
				}
				}
				
			}
			countOnes=0;
				System.out.println("");
		}
		if(indexOfRow == -1)
			System.out.println("row  was all  zeroes");
		else
			System.out.println("index of first largest 1 rows"+indexOfRow);
		///////////////
		maxNumOfOnes = 0 ;
		for(int coulumn = 0 ; coulumn < matrix[0].length ; coulumn++) {
			for(int row = 0 ; row < matrix.length ; row++) {
				if(matrix[row][coulumn] == 1) {
					countOnes++;
					if(countOnes > maxNumOfOnes) { 
					maxNumOfOnes = countOnes;
					indexOfColumn = coulumn;
				}
				}
				
			}
			countOnes=0;
			
		}
		if(indexOfColumn == -1)
			System.out.println("column  was all  zeroes");
		else
			System.out.println("index of first largest 1 in column"+ indexOfColumn);
	}
	
}
		*/
		/*//ex7.9	
		Scanner inpute = new Scanner(System.in);
		//default values is  '\u0000'
		char [][] positions = new char[3][3];
		// Difference between X and O
		final int diff =9;		
		
		char txt =' '; // this not equal to \u0000
		int val = (int) (Math.random()*2) ;  // random player to start X OR O
		int row, column;
		
		for ( ; statues(positions, txt) ; ) {			
			printGame(positions);
			// when val odd it will  val%2 --> 1 when even it will by 0
		
			txt = (char) ('O' +((val % 2) * diff));
			System.out.println("enter row  and column  for player "+txt);
			// read input
			row = inpute.nextInt();
			column = inpute.nextInt();
			//check if position already occupied
			if(positions[row][column] != '\u0000') { 
				System.out.println("this positon already entered try another");
				continue;
			}
				positions[row][column] = txt;
				val++;
		}

	}

	public static void printGame(char[][] positions) {
		System.out.println("-------------");
		for (int row = 0; row < positions.length; row++) {
			for (int column = 0; column < positions[row].length; column++) {				
				System.out.print("| "+ positions[row][column] +" ");
			}	
				System.out.println("|\n-------------");
		}


	}

	public static boolean statues(char[][]pos ,char player) {

		if(isWon(pos, player)) {
			System.out.println("player " +player+" won");
			return false;}
		else if(isDraw(pos)) {
			System.out.println("draw");
			return false;	
		}
		return true;

	}

	public static boolean isWon(char[][] pos, char player) {
		// check row
		for (int row = 0; row < pos.length; row++) {
			if (pos[row][0] !='\u0000'  && (pos[row][0] == pos[row][1]) &&
				(pos[row][1] == pos[row][2])) {
				return true;
			}
		}
		///////////
		// check column
		for (int column = 0; column < pos.length; column++) {
			if (pos[column][0] !='\u0000'  && (pos[0][column] == pos[1][column]) &&
					(pos[1][column] == pos[2][column])) {
				return true;
			}
		}
		//////////////
		//another style this good when play high n *n   game 
		//code will be the same here not as above
		// check major diagonal
		int row = 0;
		for (row = 0; row < pos.length; row++) {
			if (pos[row][row] != player)
				break;
		}
		if (row == 3) {
			System.out.println("major");
			return true;
		}
		///////////////////////
		// check minor diagonal
		int column;
		for (column = 0,row = pos.length - 1; row >=0; row--,column++) {
			if (pos[row][column] != player) {
				break;}
		}
		if (row == -1) {
			System.out.println("minor");
			return true;
		}
		////////////////////////
		return false;
	}

	public static boolean isDraw(char[][] pos) {
		for (int row = 0; row < pos.length; row++) {
			for (int column = 0; column < pos[row].length; column++) {
				if (pos[row][column] == '\u0000')
					return false;
			}
		}
		return true;
	}

	
	
}*/
	
		/*//ex7.8
		double[][] points = {{1, 1}, {0, 0.5},{-1, 3}, {-1, -1},
			      {2, 0.5}, {2, -1}, {3, 3}, {4, 2}, {4, -0.5}, };
		
		int [][]indexOfSmallest =new int[points.length][points[0].length];
		
		double smallestPoint = destance(points, 0, 1);
		double destance =0;
		int i =-1 ;
		for(int row = 0 ;row < points.length ; row++) {
			for(int torow = row + 1 ; torow < points.length ;torow++) {
				destance =destance(points, row, torow);
				if(destance < smallestPoint) {
					indexOfSmallest[i][0] = row;
					indexOfSmallest[i][1] = torow;
					i=0;
					smallestPoint =destance;					
				}
				else if(destance == smallestPoint) {
					i++;
					indexOfSmallest[i][0] = row;
					indexOfSmallest[i][1] = torow;
				}
			}	
		}
//		for(int row =0 ; row <= i ; row++) {
//			for(int column = 0 ;column <indexOfSmallest[row].length;column++)
//				printArray(points, indexOfSmallest[row][column]);
//				
//			System.out.println("");
//		}
		//another solution to print  from yang
		for (int row = 0; row <= i; row++) {
		      int p1 = indexOfSmallest[row][0]; 
		      int p2 = indexOfSmallest[row][1]; 
		     
		      System.out.println("The closest two points are " +
		        "(" + points[p1][0] + ", " + points[p1][1] + ") and (" +
		        points[p2][0] + ", " + points[p2][1] + ")");
		    }
		
		
	}
		
			public static double destance(double [][] points ,int row ,int torow ) {
				
				double x=0 ,y=0,z=0;					
					x =   points[torow][0] - points[row][0];
					y =   points[torow][1] - points[row][1];
				
					
				return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) );
			}	
			
			public static void printArray(double points[][] , int row) {
				System.out.print(" ( ");
				for(int column =0 ; column < points[0].length ; column++) {
					System.out.print(points[row][column]+" ");
				}
				System.out.print(" )");
				
			}
	
	}
	
	*/

		/*//ex7..7	
		double[][] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1},
				{2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2},
				{5.5, 4, -0.5}};
				
		double smallestPoint = destance(points, 0, 1);
		int indexOfPoint1 = 0;
		int indexOfPoint2 = 0;
		
		for(int row = 0 ;row < points.length ; row++) {
			for(int torow = row + 1 ; torow < points.length ;torow++) {
				
				if(destance(points ,row ,torow) < smallestPoint) {
					indexOfPoint1 =row;
					indexOfPoint2 =torow;		
				}
			}	
		}
		
		// print output
		System.out.println("smallest point is \n"
		+ points[indexOfPoint1][0] +" "+ points[indexOfPoint1][1] +" " +points[indexOfPoint1][2] +"\n" 
		+ 
		points[indexOfPoint2][0] +" "+ points[indexOfPoint2][1] +" " +points[indexOfPoint2][2] +" " );
		
	
		
	}
		
			public static double destance(double [][] points ,int row ,int torow ) {
				
				double x=0 ,y=0,z=0;					
					x =   points[torow][0] - points[row][0];
					y =   points[torow][1] - points[row][1];
					z =   points[torow][2] - points[row][2];
					
				return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) +Math.pow(z, 2));
			}	
	
}*/
		/*//ex7.6	
		Scanner inpute = new Scanner(System.in);

		double[][] a = new double[3][3];
		double[][] b = new double[3][3];
		double[][] c = new double[3][3];

		System.out.println("enter matrix 1 ");
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[row].length; column++) {
				a[row][column] = inpute.nextDouble();
			}
		}
		/////
		System.out.println("enter matrix 2 ");

		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < b[row].length; column++) {
				b[row][column] = inpute.nextDouble();
			}
		}
		///////////////////////////////////////////////////////
		// print output
		c=multiplyMatrix(a, b);
		for (int row = 0; row < c.length; row++) {
			for (int column = 0; column < a[row].length; column++) 
			System.out.print(a[row][column] + " ");
			if(row == 1)
				System.out.print("   *   ");
			else
				System.out.print("       ");
			System.out.print("   ");
			for (int column = 0; column < b[row].length; column++) 
				System.out.print(b[row][column] + " ");
			if(row == 1)
				System.out.print("   =   ");
			else
				System.out.print("       ");
			for (int column = 0; column < c[row].length; column++) 
				System.out.printf("%3.1f  ",c[row][column] );
			System.out.println("");
		
		}
		
	}
		public static double[][] multiplyMatrix(double[][] a, double[][] b){
			double[][] c = new double[3][3];
			for (int row = 0; row < c.length; row++) {
				for (int column = 0; column < c[row].length; column++) {
					c[row][column] =( a[row][0] * b[0][column]) +(a[row][1] * b[1][column])+(a[row][2] * b[2][column]);
				}
			}
			
			
			return c;
		}

}
	*/
	
		/*//ex7.5	
		Scanner inpute = new Scanner(System.in);

		double[][] a = new double[3][3];
		double[][] b = new double[3][3];
		double[][] c = new double[3][3];

		System.out.println("enter matrix 1 ");
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[row].length; column++) {
				a[row][column] = inpute.nextDouble();
			}
		}
		/////
		System.out.println("enter matrix 2 ");

		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < b[row].length; column++) {
				b[row][column] = inpute.nextDouble();
			}
		}
		///////////////////////////////////////////////////////
		// print output
		c=addMatrix(a, b);
		for (int row = 0; row < c.length; row++) {
			for (int column = 0; column < a[row].length; column++) 
			System.out.print(a[row][column] + " ");
			if(row == 1)
				System.out.print("   +   ");
			else
				System.out.print("       ");
			System.out.print("   ");
			for (int column = 0; column < b[row].length; column++) 
				System.out.print(b[row][column] + " ");
			if(row == 1)
				System.out.print("   =   ");
			else
				System.out.print("       ");
			for (int column = 0; column < c[row].length; column++) 
				System.out.print(c[row][column] + " ");
			System.out.println("");
		
		}
		
	}
		public static double[][] addMatrix(double[][] a, double[][] b){
			double[][] c = new double[3][3];
			for (int row = 0; row < c.length; row++) {
				for (int column = 0; column < c[row].length; column++) {
					c[row][column] = a[row][column] + b[row][column];
				}
			}
			
			
			return c;
		}


	
	
	

}	*/
		/*//ex4.7	
		double[][] workHours = {
			      {2, 4, 3, 4, 5, 8, 8},
			      {7, 3, 4, 3, 3, 4, 4},
			      {3, 3, 4, 3, 3, 2, 2},
			      {9, 3, 4, 7, 3, 4, 1},
			      {3, 5, 4, 3, 6, 3, 8},
			      {3, 4, 4, 6, 3, 4, 4},
			      {3, 7, 4, 8, 3, 8, 4},
			      {6, 3, 5, 9, 2, 7, 9}};
		
		// store total hours of each employee
		double [] totalHours = new double[workHours.length];
		
	
		for(int row = 0; row < workHours.length ;row++) {
			
			for(int column = 0 ; column < workHours[row].length ;column++) 		
				totalHours[row] += workHours[row][column];
		}
		Arrays.sort(totalHours);
		for(int i =totalHours.length -1  ;i >=0 ;i--) {
			System.out.println("employee "+(totalHours.length - i)+" work "+ totalHours[i] + "hours ");
		}
		
	}
	
}
		*/
		/*	//ex7.3
		// Students' answers to the questions
	    char[][] answers = {
	      {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
	      {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
	      {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
	      {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
	      {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
	      {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
	      {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
	      {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};
	    
	    
	    //score of each student
		int [] correct = new int[answers.length];

	    // Key to the questions
	    char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

	    // Grade all answers
	    for (int i = 0; i < answers.length; i++) {
	      // Grade one student
	      int correctCount = 0;
	      for (int j = 0; j < answers[i].length; j++) {
	        if (answers[i][j] == keys[j])
	          correct[i]++;
	        
	      }
	    }
	      Arrays.sort(correct);
	      
	      for(int i =0 ; i < correct.length ;i++) {
	    	  System.out.println("student " +(i +1 )+ " correct count is "+correct[i]);
	      }
	    
		
	}
}*/
		/*//ex7.2
		Scanner inpute = new Scanner(System.in);
		
		double [][] matrix = new double[4][4];
		System.out.println("enter 3 by 4 matrix");
		//row == column in major digonal
		for (int row = 0; row < matrix.length; row++) {

			for (int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = inpute.nextDouble();

			}

		}
		
		System.out.println("sum of major digonal is "+sumMajorDigonal(matrix));
	}
		public static double sumMajorDigonal(double [][] matrix) {
			double sum =0;
			for(int row = 0 ; row<matrix.length ;row++) {
				sum+= matrix[row][row];
				
			}
			return  sum ;
		}
		
	}*/

		/*//ex7.1
		 Scanner inpute = new Scanner(System.in);
		double sum = 0;
		double[][] matrix = new double[3][4];
		System.out.println("enter 3 by 4 matrix");
		for (int row = 0; row < matrix.length; row++) {

			for (int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = inpute.nextDouble();

			}

		}
		
		for(int column = 0 ;column <matrix[0].length ; column ++) {
			System.out.println(" sum of column"+column+" is " + sumColumn(matrix, column));
		}
				

	}
	public static double sumColumn(double[][] m , int columnIndex) {
		double sum=0;
		for(int row = 0 ; row <m.length ;row++) 
			sum+=m[row][columnIndex];	
		return sum;
	}*/
		/*ex6.34 
		// array containe poistion of queens in board
		// queens placed at (i,queen[i])
		int[] queenPos = new int[8];
		int count = 1;
		// if i return -1 it mean no possible solutions so out
		for (int i = 0, temp = 0; queenPositions(i, temp, queenPos) >= 0; count++) {
			System.out.println("\nsolution number " + count + "\n");
			displayQueen(queenPos);
			// tell methode to start from last sucess solution
			i = 7; // not pos = 7 but pos in arry[7]
			// to start after last sucess pos
			temp = 1;
		}
		System.out.println("the end ");

	}

	public static int queenPositions(int i, int temp, int[] queenPos) {

		// i>=0 to sure when i = -1 as no another solutions not make exception error

		for (; i < queenPos.length && i >= 0;) {
			int newPos = 0;
			for (newPos += queenPos[i] + temp; newPos <= 7; newPos++) {
				// ckeck conditions
				if (isPosValid(i, newPos, queenPos)) {
					// update queen array
					queenPos[i] = newPos;
					i++;
					temp = 0;
					break;
				}
			}
			// go back step when can't find pos
			if (newPos > 7) {
				// Initialize current array pos to not checked when go back step
				// if go back 2 steps it may raise error it will be 2 valus in one row
				queenPos[i] = 0;
				i--;
				temp = 1; // start from last pos + 1
			}
		}

		return i; // to indicate it -1 or not

	}

	public static boolean isPosValid(int i, int newPos, int queenPos[]) {
		int temp = i;
		int j;

		for (j = 0; j < i; j++, temp--) {
			// if false break
			if (newPos == queenPos[j] || (Math.abs(queenPos[j] - newPos) == temp)) {

				return false;
			}
		}

		return true;

	}

	public static void displayQueen(int... queenPositions) {

		for (int i = 0; i < queenPositions.length; i++) {
			System.out.print("|");
			for (int j = 0; j < queenPositions.length; j++) {
				if (j == queenPositions[i])
					System.out.print("Q|");
				else
					System.out.print(" |");

			}
			System.out.println("");
		}
	}
}*/
		/* ex 6.22 another solution
		// array containe poistion of queens in board
		// queens placed at (i,queen[i])
		int[] queenPos = new int[8];

		queenPositions(queenPos);
		displayQueen(queenPos);
	}

	public static void queenPositions(int[] queenPos) {
		int temp = 0;
		for (int i = 0; i < queenPos.length;) {
			int newPos = 0;
			for (newPos += queenPos[i] + temp; newPos <= 7; newPos++) {
				// ckeck conditions
				if (isPosValid(i, newPos, queenPos)) {
					// update queen array
					queenPos[i] = newPos;
					i++;
					temp = 0;
					// System.out.println("valid"+newPos +" "+i);

					break;
				}
			}
			if (newPos > 7) {
				queenPos[i] = 0;
				i--;
				temp = 1;
			}
		}
	

	}

	public static boolean isPosValid(int i, int newPos, int queenPos[]) {
		int temp = i;
		int j;

		for (j = 0; j < i; j++, temp--) {
			// if false break
			if (newPos == queenPos[j] || (Math.abs(queenPos[j] - newPos) == temp)) {

				return false;
			}
		}

		return true;

	}

	public static void displayQueen(int... queenPositions) {

		for (int i = 0; i < queenPositions.length; i++) {
			System.out.print("|");
			for (int j = 0; j < queenPositions.length; j++) {
				if (j == queenPositions[i])
					System.out.print("Q|");
				else
					System.out.print(" |");

			}
			System.out.println("");
		}

	}

}
*/
		/*//ex6.32   better than solution of book
		Scanner inpute = new Scanner(System.in);
		System.out.println("enter list ");
		int list [] = new int[inpute.nextInt()];
		for(int i = 0 ; i< list.length;i++) {
			list[i] = inpute.nextInt();
		}		
		int pivotLocation = partition(list) ;		
	}
	
	public static int partition(int [] list) {
		int pivot = list[0];
		int listPar[] = new int[list.length];
		int min =0;
		for(int i =1 , max=list.length-1 ; i< list.length ;i++) {
			if(list[i] <=pivot) {
				listPar [min] = list[i];
				min++;
			}
			else {
				listPar [max] = list[i];
				max--;
			}
		}
		//pivot is after last min and its already incremented
		listPar[min] = pivot;
		//print reasult
		for (int i : listPar) {
			System.out.print(i);
			
		}
		///
		return min +1 ;
	}
	
	}*/
	/*//ex6.31 
	 *another solution Is  better 	at 
	 *https://soultionmanual.blogspot.com/2016/08/chapter-7-exercise-31-introduction-to.html
	 *
		Scanner inpute = new Scanner(System.in);
		System.out.println("enter list1");

		int [] list1 =new int[inpute.nextInt()];
		
		for(int i = 0 ;i < list1.length ;i++)
			list1[i] = inpute.nextInt();
		/////////////////////////////////////////
		System.out.println("enter list2");

		int [] list2 =new int[inpute.nextInt()];
		
		for(int i = 0 ;i < list2.length ;i++)
			list2[i] = inpute.nextInt();
		////////////////////////////////////////
		int[] merg =merge(list1, list2);
		for (int i : merg) {
			System.out.print(i+" ");
		}

	}
	
	public static int[] merge(int[] list1, int[] list2) {
		int size =list1.length+list2.length ;
		int merge [] =new int[size];
		for(int i = 0 ;i <list1.length;i++) 
			merge[i] = list1[i];
		
		for(int i =0 ;i< list2.length ;i++)
			merge[i+list1.length] = list2[i];
		
		Arrays.sort(merge);
		
		return merge;
	}
}
	*/
	/*//ex6.30	
		Scanner inpute = new Scanner(System.in);
	
		System.out.println("enter number of integers");
		int[] list = new int[inpute.nextInt()];
		
		System.out.println("enter numbers");
		for(int i=0 ;i<list.length ;i++)
			list[i] = inpute.nextInt();
		
		if(isConsecutiveFour(list))
			System.out.println("its have pattern");
		else
			System.out.println("no pattern");
	}
	
	
	public static boolean isConsecutiveFour(int[] values) {

		int count=0;
		for(int i = 1 ; i<values.length  && count < 3; i++ ) {
		
			if(values[i] == values[i-1])
				count++;
			else
				count = 0;			
		}
		if (count ==3)
			return true;
		return false;
	}
}*/
	/*//ex6.29
		int[] cardNumbers =new int[4];
		int sum =0 ,picks;
		for(picks =0;sum !=24 ; picks++) {
			sum =0;
			for(int i=0 ; i<cardNumbers.length ; i++) {
				cardNumbers[i] =1+  (int)(Math.random() * 52);
				sum +=cardNumbers[i];
			}
			
		}
		System.out.println("numper of picks "+4*picks);
	}
	
	}*/
		/*//6.24 
		boolean [] groupNumbers = new boolean [4];
		String [] groupNames = {"clubs","dimonds", "hearts" ,"spades"};
		String [] playingCards = {"ace" ,"2","3","4","5", "6","7","8","9","10","jack","queen","king"};
		int picks =0;
		for( int j = 0 ; j<4 ; picks++) {
			
			int randomCard =  (int)(Math.random() * 52 ); // 0-->51
			System.out.println("num is "+randomCard);
			int cardGroup = randomCard / 13 ;
			if(!groupNumbers[cardGroup]) {
				groupNumbers[j] = true;
				j++;
				
				System.out.println(playingCards[randomCard % 13 ]+" of " + groupNames[cardGroup]);
			}	
			
		}
		System.out.println("number of picks "+ picks);
		
		
		
		
	
	}
	
	
	
	
	}*/
	/*	//ex6.23 
		boolean [] lockState = new boolean[100];
		
		interactStudentWithLocks(lockState);
		
		for(int i=0 ; i<lockState.length;i++) {
			if(lockState[i] == true)
				System.out.print(i +" ");
		}
		System.out.println("are opened ");
		
		
		
	}
	public static void interactStudentWithLocks(boolean [] lockState) {
		int pos ;

		
		
		for(int studentNumber = 1 ; studentNumber <=100 ; studentNumber++) {		
			for(int i = studentNumber ; i <= 100 ; i+=studentNumber ) {
				pos = i -1 ;
				lockState[pos] = !lockState[pos];			
			}	
				
		}
		
	}
	
		
		
}*/
		/*//ex 6.22
		// array containe poistion of queens in board
		// queens placed at (i,queen[i])
		int[] queenPos = new int[8];
		boolean found = false;
		double start = System.currentTimeMillis();
		int i=0;
		while (!found) {
			// Initialize array as values in last try will be checked in conditions
			// so it may break for valid suggested position for example if
			// first positon in last try was 1 and sugesteed pos was 1 it will break
			
			Arrays.fill(queenPos, 0);
			found = queenPositions(queenPos);
			i++;
		}
		double end = System.currentTimeMillis();
		System.out.println("found  after "+ i +" tryes" );
		System.out.println("time is  " + (end - start)+" ms");

		displayQueen(queenPos);
		// displayQueen(1,2,3);
	}

	public static boolean queenPositions(int[] queenPos) {
		int temp, newPos = 0;
		// hold the generated random positions in this array to
		// Check is it repeated to not test this suggested position
		// as it will be in valid
		int[] generatedNumbers = new int[8];
		for (int i = 0, count = 0; i < queenPos.length; count++) {
			temp = i;
			// prevent unfiniteLoop as all possible case 1 --> 8 are failed
			if (count > 7)
				return false;
			// random position
			newPos = generatedNumbers[count] = getDistinctRandomPosition(generatedNumbers);

			// ckeck conditions
			int j;

			for (j = 0; j < i; j++, temp--) {
				// if false break
				if (newPos == queenPos[j] || (Math.abs(queenPos[j] - newPos) == temp)) {

					break;
				}
			}

			if (j == i) {
				// update queen array
				queenPos[i] = newPos;
				i++;
				//Initialize count for another suggested position
				count = 0;
				// Initialize array as values in last try will be checked in conditions
				// so it may break for valid suggested position
				// and generated numbers will be always the same !
				// so may not find any solution or take too long
				Arrays.fill(generatedNumbers, 0);
			}
		}
		return true;
	}

	public static int getDistinctRandomPosition(int[] generatedNumbers) {
		for (;;) {
			int newPos = 1 + (int) (Math.random() * 8);
			if (TestClass.linearSearch(generatedNumbers, newPos) < 0)
				return newPos;
		}

	}

	public static void displayQueen(int... queenPositions) {

		for (int i = 0; i < queenPositions.length; i++) {
			System.out.print("|");
			for (int j = 0; j < queenPositions.length; j++) {
				if (j == queenPositions[i] - 1)
					System.out.print("Q|");
				else
					System.out.print(" |");

			}
			System.out.println("");
		}
	}
	public static boolean isValid() {
		
		return false;
	}

}*/
		/*ex6.28
		Scanner inpute = new Scanner(System.in);
		int [] numbers = new int[3];
		int [] diffValues = new int [4];
		
		System.out.println("enter numbers ");
		for (int i =0 ; i<numbers.length ; i++) {
			numbers[i] = inpute.nextInt();
		}
		getUnMatedValues(numbers,diffValues);
		
		displayAllCombination(diffValues);
		
	}
	
	public static void getUnMatedValues(int[] numbers,int [] diffValues) {
		int found = -1 ,j ;
		for(int i =0 ; i < numbers.length ; i++) {
			
			for(j = 0 ; diffValues[j] != 0 ; j++ ) {
				found = TestClass.linearSearch(diffValues, numbers[i]);
			}
			if(found < 0)
				diffValues[j] = numbers[i];
		}
	}

	
	public static void displayAllCombination(int[] diffValus) {
		for (int i = 0 ;diffValus[i] !=0 ; i++) {
			for(int j= 0;  diffValus[j] !=0 ;j++) {
				System.out.println(diffValus[i] + " " + diffValus[j]);
			}
			
		}
		
	}
	
	

	}*/
		/*ex6.21
		Scanner inpute = new Scanner(System.in);
		System.out.println("Enter the number of balls to drop: ");
		System.out.println("Enter the number of slots in the bean machine:");
		// let 0 --> L and 1---> R

		int nubOfDrops = inpute.nextInt();
		int numOfSlots = inpute.nextInt();

		int[] slot = new int[numOfSlots];
		int[] pathList = new int[numOfSlots - 1];

		for (int i = 0; i < nubOfDrops; i++) {
			getPath(pathList, slot);
		}

		for (int i = 0; i < slot.length; i++) {
			System.out.println("\nnumber of balls at " + i + " is " + slot[i]);
		}

		displayBallsInSlots(nubOfDrops, slot);

	}

	public static void displayBallsInSlots(int numOfDropes, int[] slot) {
		for (int i = 0; i < numOfDropes; i++) {
			for (int j = 0; j < slot.length; j++) {
				if (slot[j] == numOfDropes - i) {
					System.out.print(" O ");
					slot[j]--;
				} else
					System.out.print(" * ");
			}
			System.out.println("");
		}

	}

	// num of balls = num of pathes =num of slots - 1
	public static void getPath(int[] pathList, int[] slot) {

		for (int i = 0; i < slot.length - 1; i++) {
			pathList[i] = (int) (Math.random() * 2);
		}

		addBallsToSlot(pathList, slot);

		for (int i : pathList) {
			if (i == 0)
				System.out.print("L ");
			else
				System.out.print("R ");
		}
		System.out.println("");

	}

	public static void addBallsToSlot(int pathList[], int[] slot) {
		int ballNum = 0;
		int i = 0;
		// lopp to last path
		for (i = 0; i < slot.length - 1; i++) {
			if (pathList[i] == 1)
				ballNum++;
		}
		
			slot[ballNum]++;
	

	}
	
}*/
		/*//ex6.20
		int list [] = {2,5,4,1};
		
		int max = 0 , indexOfMax = 0;
		 for(int i = list.length - 1 ; i >=0  ; i--) {				
			 max = list[i];
			 indexOfMax = i;
			 				 
			 for( int j = i  - 1 ; j >=0 ; j--) {					  
				 if (max < list[j]) {
					  indexOfMax = j;						  
					 max = list[j];
				 }
				 
			 }
			        //SWAP  if neccessary
			 if(indexOfMax != i) {
			 list[indexOfMax] = list[i];
			 list[i] = max;				 
			 }		
	
	}
		 for (int i : list) {
			System.out.println(i);
		}

	}
}/*
		/*System.out.println("enter numofval");
		int numOfVal=inpute.nextInt();
		int list [] = new int[numOfVal];
		if(isSorted(list))
			System.out.println("sorted");
		else
			System.out.println("un sorted");
	}
		
		public static boolean isSorted(int[] list){
			Scanner inpute = new Scanner(System.in);

			list[0] =inpute.nextInt();
			for (int i = 1; i < list.length; i++) {
				list[i] = inpute.nextInt();
				if(list[i] < list[i-1])
					return false;
				
			}
			return true ;

			
		}
	


}*/
		/*//ex6.17
		System.out.println("enter number of students");
		int numOfStudents = inpute.nextInt();
		int [] scores = new int[numOfStudents];
		String [] names = new String [numOfStudents];
		
		//get inpute
		for (int i =0;i < scores.length ; i++) {
			System.out.printf("enter #%d student name an score \n",i+1);
			names[i] = inpute.next();
			scores[i] = inpute.nextInt();
		}
		
		///// insertion sort
		
		int temp = 0;
		  for(int i = 1 ; i < scores.length ; i++) {
			//  put scores[i] in correct position
			  int cureentElement = scores[i];
			  String cureentName = names[i];
			  int j;
			  for( j = i - 1 ; j >= 0 && scores[j] < scores[i]; j--) {
					 //shifting
				  scores[j+1] =scores[j];
				  names[j+1] =names[j];
				  
			  }
			  scores[j + 1] = cureentElement;
			  names[j + 1] = cureentName;
		  }
		  
		  
		  for (int i =0 ; i<scores.length ; i++) {
			  System.out.printf(names[i]+" "+scores[i]+"\n");
			
		}
		
		
	}
	
}*/
		/*//6.16
		int list[] = new int[10000];
		for(int i =0 ; i<10000 ;i++) {
			list[i] = 1+(int) (Math.random() * 1000000);
 		}
		int key = 1 + (int)Math.random() * 1000000;
		long startTime = System.currentTimeMillis();
		if(TestClass.linearSearch(list, key) > 0)
			System.out.println(" found ");
		else
			System.out.println("not found");
			
		
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("time is "+executionTime);
		
		java.util.Arrays.sort(list);
		
		startTime = System.currentTimeMillis();
		
		if(java.util.Arrays.binarySearch(list, key) > 0)
			System.out.println("found");
		else
			System.out.println("not found");
		 endTime = System.currentTimeMillis();
		 
		 executionTime = endTime - startTime;
		System.out.println("time is "+executionTime);

	}}*/
		/*//6.15
		int[] list = TestClass.getInput(10);
		int[] val = eliminateDuplicates(list);

		for (int i = 0; val[i] != 0; i++) {
			System.out.println(val[i]);
		}

	}

	public static int[] eliminateDuplicates(int[] list) {
		int val[] = new int[10];
		int j = 0;
		for (int i = 0; i < list.length; i++) {
			if (TestClass.linearSearch(val, list[i] , j) < 0) {
				val[j] = list[i];
				j++;
			}
		}
		return val;
	}
}*/
		/*//6.14 note 4
		int gcd = gcd(20,60,40);
		System.out.println("greatest comm divisor  is " + gcd);
		
	}

	public static int gcd(int... numbers) {
		//find min number
		int min = numbers[0];
		for(int i = 1 ; i <numbers.length ; i++) {
			if(numbers[i] < min)
				min = numbers[i];
		}
		int i = 0;
		for(;i != numbers.length ;min--) {
			i = 0 ;
			for(;i<numbers.length && numbers[i] % min == 0 ; i++) {
							
			}
			
		}
		min++;
		return min;
	}

		
		
	
}*/
		/*//ex6.13		
		 System.out.println(getRandom(5,8,9));				
	}	
	public static int getRandom(int... numbers) {		
		for(;;) {			
		int num = 2 + (int)(Math.random() * 52); 
		for(int i =0 ; i < numbers.length && num != numbers[i]; i++ ) {
			return num ;
		}
		
		}
	}
	}*/
		/*//ex6.12
		int [] list = {1,2,3,4,5};
		int [] list2 = reverse(list);

		for(int i =0 ; i < list2.length;i++) {
			System.out.print(list2[i]+" ");
		}
	}
	
	public static int[] reverse(int [] list) {
		int temp = 0 ;
		for(int i = 0 ; i< list.length / 2 ; i++) {
			temp = list[i];
			list[i] = list[list.length - 1 - i];
			list[list.length - 1 - i] =temp;
		}
		
		return list ;
		
	}
	
}	*/
		/*//6.11
		double [] list = new double[10];
		System.out.println("enter 10 numbers");
		for(int i=0 ; i <list.length ; i++) {
			list[i] = inpute.nextDouble();
		}
		System.out.printf("mean is %.2f ",mean(list) );
		System.out.printf("dev is %f ",deviation(list));

		
		
	}
	
	// Compute the deviation of double values 
	public static double deviation(double[] x) {
		double sum =0 ;
		for(int i =0 ; i< x.length ;i ++) {
			sum += Math.pow(x[i] - mean(x), 2)/ (x.length - 1); 	
		}
		sum=Math.sqrt(sum);
		return sum;
	}
	// Compute the mean of an array of double values 
	public static double mean(double[] x) {
		double sum =0;
		for(int i= 0 ;i < x.length ; i++) {
		sum	+=x[i];
		}
		
		return sum / x.length;
	}


}
	*/
	/*//ex6.10
		double [] list = new double[10];
		System.out.println("enter 10 numbers");
		for(int i=0 ; i <list.length ; i++) {
			list[i] = inpute.nextDouble();
		}
		
		System.out.println("index of smallest num is "+ min(list));
		
		
	}
	
	public static int min(double[] array) {
		double min = array[0];
		int indexOfMin = 0 ;
		for(int i=1;i<array.length ;i++) 
			if(array[i] < min) {
				min = array[i];
				indexOfMin = i ;
			}
		
		return indexOfMin;
	}	
	
}
	*/
		/*//6.9
		double [] list = new double[10];
		System.out.println("enter 10 numbers");
		for(int i=0 ; i <list.length ; i++) {
			list[i] = inpute.nextDouble();
		}
		
		System.out.println("smallest num is "+ min(list));
		
		
	}
	
	public static double min(double[] array) {
		double min = array[0];
		for(int i=1;i<array.length ;i++) 
			if(array[i] < min)
				min = array[i];
		
		return min;
	}

	
}

*/
/* 6.8
		System.out.println("enter 10 numbers");
		double numbers[] = new double[10];
		for(int i=0 ;i< numbers.length ;i++) {
			numbers[i] = inpute.nextDouble();
		}
		
		System.out.println(" avg is "+average(numbers));
		
	}
		public static  int average(int numbers []) {
			System.out.println(" this");
			int sum =0 ;
			for(int i= 0 ; i< numbers.length ;i ++) {
				sum +=numbers[i];
			}
			int avg = sum / 10 ;
			
			return avg ;
		}
		public static  double average(double numbers []) {
			double sum =0 ;
			for(int i= 0 ; i< numbers.length ;i ++) {
				sum +=numbers[i];
			}
			double avg = sum / 10 ;
			
			
			
			return avg;
		}
		
		
	
	
}
*/
	/*	//ex 6. 7
		int [] list =new int  [100];
		//int []list  = {2,2,1,3,4,3,4};
		int occurance [] = new int [100];
		int values [] = new int [100];
		int numOfVal = 0;
		boolean matched ;
		
		for(int i = 0 ; i< list.length;i++) {
			list[i] = 1 + (int)(Math.random() * 9);
		}
		
		
		for(int i=0 ; i<list.length;i++) { 
			matched = false ;
			
			//get distinct values
			for(int j=0 ; j < numOfVal ;j++) {		// or  values[i] !=0
				
				if(list[i] == values[j]) {
					matched = true ;
					break ;
				}
				
			}
			if(!matched) {
				values[numOfVal] = list[i] ;
				// better solution to get ocuurance
				for(int j = i ; j < list.length ; j++) {
					if(values[numOfVal] == list[j])
						occurance[numOfVal]++;
				}
				numOfVal++;
			}						
		}
		
		
		//another sol  get ocuurence 
//		for(int i=0 ; i < numOfVal ;i++ ) { // or values[i] !=0
//		for(int j = 0; j < list.length; j++) {
//			
//			if(values[i] == list[j])
//				occurance[i]++;
//		}
//		}
		for(int i = 0 ; i < numOfVal ;i++) {
			System.out.println("number "+ values[i]
					+" occures "+occurance[i]);
		}
			
	}
}
*/
		/*6.6 note3
		 * final int NUM_OF_PRIMES = 50;
	    // Store prime numbers
	    int[] primeNumbers = new int[NUM_OF_PRIMES];
	    int count = 0; // Count the number of prime numbers
	    int number = 2; // A number to be tested for primeness
	    boolean isPrime = true; // Is the current number prime?

	    System.out.println("The first 50 prime numbers are \n");

	    // Repeatedly find prime numbers
	    while (count < NUM_OF_PRIMES) {
	      // Assume the number is prime
	      isPrime = true;

	      // Exercise03_21 if number is prime
	      for (int i = 0; i < count &&
	        primeNumbers[i] <= Math.sqrt(number); i++) {
	        //If true, the number is not prime
	        if (number % primeNumbers[i] == 0) {
	          // Set isPrime to false, if the number is not prime
	          isPrime = false;
	          break; // Exit the for loop
	        }
	      }

	      // Print the prime number and increase the count
	      if (isPrime) {
	        primeNumbers[count] = number;
	        count++; // Increase the count

	        if (count % 10 == 0) {
	          // Print the number and advance to the new line
	          System.out.println(number);
	        }
	        else
	          System.out.print(number + "\t");
	      }

	      // Check if the next number is prime
	      number++;
	    }
	  }
	}*/
		/*
		//ex 6.5
		System.out.println("enter ten numbers");
		int [] numbers = new int[10];
		int num ;
		boolean match ;
		for(int i=0;i<numbers.length;i++) {
			num = inpute.nextInt();
			match = false;
			for(int j = 0 ; j  < i ;j++ ) {
				if(num == numbers[j]) {
					match = true;
					break;		
				}
			}
			if(!match) {
				numbers[i]=num;
				System.out.print(numbers[i]+" ");}
		}
		
			
			
			
			
		
	}
}*/
/*ex6.4
		System.out.println("enter scores");
		int [] scores = new int[100] ;
		int i= 0;
		int avg = 0 ;
		int sum = 0 ;
		int aboveOrEqualCount=0;
		int belowCount=0;
		for(;;) {
			int number =inpute.nextInt();
			if(number < 0)
				break;
				scores[i] = number;
				sum+=scores[i];
				i++;
		}
		
		avg =sum / i ;
		
		for(int j=0;j<i;j++) {
			if(scores[j]>=avg)
				aboveOrEqualCount++;
			else
				belowCount++;
		}
		System.out.println("avg is "+avg+"\nabove equal is "+aboveOrEqualCount+"\n below "+belowCount);
		
	}
}

*/		
		/*6.3 another solution
		
		Scanner inpute = new Scanner(System.in);
		System.out.println("enter numbers between 1 100");
		int [] numbers =new int[100];
		boolean [] matched = new boolean[101];
		int occurance [] = new int[101];
		int number;
		int i=0;
		int numberToMatch;
		for(;;) {
		number = inpute.nextInt();
		if(number == 0)
			break;
		else if(number>=1 && number <=100) {
			numbers[i] = number;
			i++;
		}
			
		}
		
		for(int j =0 ;j<i;j++) {
			int min =numbers[j];
			int indexOfMin = j;
			for(int x = j + 1; x < i ;x++) {
			if( min > numbers[x]) {
				min = numbers[x];
				indexOfMin = x;
				
			}
			
			}
			numbers[indexOfMin]=numbers[j];
			numbers[j]=min;
			matched[min] = true ;
			//System.out.println(numbers[j]);
		}
		
		
		for(int j=0;j<i;j++) {
			if(numbers[j]==numbers[j+1]) {
				
				occurance[numbers[j]]++;
			}
			else
				occurance[numbers[j]]++;
				
		}

	
		for(int x = 0 ;x < occurance.length ;x++) {
			if(matched[x])
			System.out.println("number "+x+" occures "+ occurance[x]);
	
		}		
	}
	
}
*/	
		/*ex3.6
		Scanner inpute = new Scanner(System.in);
		System.out.println("enter numbers between 1 100");
		int [] numbers =new int[100];
		boolean [] matched = new boolean[100];
		int occurance [] = new int[100];
		int number;
		int i=0;
		int numberToMatch;
		for(;;) {
		number = inpute.nextInt();
		if(number == 0)
			break;
		else if(number>=1 && number <=100) {
			numbers[i] = number;
			i++;
		}
			
		}
		
		for(int j =0 ;j<i;j++) {
			if(matched[numbers[j]])
				continue ;
			numberToMatch =numbers[j];
			for(int x = j; x < i ;x++) {
			if( numberToMatch == numbers[x])
				occurance[numberToMatch]++; 
			}
			matched[numbers[j]] = true;
			
		}
		for(int x = 0 ;x < occurance.length ;x++) {
			if(matched[x])
			System.out.println("number "+x+" occures "+ occurance[x]);
	
		}		
	}
	
}
		/*ex 6.2
		Scanner inpute = new Scanner(System.in);
		int [] arr = new int[10];
		System.out.println("enter ten numbers");
		for(int i = 0 ; i < arr.length ;i++)
			arr[i] = inpute.nextInt();
		for(int i = arr.length - 1  ; i >=0 ; i-- )
			System.out.print(arr[i]+" ");
	}
*/	

		//ex 6.1	
	/*	System.out.println("enter number of students");
		int numOfStudents = inpute.nextInt();
		int [] scores = new int [numOfStudents];
		
		System.out.println("enter all scores");
		int max =scores[0] ;
		for(int i = 0 ; i < scores.length;i++) {
			scores[i] = inpute.nextInt();
			if(max < scores[i])
				max =scores[i];
		}
	
		for(int i=0; i < scores.length ; i++) {
			System.out.println(" student "+i+"score is "+scores[i]+" and grade is "+getGrade(scores[i], max));
				
		}
		
		
	
	}
	public static char getGrade(int score , int max) {
		char [] grades = {'A','B','C','D','F'};

		if(score >= max - 10)
			return grades[0];
		else if (score >= max - 20)
			return grades[1];
		else if (score >= max - 30)
			return grades[2];
		else if(score >= max - 40)
			return grades[3];
		else
			return grades[4];
		
	}
	
}
*/
	
		/*ex 5.31
		Scanner inpute = new Scanner(System.in);
		
		System.out.println("enter credit card number");
		long creditNumber =inpute.nextLong();
		if(isValid(creditNumber))
			System.out.println("num is valid");
		else
			System.out.println("num is invalde");
		
		
		
	}	
	public static boolean isValid(long creditNumber) { 
		int result = (int) (sumOfEveryOddNumber(creditNumber) +
				sumOfEverySecondNumber(creditNumber));
		System.out.println("result "+ result);
		boolean valdtion = 
				result % 10 == 0 && 
				getSize(creditNumber) >=13 && getSize(creditNumber) <=16&&
				(prefixMatched(creditNumber, 4) || prefixMatched(creditNumber, 5) ||
						prefixMatched(creditNumber, 37) || prefixMatched(creditNumber, 6)) ;
return valdtion;

	}
	public static int getDigit(long creditNumber) {

		int digit;
		
			digit = (int) (creditNumber % 10) * 2 ;
			if(digit / 10 !=0) {//if (number < 9
				int digit1 = digit % 10;
				int digit2 = digit / 10;
				digit =digit1 + digit2 ;
			
			}
			return digit;			
	}
	public static int sumOfEveryOddNumber(long creditNumber) {
		int i , sum = 0;	
		int digit;
		for( i=100 ; creditNumber > 0; ) {	
			digit = (int) (creditNumber % 10) ;	
			sum +=digit;
			creditNumber = creditNumber / i ;
		}
		return sum;
	}
	public static int sumOfEverySecondNumber(long creditNumber) {
			int sum = 0 ;
			long i;
			long num = creditNumber ;

			for( i=10 ; num > 0; i=i*100 ) {
				num = creditNumber / i ;
			sum +=getDigit(num);	
			}
		return sum;
	}
	public static int getSize(long creditNumber) {
		int i ;	
		for( i=0 ; creditNumber > 0 ; i++) 
			creditNumber = creditNumber / 10 ;	
		return i;		
	}		
	public static boolean prefixMatched(long number, int d) {		
		if(getPrefix (number, getSize(d)) == d )
		return true;
		return false;
	}
	public static long getPrefix(long number, int k) {
		number = (long) (number / Math.pow(10, (getSize(number) - k )))  ;
		
		return number;
	}
		
}

	/*	System.out.println("enter credit card number");
		long creditNumber =inpute.nextLong();
		int result = (int) (sumOfEveryOddNumber(creditNumber) +
				     sumOfEverySecondNumber(creditNumber));
		System.out.println("result "+ result);
		if(getNumberOfDigits(creditNumber) >=13 && getNumberOfDigits(creditNumber) <=16) {
		if(result % 10 == 0) {
			System.out.println("the number  is valid ");
			//System.exit(0);
		}
		else
			System.out.println("number not valid");
		}else
			System.out.println("number is small");
		
		
	}
	
	public static int sumOfEveryOddNumber(long creditNumber) {
		int i , sum = 0;	
		int digit;
		for( i=100 ; creditNumber > 0; ) {	
			digit = (int) (creditNumber % 10) ;	
			sum +=digit;
			creditNumber = creditNumber / i ;
		}
		return sum;
	}
	public static int sumOfEverySecondNumber(long creditNumber) {
		long i;	
		int digit,sum =0;
		long num = creditNumber ;
		for( i=10 ; num > 0; i=i*100 ) {
			num = creditNumber / i ;
			
			//double every digit
			digit = (int) (num % 10) * 2 ;
			
			
			
			if(digit / 10 !=0) {
				int digit1 = digit % 10;
				int digit2 = digit / 10;
				digit =digit1 + digit2 ;
			}
			sum +=digit;	
		}
		return sum;
	}
	public static int getNumberOfDigits(long creditNumber) {
		int i ;	
		for( i=0 ; creditNumber > 0 ; i++) 
			creditNumber = creditNumber / 10 ;		
		return i;		
	}
*/





		/* ex5.32
		char ch ;
		
		for(int i = 1 ; i<=100 ; i++)  {
		ch=TestClass.getRandomCharacter('A', 'Z');
		System.out.print(ch);
		if( i % 10 == 0)
			System.out.println("");
		}
		for(int i = 1 ; i<=100 ; i++)  {
			ch=TestClass.getRandomDigitCharacter();
			System.out.print(ch);
			if( i % 10 == 0)
				System.out.println("");
			}
	}
}
*/
	
		/*//ex5.39
		Scanner input = new Scanner(System.in);

		System.out.println("Enter three points for p0, p1, and p2:");
		double x0=input.nextDouble();
		double y0=input.nextDouble();
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		String tem="";
		
		
		if (onTheSameLine(x0, y0, x1, y1, x2, y2)) 
			tem="  p2  is on the same line ";
		else if ( onTheRight(x0, y0, x1, y1, x2, y2)) 
			tem="  p2 is on the right side of the line ";			
		else if(leftOfTheLine(x0, y0, x1, y1, x2, y2))
			tem="  p2 is on the left side of the line " ;
		else
			tem=" on line segment";
		System.out.println("("+x2 +","+y2+")" + tem + "("+x0 +","+y0+")" +" to "+"("+x1 +","+y1+")");

			
	}
		
		public static boolean leftOfTheLine(double x0, double y0,
		double x1, double y1, double x2, double y2) {
			double result =(x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0);
			if (result > 0)
			return true;
			return false;
		}

		public static boolean onTheSameLine(double x0, double y0,
		double x1, double y1, double x2, double y2) {
			double result =(x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0);
			if (result == 0)
			return true;
			return false;
		}
	 
		public static boolean onTheLineSegment(double x0, double y0,
		double x1, double y1, double x2, double y2) {
			double result =(x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0);
			if (result <= 0.0000000001 && ((x0 <= x2 && x2 <= x1) || (x0 >= x2 && x2 >= x1)))
			return true;
			return false;
		}
		public static boolean onTheRight(double x0, double y0,
				double x1, double y1, double x2, double y2) {
					double result =(x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0);
					if (result < 0)
					return true;
					return false;
				}
				
		
		
	
	
	
	}*/
		/*ex5.32
		int winCount=0;
		for(int i = 0 ; i<1000 ;i++) {
		int num1 = 0, num2 = 0, sum = 0;
		num1 = 1 + (int) (Math.random() * 7);
		num2 = 1 + (int) (Math.random() * 7);
		sum = num1 + num2;
		System.out.println("you rolled" + num1 + " + " + num2 + " = " + sum);
		if (sum == 2 || sum == 3 || sum == 12) {
			//System.out.println("you lose");
		} else if (sum == 7 || sum == 11) {
			//System.out.println("you win");
			winCount++;
		} else {
			int lastpoint = sum;
			while (true) {
				num1 = 1 + (int) (Math.random() * 7);
				num2 = 1 + (int) (Math.random() * 7);
				sum = num1 + num2;
				//System.out.println("you rolled" + num1 + " + " + num2 + " = " + sum);

				//
				if (sum == lastpoint) {
					//System.out.println("you win");
					winCount++;
					break;
				} else if (sum == 7) {
					//System.out.println("you lose");
					break;
				}
			}

		}
		}
		}

}*/

		/* ex 5.37
	}
		System.out.println(format(1121, 5));
	}
	public static String format(int number, int width) {
		int temp=number;
		String str ="";
		int numberOfDigits;
		// if zero will returen wrong value
		for( numberOfDigits = 0 ;   temp > 0 ;numberOfDigits++) {
			temp =temp / 10 ;
		}

		
		for(int i =numberOfDigits ;i < width ; i++) {
			str+="0";
			
		}
		
		
		str+=number;
		
		return str;
	}
}
*/


	
		/*5.30
	int num1=0,num2=0,sum=0;
		 num1 =1+(int)(Math.random() * 7);
		 num2 =1+(int)(Math.random() * 7);
		 sum = num1+num2;
		 System.out.println("you rolled"+num1+" + "+num2+" = "+ sum);
		 if(sum == 2  || sum ==3 || sum == 12) {
			 System.out.println("you lose");
		 }
		 else if(sum == 7 ||sum ==11) {
			System.out.println("you win"); 
		 }
		 else {
			 int lastpoint=sum;
			 while(true) {
				 num1 =1+(int)(Math.random() * 7);
				 num2 =1+(int)(Math.random() * 7);
				 sum = num1+num2;
				 System.out.println("you rolled"+num1+" + "+num2+" = "+ sum);

				 //
				 if(sum == lastpoint) {
					 System.out.println("you lose");
					 break;
				 }
				 else if(sum == 7) {
					 System.out.println("you lose");
					 break;
				 }
			 }
			
		}
		 
	
	

	
	}
	

}

*/

/*//ex5.29		
		
		int number =2 ,count=0;
		while(number <1000 -2) {
			if(isPrime(number)&& isPrime(number + 2)) {
				System.out.println("(" + number +","+(number+2)+")");	
			}
				number++;	
		}
			
	}
	public static boolean isPrime(int number) {
		for(int divisor =2;divisor<= number / 2;divisor++) {
			if(number % divisor ==0)
				return false ;
			
		}
			
			return true;
		
	}
	}*/
		/*//ex5.28
//		int  a =(int)(Math.pow(2, 31) -1);
//		int b=(int)Math.pow(2, 31) -1;
//		double c=Math.pow(2, 31) -1;
//		System.out.println(a +" "+b+"  "+c);
//		
		int number =2 ;
		while(number <=31) {
			int i=(int)(Math.pow(2, number) - 1);
			if(isPrime(i) ) {
				
				
				System.out.printf(number +" ");
				
			
			}
				number++;
			
			
		}
			
	}
	public static boolean isPrime(int number) {
		for(int divisor =2;divisor<= number / 2;divisor++) {
			if(number % divisor ==0)
				return false ;
			
		}
			
			return true;
		
	}
		
	}
	


*/
		
		/*//empir ex5.27
		
		int number =2 ,count=0;
		while(count <100) {
			if(isPrime(number) && !isPalindeom(number) && isPrime(reverse(number))) {
				
				count++;
				System.out.printf(number +" ");
				if(count % 10 ==0)
					System.out.println("");
			
			}
				number++;
			
			
		}
			
	}
	public static boolean isPrime(int number) {
		for(int divisor =2;divisor<= number / 2;divisor++) {
			if(number % divisor ==0)
				return false ;
			
		}
			
			return true;
		
	}
public static boolean isPalindeom(int number) {
		
		if(number ==reverse(number))
			return true;
		else
			return false;
		
	}
	public static int reverse(int number) {
		
		//getNumberOfDigits()
		int testNumber =number;
		int numOfDigits=0;
		do {
			numOfDigits++;
			testNumber /=10;
		}while(testNumber > 0);
		int all=0;
		//reverse it
		for(int i=numOfDigits-1;i>=0;i--) {
			all+=(number  % 10 ) * (int)Math.pow(10, i);
			number/=10;
		}
		
			return all;
		
	
	}
	
	
	
	}
		/*ex5.26
		int number =2 ,count=0;
		while(count <100) {
			if(isPrime(number) && isPalindeom(number)) {
				
				count++;
				System.out.printf(number +" ");
				if(count % 10 ==0)
					System.out.println("");
			
			}
				number++;
			
			
		}
			
	}
	public static boolean isPrime(int number) {
		for(int divisor =2;divisor<= number / 2;divisor++) {
			if(number % divisor ==0)
				return false ;
			
		}
			
			return true;
		
	}
public static boolean isPalindeom(int number) {
		
		if(number ==reverse(number))
			return true;
		else
			return false;
		
	}
	public static int reverse(int number) {
		
		//getNumberOfDigits()
		int testNumber =number;
		int numOfDigits=0;
		do {
			numOfDigits++;
			testNumber /=10;
		}while(testNumber > 0);
		int all=0;
		//reverse it
		for(int i=numOfDigits-1;i>=0;i--) {
			all+=(number  % 10 ) * (int)Math.pow(10, i);
			number/=10;
		}
		
			return all;
		
	
	}
	
	
	
	}*/
		
		
	
		/*//ex 4.26 +4.25       book is better
		System.out.println("time is "+currentTime());
	
	}
	
	//  currentTime
	public static String currentTime() {
		long totalSeconds = System.currentTimeMillis() /1000;
		
		long sec =  totalSeconds % 60 ;
	
		long totalMinutes = totalSeconds  / 60;
		long minutes = totalMinutes %60 ;
	
		long totalHoures = totalMinutes / 60 ;
		long houres =totalHoures % 24 ;
		// 
		getYear(totalHoures);
			
	return houres +" : "+minutes+" : " + sec +" GMT"  ;
	
	}	
	//currentDate
	public static String currentDate() {
		//getYear(totalHoures);
		
		return "jk";
	}
	
	public static long getYear(long totalHoures) {
		int sum =0,year=0;
		long totalDayes = getToatalDays(totalHoures);
		for( year =1970 ; sum < totalDayes ; year++ ) {
			if(isLeap(year))
				sum+=366;
				
			else
				sum+=365;
			
		}
		year--;		
		//
		System.out.println("\n year is  " +year);
		getMonth(remainingDays(year , sum ,totalDayes) ,year);
		
		
		return year;
		
		
	}
	public static int getMonth( int remainingDayes,int year) {
		int sum =0,month=0;
		for( month =1 ; sum<remainingDayes ;month++) {
		sum+=numberOfDaysInMonth(month ,year);
		}
		month--;
		sum = sum - numberOfDaysInMonth(month, year);
		int leftDayes = remainingDayes - sum + 1 ;
		getDay(leftDayes);
		System.out.println("\n month is "+month);
		return month;
	}
	public static int getDay(int leftDays) {
		System.out.println("\n day is "+leftDays);
		return leftDays;

	}
	public static long getToatalDays(long totalHoures) {
		
		return totalHoures / 24 ;

	}
	public static int remainingDays(int year , int sum ,long totalDayes) {
		if(isLeap(year)) 
			sum-=366;
		else
			sum-=365;

		return (int) (totalDayes - sum) ;

	}
	public static int numberOfDaysInMonth(int month ,int year) {
		 if (month == 1 || month==3 || month == 5 || month == 7 ||
			      month == 8 || month == 10 || month == 12)
			      return 31;

			    if (month == 4 || month == 6 || month == 9 || month == 11)
			      return 30;

			    if (month == 2)
			      if (isLeap(year))
			        return 29;
			      else
			        return 28;

			    return 0; // If month is incorrect.

	}
	public static boolean isLeap(int year) {
		
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
		      return true;

		    return false;
	}
		
}	
		
		
*/		
		
		
		
		
		/*//5.22	
		System.out.println(sqrt(4));
		
	}
	
	
	public static double sqrt(long n) {
		
		double nextGuess =1,lastGuess =0 ;
		
		do {
			lastGuess =nextGuess;

			nextGuess =(lastGuess + n /lastGuess) / 2;

		}while(Math.abs(nextGuess - lastGuess) > .00001);
		
		
		return nextGuess;
	}
		

}
*/




















/*//ex.5.21
System.out.println("enter latitude and longtude");
double x1 = inpute.nextDouble();
double y1 =inpute.nextDouble();
double x2 =inpute.nextDouble();
double y2 =inpute.nextDouble();
x1=Math.toRadians(x1);
x2=Math.toRadians(x2);
y1=Math.toRadians(y1);
y2=Math.toRadians(y2);
double radius = 6371.01;
double d =radius * Math.acos(Math.sin(x1) * Math.sin(x2)  + Math.cos(x1)
		* Math.cos(x2) *Math.cos(y1 - y2));
System.out.println(d);*/

		/*//ex5.15
		Scanner input = new Scanner(System.in);
		double stats0,stats1,stats2,stats3;
		System.out.println("income \t\t  0   \t\t   1   \t\t    2   \t\t   3   \t\t ");
	    for( double i =50000;i<=60000;i=i+50) {
	    	
	    	 stats0 =  computeTax(i, 8350, 33950, 82250, 171550, 372950) ;
		     
		       stats1 = computeTax(i, 12000, 46700, 112850, 171950, 307050);
		      
		       stats2 =  computeTax(i, 6000, 23350, 56425, 85975, 153525);
		      		    
		       stats3 =computeTax(i, 10000, 37450, 96700, 156600, 307050);
		       System.out.printf("%-7d\t\t%-7d\t\t%-7d\t\t%-7d\t\t%-7d",(int)i,(int)stats0,(int)stats1,(int)stats2,(int)stats3);
		       
	    		    System.out.println("");
	    		    //System.out.println(" stats0 is "+stats0);
	 		      // break;

	    }
		
		
		

	  }

	  public static double computeTax(double income,
	      int r1, int r2, int r3, int r4, int r5) {
	    double tax = 0;

	    if (income <= r1)
	      tax = income * 0.10;
	    else if (income <= r2)
	      tax = r1 * 0.1 + (income - r1) * 0.15;
	    else if (income <= r3)
	      tax = r1 * 0.1 + (r2 - r1) * 0.15 + (income - r2) * 0.25;
	    else if (income <= r4)
	      tax = r1 * 0.1 + (r2 - r1) * 0.15 +
	        (r3 - r2) * 0.25 + (income - r3) * 0.28;
	    else if (income <= r5)
	      tax = r1 * 0.1 + (r2 - r1) * 0.15 + (r3 - r2) * 0.25 +
	        (r4 - r3) * 0.28 + (income - r4) * 0.33;
	    else
	      tax = r1 * 0.1 + (r2 - r1) * 0.15 + (r3 - r2) * 0.25 +
	        (r4 - r3) * 0.28 + (r5 - r4) * 0.33 + (income - r5) * 0.35;

	    return tax;
	  }
		
	
}*/

		
		
		
		/*//ex5.7
		System.out.println(" enter amount /interest rate/years");
		
		double amount =input.nextDouble();
		double interestRate =input.nextDouble() /1200;
		int years =input.nextInt();
		System.out.println("years\t\t\tfuture value");
		double get=0;
		for(int i=1 ;i<=years ;i++ ) {
			
			get=futureInvestmentValue(amount, interestRate, i);
			System.out.printf("%-5d\t\t\t%-7.2f",i,get);
			System.out.println("");
			
		}
		
		
		
		
		
		
	}
	
	
	public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
		
		
		double futureInvestmentValue = investmentAmount * Math.pow(1 + monthlyInterestRate , years * 12);
		
				
		
		return futureInvestmentValue;
	}
}
*/
		
		
		
		
		
		/*//5.7
		System.out.println("enter n");
		int n =input.nextInt();
		displayPattern(n);
		
		
		
	}
	
	public static void displayPattern(int n) {
		
		for(int i = 1 ; i<=n ;i++) {
			for(int j = n - i ; j > 0 ; j--) {
				System.out.printf("     ");
			}
			for(int x = i ;x>0;x--) {
				System.out.printf("%-4d ",i);
			}
			
			System.out.println("");
			
		}
		
	}
	
}*/


     /*//ex 5.5
		System.out.println("enter three numbers");
		double num1=input.nextInt();
		double num2=input.nextInt();
		double num3=input.nextInt();
		displaySortedNumbers(num1, num2, num3);
	}
	public static void displaySortedNumbers(double num1 ,double num2,double num3) {
		
		if(num1 <num2 && num1 <num3 ) {
			printIt(num1, num2, num3);
			
//			if(num2<num3)
//				System.out.println(num1+" " +num2 + " " + num3);
//			else
//				System.out.println(num1 +" "+num3 + " " + num2);
//			
		}
	
		else if(num2 < num1 && num2< num3) {
			printIt(num2, num1, num3);
//			System.out.print(num2+" ");
//			if(num1<num3)
//				System.out.println(num1 + " " + num3);
//			else
//				System.out.println(num3 + " " + num1);
		}
		
		else {
			printIt(num3, num1, num2);
//			System.out.print(num3+" ");
//			if(num1<num2)
//				System.out.println(num1 + " " + num2);
//			else
//				System.out.println(num2 + " " + num1);
//				
				
		}	
		
	}
		
		public static void printIt(double num1 ,double num2,double num3) {
			
			if(num2<num3)
				System.out.println(num1+" " +num2 + " " + num3);
			else
				System.out.println(num1 +" "+num3 + " " + num2);
		
		
		}
	
	
	
}	
		
		
	*/



		/*//ex5.3 +5.4
		System.out.println("enter number");
		int number =input.nextInt();
		System.out.println(isPalindeom(number));
		
	}
	  
	public static boolean isPalindeom(int number) {
		
		if(number ==reverse(number))
			return true;
		else
			return false;
		
	}
	public static int reverse(int number) {
		
		//getNumberOfDigits()
		int testNumber =number;
		System.out.println("number is "+number);
		int numOfDigits=0;
		do {
			numOfDigits++;
			testNumber /=10;
		}while(testNumber > 0);
		int all=0;
		
		for(int i=numOfDigits-1;i>=0;i--) {
			all+=(number  % 10 ) * (int)Math.pow(10, i);
			number/=10;
		}
		
			return all;
		
	
	}
	
}*/

	///**********************************************************
		// ex from me like 5.3 but change 12345 to 45312  not54321
/*
Scanner input = new Scanner(System.in);

System.out.println("enter number");
//	int number =input.nextInt();
//	System.out.println(isPalindeom(number));
reverse(54321);
}

public static boolean isPalindeom(int number) {

if(number ==reverse(number))
	return true;
else
	return false;

}
public static int reverse(int number) {

//getNumberOfDigits()
int testNumber =number;
System.out.println("number is "+number);
int numOfDigits=0;
do {
	numOfDigits++;
	testNumber /=10;
}while(testNumber > 0);
int all=0;

//for(int i=numOfDigits-1;i>=0;i--) {
//	all+=(number  % 10 ) * (int)Math.pow(10, i);
//	number/=10;
//}

//return all;


//getFirst_SecondHaves()
int secondHave = number % (int)Math.pow(10, numOfDigits / 2);
int firstHave  = number / (int)Math.pow(10, numOfDigits / 2);

System.out.println( firstHave + " " + secondHave);

boolean isDigitsOdd =false;
int middleDigit =0;
//isDigitsOdd()       //if(isDigitsOdd) ---> get_middle_digit
if(numOfDigits % 2 !=0) {
	isDigitsOdd =true;
	middleDigit =firstHave % 10 ;
	//firstHave = firstHave  / 10;
}
System.out.println("middle is "+middleDigit);

	

//gatther numbers in one number
int reversedNumber;
if(isDigitsOdd) {
	firstHave = firstHave  / 10;
	System.out.println("first is " +firstHave);
 reversedNumber = firstHave+secondHave  * (int)Math.pow(10, (numOfDigits +1) / 2)+
		 			middleDigit *	(int)Math.pow(10, numOfDigits / 2);	

}
 else 
 reversedNumber = firstHave+secondHave  * (int)Math.pow(10, numOfDigits / 2);	


System.out.println("reverse is "+reversedNumber);

return 1;
}
*/
	//************************************************************	
		
	









































	/*	//ex5.2
		System.out.println("enter number");
		long number=input.nextLong();
		System.out.println(sumDigits(number));
		
			
		
	
	}
	
		public static long sumDigits(long number) {
			long digit=0,sum=0;
			while(number >0) {
				
				digit=number % 10;
				number = number /10;
				sum+=digit;
			}
			
			
			return sum;
		}
	
}	
	*/
		
		//ex5.1
	/*	for(int i=1; i<=100;i++) {
			
			System.out.print(getPentagonalNumber(i)+"\t");
			if(i % 10 ==0)
				System.out.println("");
		}
		
	}
	public static int getPentagonalNumber(int n) {
		n= n * (3 * n - 1) / 2;
		return n;
	}

		*/	
			
				
		
		
		
		
		
		
		
		
		/*// ex 4.17	////////git slution
			int p=0;
		int startRight = 0,	// Initialize decending numbers
				 endSpace = 7;		// Initialize number of white space in row
			// Display number of rows and numbers in each row
			for (int row = 1; row <= 128; row += row) {
				// Display white space
				for (int startSpace = 0; startSpace < endSpace; startSpace++) {
					System.out.print("    ");
				}
				// Display acending numbers
				for (int l = 1; l <= row; l += l) {
					System.out.printf("%4d", (l));
					p=l;
				}
				// Display decending numbers
				//for (int r = startRight; r > 0 ; r /= 2 ) {
				//	System.out.printf("%4d", (r));	
				//}
				while(p>1) {
					p=p / 2;
					System.out.printf("%4d", (p));	
					
				}
				System.out.println();	// End line
				endSpace--; 				// Decrement endSpace
				//startRight = row;			// Assign row to startRight
			}
///////////////////////my solution///////////////////////////////	
		int p=1;
		int numOfLines = 8;
		int lastI =1;
		
		for(int j=1;j<=numOfLines;j++) {
		
			for(int x=numOfLines-j;x>0;x-- )
				System.out.print("    ");
				
			System.out.printf("%4d",1);
			
			for(int i=2 ;i<=j;i++) {
				p=p*2;
				System.out.printf("%4d",p);			
			}
			
			for(int y=1 ;y<j;y++) {
				p=p/2;
				System.out.printf("%4d",p);				
			}
			
			p=1;
			System.out.println("");
		}
		
*/
		/*//ex4.19
		System.out.println(" enter number of lines");
		int numOfLines = input.nextInt();
		
		for(int j=1;j<=numOfLines;j++) {
			for(int x=numOfLines-j;x>0;x-- )
				System.out.print("   ");
		
			for(int i=j ;i>0;i--) {
				System.out.printf("%3d",i);
				
			}
			for(int y=2 ;y<=j;y++) {
				System.out.printf("%3d",y);
				
			}
			
			
		
			System.out.println("");
		}*/
		//********************************************************	
		//ex4.18
		/*	//pattern 3
		 * 
		for(int j=1;j<=6;j++) {
			for(int x=6-j;x>0;x-- )
				System.out.print(" ");
		
			for(int i=j ;i>0;i--) {
				System.out.print(i);
				
			}
			
			System.out.println("");
		}
		*/
		//pattern 1
		/*for(int j=1;j<=6;j++) {
			for(int i = 1 ;i<=j;i++) {
				System.out.print(i);
			}
			System.out.println("");
		}*/
		 //patern 2
		/*for(int j=6;j>=1;j--) {
			for(int i = 1 ;i<=j;i++) {
				System.out.print(i);
			}
			System.out.println("");
		}*/
		
		/*pattern 4
		 * String str =" ";
		for(int j=6;j>=1;j--) {
			for(int i = 1 ;i<=j;i++) {
				System.out.print(i);
			}
			System.out.println("");
			System.out.print(str);
			str+=" ";
		}*/
		
		//*********************************************
		//ex4.7
		/*double sum =0;
		double tuition = 100;
		for(int i=1;i<=10;i++) {
			tuition = tuition * 1.1;
			System.out.println(" tuition for "+i+" = "+tuition);

		}
		for(int i =1;i<=4;i++) {
			tuition = tuition * 1.05;
			sum+=tuition;
			System.out.println("sum "+i +" "+sum);
		}
		
		System.out.println("total in 4 years is"+sum);
		*/
		/*//ex 4.45
		int count=0;
		for( int i =1;i<=7;i++) {
			for(int j=i+1;j<=7 ;j++) {
				//if(i==j)
				//	continue;
				count++;
				System.out.println(i+" "+j);
				
			}
		}
		System.out.println(count);*/
	/*ex4.44   book solution is depend on math background
	 *  not programming
	 * 	double x;
		double y;
		int odd=0;
		for(int i=0;i<100;i++) {
			x=-1+Math.random()*2.0;
		    y=-1+Math.random()*2.0;
		    
		    if(x > 0 && y>0) {
		    	//check in 2 or 3
		    	if(Math.sqrt(x *x +y * y) < Math.sqrt(2)) {
		    		System.out.printf("%2.2f %2.2f region 3\n\n",x,y);
		    		odd++;}
		    }
		    else if(x < 0) {
		    	odd++;     
	    		System.out.printf("%2.2f %2.2f region 1\n\n",x,y);

		    }
		    
		}*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*//ex4.43
		System.out.println("enter seconds");
		long totalSeconds =input.nextLong();
		
		long currentSecond = System.currentTimeMillis() / 1000  ;
		long temp =currentSecond;
		while(totalSeconds >0) { //count to zero
			currentSecond = System.currentTimeMillis() / 1000;
			if(temp+1==currentSecond  ) {
				temp =currentSecond;
				totalSeconds--;
				System.out.println(totalSeconds);				
			}
		
			
				
			

		}
		*/
		/*//5.41
		int max=0,number=0,occurances=0;
		System.out.println("enter numbers ");
		do {
			
			number =input.nextInt();
			if(number > max) {
				max =number;
				occurances=1;
			}
			
			else if(number ==max)
				occurances++;
		}
		while(number !=0);
		System.out.println("max is "+max+" occuuranse is "+occurances);
		*/
		
		
		
		
		
		
		
///----------------------------------------------------------------------------------------------------------
		/*//ex4.39    ////////////my solution better than book solution 4.42
		// i can reverse programe and calculate  saes from commesion by
		
		// amount =  (target - (endRange1 +endRange2)) *perst3+(endRange1 *perst1)+(endRange2*perst2) ;
		 //amount = (target- endRange1) /perst2 +endRange1* perst1;
		// amount = target *perst1;		
         
		final double perst1 =.08,perst2=.1,perst3=.12;
		final double  endRange1=5000,endRange2=10000;			
		final int  target=100;
		double amount=0;
		double i ;
		amount =endRange1 * perst1 ;

		if(target <= amount) {         
			amount =0;
			amount = target /perst1;
			System.out.println(amount);
			System.exit(0);
		}	
		// range 2
		amount+=endRange2 * perst2 ;

		 if(target <= amount) {         
			amount=Math.abs(amount -endRange2 * perst2);
			amount = (target- amount) /perst2 +endRange1;
			
			System.out.println(amount);
			System.exit(0);
		}
		//  range 3
		amount =  (target- amount) /perst3+endRange1+endRange2 ;	
		System.out.println(amount);
		
		
		*
		*                           ======
		*
		*
		* **********************ihis bad code*****************
		*
		*final double perst1 =.08,perst2=.1,perst3=.12;
		final double  endRange1=5000,endRange2=10000;			
		final int  target=30000;
		double amount=0;
		double i ;
		amount =endRange1 * perst1 ;
		if(amount == target) {
			System.out.print(endRange1);
			System.exit(0);
		}
		else if(target < amount) {
			amount =0;
			for( i = .01 ;(int)amount <target;i++) {
				amount+=i*perst1;		
			}
			System.out.println(amount);
			System.exit(0);
		}
		
		// range 2
		amount+=endRange2 * perst2 ;

		if(amount == target) {
			System.out.print(endRange2);
			System.exit(0);
		}
		else if(target < amount) {
			amount=Math.abs(amount -endRange2 * perst2);
			for( i = .01+endRange1 ; (int)amount <target;i++) {
				amount+=i*perst2;
				
			}
			System.out.println(amount+" "+i);
			System.exit(0);
		}
		//  range 3

		for( i = .01+endRange2 ;(int)amount<target ;i++) {
			amount+=i*perst3;
			
		}
		System.out.println(amount+" "+i);
		*
		*
		*/
       
//---------------------------------------------------------------------------------------------
		
		
		
		/*
		//ex4.38 book is better
		System.out.println("enter dec ");
		int number =input.nextInt();
		
		String r ="";
		String rString="";
		int reminder =0;
		while(number> 0)
		{
			reminder =number % 16 ;
			
			if(reminder >=10) {
			switch (reminder) {
			case 10:rString ="A";break;
			case 11:rString ="B";break;	
			case 12:rString ="C";break;	
			case 13:rString ="D";break;	
			case 14:rString ="E";break;	
			case 15:rString ="F";break;	

			}
			}
			else
				rString +=reminder;
			
			r=rString +r;
			number /= 16;
			rString="";
		}
		
		System.out.println(r);
		*/
		/*ex 4.37
		int reminder =0;
		System.out.println("enter number ");
		int number =input.nextInt();
		String r="";
		while(number  >0) {
			
				reminder = number % 2;
				r = reminder +r; 
				number/=2;
		}
		System.out.println(r);*/
		
		
/*
		System.out.println("enter 9 isbns");
		int digits = input.nextInt();
		int d1 = digits  / 100000000;
		int d2 = (digits / 10000000) % 10;
		int d3 = (digits / 1000000) % 10;
		int d4 = (digits / 100000) % 10;
		int d5 = (digits / 10000) % 10;
		int d6 = (digits / 1000) % 10;
		int d7 = (digits / 100) % 10;
		int d8 = (digits / 10) % 10;
		int d9 = digits % 10;

		int checksum = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;
		
*/	
		/*ex4.36 bokk is better
		 System.out.println("enter 9 isbns");
		int digits = input.nextInt();
		int checksum=0,dig =0;
		int var = 10000000;
	    dig = digits / 100000000;
	    int i =0;
		checksum=dig;
		for( i =2 ; i<=8 ;i++) {					
			dig=(digits / var) %10;
			checksum+=dig * i;	
			
			var /=10;		
		}
		 dig = digits % 10;
		 checksum=(checksum+dig * i) % 11 ;
		 System.out.print("isbn 10 number is "+digits);

		if (checksum == 10)
			System.out.print("x");

		else
			System.out.print(checksum);
//////////////////////////////////////////////////////////////////////////
////////////////////anoter solution///////////////////////////////////				 
		System.out.print("Enter the first 9-digit of an ISBN number as integer: ");
		int number = input.nextInt();
		int t = number;
		int i = 9;
		int sum = 0;

	
		while (t != 0) {
			sum += (t % 10) * i;
			i--;
			t = t / 10;
		}

		int checksum = sum % 11;

		System.out.print("The ISBN number is ");

		 Display leading zeros
		int temp = 100000000;
		while (number / temp == 0) {
			System.out.print("0");
			temp = temp / 10;
		}

		System.out.print(number);

		if (checksum == 10)
			System.out.print("X");
		else
			System.out.print(checksum);
			
		
		
		*/
		
		
		
		
		
		
		
		/* scissor can cut a paper,
		 *  rock can knock a scissor,
		 *  paper can  wrap a rock 
		 * */
		/*ex4.34
		 * int countCom=0,countUser=0;
		 
		
		 while (countCom <=2   && countUser<=2 ) {
		      // Generate scissor, rock, paper
		      int computerNumber = (int)(Math.random() * 3);

		      // Prompt the user to enter scissor, rock, or paper
		      System.out.print("scissor (0), rock (1), paper (2): ");
		      int userNumber = input.nextInt();

		      // Check the guess
		      switch (computerNumber) {
		      case 0:
		        if (userNumber == 0) {
		          System.out.println("It is a draw");
		        }
		        else if (userNumber == 1) {
		          System.out.println("You won");
		          countUser++;
		        }
		        else if (userNumber == 2) {
		          System.out.println("You lost");
		          countCom++;
		        }
		        break;
		      case 1:
		        if (userNumber == 0) {
		          System.out.println("You lost");
		          countCom++;
		        }
		        else if (userNumber == 1) {
		          System.out.println("It is a draw");
		        }
		        else if (userNumber == 2) {
		          System.out.println("You won");
		          countUser++;
		        }
		        break;
		      case 2:
		        if (userNumber == 0) {
		          System.out.println("You won");
		          countUser++;
		        }
		        else if (userNumber == 1) {
		          System.out.println("You lost");
		          countCom++;
		        }
		        else if (userNumber == 2) {
		          System.out.println("It is a draw");
		        }
		        break;
		      }
		    }

		    if (countUser > 2) {
		      System.out.println("You won more than two times");
		    }
		    else {
		      System.out.println("The computer won more than two times");
		    }
		
		*/
		
		/*ex4.35
		double sum =0;
		for(int i=1 ; i<=624;i++) {
			sum=sum + 1 / (i+ Math.sqrt(i+1));
			System.out.println("   " + i +"\n"+"------"+"\n"+i +"+"+"^"+(i+1));
		}
		System.out.println("sum is "+sum);
		
		*/
		
		
		
		
		
		
		
		
		/*//ex4.33
		System.out.println("asd");
		for(int j=2 ; j<10000;j++) {
			
			int sum =0;
			for(int i= 1 ; i<j;i++) {
				if(j % i == 0)
					sum+=i;
			}
			if(sum ==j)
				System.out.println(j +" is perfect");
		}*/
		
		
		
		
		
		
		
		
		
		
		
		/*//ex4.32
		int lotteryDigit1 =(int)( Math.random() * 10 );
		int lotteryDigit2;
		do {
			lotteryDigit2 = (int)(Math.random() * 10 );
		}
		while(lotteryDigit1 == lotteryDigit2);
		// Prompt the user to enter a guess
		System.out.print("Enter your lottery pick (two digits): ");
		int guess = input.nextInt();

		// Get digits from lottery
		

		// Get digits from guess
		int guessDigit1 = guess / 10;
		int guessDigit2 = guess % 10;

		System.out.println("The lottery number is " + lotteryDigit1+lotteryDigit2);

		 
		if ((lotteryDigit1 == guessDigit1 )&& (lotteryDigit2 == guessDigit2))
			System.out.println("Exact match: you win $10,000");
		else if (guessDigit2 == lotteryDigit1 && guessDigit1 == lotteryDigit2)
			System.out.println("Match all digits: you win $3,000");
		else if (guessDigit1 == lotteryDigit1 || guessDigit1 == lotteryDigit2 || guessDigit2 == lotteryDigit1
				|| guessDigit2 == lotteryDigit2)
			System.out.println("Match one digit: you win $1,000");
		else
			System.out.println("Sorry, no match");
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		//ex4.30
		System.out.println("amount \n   annual interest rate\n months");
		double amount =input.nextDouble();
		double annualInterest = input.nextDouble();
		int numberOfMonthes=input.nextInt();
		double totalAmount=0;
		
		double monthInterestRate = annualInterest / 1200 + 1 ;
		for(int i = 1 ;i<=numberOfMonthes;i++ ) {
			
			totalAmount = (totalAmount + amount) * monthInterestRate;
			System.out.println(" amount is"+totalAmount+"for "+i+"month");
		}
		
		*/
		
		/*4.31
		System.out.println("amount \n "
				+ "  annual persantage  yield \n "
				+ "months");
		double amount =input.nextDouble();
		double annualInterest = input.nextDouble();
		int numberOfMonthes=input.nextInt();
		
		double monthInterestRate = annualInterest / 1200  ;
		for(int i = 1 ;i<=numberOfMonthes;i++ ) {
			
			amount = amount +( amount * monthInterestRate );
			System.out.printf(" amount is %1.2f "+" for "+i+"month",amount);
			System.out.println("");
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		///////////////////////////////////////////////////////////////
		/*//ex4.29   
		System.out.print("Enter a year: ");
		int year = input.nextInt();

		System.out.print("Enter the first day of the year: ");
		int firstDay = input.nextInt();

		int numberOfDaysInMonth = 0;

		// Display calendar for each month
		for (int month = 1; month <= 12; month++) {
			// Display Calendar title
			switch (month) {
			case 1:
				System.out.println("\n\t\t January 1, " + year + " is ");
				numberOfDaysInMonth = 31;
				break;
			case 2:
				System.out.println("\n\t\t February 1, " + year + " is ");
				if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
					numberOfDaysInMonth = 29;
				else
					numberOfDaysInMonth = 28;
				break;
			case 3:
				System.out.println("\n\t\t March 1, " + year + " is ");
				numberOfDaysInMonth = 31;
				break;
			case 4:
				System.out.println("\n\t\t April 1, " + year + " is ");
				numberOfDaysInMonth = 30;
				break;
			case 5:
				System.out.println("\n\t\t May 1, " + year + " is ");
				numberOfDaysInMonth = 31;
				break;
			case 6:
				System.out.println("\n\t\t June 1, " + year + " is ");
				numberOfDaysInMonth = 30;
				break;
			case 7:
				System.out.println("\n\t\t July 1, " + year + " is ");
				numberOfDaysInMonth = 31;
				break;
			case 8:
				System.out.println("\n\t\t August 1, " + year + " is ");
				numberOfDaysInMonth = 31;
				break;
			case 9:
				System.out.println("\n\t\tSeptember 1, " + year + " is ");
				numberOfDaysInMonth = 30;
				break;
			case 10:
				System.out.println("\n\t\t October 1, " + year + " is ");
				numberOfDaysInMonth = 31;
				break;
			case 11:
				System.out.println("\n\t\t November 1, " + year + " is ");
				numberOfDaysInMonth = 30;
				break;
			case 12:
				System.out.println("\n\t\t December 1, " + year + " is ");
				numberOfDaysInMonth = 31;
				break;
			}

			System.out.println("__________________________________________________");
			System.out.println(" sun\tmon\ttue\twd\tthu\tfri\tsat\t");
			
			for(int x = 0;x<firstDay;x++){
					System.out.print("\t");			
				}
			int count = firstDay;
			for (int i = 1; i <= numberOfDaysInMonth; i++) {
				//

				//
				System.out.printf("%3d\t", i);
				count++;
				if (count % 7 == 0) {
					System.out.println("");

				}

			}
			firstDay = (firstDay + numberOfDaysInMonth) % 7;

		}*/
				    
				      
				      
					
			////////////////////////////////////////////////////////////////////////////		
	
		
		
		
		
		/*ex4.28 another solution me better
		 * 
		 * // Prompt the user to enter the year and first day of the year
		System.out.print("Enter year: (e.g., 2012): ");
		int year = input.nextInt();	// Holds the year
		System.out.print("Enter first day of the year: ");
		int day = input.nextInt();		// Holds the day

		String output; 		// Holds string output
		for (int month = 1; month <= 12; month++) {
			output = "";		// Clear string output
			switch (month) {	// Concat Month to output
				case 1: output += "January "; break;
				case 2: output += "February "; break;
				case 3: output += "March "; break;
				case 4: output += "April "; break;
				case 5: output += "May "; break;
				case 6: output += "June "; break;
				case 7: output += "July "; break;
				case 8: output += "August "; break;
				case 9: output += "September "; break;
				case 10: output += "October "; break;
				case 11: output += "November "; break;
				case 12: output += "December "; break;
			}	
			// Concat string
			output += "1, " + year + " is ";

			// Compute the day of the month
			day %= 7;
			// Display the output and the first day of the month
			switch (day) {
				case 0: System.out.println(output + "Sunday"); break;
				case 1: System.out.println(output + "Monday"); break;
				case 2: System.out.println(output + "Tuesday"); break;
				case 3: System.out.println(output + "Wednesday"); break;
				case 4: System.out.println(output + "Thursday"); break;
				case 5: System.out.println(output + "Friday"); break;
				case 6: System.out.println(output + "Saturday"); break;				
			}

			// Add days of present month
			if ( month == 1 || month == 3  || month == 5 || month == 7 ||
				  month == 8 || month == 10 ||month == 12)
				day += 31;
			else if (month == 4 || month == 6 || month == 9 || month == 11)
				day += 30;
			else {
				if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
					day += 29;
				else
					day += 28;
			}
		}
//***************************************************************
		 */
		
		/*ex4.28   this solution is best 
		System.out.println("enter year");
		// System.out.println("enter day of month 1-31");
		
		
		int year = input.nextInt();
		int month = 1; // m
		int day = 1; // q

		int q = day;
		int i = 1;
		int realYear = year;
		while (i <= 12) {
			month = i;
			if (month == 1 || month == 2) {
				month += 12;
				if (month == 13)
					year--;
			} else
				year = realYear;
			int m = month;
			int j = year / 100; // century
			int k = year % 100; // year of century

			int h = (q + 26 * (m + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
			String dayName = "";
			switch (h) {
			case 0:
				dayName = "saturday";
				break;
			case 1:
				dayName = "sunday  ";
				break;
			case 2:
				dayName = "monday  ";
				break;
			case 3:
				dayName = "tuesday";
				break;
			case 4:
				dayName = "wensday";
				break;
			case 5:
				dayName = "thursday";
				break;
			case 6:
				dayName = "friday";
				break;

			default:
				System.out.println("error");
				System.exit(0);
			}
			String monthName = "";
			switch (m) {
			case 3:
				monthName = "march";
				break;
			case 4:
				monthName = "april";
				break;
			case 5:
				monthName = "may";
				break;
			case 6:
				monthName = "june";
				break;
			case 7:
				monthName = "july";
				break;
			case 8:
				monthName = "august";
				break;
			case 9:
				monthName = "septemper";
				break;
			case 10:
				monthName = "october";
				break;
			case 11:
				monthName = "november";
				break;
			case 12:
				monthName = "december";
				break;
			case 13:
				monthName = "january";
				break;
			case 14:
				monthName = "february";
				break;

			default:
				break;
			}

			System.out.printf("%-10s" + " " + "%-3d" + ", " + realYear + " is " + dayName, monthName, i);
			i++;
			System.out.println("");
		}
		
		
		*/
		
		
		
		
		
		
		/*ex4.27
		 * 
		 * 
		int count =0;
		for (int year = 2001; year <= 2100; year++) {
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				System.out.print(year+" ");
				count++;
				if (count % 10 == 0)
					System.out.println("");
			}
		}
		*/
		
		
		
		
		
		
		
		
		/*//ex4.26//note2                  original
		double fact = 1,number = 1,i = 10000,e = 1;
		
		
		while (i <= 100000) {
			for (double j = 1 ; j<=i ; j++) {
				number = j;

				while (number >= 1) {
					fact *= number;
					number--;
				}
				e+=1 / fact ;
				fact =1;
			}
			
			System.out.println("e for i = " + i + " is " + e);
			e = 1;
			i += 10000;
		}
		////////another solution    optimized
		double fact = 1,number = 1,i = 1,e = 1;
		
		while (i <= 100000) {

			number = i;

			while (number >= 1) {
				fact *= number;
				number--;
			}
			e += 1 / fact;
			fact =1.0 ;
			if (i == 10000 || i == 20000 || i == 30000 || i == 40000 || i == 50000 || i == 60000 || i == 70000
					|| i == 80000 || i == 90000 || i == 100000)
				System.out.println("e for i = " + i + " is " + e);
			i++;
		}
		////another solution   the best
		double e = 1;
	    double item = 1;

	    for (int i = 1; i <= 100000; i++) {
	      item = item / i;
	      e += item;

	      if (i == 10000 || i == 20000 || i == 30000 || i == 40000 ||
	          i == 50000 || i == 60000 || i == 70000 || i == 80000 ||
	          i == 90000 || i == 100000)
	      System.out.println("The e is " + e + " for i = " + i);
	    }
	    */
		
		
		
		
		
		
		
		
		
		
		
		/*4.25
		double sum =0 ,finalSum=0;
		double j =10000; 
		while(j<=100000) {
		 for(double i = 1 ; i<= j ;i++) {
			  //eqation
		    sum+=Math.pow(-1, i+1) / (2 * i -1);
		 }
			
		 finalSum = 4 * sum;
		 sum=0;
		 System.out.println("pi for i="+ j + " is "+finalSum );
		 j+=10000;
		}*/
		
		
		
		
		
		
		
		
		/*ex4.24
		int count=0;
		double sum  = 0;
		//ex2.24
		for(double i =1 ; i<=97 ; i+=2 ) {
			sum +=i / (i + 2);
			count++;
			System.out.println(count + "   "+i +"/"+ (i + 2));
		}
		System.out.printf("sum is %f",sum);
		
		
		*/
		
		
		
		
		
		
		
		/*ex4.23
		double sumRight =0,sumLeft=0 ;
		for(double i = 1 ,j=5000 ; i <= 5000 ;i++,j--) {
			
			sumLeft+=1 / i ;
			sumRight+=1 / j ;
			
			
		}
		
		System.out.println("sum form left "+ sumLeft);
		System.out.println("        right "+ sumRight);
		*/
		
		
		
		
		/*//ex2.21
		 // Enter loan amount
	    System.out.print(
	      "Enter loan amount ");
	    double loanAmount = input.nextDouble();

	    // Enter number of years
	    System.out.print(
	      "Enter number of years ");
	    int numOfYears = input.nextInt();
	    
	    int count =0;
	    for(double annualInterestRate = 5.0 ; annualInterestRate <= 8.0;annualInterestRate=annualInterestRate+(1/8.0) ) {
	    	count++;
	    //double annualInterestRate = 5.0;
	    // Obtain monthly interest rate
	    double monthlyInterestRate = annualInterestRate/1200;

	    // Compute  monthly payment
	    double monthlyPayment = loanAmount*monthlyInterestRate /
	      (1 - (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
	    double totalPayment = monthlyPayment * 12 * numOfYears ;

	    System.out.printf(count+" | %1.3f\t\t%1.2f\t\t%1.2f\n",annualInterestRate,monthlyPayment,totalPayment);
	    }
	    
	    */
	   
	    
		
		
		/*//ex 4.20 //note1
		int count=0;
		int last = 1000;
		boolean isprime = true;
		for(int i = 2  ; i <= last ;i++) {
			isprime = true;
			for(int j = 2 ; j <= i /2   ; j++) {
				if( i % j ==0) {
					isprime = false;
					break;
				}
								
			}
			 if(isprime) 
			{
				System.out.printf("%-5d",i);
				count++;
				if(count % 10 == 0)
					System.out.println("");
			}
		}
		System.out.println("\ncount is "+ count);
		
		*/
		/*my notes 
		 * 
		 * 1-you may test all possible cases exept one and it could give you error so testing is very important  
		 * 2-attention for potimization start from last not from begining
		 * 3-optimization made by mathmatics day of week and primenumbers
		 * 4-learn how to profile  programes to  measure performance 
		 * 5-importance of metdos + arrays  + loops vip code tax listing 3.10 ex7.12 EX7.12
		 * 6-implortance of knowing imlemntation of datastruchre and alogartims 
		 * 7-you may take 1day to impement task that are high optimized
		 * 	 insted of 1 houre thinh that just work 
		 * now who better who made 4 featuesr that are slow consume ram
		 *            or made 1 that are high optimized?
		 * 
		 * 
		 * my codetips
		 * 1-you can pass refrence of 2d array to 1 d array
		 * 						int m[] = mat[0]
		 * 						mat[2]  = m 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
				/*ex4.16/5.16
				 *System.out.print(
			      "Enter a positive integer: ");
			    int number = inpute.nextInt();

			    // Find all the smallest factors of the integer
			    System.out.println("The factors for " + number + " is");
			    int factor = 2;
			    while (factor <= number) {
			      if (number % factor == 0) {
			        number = number / factor;
			        System.out.println(factor);
			      }
			      else {
			        factor++;
			      }
			    }
		
		
		//
		System.out.println("enter number");
		int number =inpute.nextInt();
		
		int i = 0 ;
		int tem =number;
		for( i = 2 ; i<= number ;  ) {
			if(i==tem) {
				System.out.println(number +"   its prime number ");
				break;
			}
				
			else if( number % i == 0 ) {
				System.out.println(i);
				number/=i;
				
			}
			else
				i++;
				
			
		}
		
			*/
		
			
		
		
		
		
		
		/*char stop = '~';
		int counte=1;
		for(char start = '!' ;start<=stop;start++) {
			System.out.print(start+" ");
			counte++;
			if(counte == 11) {
				System.out.println("");
				counte=1;}
		}*/
		
		
		
		
		
		
		
		
		/*ex4.14/5.15
		int number1=0,number2=0,d = 0 ,gcd =1;
		
		System.out.println("enter n1 n2");
		number1 = inpute.nextInt();
		number2 = inpute.nextInt();
		if(number1 > number2)
			d=number2;
		else
			d=number1;
		
		for(;d>=1;d--) {
			if (number1 % d ==0 && number2 % d ==0) {
				
				break;
			}
			System.out.printf("%d is greatest divesor",d);
		}
		
		*/
		
		
		
		/*ex4.10/5.10
		    int a =(int)Math.sqrt(12000) + 1;
		   
		    
		    System.out.println("This number is " + i);
		    System.out.println(a);
		*/
		
		/*ex4.9/5.9
		String studentNameMax = "" ,studentNameMin =" ";
		
		String StudentName = "";
		int numberOfStudents=0;
		double StudentScore = 0;
		double StudentScoreMax=0 ,StudentScoreMin=0;
		int i =0 ;
		System.out.println("enter number of students ");
		numberOfStudents=inpute.nextInt();

		do {
			System.out.println(" students name  and score ");
			StudentName = inpute.next();
			StudentScore = inpute.nextDouble();
			
			//find two hightst scores
			
			
			
			
			 if (StudentScore >= StudentScoreMax) {
				//swap max to min
				studentNameMin =studentNameMax; 
				StudentScoreMin=StudentScoreMax;
				//
				studentNameMax = StudentName;
				StudentScoreMax = StudentScore;
				
			}
			else if(StudentScore >=StudentScoreMin) {
				studentNameMin =StudentName;
				StudentScoreMin =StudentScore;
				
			}
			
			
			
			i++;
			
		} while (i< numberOfStudents);
		System.out.printf("%s  with score %2.1f  is higtest %s with score %2.1f is seconsery",studentNameMax,StudentScoreMax,studentNameMin,StudentScoreMin);
		*/
		
		
		
		/* double tuition = 10000;   // Year 0
		    int year = 0;
		    while (tuition < 40000) {
		      tuition = tuition * 1.07;
		      year++;
		    }
		  
		    System.out.println("Tuition will be doubled in " 
		      + year + " years");
		    System.out.printf("Tuition will be $%.2f in %1d years",  
		      tuition, year);		
	 
		//////////////
		double tuition = 1000;
		double percentage=7;
		int years = 1;
		
		if(100 % percentage ==0)
			years--;
		years +=100 / (int)percentage ;
		
		double total =tuition * years * .07;
		
		System.out.println("tution will double in "+ years+" years ");
		System.out.println("tution will be "+total + " in " + years+" years ");
		*/
		/*
		 // Display the number title
	    System.out.print("      ");
	    for (int j = 1; j <= 100; j++)
	      System.out.printf("%-6d", j);
	    
	    System.out.println("");

	    //System.out.println("\n-----------------------------------------");

	    // Print table body
	    for (int i = 1; i <= 100; i++) {
	      System.out.printf("%-6d",i );
	      for (int j = 1; j <= 100; j++) {
	        // Display the product and align properly
	        System.out.printf("%-6d", i * j);
	      }
	      System.out.println();
	    }*/
		/*
		int correct=0;
		int i =0;
		int result=0;
		String str="";
		long startMsecond=System.currentTimeMillis();
		while(i <5)
		{
			
			
			i++;
		int number1 = (int)(Math.random()* 10 );
		int number2 = (int)(Math.random()* 10 );
		
		System.out.println("what is "+number1+" - "+number2);
		double answer =input.nextDouble();
		result = number1 - number2;
		if(result == answer)
		{
			System.out.println("you are correct");
			correct++;
			str +=number1 +" - "+number2+" correct\n";
		}
		
		else
		{
			System.out.println("your answer is wrong");
			System.out.println(number1 + " - " + number2 + "should be" + result);
			str +=number1 +" - "+number2+" wrong\n";

		}
		}
		long stopMsecond=System.currentTimeMillis();
		//
		long totalseconds = (stopMsecond -startMsecond) / 1000 ;
		
		System.out.println("correct count is "+correct);
		System.out.println("test time is "+totalseconds);
		System.out.println(str);
		
*/		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
		
		
		
		
		/* ex .34
		 System.out.print("Enter three points for p0, p1, and p2: ");
		    double x0 = input.nextDouble();
		    double y0 = input.nextDouble();
		    double x1 = input.nextDouble();
		    double y1 = input.nextDouble();
		    double x2 = input.nextDouble();
		    double y2 = input.nextDouble();

		    double status = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
		    
		    if (status == 0 && ((x0 <= x2 && x2 <= x1) || (x0 >= x2 && x2 >= x1))) {
		      System.out.println("(" + x2 + ", " + y2 + ") is on the line segment from"
		        + " (" + x0 + ", " + y0 + ") to " + "(" + x1 + ", " + y1 + ")");
		    }
		    else 
		      System.out.println("(" + x2 + ", " + y2 + ") is not on the line segment from"
		        + " (" + x0 + ", " + y0 + ") to " + "(" + x1 + ", " + y1 + ")"); 
		    */
		/*ex 3.28  edited by me                  
	    System.out.print("Enter r1’s center x-, y-coordinates, width, and height: ");
	    double x1 = input.nextDouble();
	    double y1 = input.nextDouble();
	    double w1 = input.nextDouble();
	    double h1 = input.nextDouble();

	    System.out.print("Enter r2’s center x-, y-coordinates, width, and height: ");
	    double x2 = input.nextDouble();
	    double y2 = input.nextDouble();
	    double w2 = input.nextDouble();
	    double h2 = input.nextDouble();
	    
	    double xDistance = Math.abs(x1 - x2);
	    double yDistance = Math.abs(y1 - y2);
	    
	    if (xDistance <=Math.abs (w1 - w2) / 2 && yDistance <= Math.abs(h1 - h2) / 2)
	    {
	    	if (w1 > w2) 
	    		System.out.println("rectangle 2  is in rectangle 1");
	    	else if(w2 > w1)
	    		System.out.println("rectangle 1  is in rectangle 2");
	    	else 
	    		System.out.println(" identical");
	    	
	    }
	      
	    else if (xDistance <=Math.abs (w1 + w2) / 2 && yDistance <=Math.abs (h1 + h2) / 2)
	      System.out.println("r2 overlaps r1");
	    else
	      System.out.println("r2 does not overlap r1");
	    */
		
		/*ex3.28
		 * System.out.println("enter r1 center  width height");
		 
		double r1Center_x=input.nextDouble();
		double r1Center_y=input.nextDouble();
		double r1width=input.nextDouble();
		double r1height=input.nextDouble();
		
		System.out.println("enter r2 center width height");
		double r2Center_x=input.nextDouble();
		double r2Center_y=input.nextDouble();
		double r2width=input.nextDouble();
		double r2height=input.nextDouble();
		
		
		//shift r1 and r2
		r2Center_x=r2Center_x - r1Center_x;
		r2Center_y=r2Center_y - r1Center_y;
		
		// calculate x,y   of r1
		double r1_X=r1width / 2 ;
		double r1_Y=r1height / 2 ;
	   /*
	    * x4_________ x1
		   |         |
		   |_________|
		  x3 		  x2	
		 *//*
		// claulate x1,y1 of r2
		double r2_X1 = Math.abs( r2Center_x + r2width / 2) ;
		double r2_Y1 = Math.abs( r2Center_y + r2height / 2);
		
		//          x2,y2
		double r2_X2 = Math.abs( r2Center_x + r2width / 2 );
		double r2_Y2 = Math.abs( r2Center_y - r2height / 2);
		
		//          x3,y3
		double r2_X3 = Math.abs( r2Center_x - r2width / 2 );
		double r2_Y3=  Math.abs( r2Center_y - r2height / 2 );
		
		//          x4,y4
		
		double r2_X4 = Math.abs( r2Center_x - r2width / 2 );
		double r2_Y4 = Math.abs( r2Center_y + r2height / 2);
		
		
		boolean a=false , b=false,c=false,d=false;
		if((r2_X1 == r1_X && r2_Y1 == r1_Y) && (r2_X3 == r1_X && r2_Y3 == r1_Y)) {
			System.out.println("identicale");
			System.exit(0);}
			
		if((a=(r2_X1 <= r1_X && r2_Y1 <= r1_Y)) && (b=(r2_X3 <= r1_X && r2_Y3 <= r1_Y)))
		
		{	System.out.println("r2 is in r1");
	     	System.exit(0);
		}
		
		if((c=(r2_X1 >= r1_X && r2_Y1 >= r1_Y)) && (d=(r2_X3 >= r1_X && r2_Y3 >= r1_Y)))
		{	
			System.out.println("r1 is in r2");
	     	System.exit(0);

		}
		// ther better solution in blog for this
		else if(a || b || c || d) {
			System.out.println("r2 is overlap r1");
		}
		
		else if( (r2_X2 <= r1_X &&  r2_Y2 <= r1_Y ) || ( r2_X4 <= r1_X && r2_Y4 <= r1_Y ) )
			System.out.println("r2 is overlap r1");
		
		else
			System.out.println("r2 dont overlap r1 ");*/
		
		
//-----------------------*****************-------------------*************--------------*******-------------************------//		

		
		
		
		
		
		
		
		/*ex3.29      blog better
		System.out.println("Enter circle1's center x-, y-coordinates, and radius:");
		double x1 =input.nextDouble();
		double y1 =input.nextDouble();
		double raduis1 =input.nextDouble();
		System.out.println("Enter circle1's center x-, y-coordinates, and radius:");
		System.out.println("");
		double x2 =input.nextDouble();
		double y2 =input.nextDouble();
		double raduis2 =input.nextDouble();
		
		String tem ="";
		//get distance between two centers
		
		double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		if(raduis1== raduis2 && x1 == x2 && y1 == y2)
			System.out.println("two circules are identicals");
		else
		{
		if(raduis2 > raduis1) 
			tem="cicle 1  inside circle 2 ";
	    else
			tem="cicle 2  inside circle 1 ";

		if(distance <= Math.abs(raduis1 - raduis2))
			System.out.println(tem);
		else if((distance <= raduis1 + raduis2)) 
			System.out.println("overlaps");
		else
			System.out.println("circle2 does not overlap circle");
		}*/
		
		/*ex 3.33
		System.out.println("Enter weight and price for package 1:");
		double weightItem1=input.nextDouble();
		double priceItem1=input.nextDouble();
		
		
		System.out.println("Enter weight and price for package 2:");
		double weightItem2=input.nextDouble();
		double priceItem2=input.nextDouble();
		
		
		double cost1=priceItem1 / weightItem1 ;
		double cost2=priceItem2 / weightItem2 ;
		
		if(cost1 < cost2)
			System.out.println("package 1 has better cost");
		else if(cost2 < cost1)
			System.out.println("package 2 has better cost");
		else 
			System.out.println(" two are identical");
		*/
		
		
		
		
		
		/*ex3.32
		System.out.println("Enter three points for p0, p1, and p2:");
		double x0=input.nextDouble();
		double y0=input.nextDouble();
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		String tem="";
		double result =(x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0);
		
		if (result == 0) 
			tem="  p2  is on the same line ";
		else if (result < 0) 
			tem="  p2 is on the right side of the line ";			
		else 
			tem="  p2 is on the left side of the line " ;
			
		System.out.println("("+x2 +","+y2+")" + tem + "("+x0 +","+y0+")" +" to "+"("+x1 +","+y1+")");
		*/

		
			
			/*ex3.31
			double amount =0,result=0;
			System.out.println("Enter the exchange rate from dollars to RMB");
			double dolarToRMB = input.nextDouble();
			System.out.println("Enter 0 to convert dollars to RMB and 1 vice versa");
			int decition = input.nextInt();
			
			if (decition!=0 && decition!=1) {
				System.out.println("wrong value");
				System.exit(0);			
			}
			
			else if(decition==1) {
				System.out.println("enter amount of rmb ");
			     amount = input.nextDouble();
			     result=amount / dolarToRMB ;
			    System.out.println("rmb "+ amount +" is " + result+" dollars ");
			}
			else {
				System.out.println("enter amount of dollars ");
			    amount = input.nextDouble();
			    result=amount * dolarToRMB ;
			    System.out.println("$"+ amount +" is " + result+" yuan ");

			}
			*/
			
			/*ex3.30
		    System.out.print("Enter the time zone offset to GMT: ");
		    long timeZoneOffset = input.nextInt();
		    
		    // Obtain the total milliseconds since the midnight, Jan 1, 1970
		    long totalMilliseconds = System.currentTimeMillis();

		    // Obtain the total seconds since the midnight, Jan 1, 1970
		    long totalSeconds = totalMilliseconds / 1000;

		    // Compute the current second in the minute in the hour
		    long currentSecond = totalSeconds % 60;

		    // Obtain the total minutes
		    long totalMinutes = totalSeconds / 60;

		    // Compute the current minute in the hour
		    long currentMinute = totalMinutes % 60;

		    // Obtain the total hours
		    long totalHours = totalMinutes / 60;

		    // Compute the current hour
		    long currentHour = (totalHours + timeZoneOffset) % 24;

		    // Display results
		    System.out.print("Current time is " +currentHour+":"+(currentHour % 12) + ":"
		      + currentMinute + ":" + currentSecond);
		    
		    if (currentHour < 12)
		      System.out.println(" AM");
		    else
		      System.out.println(" PM");  */
		
		//--------***********--------------------*****************-------------------------********---------------------------------------//
				
		
		
		
		
		
		/*ex3027
		System.out.print("Enter a point's x- and y-coordinates:");
		  double x = input.nextDouble();
		  double y = input.nextDouble();
		  double y2 = -x / 2 + 100;
		  String s = " ";
		 
		  // Check if y and x is in range and under the line
		 if(( (y > 0) && (x > 0) && (x + 2*y < 200) )){
		   s = " ";
		  }
		  else
		  {
		    s = " not ";
		  }
		 
		  System.out.print("The point is" + s + "in the triangle");
			*/
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
	 * ex3.25
	 * 	  System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4:");

		System.out.println("enter x1 y1 x2 y2 x3 y3 x4 y4");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		double x4=input.nextDouble();
		double y4=input.nextDouble();
		
		//2 2 5 -1.0 4.0 2.0 -1.0 -2.0
		
		double a=y1 - y2;
		double b=-(x1 -x2) ;
		double c=y3 -y4 ;
		double d=-(x3 -x4) ;
		double e=a * x1 + ( b * y1);//-- >+
		double f=c * x3 + (d *y3); //-->+
		
		if (a * d - b * c == 0) {
			   System.out.println("The two lines are parallel.");
			   System.exit(0);}

		 double x = (e * d - b * f) / (a * d - b * c);
		 double y = (a * f - e * c) / (a * d - b * c);
		
		
		
				System.out.printf("point is %f %f",x,y );*/

		
		
		
		
		
		
		
		
		
	/*ex3.24 solution from book
	 * 	final int NUMBER_OF_CARDS = 52;
	    // Pick a card
	    int number = (int)(Math.random() * NUMBER_OF_CARDS);
	    System.out.print("The card you picked is ");
	    if (number % 13 == 0)
	      System.out.print("Ace of ");
	    else if (number % 13 == 10)
	      System.out.print("Jack of ");
	    else if (number % 13 == 11)
	      System.out.print("Queen of ");
	    else if (number % 13 == 12)
	      System.out.print("King of ");
	    else
	      System.out.print((number % 13) + " of ");

	    if (number / 13 == 0)
	      System.out.println("Clubs");
	    else if (number / 13 == 1)
	      System.out.println("Diamonds");
	    else if (number / 13 == 2)
	      System.out.println("Hearts");
	    else if (number / 13 == 3)
	      System.out.println("Spades");
	  
		*/
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*ex3.21
		System.out.println("enter year");
		System.out.println("enter month 1-12");
		System.out.println("enter day of month 1-31");
		
		
		int year =input.nextInt();
		int month=input.nextInt();     //m
		int day =input.nextInt();      //q
		
		int q=day;
		if(month==1 || month==2) {
			month+=12;
			year--;}
		
		int m=month;
		int j=year / 100; //century
		int k =year % 100; //year of century
		
		
		int h=(q + 26 * (m + 1) / 10 + k + k / 4 + j/4 +5 * j) % 7;
		String dayName ="";
		switch (h) {
		case 0: dayName ="saturday";break;						
		case 1:dayName ="sunday"  ; break;
		case 2:dayName ="monday"  ; break;
		case 3:dayName ="tuesday"  ; break;
		case 4:dayName ="wensday"  ; break;
		case 5:dayName ="thursday"  ; break;
		case 6:dayName ="friday"  ; break;
				
		default:
			System.out.println("error");
			System.exit(0);
		}
		
		System.out.println("day is "+ dayName );
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*ex3.15
	 * 	
	 // Generate a lottery
	  //int lottery = (int) (Math.random() * 1000);
		int lottery = 123;
	  // Prompt the user to enter a guess
	  System.out.print("Enter your lottery pick (three digits): ");
	  int guess = input.nextInt();
	 
	  // Get digits from lottery
	  int lotteryDigit1 = lottery / 100;
	  int lotteryDigit2 = (lottery % 100) / 10;
	  int lotteryDigit3 = lottery % 10;
	 
	  // Get digits from guess
	  int guessDigit1 = guess / 100;
	  int guessDigit2 = (guess % 100) / 10;
	  int guessDigit3 = guess % 10;
	 
	  System.out.println("The lottery number is " + lotteryDigit1
	    + lotteryDigit2 + lotteryDigit3);
	 
	  // Check the guess
	  if (guess == lottery)
	   System.out.println("Exact match: you win $10,000");
	  else if ((guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit1 && guessDigit3 == lotteryDigit3)
	    || (guessDigit1 == lotteryDigit2
	      && guessDigit2 == lotteryDigit3 && guessDigit3 == lotteryDigit1)
	    || (guessDigit1 == lotteryDigit3
	      && guessDigit2 == lotteryDigit1 && guessDigit3 == lotteryDigit2)
	    || (guessDigit1 == lotteryDigit3
	      && guessDigit2 == lotteryDigit2 && guessDigit3 == lotteryDigit1)
	    || (guessDigit1 == lotteryDigit1
	      && guessDigit2 == lotteryDigit3 && guessDigit3 == lotteryDigit2))
	   System.out.println("Match all digits: you win $3,000");
	  else if (guessDigit1 == lotteryDigit1 || guessDigit1 == lotteryDigit2
	    || guessDigit1 == lotteryDigit3 || guessDigit2 == lotteryDigit1
	    || guessDigit2 == lotteryDigit2 || guessDigit2 == lotteryDigit3
	    || guessDigit3 == lotteryDigit1 || guessDigit3 == lotteryDigit2
	    || guessDigit3 == lotteryDigit3)
	   System.out.println("Match one digit: you win $1,000");
	  else
	   System.out.println("Sorry, no match");
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*	ex3.9
		System.out.println("enter 9 isbns");
		int digits=input.nextInt();
		 int d1= digits  / 100000000 ;
		 int d2=(digits  / 10000000) % 10;
		 int d3=(digits  / 1000000 ) % 10;
		 int d4=(digits  / 100000 ) % 10;
		 int d5=(digits  / 10000 ) % 10;
		 int d6=(digits  / 1000 ) % 10;
		 int d7=(digits  / 100 ) % 10;
		 int d8=(digits  / 10 ) % 10;
		 int d9=digits % 10;






		 
		
		int checksum=(d1*1+d2*2+d3*3+d4*4+d5*5+d6*6+d7*7+d8*8+d9*9) % 11 ;
		  System.out.print("The ISBN-10 number is " + d1 + d2 + d3 + d4 + d5 + d6
				    + d7 + d8 + d9);

		
		if(checksum==10)
			System.out.print("x");
			
		else 
			System.out.print(checksum);

			*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		String sort="";
//		System.out.println("enter");
//		int numb1=inpute.nextInt();
//		int numb2=inpute.nextInt();
//		int numb3=inpute.nextInt();
//		
//		if((numb1 >= numb2) && (numb1 >= numb3) && (numb2 >= numb3))
//			System.out.printf("%d %d %d ",numb1,numb2,numb3);
//		else if((numb1 >= numb2) && (numb1 >= numb3) && (numb3 > numb2))
//			System.out.printf("%d %d %d ",numb1,numb3,numb2);
//		
//		else if((numb2 >= numb1) && (numb2 >= numb3) && (numb1 >= numb3))
//			System.out.printf("%d %d %d",numb2,numb1,numb3);
//		
//		else if((numb2 >= numb1) && (numb2 >= numb3) && (numb3 > numb1))
//			System.out.printf("%d %d %d",numb2,numb3,numb2);
//		
//		else if((numb3 >= numb1) && (numb3 >= numb2) && (numb2 >= numb1))
//			System.out.printf("%d %d %d",numb3,numb2,numb1);
//		
//		else if   ((numb3 >= numb1) && (numb3 >= numb2) && (numb1 > numb2))
//			System.out.printf("%d %d %d",numb3,numb1,numb2);
//		
		
//////////////////////////////		
		
		/*
		 * ex3.8 better sloution
		 System.out.print("Enter three integers:");
		  int number1 = input.nextInt();
		  int number2 = input.nextInt();
		  int number3 = input.nextInt();
		  int temp = 0;
		 
		  if (number1 > number2) {
		   temp = number1;
		   number1 = number2;
		   number2 = temp;
		  }
		 
		  if (number2 > number3) {
		   temp = number2;
		   number2 = number3;
		   number3 = temp;
		  }
		 
		  if (number1 > number2) {
		   temp = number1;
		   number1 = number2;
		   number2 = temp;
		  }
		 
		  System.out.println(number1);
		  System.out.println(number2);
		  System.out.println(number3);
		 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		/*ex 3.6
		 * System.out.println("entre weight ");
		System.out.println("enter feet");
		System.out.println("enter inches");
		double weight = inpute.nextDouble();
		double feet =inpute.nextDouble();
		double inches= inpute.nextDouble();
		
		double height = feet / 3.28084 + inches / 39.3701 ;
		weight = weight / 2.20462 ;
		
		double bmi = weight / (height *height) ;
		System.out.printf(" bmi = %5.2f " ,bmi);
		if (bmi <18.5) 
			System.out.println("under");
		else if(bmi < 25)
			System.out.println("normal");
		else if(bmi < 30)
			System.out.println("over");
		else {
			System.out.println("obese");
		}
		*/
				
		
		
		
		
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		
		
		
		
		
		/*ex3.5
		 * System.out.println("enter number of day");	
		System.out.println("enter nuber of days after this day ");
		int nub =inpute.nextInt();
		int ealpesdDays=inpute.nextInt();
		
		String dayString="" ;
		switch (nub % 7) {
		   case 1:dayString= "Monday";break;
		   case 2:dayString= "Tuesday";break;
		   case 3:dayString= "Wednesday";break;
		   case 4:dayString= "Thursday";break;
		   case 5:dayString= "Friday";break;
		   case 6:dayString= "Saturday";break;
		   case 0:dayString= "Sunday";break;
		default:
			break;
		}
		
		
		System.out.println("current day is "+ dayString);
		
		ealpesdDays = (ealpesdDays + nub ) %7 ;
		
		switch (ealpesdDays) {
		   case 1:dayString= "Monday";break;
		   case 2:dayString= "Tuesday";break;
		   case 3:dayString= "Wednesday";break;
		   case 4:dayString= "Thursday";break;
		   case 5:dayString= "Friday";break;
		   case 6:dayString= "Saturday";break;
		   case 0:dayString= "Sunday";break;
		default:
			break;
		}
	   
			
		System.out.println("current day is "+ dayString);
*/
		
		
		
		/*System.out.println("enter filing states");
		int status=inpute.nextInt();
		System.out.println("enter income ");
		double income=inpute.nextDouble();
		
		final double single_max_10 =8350, single_max_15 =33950,
				     single_max_25 =82250, single_max_28 =171550,
				     single_max_33 =372950 ;
		
		double tax = 0,temp;
		
		if(status==0) {
			
			if(income <= single_max_10)
				tax=income*.1;
			else if(income <=single_max_15)
			{
				tax= (income - single_max_10) * .15 +  single_max_10 *.1;
				
			}
			
			else if(income <=single_max_25)
			{
				tax= (income - single_max_15) *.25 + (single_max_15 - single_max_10)* .15 + single_max_10 * .1 ;
					
			}
			
			else if(income <=single_max_28)
			{
				tax=(income - single_max_25) *.28 +
					(single_max_25 - single_max_15) * .25 +
					(single_max_15 - single_max_10) * .15 + 
						              single_max_10 * .1 ;

			}
			
			else if(income <=single_max_33)
			{
				tax=(income - single_max_33) *.33 +
					(single_max_28 - single_max_25) * .28 +
					(single_max_25 - single_max_15) * .25 +
					(single_max_15 - single_max_10) * .15 + 
						               single_max_10 * .1 ;

			}
			else {
				tax=(income - single_max_33) *.35 +
						(single_max_33 - single_max_28) * .33 +
						(single_max_28 - single_max_25) * .28 +
						(single_max_25 - single_max_15) * .25 +
						(single_max_15 - single_max_10) * .15 + 
							               single_max_10 * .1 ;

				
				
			}
			
			
			

				
			
		}
		
		
		else {
			System.out.println("error invalid status");
			System.exit(1);
			
		}
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println(" tax is " + (int)(tax * 100) / 100.0 );
		
		*/
		
		
		
		
		
		/*//birthdays guseeing
		int day=0;
		String set1="1  3  5  7  \n" +
					"9  11 13 15 \n" +
					"17 19 21 23 \n" +
					"25 27 29 31   ";
		
		String set2="2  3  6  7  \n" +
					"10 11 14 15 \n" +
					"18 19 22 23 \n" +
					"26 27 30 31  " ;
		String set3="4  5  6  7  \n" +
					"12 13 14 15 \n" +
					"20 21 22 23 \n" +
					"28 29 30 31";
					
		String set4="8  9  10 11 \n" + 
					"12 13 14 15 \n" +
					"24 25 26 27 \n" +
					"28 29 30 31   ";
		
		String set5="16 17 18 19 \n" +
					"20 21 22 23 \n" +
					"24 25 26 27 \n" +
					"28 29 30 31   ";
		
		System.out.println("is your birthday in set 1");
		System.out.println(set1);
		System.out.println("enter 0 for no 1 for yes");
		int answer =inpute.nextInt();
		
		if(answer==1)
			day+=1;
		

		System.out.println("is your birthday in set 2");
		System.out.println(set2);
		System.out.println("enter 0 for no 1 for yes");
		 answer =inpute.nextInt();
		
		if(answer==1)
			day+=2;
		System.out.println("is your birthday in set 3");
		System.out.println(set3);
		System.out.println("enter 0 for no 1 for yes");
	    answer =inpute.nextInt();
		
		if(answer==1)
			day+=4;
		System.out.println("is your birthday in set 4");
		System.out.println(set4);
		System.out.println("enter 0 for no 1 for yes");
	    answer =inpute.nextInt();
		
		if(answer==1)
			day+=8;
		System.out.println("is your birthday in set 5");
		System.out.println(set5);
		System.out.println("enter 0 for no 1 for yes");
		answer = inpute.nextInt();
		
		if(answer==1)
			day+=16;
		
		System.out.println("\n your birthday is "+ day);
		*/
			
		
		
		
		
//		double x1,x2,y1,y2;
//		System.out.println("enter x1 and y1" );
//		x1=inpute.nextDouble();
//		y1=inpute.nextDouble();
//		
//		System.out.println("enter x1 and y2");
//		x2=inpute.nextDouble();
//		y2=inpute.nextDouble();
//		
//		
//		double result =Math.pow(Math.pow(x2 - x1,2)+Math.pow(y2 - y1, 2), .5);
//		System.out.println("result = "+ result);

		
	/*	System.out.println("enter saving amount");
		
		double savingAmount,accountValue=0;
		
		savingAmount=inpute.nextDouble();
		final double fix=1.00417;
		
		accountValue=(savingAmount+accountValue)*fix;
		accountValue=(savingAmount+accountValue)*fix;
		accountValue=(savingAmount+accountValue)*fix;
		accountValue=(savingAmount+accountValue)*fix;
		accountValue=(savingAmount+accountValue)*fix;
		accountValue=(savingAmount+accountValue)*fix;

		System.out.println(" accountvalue = " +(int)(accountValue*100)/100.0);
		*/
		
/*
		System.out.println("enter number of years");
		int numberOfYears=inpute.nextInt();
		long Populationinyear,births,death,imagration,yearseconds;
		long  current_Population=312032486;
				
		yearseconds=365*24*60*60;
		births=yearseconds/7;
		imagration=yearseconds/45;
		death=yearseconds/13;
		Populationinyear=births+imagration-death;
		
		current_Population=current_Population+numberOfYears*Populationinyear;
		System.out.println("pop in "+numberOfYears+" = "+current_Population);		
		    long birthRateInSeconds = 7;
	        long deathRateInSeconds = 13;
	        long newImmigrantInSeconds = 45;



	        long currentPopulation = 312032486;

	        long secondsInYears = 60 * 60 * 24 * 365;

	        long numBirths = secondsInYears / birthRateInSeconds;
	        long numDeaths = secondsInYears / deathRateInSeconds;
	        long numImmigrants = secondsInYears / newImmigrantInSeconds;

	        for (int i = 1; i <= numberOfYears; i++) {
	            //currentPopulation += numBirths + numImmigrants - numDeaths;
	              currentPopulation +=Populationinyear ;
	              
	          //  current_Population+=Populationinyear;
	      		
	      		
	            System.out.println("Year " + i + " = " + currentPopulation);
	            //System.out.println("Year " + i + " = " +current_Population );

*/	       
		
		
		

		
		
		
		
		
		
		
		
//-------------------------------------------------------------------------------------------------------		
		/*ex2.6 rotat number
		System.out.println("enter digits");
		int number=inpute.nextInt();
		int first2gdigits=number/100;
		int lastdigit    =number%100;
		System.out.println("revers of number "+number+ "\t is "+lastdigit+first2gdigits);
		
		int first,second,third,fourth,first2,last2;
		first2=number/100;
		last2=number%100;
		
		first=first2/10;
		second=first2%10;
		third=last2/10;
		fourth=last2%10;
		
		
		System.out.println("addition of numbers is "+(first+second+third+fourth));
		
		
		
		
		
		    int lastDigit = number % 10;
		    int remainingNumber = number / 10;
		    int secondLastDigit = remainingNumber % 10;
		    remainingNumber = remainingNumber / 10;
		    int thirdLastDigit = remainingNumber % 10;

		    // Obtain the sum of all digits
		    int sum = lastDigit + secondLastDigit + thirdLastDigit;

		    // Display results
		    System.out.println("The sum of all digits in " + number
		      + " is " + sum);
*/		
		/*
		 * ex2.7 covert  seconds to days 
		
		System.out.println("enter number of seconds");
		int totalSeconds=inpute.nextInt();	
		
		int total_minuts=totalSeconds/60;
		int remain_seconds=totalSeconds%60;
		
		int total_hours=total_minuts/60;
		int remain_minuts=total_minuts%60;
		
		int days=total_hours/24;
		int remain_hours=total_hours%24;
		
		int covert_to_minuts=remain_minuts+remain_hours*60;
		
		
		System.out.println("days   "+days+"\nhours  "+remain_hours+"\nminuts "+remain_minuts+"\nseconds "+
		remain_seconds+"\nconert to minuts " +covert_to_minuts);*/
		
		
		
		/*
		char cc='a';
		float f=(float)cc;
		System.out.println("f is "+f);
		char y = 65535;
		float d=97.0f;
		char dd=(char)d;
		System.out.println(dd);
		
		System.out.println("\n\n\n\n\\n\n\n");
		char c=56999;
		System.out.println(""+c);
		System.out.println("\n\n\n\n\n\n");
		 System.out.println("10"+20);
		 System.out.println('a'+1);
		 System.out.println("10"+(10+20));
		 System.out.println("1"+(char)(10+55));
		 System.out.println('1'+'a'+10);
		 char a =(char)(2);
		  int b =a;
		  System.out.println("\n"+b+"\t"+a);
		  
		  System.out.println(10+"20"+1+1);
		  System.out.println(10+(char)(1+1)+"20");///
		  System.out.println(10+"20"+ 'A'+10);
		  System.out.println(10+"20"+(char)('\u0041'+1));*/
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  /*double annualInterestrate,loanAmount,monthlyInterestrate,totalPayment,montlyPayment;
		  int numberOfYears;
		  
		  System.out.println("enter annual interest rate ");
		  annualInterestrate=inpute.nextDouble();
		  
		  monthlyInterestrate=annualInterestrate/1200;
		  
		  System.out.println("enter number of yaers");
		  numberOfYears=inpute.nextInt();
		  
		  System.out.println("enter loan amount");
		  loanAmount=inpute.nextDouble();
		  
		  montlyPayment=loanAmount*monthlyInterestrate/(1-1/Math.pow(1+monthlyInterestrate,numberOfYears * 12));
		  totalPayment=montlyPayment*12*numberOfYears;
		  System.out.println("monthly payment is " +(int)montlyPayment);
		  System.out.println("total payment is "+(int)(totalPayment*100)/100.0);
		  */
		  
		 
		 /* java.util.Scanner input = new java.util.Scanner(System.in);
		    // Receive the amount entered from the keyboard
		    System.out.print(
		      "Enter an amount in integer, for example 1156 \nfor 11 dollars and 56 cents: ");
		    int amount = input.nextInt();

		    int remainingAmount = amount;
		    char an='';
		    // Find the number of one dollars
		    int numOfOneDollars = remainingAmount / 100;
		    remainingAmount = remainingAmount % 100;

		    // Find the number of quaters in the remaining amount
		    int numOfQuarters = remainingAmount / 25;
		    remainingAmount = remainingAmount % 25;

		    // Find the number of dimes in the remaining amount
		    int numOfDimes = remainingAmount / 10;
		    remainingAmount = remainingAmount % 10;

		    // Find the number of nickels in the remaining amount
		    int numOfNickels = remainingAmount / 5;
		    remainingAmount = remainingAmount % 5;

		    // Find the number of pennies in the remaining amount
		    int numOfPennies = remainingAmount;

		    // Display results
		    System.out.println("Your amount " + amount + " consists of ");
		    System.out.println(numOfOneDollars + "\t dollars");
		    System.out.println(numOfQuarters + "\t quarters");
		    System.out.println(numOfDimes + "\t dimes");
		    System.out.println(numOfNickels + "\t nickels");
		    System.out.println(numOfPennies + "\t pennies");
		*/
		  
		  //////////////////////////////////////////////////////////////////////////////////////////
		/*long totalMilliseconds,totalSeconds,totalMnutes,totalHours,totalDayes;
		long currentSeconds , currentMinute , currentHoure ;
		long currentYear , currentMonth , Currentday ;
		long remainDays;
		totalMilliseconds = (System.currentTimeMillis());
		
		totalSeconds = totalMilliseconds / 1000 ;
		totalMnutes  = totalSeconds / 60;
		totalHours   = totalMnutes / 60;
		totalDayes   = totalHours / 24;
		
		currentSeconds = totalSeconds % 60 ;
		currentMinute  = totalMnutes % 60 ;
		currentHoure   = totalHours % 24 ;
		
		currentYear = totalDayes / 365 +1970 ;
		remainDays  = totalDayes % 365 ;
		currentMonth= remainDays / 30 ;
		Currentday  = remainDays % 30 ;
		
		
		System.out.println("Current time is "+ currentHoure + ":" + currentMinute+":" + currentSeconds);
		System.out.print(" year "+ currentYear + " month " + currentMonth + " day "+ Currentday);
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*ex1.1
		 * System.out.println("welcome to java");
		System.out.println("you have succeeded");*/
		
///////////////////////////////////////////////////////////////////////////////		
		
		/*ex1.3
	    System.out.println("    j     A     V     V     A   ");
		System.out.println("    j    A A     V   V     A A  ");
		System.out.println("j   j	AAAAA     V V     AAAAA  ");
		System.out.println(" j j   A     A     V     A     A ");*/
		
////////////////////////////////////////////////////////////////////////////////		

	   /*ex.4
	    *System.out.println("a    a*2    a*3    ");
		 System.out.println("1    2      3      ");
		 System.out.println("2    4      6      ");
		 System.out.println("3    6      9      ");
		 System.out.println("4    8      12     ");*/
		
///////////////////////////////////////////////////////////////////////////////	
	  /*ex.5
	   * System.out.println(((7.5 * 2.5) - (1.5*3)) / (35.5 - 2.5));
		 System.out.print((7.5 * 2.5 - 1.5 * 3) / (35.5 - 2.5));*/

///////////////////////////////////////////////////////////////////////////////
		
	



