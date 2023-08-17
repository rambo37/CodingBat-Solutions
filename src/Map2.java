import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Map2 {
    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            map.put(string, 0);
        }
        return map;
    }


    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            map.put(string, string.length());
        }
        return map;
    }


    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String string : strings) {
            map.put(string.substring(0, 1), string.substring(string.length() - 1));
        }
        return map;
    }


    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            }
            else {
                map.put(string, map.get(string) + 1);
            }
        }
        return map;
    }


    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String string : strings) {
            String first = string.substring(0, 1);
            if (!map.containsKey(string.substring(0, 1))) {
                map.put(first, string);
            }
            else {
                map.put(first, map.get(first) + string);
            }
        }
        return map;
    }


    public String wordAppend(String[] strings) {
        String result = "";
        Map<String, Integer> map = new HashMap<>();

        for (String string : strings) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            }
            else {
                map.put(string, map.get(string) + 1);
            }

            if (map.get(string) % 2 == 0) {
                result += string;
            }
        }

        return result;
    }


    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String s : strings) {
            if (map.containsKey(s)) {
                map.put(s, true);
            }
            else {
                map.put(s, false);
            }
        }
        return map;
    }


    public String[] allSwap(String[] strings) {
        // Map each index to a Boolean that indicates whether that index has already
        // been involved in a swap.
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            // The index is mapped to false initially to indicate it has not been swapped
            map.put(i, false);
            // Stop j when it's 1 short of i, so we do not compare the same string to itself
            for (int j = 0; j <= i - 1; j++) {
                // Only do the swap if both indices have not already been swapped and the
                // two Strings match. Update the map entries for the indices after the swap.
                if (!map.get(i) && !map.get(j) && match(strings[i], strings[j])) {
                    String stringJ = strings[j];
                    strings[j] = strings[i];
                    strings[i] = stringJ;
                    map.put(i, true);
                    map.put(j, true);
                }
            }
        }

        return strings;
    }
    // This helper method is used in both the allSwap and firstSwap problems
    public boolean match(String x, String y) {
        return (!x.isEmpty() && !y.isEmpty() && x.charAt(0) == y.charAt(0));
    }


    public String[] firstSwap(String[] strings) {
        // Map each index to a Boolean that indicates whether that index has already
        // been involved in a swap.
        Map<Integer, Boolean> map = new HashMap<>();
        // ArrayList of all Characters that have already been used in a swap, so they
        // are not used more than once.
        ArrayList<Character> swapped = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            // The index is mapped to false initially to indicate it has not been swapped
            map.put(i, false);
            for (int j = 0; j <= i - 1; j++) {
                // Only do the swap if both indices have not already been swapped, the
                // two Strings match, and we have not already swapped on this character
                if (!map.get(i) && !map.get(j) && match(strings[i], strings[j]) &&
                        !swapped.contains(strings[i].charAt(0))) {
                    String stringJ = strings[j];
                    strings[j] = strings[i];
                    strings[i] = stringJ;
                    // Update the map entries for the indices after the swap.
                    map.put(i, true);
                    map.put(j, true);
                    // Add the first character of one of these Strings to the swapped list,
                    // so we do not use it again
                    swapped.add(strings[i].charAt(0));
                }
            }
        }

        return strings;
    }
}
