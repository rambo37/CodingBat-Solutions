import java.util.ArrayList;

public class String2 {
    public String doubleChar(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.substring(i, i+1);
            result += str.substring(i, i+1);
        }
        return result;
    }


    public int countHi(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i+2).equals("hi")) count++;
        }
        return count;
    }


    public boolean catDog(String str) {
        return countOccurrences(str, "cat") == countOccurrences(str, "dog");
    }
    public int countOccurrences(String str, String substring) {
        // limit is the final index at which the substring could possibly occur
        int limit = str.length() - substring.length();
        int count = 0;
        for (int i = 0; i <= limit; i++) {
            if (str.substring(i, i+substring.length()).equals(substring)) count++;
        }
        return count;
    }


    public int countCode(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.substring(i, i+2).equals("co") && str.charAt(i + 3) == 'e') count++;
        }
        return count;
    }


    public boolean endOther(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        a = a.toLowerCase();
        b = b.toLowerCase();

        if (lengthA >= lengthB) {
            return a.endsWith(b); // return a.substring(lengthA - lengthB).equals(b);
        }

        return b.endsWith(a); // return b.substring(lengthB- lengthA).equals(a);
    }


    public boolean xyzThere(String str) {
        if (str.length() < 3) return false;
        if (str.startsWith("xyz")) return true;

        for (int i = 1; i < str.length() - 2; i++) {
            if (str.startsWith("xyz", i) && str.charAt(i-1) != '.') {
                // don't need to worry about charAt(i-1) being undefined since we start
                // from i = 1. Can do this due to the second if statement at the top
                // which catches the case where the string starts with "xyz"
                return true;
            }
        }

        return false;
    }


    public boolean bobThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i+2) == 'b') return true;
        }
        return false;
    }


    public boolean xyBalance(String str) {
        if (str.contains("x") && !str.contains("y")) return false;

        int lastX = 0;
        int lastY = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') lastX = i;
            else if (str.charAt(i) == 'y') lastY = i;
        }

        return lastX <= lastY;
    }


    public String mixString(String a, String b) {
        StringBuilder result = new StringBuilder();
        boolean aTurn = true;
        while (a.length() > 0 && b.length() > 0) {
            if (aTurn) {
                result.append(a.charAt(0));
                a = a.substring(1);
                aTurn = false;
            }
            else {
                result.append(b.charAt(0));
                b = b.substring(1);
                aTurn = true;
            }
        }

        result.append(a);
        result.append(b);

        return result.toString();
    }


    public String repeatEnd(String str, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(str.substring(str.length() - n));
        }
        return result.toString();
    }


    public String repeatFront(String str, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int size = n - i;
            result.append(str.substring(0, size));
        }
        return result.toString();
    }


    public String repeatSeparator(String word, String sep, int count) {
        if (count == 0) return "";
        StringBuilder result = new StringBuilder(word);
        for (int i = 0; i < count - 1; i++) {
            result.append(sep).append(word);
        }
        return result.toString();
    }


    public boolean prefixAgain(String str, int n) {
        String substring = str.substring(0, n);
        return str.substring(n).contains(substring);
    }


    public boolean xyzMiddle(String str) {
        int length = str.length();

        for (int i = 0; i < length - 2; i++) {
            if (str.substring(i, i+3).equals("xyz")) {
                int charsBefore = i; // number of chars before the xyz
                int charsAfter = length - (i+3); // number of chars after the xyz
                // return true if the difference is 0 or 1
                if (Math.abs(charsAfter - charsBefore) <= 1) return true;
            }
        }

        return false;
    }


    public String getSandwich(String str) {
        int beginIndex = str.indexOf("bread");
        if (beginIndex == -1) return "";
        int lastIndex = str.lastIndexOf("bread");
        if (beginIndex == lastIndex) return "";
        return str.substring(beginIndex + 5, lastIndex);
    }


    public boolean sameStarChar(String str) {
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*') {
                if (str.charAt(i-1) != str.charAt(i+1)) {
                    return false;
                }
            }
        }
        return true;
    }


    public String oneTwo(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length() - 2; i += 3) {
            result.append(str.substring(i + 1, i + 3)).append(str.charAt(i));
        }
        return result.toString();
    }


    public String zipZap(String str) {
        if (str.length() < 3) return str;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            result.append(str.charAt(i));
            if (str.charAt(i) == 'z' && i+2 < str.length() && str.charAt(i+2) == 'p') {
                i++; // Skip the next char since it is between a 'z' and a 'p'
            }
        }
        return result.toString();
    }


    public String starOut(String str) {
        String str2 = "0" + str + "0";
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < str2.length() - 1; i++) {
            // Cannot include the current char in the result if it is a star
            if (str2.charAt(i) == '*') continue;
            // Cannot include the current char in the result if it is preceded by a star
            if (str2.charAt(i - 1) == '*') continue;
            // Cannot include the current char in the result if it is followed by a star
            if (str2.charAt(i + 1) == '*') continue;
            // If we reach here, it is safe to add the current char to the result
            result.append(str2.charAt(i));
        }
        return result.toString();
    }


    public String plusOut(String str, String word) {
        int length = word.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i <= str.length() - length) {
                if (str.substring(i, i+length).equals(word)) {
                    result.append(word);
                    i += length-1; // length - 1 rather than length due to the i++ of the loop
                    continue;
                }
            }
            result.append("+");
        }
        return result.toString();
    }


    public String wordEnds(String str, String word) {
        ArrayList<Integer> indices = new ArrayList<>();
        int length = word.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= str.length() - length; i++) {
            if (str.substring(i, i+length).equals(word)) {
                indices.add(i);
                i += length-1;
            }
        }

        // index stores the index of the word
        for (Integer index: indices) {
            // Append the char before the word
            // Check that there is a previous char
            if (index > 0) {
                result.append(str.charAt(index - 1));
            }
            // Append the char after the word
            // check that there is room for at least one char after the word
            if (index + length < str.length()) {
                result.append(str.charAt(index + length));
            }
        }

        return result.toString();
    }

}
