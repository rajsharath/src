package ds;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MedianMaintainance {

	MinNodeHeap mn = new MinNodeHeap();
	MaxHeap mx = new MaxHeap();

	public void medianMaintain(int[] arr) {
		int sum = 0;
		for (Integer x : arr) {
			//System.out.println("x is : " + x);
			//System.out.println(median(x) + " is the median");
			sum += findMedian(x);	
			//System.out.println("minHeap size " + mn.lastIndex + " maxHeap size " + mx.lastIndex);
		}
		System.out.println("answer " + sum % 10000);
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
			return mn.min().minDistance;
		}
	}

	private void rebalanceHeaps() {
		if (Math.abs(mn.size() - mx.size()) <= 1) {
			return;
		}
		if (mx.size() > mn.size()) {
			int max = mx.extractMax();
			mn.insert(new Node(1, max));
		} else {
			int min = mn.extractMin().minDistance;
			mx.insert(min);
		}		
	}

	private void addToCorrectHeap(int x) {
		// both null
		if (mn.min() == null && mx.max() == -100000) {
			mn.insert(new Node(1, x));
			return;
		}		
		
		if (x > mn.min().minDistance) {
			mn.insert(new Node(1, x));
		} else {
			mx.insert(x);
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
	
	public static void main(String[] args) { // 1 2 8 10 13 14 20 21
	/*	// int[] arr = { 2, 8, 1, 4, 10, 14, 3 };
		// 2 2/8 2 2/4 4 4/8 4

		int[] arr2 = { 1, 8, 13, 20, 30, 40 };
		// 1 1/8 8 8/13 13 13/20

		int[] arr3 = { 30, 20, 10, 5, 4, 1, 40 };
		// 30 20/30 20, 10/20 10 5/10 10

		// int[] arr = { 5, 10, 4, 3, 19, 1 };*/
		int arr[] = readFile();
		new MedianMaintainance().medianMaintain(arr);
	}

}
