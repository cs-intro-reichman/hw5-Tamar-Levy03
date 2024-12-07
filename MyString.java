/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        System.out.println(randomStringOfLetters(5));
        System.out.println(lowerCase("HELLO"));
        System.out.println(equals("hello", "hello"));
        System.out.println(equalsIgnoreCase("hello", "HeLlo"));
        System.out.println(isContain("runi", "running"));
        System.out.println(isContain("runi", "rnnt"));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        //// Replace the following statement with your code
        int counter = 0;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ch) {
                counter++;
            }
        }
        return counter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
         //// Replace the following statement with your code
         if (str1.isEmpty()) {
            return true;
         }
         if (str1.length() > str2.length()) {
            return false;
         }
        boolean ifsub = false;
        for(int i = 0; i < str2.length()-str1.length() + 1; i++){
                ifsub = true;
                for(int j = 1; j<str1.length(); j++)
                {
                    if (str1.charAt(j) != str2.charAt(i+j)) {
                        ifsub = false;
                        break;
                    }
                }
                if (ifsub) {
                    return true;
                }
        }
        return false;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        //// Replace the following statement with your code
        if (str == "") {
            return str;
        }
        String newStr = "";
        for(int i = 0; i < str.length() - 1 ; i++){
            newStr += str.charAt(i) + " ";
        }
        newStr = newStr + str.charAt(str.length()-1);
        return newStr;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        //// Replace the following statement with your code
        double random = Math.random()*26;
        String str = "";
        for(int i = 0; i < n; i++){
            str = str + (char)(97 + ((int)random));
            random = Math.random()*26;
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
       //// Replace the following statement with your code
       String newStr = "";
       boolean found = false;
       if (str2 == "") {
        return str1;
       }
       for (int i = 0; i < str2.length(); i++){
        for(int j = 0; j < str1.length(); j++){
            if (str2.charAt(i) == str1.charAt(j) && !found) {
                found = true;
            }
            else{
                newStr += str1.charAt(j);
            }
        }
        str1 = newStr;
        newStr = "";
        found = false;
    }
    return str1;
    }


    // funcation that gets 2 string and return true if they equals
    public static Boolean equals(String str1, String str2){
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        for(int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // funcation that get a string and return him with only lower case letter
    public static String lowerCase(String str){
        String newStr = "";
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) > 64 && str.charAt(i) < 91) {
                newStr += (char)(str.charAt(i)+ 32);
            }
            else{
                newStr += str.charAt(i);
            }
        }
        return newStr;
    }


    // funcation that gets 2 string and return true if thet equals without considerd if they have lower case or upper case letters
    public static Boolean equalsIgnoreCase(String str1, String str2){
        str1 = lowerCase(str1);
        str2 = lowerCase(str2);
        if (equals(str1, str2)) {
            return true;
        }
        return false;
    }


    //funcation that gets 2 string and chech if all the letters of the first one is in the other (not necessarliy in a sequence)
    public static boolean isContain(String str1, String str2){
        if (subsetOf(str1, str2)) {
            return true;
        }
        boolean found = false;
        for(int i = 0; i < str1.length(); i++){
            found = false;
            for(int j = 0; j < str2.length(); j++){
                if (str1.charAt(i) == str2.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
