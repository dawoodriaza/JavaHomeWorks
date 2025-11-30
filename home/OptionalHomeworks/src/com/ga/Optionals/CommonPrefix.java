package com.ga.Optionals;

public class CommonPrefix {

    public static String longestCommonPrefix(String[] words) {
    if (words.length == 0){
         return "";
         };

        String common = words[0];  
        StringBuilder prefix = new StringBuilder();

   
        for (int i = 0; i < common.length(); i++) {

            char c = common.charAt(i);

          
            for (int j = 1; j < words.length; j++) {

          
                if (i >= words[j].length() || words[j].charAt(i) != c) {
                    return prefix.toString();
                }
            }

        
            prefix.append(c);
        }

        return prefix.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); 
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"})); 
    }
}