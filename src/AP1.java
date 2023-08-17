import java.util.ArrayList;
import java.util.List;

public class AP1 {
    public boolean scoresIncreasing(int[] scores) {
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < scores[i-1]) return false;
        }
        return true;
    }


    public boolean scores100(int[] scores) {
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] == 100 && scores[i-1] == 100) return true;
        }
        return false;
    }


    public boolean scoresClump(int[] scores) {
        for (int i = 0; i <= scores.length - 3; i++) {
            int score1 = scores[i];
            int score2 = scores[i+1];
            int score3 = scores[i+2];
            if (Math.abs(score1 - score2) <= 2 && Math.abs(score2 - score3) <= 2 &&
                    Math.abs(score1 - score3) <= 2) {
                return true;
            }
        }

        return false;
    }


    public int scoresAverage(int[] scores) {
        int halfWay = scores.length / 2;
        int average1 = average(scores, 0, halfWay);
        int average2 = average(scores, halfWay, scores.length);
        return Math.max(average1, average2);
    }
    public int average(int[] scores, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += scores[i];
        }
        return sum / (end - start);
    }


    public int wordsCount(String[] words, int len) {
        int count = 0;
        for (String word : words) {
            if (word.length() == len) count++;
        }
        return count;
    }


    public String[] wordsFront(String[] words, int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = words[i];
        }
        return arr;
    }


    public List wordsWithoutList(String[] words, int len) {
        List<String> list = new ArrayList<String>();
        for (String word : words) {
            if (word.length() != len) list.add(word);
        }
        return list;
    }


    public boolean hasOne(int n) {
        while (n > 9) {
            if (n % 10 == 1) return true;
            n /= 10;
        }

        return n == 1;

        // as a 1 liner
        // return ("" + n).contains("1");
    }


    public boolean dividesSelf(int n) {
        if (("" + n).contains("0")) return false;
        int current = n;
        while (current > 0) { //
            if (n % (current % 10) != 0) return false;
            current /= 10;
        }
        return true;
    }


    public int[] copyEvens(int[] nums, int count) {
        int[] arr = new int[count];
        int numsIndex = 0;
        int arrIndex = 0;
        while (arrIndex < count && numsIndex < nums.length) {
            if (nums[numsIndex] % 2 == 0) {
                arr[arrIndex] = nums[numsIndex];
                arrIndex++;
            }
            numsIndex++;
        }
        return arr;
    }


    public int[] copyEndy(int[] nums, int count) {
        int[] arr = new int[count];
        int numsIndex = 0;
        int arrIndex = 0;

        while (arrIndex < count && numsIndex < nums.length) {
            if (isEndy(nums[numsIndex])) {
                arr[arrIndex] = nums[numsIndex];
                arrIndex++;
            }
            numsIndex++;
        }

        return arr;
    }
    public boolean isEndy(int n) {
        return (n >= 0 && n <= 10) || (n >= 90 && n <= 100);
    }


    public int matchUp(String[] a, String[] b) {
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            String stringA = a[i];
            String stringB = b[i];
            if (!stringA.isEmpty() && !stringB.isEmpty()) {
                if (stringA.charAt(0) == stringB.charAt(0)) count++;
            }
        }

        return count;
    }


    public int scoreUp(String[] key, String[] answers) {
        int score = 0;

        for (int i = 0; i < key.length; i++) {
            String answer = answers[i];
            if (answer.equals("?")) continue;
            if (key[i].equals(answer)) score += 4;
            else score -= 1;
        }

        return score;
    }


    public String[] wordsWithout(String[] words, String target) {
        int count = 0;

        for (String word : words) {
            if (word.equals(target)) count++;
        }

        String[] arr = new String[words.length - count];
        int arrIndex = 0;

        for (String word : words) {
            if (!word.equals(target)) {
                arr[arrIndex] = word;
                arrIndex++;
            }
        }

        return arr;
    }


    public int scoresSpecial(int[] a, int[] b) {
        return largestSpecialScore(a) + largestSpecialScore(b);
    }
    public int largestSpecialScore(int[] a) {
        int largest = 0;
        for (int score : a) {
            if (score % 10 == 0 && score > largest) largest = score;
        }
        return largest;
    }


    public int sumHeights(int[] heights, int start, int end) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += Math.abs(heights[i] - heights[i+1]);
        }

        return sum;
    }


    public int sumHeights2(int[] heights, int start, int end) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            int diff = heights[i+1] - heights[i];
            sum += (diff > 0) ? 2*diff : Math.abs(diff);
        }

        return sum;
    }


    public int bigHeights(int[] heights, int start, int end) {
        int count = 0;

        for (int i = start; i < end; i++) {
            if (Math.abs(heights[i] - heights[i+1]) >= 5) count++;
        }

        return count;
    }


    public int userCompare(String aName, int aId, String bName, int bId) {
        if (aName.compareTo(bName) < 0) return -1;
        if (aName.compareTo(bName) > 0) return 1;
        return Integer.compare(aId, bId);
    }


    public String[] mergeTwo(String[] a, String[] b, int n) {
        String[] arr = new String[n];
        int arrIndex = 0;
        int aIndex = 0;
        int bIndex = 0;
        while (arrIndex < n) {
            int result = a[aIndex].compareTo(b[bIndex]);
            if (result == 0) {
                arr[arrIndex] = a[aIndex];
                // Increment both indices to avoid putting a duplicate in arr
                aIndex++;
                bIndex++;
            }
            else if (result < 0) {
                arr[arrIndex] = a[aIndex];
                aIndex++;
            }
            else {
                arr[arrIndex] = b[bIndex];
                bIndex++;
            }
            arrIndex++;
        }

        return arr;
    }


    public int commonTwo(String[] a, String[] b) {
        int count = 0;
        int indexA = 0;
        int indexB = 0;

        while (indexA < a.length && indexB < b.length) {
            int result = a[indexA].compareTo(b[indexB]);
            if (result == 0) {
                count++;
                String currentA = a[indexA];
                String currentB = b[indexB];
                while (indexA < a.length && a[indexA].equals(currentA)) {
                    indexA++;
                }
                while (indexB < b.length && b[indexB].equals(currentB)) {
                    indexB++;
                }
            }
            else if (result < 0) {
                indexA++;
            }
            else {
                indexB++;
            }
        }

        return count;
    }

}
