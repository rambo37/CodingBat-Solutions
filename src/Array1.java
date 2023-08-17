public class Array1 {
    public boolean firstLast6(int[] nums) {
        return nums[0] == 6 || nums[nums.length - 1] == 6;
    }


    public boolean sameFirstLast(int[] nums) {
        return nums.length >= 1 && nums[0] == nums[nums.length - 1];
    }


    public int[] makePi() {
        return new int[]{3, 1, 4};
    }


    public boolean commonEnd(int[] a, int[] b) {
        return a[0] == b[0] || a[a.length - 1] == b[b.length - 1];
    }


    public int sum3(int[] nums) {
        return nums[0] + nums[1] + nums[2];
    }


    public int[] rotateLeft3(int[] nums) {
        return new int[]{nums[1], nums[2], nums[0]};
    }


    public int[] reverse3(int[] nums) {
        return new int[]{nums[2], nums[1], nums[0]};
    }


    public int[] maxEnd3(int[] nums) {
        int max = Math.max(nums[0], nums[2]);
        return new int[]{max, max, max};
    }


    public int sum2(int[] nums) {
        int result = 0;
        int limit = Math.min(nums.length, 2);
        for (int i = 0; i < limit; i++) {
            result += nums[i];
        }
        return result;
    }


    public int[] middleWay(int[] a, int[] b) {
        return new int[]{a[1], b[1]};
    }


    public int[] makeEnds(int[] nums) {
        return new int[]{nums[0], nums[nums.length - 1]};
    }


    public boolean has23(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2 || nums[i] == 3) return true;
        }
        return false;
    }


    public boolean no23(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2 || nums[i] == 3) return false;
        }
        return true;
    }


    public int[] makeLast(int[] nums) {
        int[] a = new int[nums.length * 2];
        a[a.length - 1] = nums[nums.length - 1];
        return a;
    }


    public boolean double23(int[] nums) {
        int twoCount = 0;
        int threeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) twoCount++;
            if (nums[i] == 3) threeCount++;
        }

        return twoCount == 2 || threeCount == 2;
    }


    public int[] fix23(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i+1] == 3) {
                nums[i+1] = 0;
            }
        }
        return nums;
    }


    public int start1(int[] a, int[] b) {
        int result = 0;
        if (a.length >= 1 && a[0] == 1) {
            result++;
        }
        if (b.length >= 1 && b[0] == 1) {
            result++;
        }
        return result;
    }


    public int[] biggerTwo(int[] a, int[] b) {
        int sumA = a[0] + a[1];
        int sumB = b[0] + b[1];
        if (sumA >= sumB) return a;
        return b;
    }


    public int[] makeMiddle(int[] nums) {
        return new int[] {nums[nums.length / 2 - 1], nums[nums.length / 2]};
    }


    public int[] plusTwo(int[] a, int[] b) {
        return new int[] {a[0], a[1], b[0], b[1]};
    }


    public int[] swapEnds(int[] nums) {
        int first = nums[0];
        nums[0] = nums[nums.length - 1];
        nums[nums.length - 1] = first;
        return nums;
    }


    public int[] midThree(int[] nums) {
        return new int[]{nums[nums.length/2 - 1], nums[nums.length/2], nums[nums.length/2 + 1]};
    }


    public int maxTriple(int[] nums) {
        int first = nums[0];
        int last = nums[nums.length - 1];
        int middle = nums[nums.length / 2];

        return Math.max(Math.max(first, last), middle);
    }


    public int[] frontPiece(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        if (nums.length == 1) {
            return new int[] {nums[0]};
        }
        return new int[] {nums[0], nums[1]};
    }


    public boolean unlucky1(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        if (nums[0] == 1 && nums[1] == 3) {
            return true;
        }
        if (nums.length >= 3 && nums[1] == 1 && nums[2] == 3) {
            return true;
        }
        return nums[nums.length-2] == 1 && nums[nums.length-1] == 3;
    }


    public int[] make2(int[] a, int[] b) {
        int[] c = new int[2];

        if (a.length >= 1) {
            c[0] = a[0];
        }
        else {
            c[0] = b[0];
            c[1] = b[1];
        }

        if (a.length >= 2) {
            c[1] = a[1];
        }

        if (a.length == 1) {
            c[1] = b[0];
        }

        return c;
    }


    public int[] front11(int[] a, int[] b) {
        if (a.length != 0 && b.length != 0) {
            return new int[] {a[0], b[0]};
        }

        if (a.length == 0 && b.length != 0) {
            return new int[] {b[0]};
        }

        if (a.length != 0) {
            return new int[] {a[0]};
        }

        return new int[0];
    }
}
