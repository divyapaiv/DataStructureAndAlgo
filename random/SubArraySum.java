
/*
Sliding window technique
  Algorithm: 
  1. set cursum=arr[0]
  2. for each element 
      remove all elements until sum>cursum and start <i-1  
  3. if cursum==sum return start to i-1 as position. 
  4. if(i<n) add arr[i] to cursum
   */
class SubArraySum {
  //none
  int subArraySum(int arr[], int n, int sum)
	{
		int currentSum = arr[0], start = 0, i;
		for (i = 1; i <= n; i++) {
			// If currentSum exceeds the sum,
			// then remove the starting elements
			while (currentSum > sum && start < i - 1) {
				currentSum = currentSum - arr[start];
				start++;
			}

			// If currentSum becomes equal to sum,
			// then return true
			if (currentSum == sum) {
				int p = i - 1;
				System.out.println(
					"Sum found between indexes " + start
					+ " and " + p);
				return 1;
			}

			// Add this element to curr_sum
			if (i < n)
				currentSum = currentSum + arr[i];
		}

		System.out.println("No subarray found");
		return 0;
	}

	public static void main(String[] args)
	{
		SubArraySum arraysum = new SubArraySum();
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int n = arr.length;
		int sum = 23;
		arraysum.subArraySum(arr, n, sum);
	}
}
