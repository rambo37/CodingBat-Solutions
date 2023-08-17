public class String3 {
    public int countYZ(String str) {
        int count = 0;
        str = str.toLowerCase();
        str += ".";
        // extend the string with a character that ends a word so if the string ends
        // with a word ending in y or z, it is included in the count

        for (int i = 1; i < str.length(); i++) {
            // We have a new word if the current char is not a letter
            if (!Character.isLetter(str.charAt(i))) {
                if (str.charAt(i-1) == 'y' || str.charAt(i-1) == 'z') {
                    count++;
                }
            }
        }

        return count;
    }


    public String withoutString(String base, String remove) {
        remove = remove.toLowerCase();
        if (!base.toLowerCase().contains(remove)) return base;

        boolean finished = false;
        int length = remove.length();

        while (!finished) {
            int index = base.toLowerCase().indexOf(remove);
            base = base.substring(0, index) + base.substring(index+length);
            finished = !base.toLowerCase().contains(remove);
        }

        return base;
    }


    public boolean equalIsNot(String str) {
        return numOccurrences(str, "is") == numOccurrences(str, "not");
    }

    public int numOccurrences(String str, String substr) {
        int count = 0;
        int strLength = str.length();
        int substrLength = substr.length();

        for (int i = 0; i <= strLength - substrLength; i++) {
            if (str.substring(i, i+substrLength).equals(substr)) {
                count++;
                i += (substrLength-1);
            }
        }

        return count;
    }


    public boolean gHappy(String str) {
        // Extend the string with characters that are not 'g' at the beginning and at
        // the end
        str = "x" + str + "x";
        // Iterate only over the original part of the string. Thanks to the appending
        // of some dummy characters, there will be no index out of bounds issues.
        for (int i = 1; i < str.length()-1; i++) {
            if (str.charAt(i) == 'g') {
                if (str.charAt(i+1) != 'g' && str.charAt(i-1) != 'g') return false;
            }
        }
        return true;
    }


    public int countTriple(String str) {
        int count = 0;

        for (int i = 0; i <= str.length() - 3; i++) {
            char char1 = str.charAt(i);
            char char2 = str.charAt(i+1);
            char char3 = str.charAt(i+2);
            if (char1 == char2 && char1 == char3) {
                count++;
                // increment i additionally here if overlaps are not to be counted, i.e., i+=2;
            }
        }
        return count;
    }


    public int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (Character.isDigit(current)) {
                sum += Integer.parseInt(str.substring(i, i+1));
            }
        }
        return sum;
    }


    public String sameEnds(String string) {
        int length = string.length();
        int halfLength = length / 2;

        // Split the string into two halves of equal length. If there are an odd
        // number of chars, the middle char is excluded.
        String s1 = string.substring(0, halfLength);
        String s2;
        if (length % 2 == 0) {
            s2 = string.substring(halfLength);
        }
        else {
            s2 = string.substring(halfLength + 1);
        }

        while (!s1.isEmpty()) {
            if (s1.equals(s2)) return s1;
            s2 = s2.substring(1);
            s1 = s1.substring(0, s1.length()-1);
        }

        return "";
    }


    public String mirrorEnds(String string) {
        StringBuilder reversedStr = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            reversedStr.insert(0, string.charAt(i));
        }

        if (string.equals(reversedStr.toString())) return string;


        StringBuilder result = new StringBuilder();
        int begin = 0;
        int end = string.length()-1;
        boolean finished = false;

        while (begin != end && !finished) {
            if (string.charAt(begin) == string.charAt(end)) {
                result.append(string.charAt(begin));
                begin++;
                end--;
            }
            else {
                finished = true;
            }
        }

        return result.toString();
    }


    public int maxBlock(String str) {
        int length = str.length();
        if (length <= 1) return length;

        int max = 1; // length of the largest block
        int current = 1; // length of the current block
        char blockChar = str.charAt(0); // the char in the current block
        // Start from index 1 since we already processed index 0
        for (int i = 1; i < length; i++) {
            if (str.charAt(i) == blockChar) {
                // Continuation of the current block
                current++;
                if (current > max) max = current;
            }
            else {
                // Beginning of a new block
                current = 1;
                blockChar = str.charAt(i);
            }
        }
        return max;
    }


    public int sumNumbers(String str) {
        int sum = 0;
        StringBuilder current = new StringBuilder();
        // Extend the string with a non-digit char to avoid the need for special
        // treatment of strings ending with a digit
        str += "a";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                current.append(str.charAt(i));
            }
            else {
                // Since the current char is not a string, add whatever the current number
                // is to the total and reset current
                if (current.length() > 0) {
                    sum += Integer.parseInt(current.toString());
                    current = new StringBuilder();
                }
            }
        }

        return sum;
    }


    public String notReplace(String str) {
        str = "1" + str + "11";
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= str.length(); i++) {
            String s = str.substring(i, i+2);
            char before = str.charAt(i-1);
            char after = str.charAt(i+2);
            if (s.equals("is") && !Character.isLetter(before) && !Character.isLetter(after)) {
                result.append("is not");
                i++; // Increment i additionally to avoid iterating over the "s" of the "is"
            }
            else {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }
}
