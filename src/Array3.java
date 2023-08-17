import java.util.Arrays;

public class Array3 {
    public int maxSpan(int[] nums) {
        if (nums.length == 0) return 0;
        int largestSpan = 1;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] == current) {
                    int span = (j - i) + 1;
                    largestSpan = Math.max(span, largestSpan);
                    break;
                }
            }
        }

        return largestSpan;
    }


    public int[] fix34(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 3 && nums[i+1] != 4) {
                int temp = nums[i+1];
                int index = indexOfFirstFree4(nums);
                nums[i+1] = 4;
                nums[index] = temp;
            }
        }
        return nums;
    }
    // Returns the index of the first 4 that is free (i.e., not preceded by a 3)
    public int indexOfFirstFree4(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 4 && nums[i-1] != 3) return i;
        }
        return nums.length-1;
    }


    public int[] fix45(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 4 && nums[i+1] != 5) {
                int temp = nums[i+1];
                int index = indexOfFirstFree5(nums);
                nums[i+1] = 5;
                nums[index] = temp;
            }
        }
        return nums;
    }
    // Returns the index of the first 5 that is free (i.e., not preceded by a 4)
    public int indexOfFirstFree5(int[] nums) {
        // This time, there is no guarantee that the first element of the nums array
        // is not a 5. So the loop below that worked previously was missing this edge
        // case. Cannot just set the loop to start from i = 0 since it does nums[i-1].
        if (nums[0] == 5) return 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 5 && nums[i-1] != 4) return i;
        }
        return nums.length-1;
    }


    public boolean canBalance(int[] nums) {
        // i is the splitting point which is gradually increased
        for (int i = 1; i < nums.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += nums[j];
            }
            for (int j = i; j < nums.length; j++) {
                sumRight += nums[j];
            }

            if (sumLeft == sumRight) return true;
        }

        return false;
    }


    public boolean linearIn(int[] outer, int[] inner) {
        if (inner.length == 0) return true;
        int innerIndex = 0;
        int outerIndex = 0;

        while (outerIndex < outer.length && innerIndex < inner.length) {
            // As soon as the current element of outer is greater than the current
            // element of inner, it is impossible for outer to contain the current
            // element of inner.
            if (outer[outerIndex] > inner[innerIndex]) return false;
            // If the current element of outer is the same as the current element of
            // inner, then increment the inner index, so we check the next element of
            // inner. If inner was at its last element though, then return true.
            if (outer[outerIndex] == inner[innerIndex]) {
                if (innerIndex == inner.length - 1) return true;
                innerIndex++;
            }
            outerIndex++;
        }

        return false;
    }


    public int[] squareUp(int n) {
        int[] arr = new int[n*n];
        // The number of zeroes that a group of n should contain.
        int numZeroes = 0;
        // n groups of n. Start with the last group which should have no zeroes.
        for (int i = n - 1; i >= 0; i--) {
            // The number we are going to write into the array. Initialised with 1 at
            // the start of the iteration for each group.
            int current = 1;
            // Stop iterating once we reach numZeroes - this means we skip the first
            // numZeroes elements of the group. These were just filled with 0s
            // automatically when we created the array.
            for (int j = n - 1; j >= numZeroes; j--) {
                int index = n*i + j;
                arr[index] = current;
                current++;
            }
            // Increment numZeroes so the next group ends up with 1 extra 0 than the
            // current group.
            numZeroes++;
        }

        return arr;
    }


    public int[] seriesUp(int n) {
        int size = n*(n+1) / 2;
        int[] arr = new int[size];
        int limit = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < limit; j++) {
                arr[i] = j;
                i++; // increment i after each number we write, so we write to the next loc
            }
            arr[i] = limit; // write limit as well. Could loop 1 more iteration (use <=
            // rather than <) instead but would then need to decrement i afterwards
            limit++;
        }

        return arr;
    }


    public int maxMirror(int[] nums) {
        if (nums.length <= 1) return nums.length;
        // The number of contiguous elements we are checking, initially the full array
        int currentSize = nums.length;
        while (currentSize >= 2) {
            // Check every possible subset of contiguous elements of size currentSize
            for (int i = 0; i <= nums.length - currentSize; i++) {
                // Store in a new array the elements we are considering currently
                int[] subset = new int[currentSize];
                for (int j = 0; j < currentSize; j++) {
                    subset[j] = nums[i+j];
                }
                // If the current subset of currentSize elements is a mirror section, we
                // have found the largest mirror.
                if (arrayContainsMirror(nums, subset)) {
                    return currentSize;
                }
            }
            currentSize--;
        }
        return 1;
    }
    // Returns true if the nums array contains the subset array in reverse order
    public boolean arrayContainsMirror(int[] nums, int[] subset) {
        int[] mirror = getMirror(subset);

        for (int i = 0; i <= nums.length - subset.length; i++) {
            int[] current = new int[subset.length];
            for (int j = 0; j < subset.length; j++) {
                current[j] = nums[i+j];
            }
            if (Arrays.equals(current, mirror)) return true;
        }

        return false;
    }
    // Returns a new array with the same elements but in reverse order
    public int[] getMirror(int[] arr) {
        int length = arr.length;
        int[] mirror = new int[length];

        for (int i = 0; i < length; i++) {
            mirror[i] = arr[length - i - 1];
        }

        return mirror;
    }


    public int countClumps(int[] nums) {
        if (nums.length <= 1) return 0;
        int clumps = 0;
        int currentNum = nums[0];
        int currentCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentNum) {
                currentCount++;
                if (currentCount == 2) clumps++;
            }
            else {
                currentNum = nums[i];
                currentCount = 1;
            }
        }

        return clumps;
    }


}
