// 76. Minimum Window Substring
// Hard
// 14.6K
// 621
// Companies
// Given two strings s and t of lengths m and n respectively, return the minimum window 
// substring
//  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

 

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// Example 3:

// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
 

// Constraints:

// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.
 




package Strings;

public class maximumWindowSubstring {

    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        int count = t.length();
        int arr[] = new int[128];
        int l=0;
        String ans = s + "a";
        int min = Integer.MAX_VALUE;
        for(int i=0; i<t.length(); i++){
            arr[t.charAt(i)]++;
        }       

        for(int r = 0; r<s.length(); r++){
            if(arr[s.charAt(r)]-- > 0) count--;

            if(count == 0){
                int len = r-l + 1;
                while(arr[s.charAt(l++)]++ != 0);
                count++;
                ans = ans.length() > r-l+1 ? s.substring(l-1, r+1) : ans;
                // ans = s.substring(l-1, r+1);
                // System.out.println(ans);

            }
        }

        return l==0? "" : ans;

    }
    
}
