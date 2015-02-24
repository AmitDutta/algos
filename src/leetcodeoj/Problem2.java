package leetcodeoj;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Problem2 {
	
	private static final double DELTA = 1e-15;
	
	// Accepted but this is not the way to do it.
	public double findMedianSortedArrays(int[] A, int[] B) {
		int total = A.length + B.length;
		int[] C = new int[total];
		int m = 0, n = 0, k = 0;
		while (true) {
			if (m >= A.length || n >= B.length) {
				break;
			}
			if (A[m] > B[n]) {
				C[k] = B[n];
				++k;
				++n;
			} else if (A[m] < B[n]) {
				C[k] = A[m];
				++k;
				++m;
			} else {
				C[k++] = A[m];
				C[k++] = B[n];
				++m;
				++n;
			}
		}
		
		if (m >= A.length) {
			while (n < B.length) {
				C[k++] = B[n++];
			}
		} else {
			while (m < A.length) {
				C[k++] = A[m++];
			}
		}
		
		if (C.length == 0) return 0.0;
		int index = total/2;
		if (total %2 == 0) {
			return (double) (C[index] + C[index - 1])/2;
		}else return (double) C[index];
		
	}
	
	@Test
	public void findMedianSortedArraysTest()
	{
		Problem2 sln = new Problem2();
		int[] arr1= {2,3,4};
		int[] arr2 = {1};
		//sln.findMedianSortedArrays(arr1, arr2);
		assertEquals(2.5, sln.findMedianSortedArrays(arr1, arr2), DELTA);
		
		int[] arr3 = {2,3,4};
		int[] arr4 = {1,10,12};
		//sln.findMedianSortedArrays(arr4, arr3);
		assertEquals(3.5, sln.findMedianSortedArrays(arr4, arr3), DELTA);
		
		int[] arr5 = {};
		int[] arr6 = {};
		assertEquals(0, sln.findMedianSortedArrays(arr5, arr6), DELTA);
		
		int[] arr7 = {2,3,4,5};
		int[] arr8 = {};
		assertEquals(3.5, sln.findMedianSortedArrays(arr7, arr8), DELTA);
		assertEquals(3.5, sln.findMedianSortedArrays(arr8, arr7), DELTA);
		
		
		int[] arr9 = {2,30,40,50};
		int[] arr10 = {1,25,27};
		assertEquals(27, sln.findMedianSortedArrays(arr9, arr10), DELTA);
		
		int[] arr11 = {2,30,40,50};
		int[] arr12 = {1,25,27,100};
		assertEquals(28.5, sln.findMedianSortedArrays(arr11, arr12), DELTA);
		
		int[] arr13 = {1,2};
		int[] arr14 = {1,2};
		assertEquals(1.5, sln.findMedianSortedArrays(arr13, arr14), DELTA);
		
		int[] arr15 = {1,1,3,3};
		int[] arr16 = {1,1,3,3};
		assertEquals(2, sln.findMedianSortedArrays(arr15, arr16), DELTA);
		
		int[] arr17 = {1,2,2};
		int[] arr18 = {1,2,3};
		assertEquals(2, sln.findMedianSortedArrays(arr17, arr18), DELTA);
		
		int[] arr19 = {};
		int[] arr20 = {2,3};
		assertEquals(2.5, sln.findMedianSortedArrays(arr19, arr20), DELTA);
		
		int [] arr21 = {1};
		int [] arr22 = {2};
		assertEquals(1.5, sln.findMedianSortedArrays(arr21, arr22), DELTA);
	}
}
