import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Array2 {
    public int countEvens(int[] nums) {
        return (int) Arrays.stream(nums).filter(num -> num % 2 == 0).count();
    }


    public int bigDiff(int[] nums) {
        int smallest = nums[0];
        int largest = nums[0];

        for (int num : nums) {
            if (num > largest) largest = num;
            if (num < smallest) smallest = num;
        }

        return largest - smallest;
    }


    public int centeredAverage(int[] nums) {
        int smallest = nums[0];
        int largest = nums[0];
        int sum = 0;

        for (int num : nums) {
            if (num > largest) largest = num;
            if (num < smallest) smallest = num;
            sum += num;
        }

        sum -= (smallest + largest);
        return sum / (nums.length - 2);
    }


    public int sum13(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) i++;
            else sum += nums[i];
        }
        return sum;
    }


    public int sum67(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 6) {
                sum += nums[i];
            }
            else {
                while (nums[i] != 7) i++;
            }
        }
        return sum;
    }


    public boolean has22(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i+1] == 2) return true;
        }
        return false;
    }


    public boolean lucky13(int[] nums) {
        for (int num : nums) {
            if (num == 1 || num == 3) return false;
        }
        return true;
    }


    public boolean sum28(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (num == 2) sum += 2;
        }
        return sum == 8;
    }


    public boolean more14(int[] nums) {
        int num1s = 0;
        int num4s = 0;
        for (int num : nums) {
            if (num == 1) num1s++;
            else if (num == 4) num4s++;
        }
        return num1s > num4s;
    }


    public int[] fizzArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }


    public boolean only14(int[] nums) {
        for (int num : nums) {
            if (num != 1 && num != 4) {
                return false;
            }
        }
        return true;
    }


    public String[] fizzArray2(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i); // or "" + i
        }

        return arr;
    }


    public boolean no14(int[] nums) {
        boolean no1s = true;
        boolean no4s = true;
        for (int num : nums) {
            if (num == 1) no1s = false;
            if (num == 4) no4s = false;
        }
        return no1s || no4s;
    }


    public boolean isEverywhere(int[] nums, int val) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != val && nums[i+1] != val) return false;
        }
        return true;
    }


    public boolean either24(int[] nums) {
        boolean consecutive2s = false;
        boolean consecutive4s = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i+1] == 2) consecutive2s = true;
            if (nums[i] == 4 && nums[i+1] == 4) consecutive4s = true;
        }

        return consecutive2s ^ consecutive4s;
    }


    public int matchUp(int[] nums1, int[] nums2) {
        int count = 0;

        for (int i = 0; i < nums1.length; i++) {
            int a = nums1[i];
            int b = nums2[i];
            if (a != b && (Math.abs(a-b) <= 2)) count++;
        }

        return count;
    }


    public boolean has77(int[] nums) {
        if (nums.length < 2) return false;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 7 && nums[i+2] == 7) return true;
            if (nums[i] == 7 && nums[i+1] == 7) return true;
        }

        return nums[nums.length-2] == 7 && nums[nums.length-1] == 7;
    }


    public boolean has12(int[] nums) {
        int i = 0;
        while (i < nums.length && nums[i] != 1) i++;
        i++; // increment i once more so it points to the number after the 1
        while (i < nums.length) {
            if (nums[i] == 2) return true;
            i++;
        }

        return false;
    }


    public boolean modThree(int[] nums) {
        if (nums.length < 3) return false;
        for (int i = 0; i < nums.length - 2; i++) {
            if (isEven(nums[i]) && isEven(nums[i+1]) && isEven(nums[i+2])) return true;
            if (!isEven(nums[i]) && !isEven(nums[i+1]) && !isEven(nums[i+2])) return true;
        }

        return false;
    }
    public boolean isEven(int n) {
        return n % 2 == 0;
    }


    public boolean haveThree(int[] nums) {
        int count = 0;
        int[] nums2 = new int[nums.length+2];
        // Initialise the second array so it is the same as the first but with an
        // additional 0 at each end.
        nums2[0] = 0;
        nums2[nums2.length-1] = 0;
        for (int i = 0; i < nums.length; i++) {
            nums2[i+1] = nums[i];
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums2[i] == 3) {
                if (nums2[i-1] == 3 || nums2[i+1] == 3) return false;
                count++;
            }
        }

        return count == 3;
    }


    public boolean twoTwo(int[] nums) {
        int[] nums2 = new int[nums.length+2];
        nums2[0] = 0;
        nums2[nums2.length-1] = 0;
        for (int i = 0; i < nums.length; i++) {
            nums2[i+1] = nums[i];
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums2[i] == 2) {
                if (nums2[i-1] != 2 && nums2[i+1] != 2) return false;
            }
        }

        return true;
    }


    public boolean sameEnds(int[] nums, int len) {
        if (len == 0 || len == nums.length) return true;
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        for (int i = 0; i < len; i++) {
            arr1[i] = nums[i];
            arr2[i] = nums[nums.length-len+i];
        }
        return Arrays.equals(arr1, arr2);
    }


    public boolean tripleUp(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] + 1 == nums[i+1] && nums[i+1] + 1 == nums[i+2]) return true;
        }
        return false;
    }


    public int[] fizzArray3(int start, int end) {
        int numElements = end-start;
        int[] result = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            result[i] = i+start;
        }
        return result;
    }


    public int[] shiftLeft(int[] nums) {
        if (nums.length == 0) return nums;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            arr[i] = nums[i+1];
        }
        arr[arr.length - 1] = nums[0];
        return arr;
    }


    public int[] tenRun(int[] nums) {
        int currentMultiple = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 10 == 0) {
                currentMultiple = nums[i];
            }
            else {
                if (currentMultiple != -1) {
                    nums[i] = currentMultiple;
                }
            }
        }
        return nums;
    }


    public int[] pre4(int[] nums) {
        int index = 0;
        int i = 0;
        boolean finished = false;
        while (i < nums.length && !finished) {
            if (nums[i] == 4) {
                index = i;
                finished = true;
            }
            i++;
        }

        int[] arr = new int[index];
        for (int j = 0; j < index; j++) {
            arr[j] = nums[j];
        }
        return arr;
    }


    public int[] post4(int[] nums) {
        int index = -1;
        int i = nums.length - 1;
        boolean finished = false;
        while (i >= 0 && !finished) {
            if (nums[i] == 4) {
                index = i;
                finished = true;
            }
            i--;
        }
        index++;

        int[] arr = new int[nums.length - index];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = nums[j+index];
        }
        return arr;
    }


    public int[] notAlone(int[] nums, int val) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == val) {
                int before = nums[i-1];
                int after = nums[i+1];
                if (before == val || after == val) continue;
                int greater = Math.max(before, after);
                nums[i] = greater;
            }
        }
        return nums;
    }


    public int[] zeroFront(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) count++;
        }

        int[] arr = new int[nums.length];
        for (int i = 0; i < count; i++) {
            arr[i] = 0;
        }

        int index = count;

        for (int num : nums) {
            if (num != 0) {
                arr[index] = num;
                index++;
            }
        }

        return arr;
    }


    public int[] withoutTen(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 10) count++;
        }

        int[] arr = new int[nums.length];
        for (int i = nums.length-1; i >= nums.length-count; i--) {
            arr[i] = 0;
        }

        int index = 0;

        for (int num : nums) {
            if (num != 10) {
                arr[index] = num;
                index++;
            }
        }

        return arr;
    }


    public int[] zeroMax(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int largestOddNumber = 0;
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] % 2 != 0 && nums[j] > largestOddNumber) {
                        largestOddNumber = nums[j];
                    }
                }
                nums[i] = largestOddNumber;
            }
        }
        return nums;
    }


    public int[] evenOdd(int[] nums) {
        List<Integer> evens = new LinkedList<>();
        List<Integer> odds = new LinkedList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }

        int[] arr = new int[nums.length];
        int index = 0;
        while (!evens.isEmpty()) {
            arr[index] = evens.remove(0);
            index++;
        }

        while (!odds.isEmpty()) {
            arr[index] = odds.remove(0);
            index++;
        }

        return arr;
    }


    public String[] fizzBuzz(int start, int end) {
        String[] arr = new String[end-start];
        int index = 0;
        for (int i = start; i < end; i++) {
            boolean multipleOf3 = i % 3 == 0;
            boolean multipleOf5 = i % 5 == 0;
            if (multipleOf3 && multipleOf5) {
                arr[index] = "FizzBuzz";
            }
            else if (multipleOf3) {
                arr[index] = "Fizz";
            }
            else if (multipleOf5) {
                arr[index] = "Buzz";
            }
            else {
                arr[index] = String.valueOf(i);
            }
            index++;
        }

        return arr;
    }

}
