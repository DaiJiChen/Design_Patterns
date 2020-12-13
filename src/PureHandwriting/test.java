package PureHandwriting;

import java.util.*;

class test {
    public static String getKey(String s) {
        int k = s.charAt(0) - 'a';
        char[] chars= s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            chars[i] = (char)((chars[i] - 'a' - k + 26) % 26 + 'a');
        }

        return String.valueOf(chars);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Set<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if(map.containsKey(key)) {
                map.get(key).add(s);
            }
            else {
                Set<String> set = new HashSet<>();
                set.add(s);

                map.put(key, set);
                System.out.println(map.get(key).size());
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()) {
            List<String> list = new ArrayList<>();
            for(String s: map.get(key)) {
                System.out.println(s);
                list.add(s);
            }
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getKey("baz"));
    }
}