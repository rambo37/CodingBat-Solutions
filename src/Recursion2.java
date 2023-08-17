import java.util.ArrayList;
import java.util.List;

public class Recursion2 {
    public boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        return groupSum(start + 1, nums, target - nums[start]) ||
                groupSum(start + 1, nums, target);
    }


    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        int current = nums[start];
        // If the current digit is a 6, we have to include it in the sum.
        if (current == 6) return groupSum6(start + 1, nums, target - current);
        // Since the current digit is not 6, we can try both with and without it.
        return groupSum6(start + 1, nums, target - current) ||
                groupSum6(start + 1, nums, target);
    }


    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        return groupNoAdj(start + 2, nums, target - nums[start]) ||
                groupNoAdj(start + 1, nums, target);
    }


    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        int current = nums[start];
        // If the current digit is a multiple of 5, we must include it in the sum. If
        // however the next number is a 1, we cannot include the 1.
        if (current % 5 == 0) {
            if (start < nums.length - 1 && nums[start+1] == 1) {
                return groupSum5(start + 2, nums, target - current);
            }
            else {
                return groupSum5(start + 1, nums, target - current);
            }
        }

        // Since the current digit is not a multiple of 5, we can try both with and
        // without it.
        return groupSum5(start + 1, nums, target - current) ||
                groupSum5(start + 1, nums, target);
    }


    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        int current = nums[start];
        // Figure out the total of all consecutive duplicates as well as how many
        // consecutive duplicates there are.
        int consecutiveSum = current;
        int consecutiveDuplicates = 1;
        int i = start + 1;
        while (i < nums.length && nums[i] == current) {
            consecutiveSum += nums[i];
            consecutiveDuplicates++;
            i++;
        }
        // Regardless of whether we use the consecutive sum, we skip past however many
        // duplicates there were since we cannot use just some of them. All or nothing.
        return groupSumClump(start + consecutiveDuplicates, nums, target - consecutiveSum) ||
                groupSumClump(start + consecutiveDuplicates, nums, target);
    }


    public boolean splitArray(int[] nums) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int num : nums) {
            a.add(num);
        }
        return splitArrayHelper(0, nums, a, b);
    }
    public boolean splitArrayHelper(int start, int[] nums, List<Integer> a, List<Integer> b) {
        if (start >= nums.length) return identicalSums(a, b);

        List<Integer> a2 = new ArrayList<>(a);
        List<Integer> b2 = new ArrayList<>(b);
        if (splitArrayHelper(start + 1, nums, a2, b2)) return true;

        int current = nums[start];
        b2.add(a2.remove(a2.indexOf(current)));
        return splitArrayHelper(start + 1, nums, a2, b2);
    }
    public boolean identicalSums(List<Integer> a, List<Integer> b) {
        return sum(a) == sum(b);
    }
    public int sum(List<Integer> a) {
        int sum = 0;
        for (Integer integer : a) {
            sum += integer;
        }
        return sum;
    }


    public boolean splitOdd10(int[] nums) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int num : nums) {
            a.add(num);
        }
        return splitOdd10Helper(0, nums, a, b);
    }
    public boolean splitOdd10Helper(int start, int[] nums, List<Integer> a, List<Integer> b) {
        if (start >= nums.length) return checkBothSums(a, b);

        List<Integer> a2 = new ArrayList<>(a);
        List<Integer> b2 = new ArrayList<>(b);
        if (splitOdd10Helper(start + 1, nums, a2, b2)) return true;

        int current = nums[start];
        b2.add(a2.remove(a2.indexOf(current)));
        return splitOdd10Helper(start + 1, nums, a2, b2);

    }
    public boolean checkBothSums(List<Integer> a, List<Integer> b) {
        return (oddSum(a) && multipleOf10Sum(b)) || (oddSum(b) && multipleOf10Sum(a));
    }
    public boolean oddSum(List<Integer> a) {
        return sum(a) % 2 != 0;
    }
    public boolean multipleOf10Sum(List<Integer> a) {
        return sum(a) % 10 == 0;
    }
    // See the sum method from the previous problem


    public boolean split53(int[] nums) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int num : nums) {
            if (num % 3 == 0) b.add(num);
            else a.add(num);
        }
        return split53Helper(0, nums, a, b);
    }
    public boolean split53Helper(int start, int[] nums, List<Integer> a, List<Integer> b) {
        if (start >= nums.length) return identicalSums(a, b);

        ArrayList<Integer> a2 = new ArrayList<>(a);
        ArrayList<Integer> b2 = new ArrayList<>(b);
        int current = nums[start];

        if (current % 5 != 0 && current % 3 != 0) {
            // Only attempt moving current to list b2 if it is not a multiple of 3 or 5
            // since those are required to stay in a particular list.
            if (split53Helper(start + 1, nums, a2, b2)) return true;
            b2.add(a2.remove(a2.indexOf(current)));
        }
        return split53Helper(start + 1, nums, a2, b2);
    }
    // See the identicalSums method from 2 problems back

}
