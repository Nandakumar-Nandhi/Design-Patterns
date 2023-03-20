import java.util.Scanner;
interface SortingStrategy
{
		int[] sort( int[] inputArray );
}
class BubbleSort implements SortingStrategy
{

		public int[] sort( int[] inputArray )
		{
				int n = inputArray.length;
				for( int i = 0; i < n; i++ )
				{
						for( int j = 1; j < (n - i); j++ )
						{
								if( inputArray[j - 1] > inputArray[j] )
								{
										swap(j - 1, j, inputArray);
								}
						}
				}
				System.out.println("Array is sorted using Bubble Sort Algorithm");
				return inputArray;
		}

		private void swap( int k, int l, int[] inputArray )
		{
				int temp = inputArray[k];
				inputArray[k] = inputArray[l];
				inputArray[l] = temp;
		}
}
class InsertionSort implements SortingStrategy
{

		public int[] sort( int[] inputArray )
		{

				for( int i = 1; i < inputArray.length; i++ )
				{
						int tmp = inputArray[i];
						int j;
						for( j = i; j > 0; j-- )
						{
								if( inputArray[j - 1] < tmp )
										break;
								inputArray[j] = inputArray[j - 1];
						}
						inputArray[j] = tmp;
				}
				System.out.println("Array is sorted using Insertion Sort Algorithm");
				return inputArray;
		}

}
class SelectionSort implements SortingStrategy
{

		public int[] sort( int[] inputArray )
		{

			    for (int i = 0; i < inputArray.length - 1; i++)
			    {
			        int min = i;  
			        for (int j = i + 1; j < inputArray.length; j++)
			        {
			            if (inputArray[j] < inputArray[min])
			                min = j;
			        }
			 
			        swap(inputArray, i, min);
			    }
				System.out.println("Array is sorted using Selection Sort Algorithm");
				return inputArray;
		}

		private void swap( int[] inputArray,int k, int l )
		{
				int temp = inputArray[k];
				inputArray[k] = inputArray[l];
				inputArray[l] = temp;
		}
}


class SortContext
{

		private SortingStrategy sortingStrategy;

		public void setSortingStrategy( SortingStrategy sortingStrategy )
		{
				this.sortingStrategy = sortingStrategy;
		}

		private void printArray( int[] inputArray )
		{
				for( int i = 0; i < inputArray.length; i++ )
				{
						System.out.print(inputArray[i] + ",");
				}
				System.out.println("\n");

		}

		private int[] readUserInput()
		{
				System.out.println("Enter array size : ");

				Scanner scanner = new Scanner(System.in);
				int n = scanner.nextInt();

				System.out.println("Enter input array  : ");
				int[] inputArray = new int[n];
				for( int i = 0; i < n; i++ )
				{
						inputArray[i] = scanner.nextInt();
				}
				return inputArray;
		}

		public void sort()
		{
				int[] inputArray = readUserInput();
				inputArray = sortingStrategy.sort(inputArray);
				printArray(inputArray);
		}
}
public class Main
{
		public static void main( String[] args )
		{

				System.out.println("Please enter Sort Algorithm  : 'BubbleSort' or 'SelectionSort' or 'InsertionSort'");
				Scanner scanner = new Scanner(System.in);
				String sortAlgorithm = scanner.next();
				System.out.println("Sort Algorithm is : " + sortAlgorithm);

				SortContext context = new SortContext();
				

				if( "BubbleSort".equalsIgnoreCase(sortAlgorithm) )
				{
						context.setSortingStrategy(new BubbleSort());
				}
				else if( "SelectionSort".equalsIgnoreCase(sortAlgorithm) )
				{
						context.setSortingStrategy(new SelectionSort());
				}
				else if( "InsertionSort".equalsIgnoreCase(sortAlgorithm) )
				{
						context.setSortingStrategy(new InsertionSort());
				}

				context.sort();

		}
}
