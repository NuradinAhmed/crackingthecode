/**
 *  Question: Given two strings, write a method to decide if one is a permutation of the other.

    Questions to ask the interviwer:
    1: Permutations mean - rearrangement of characters in a set and then comparing it if the same exact characters exist.
        A: Do whitespaces significant - in the sense that they if one has whitespace and the other does not then its not permutation of eachother
        B: Do case sensitives important - ex. abcd is not the same as bcdA. b/c a is capital.
        C: Also strings of different lengths cannot be permutations of each other.

    @: Two ways to solve this:
        1: Sort algorithm. Sort the strings and then compare the sorted versions of the strings.

 */

public class CheckPermutation {

    //This is our sort method
    static String sort(String s) {

        //create an arry of character char. and toCharArry method which returns the unicode character of the string passed into
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    //now we are gong to write our permutation method which takes in two strings s and t
    static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    //Above is used for sorting algorithm and below would use an array


    static  boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false; //Permutations must be on the same length
        }

        int[] letters = new int[128]; //Assuming we are using the ASCII character only up to 128 characters
        for(int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for(int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if(letters[t.charAt(i)] < 0) {
                return  false;
            }
        }

        return true; //letters has no negative values, and therefore no positive values either

    }









    //our main method and should be able to run our permutation method here
    public static void main(String[] args) {
        System.out.println(permutation2("abcd23*45", "dbca5423*"));

    }

}