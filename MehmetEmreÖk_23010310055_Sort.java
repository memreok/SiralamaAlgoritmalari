package ödev6;

import java.util.Arrays;

public class MehmetEmreÖk_23010310055_Sort {

	public static void main(String[] args) {

		int [] arr = new int [100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}
		ExecutionTime(arr);
	}

	public static void ExecutionTime(int [] arr) {
		
		long baslangic, son;
		
		int[] arr1 = Arrays.copyOf(arr, arr.length);
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		int[] arr3 = Arrays.copyOf(arr, arr.length);
		
		baslangic = System.currentTimeMillis();
		SelectionSort(arr1);
		son = System.currentTimeMillis();
		System.out.println("Selection Sort geçen zaman: " + (son - baslangic) + "msec");
		
		
		baslangic = System.currentTimeMillis();
		InsertionSort(arr2);
		son = System.currentTimeMillis();
		System.out.println("Insertion Sort geçen zaman: " + (son - baslangic) + "msec");
	
		baslangic = System.currentTimeMillis();
		MergeSort(arr3);
		son = System.currentTimeMillis();
		System.out.println("Merge Sort geçen zaman: " + (son - baslangic) + "msec");
	
	
	}
	
	public static void SelectionSort(int [] arr) { // küçükten büyüğe tek tek bakarak sıralıyor
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
	}
	
	
	public static void swap(int [] arr, int i, int j) { // iki elemanın yerini değiştiryor ( 
								// küçükten büyüğe doğru
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void InsertionSort(int [] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	

	public static void MergeSort(int [] arr) {
		if (arr.length >= 2) {
			int [] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
			int [] right = Arrays.copyOfRange(arr,  arr.length / 2, arr.length );
			
			MergeSort(left);
			MergeSort(right);
//			merge(arr, left, right);
			
		}
	}
	
	public static void merge(int [] result, int [] left, int [] right ) {
		int i1 = 0, i2 = 0;
		for (int i = 0; i < result.length; i++) {
			if(i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
				result[i] = left[i1];
				i1++;
			}else {
				result[i] = right[i2];
				i2++;
			}
		}
	}
	
	public static void BubbleSort(int [] arr) {
		
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap arr[j + 1] and arr[j]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			
		}
		
	}
	
}
