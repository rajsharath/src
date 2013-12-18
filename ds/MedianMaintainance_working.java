package ds;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MedianMaintainance_working {

	MinHeap mn = new MinHeap();
	MaxHeap mx = new MaxHeap();

	public void medianMaintain(int[] arr) {
		int sum = 0;
		for (Integer x : arr) {
			//System.out.print(median(x) + " ");
			sum += findMedian(x);			
		}
		System.out.println(sum % 10000);
	}
	
	public int findMedian(int x) {
		addToCorrectHeap(x);
		rebalanceHeaps();
		return getMedian();
	}

	private int getMedian() {		
		if (mx.size() == mn.size()) {
			return mx.max();
		}
		if (mx.size() > mn.size()) {
			return mx.max();
		} else {
			return mn.min();
		}
	}

	private void rebalanceHeaps() {
		if (Math.abs(mn.size() - mx.size()) <= 1) {
			return;
		}
		if (mx.size() > mn.size()) {
			int max = mx.extractMax();
			mn.insert(max);
		} else {
			int min = mn.extractMin();
			mx.insert(min);
		}		
	}

	private void addToCorrectHeap(int x) {
		if (x > mn.min()) {
			mn.insert(x);
		} else {
			mx.insert(x);
		} 		
	}

	public int median(int x, int y) {
		if (mn.size() == 0 && mx.size() == 0) {
			mn.insert(x);
			return mn.min();
		}

		if (mn.size() == 0 && mx.size() > 0) {
			if (x < mx.max()) {
				mx.insert(x);
				int max = mx.extractMax();
				mn.insert(max);
				return mx.max();
			} else {
				mn.insert(x);
				return mx.max();
			}
		}
		if (mx.size() == 0 && mn.size() > 0) {
			if (x > mn.min()) {
				mn.insert(x);
				int min = mn.extractMin();
				mx.insert(min);
				return mx.max();
			} else {
				mx.insert(x);
				return mx.max();
			}
		}

		// input element is in between mn.min and mx.max (mx.max < ele < mn.min)
		if (x < mn.min() && x > mx.max()) {
			if (mn.size() > mx.size()) {
				mx.insert(x);
				return mx.max();
			} else {
				mn.insert(x);
				return mn.min();
			}
		}

		// input element is less than mx.max (ele < mx.max)
		else if (x < mx.max()) {
			mx.insert(x);
			if (mx.size() - mn.size() == 1 || mx.size() == mn.size()) {
				return mx.max();
			} else {
				int max = mx.extractMax();
				mn.insert(max);
				return mx.max();
			}
		} else {

			// if element is greater than mn.min (ele > mn.min)
			mn.insert(x);
			if (mn.size() == mx.size()) {
				return mx.max();
			} else if (mn.size() - mx.size() == 1) { 
				return mn.min();
			} else {
				int min = mn.extractMin();
				mx.insert(min);
				return mn.min();
			}
		}
	}

	private static int[] readFile() {
		int num[] = new int[10000];
		int i = 0;
		try {
			FileInputStream fstream = new FileInputStream("c:\\Median.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				num[i] = new Integer(strLine);
				i++;
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return num;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) { // 1 2 8 10 13 14 20 21
	/*	// int[] arr = { 2, 8, 1, 4, 10, 14, 3 };
		// 2 2/8 2 2/4 4 4/8 4

		int[] arr2 = { 1, 8, 13, 20, 30, 40 };
		// 1 1/8 8 8/13 13 13/20

		int[] arr3 = { 30, 20, 10, 5, 4, 1, 40 };
		// 30 20/30 20, 10/20 10 5/10 10

		// int[] arr = { 5, 10, 4, 3, 19, 1 };*/
		int arr[] = readFile();
		new MedianMaintainance_working().medianMaintain(arr);
	}

}
