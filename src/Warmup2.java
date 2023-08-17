public class Warmup2 {
    public String stringTimes(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }


    public String frontTimes(String str, int n) {
        String front = str;
        if (str.length() > 3) {
            front = str.substring(0, 3);
        }
        String result = "";
        for (int i = 0; i < n; i++) {
            result += front;
        }
        return result;
    }


    int countXX(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i+2).equals("xx")) {
                count++;
            }
        }
        return count;
    }


    boolean doubleX(String str) {
        int index = str.indexOf("x");
        // If there is no "x" in the string or there is only one at the end, return
        // false straight away
        if (index == -1 || index == str.length() - 1) {
            return false;
        }
        // If there is an "x" in the string in a position other than the end, return
        // the result of checking if the character after the "x" is also an "x"
        return str.charAt(index+1) == 'x';
    }


    public String stringBits(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i += 2) {
            result += str.charAt(i);
        }
        return result;
    }


    public String stringSplosion(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                result += str.charAt(j);
            }
        }
        return result;
    }


    public int last2(String str) {
        if (str.length() < 2) {
            return 0;
        }
        String lastTwo = str.substring(str.length()-2, str.length());
        int count = 0;
        for (int i = 0; i < str.length()-2; i++) {
            if (str.substring(i, i+2).equals(lastTwo)) count++;
        }
        return count;
    }


    public int arrayCount9(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 9) {
                count++;
            }
        }
        return count;
    }


    public boolean arrayFront9(int[] nums) {
        int limit = 4;
        if (nums.length < 4) {
            limit = nums.length;
        }
        for (int i = 0; i < limit; i++) {
            if (nums[i] == 9) {
                return true;
            }
        }
        return false;
    }


    public boolean array123(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 1 && nums[i+1] == 2 && nums[i+2] == 3) {
                return true;
            }
        }

        return false;
    }


    public int stringMatch(String a, String b) {
        int count = 0;
        int length = Math.min(a.length()  , b.length());

        for (int i = 0; i < length - 1; i++) {
            String substring = a.substring(i, i+2);
            if (b.substring(i, i+2).equals(substring)) {
                count++;
            }
        }

        return count;
    }


    public String stringX(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || i == str.length() - 1 || str.charAt(i) != 'x') {
                result += str.charAt(i);
            }
        }
        return result;
    }


    public String altPairs(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i += 4) {
            if (i < str.length()) {
                result += str.substring(i, i+1);
            }
            if (i + 1 < str.length()) {
                result += str.substring(i+1, i+2);
            }
        }
        return result;
    }


    public String stringYak(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 2 && str.charAt(i) == 'y' && str.charAt(i+2) == 'k') {
                i += 2;
            }
            else {
                result += str.charAt(i);
            }
        }
        return result;
    }


    public int array667(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 6 && (nums[i+1] == 6 || nums[i+1] == 7)) {
                count++;
            }
        }
        return count;
    }


    public boolean noTriples(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            int current = nums[i];
            if (current == nums[i+1] && current == nums[i+2]) {
                return false;
            }
        }
        return true;
    }


    public boolean has271(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            int target = nums[i] - 1;
            if (nums[i] + 5 == nums[i+1] && Math.abs(nums[i+2] - target) <= 2) {
                return true;
            }
        }
        return false;
    }


}
