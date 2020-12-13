import java.util.Arrays;

public class replaceSpace {



    //create a method for the space replacement
    public static void replaceSpaces(char[] str, int trueLength) {
        int numberOfSpaces = countOfChar(str, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;


        //if there are excess spaces, add a null character. This indicates that the spaces after that point have not been replaced with %20.
        if (newIndex + 1 < str.length)
            str[newIndex + 1] = '\0';

        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex = oldIndex - 1){ //oldIndex -= 1
            if(str[oldIndex] == ' ') { //Insert %20
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex = newIndex - 3;

            } else {
                str[newIndex] = str[oldIndex];
                newIndex = newIndex - 1;
            }
        }

    }


    //Count occurrences of target between start (inclusive) and end (exclusive).
    static int countOfChar(char[] str, int start, int end, int target) {
        int count = 0;
        for(int i = start; i < end; i ++) {
            if(str[i] == target) {
                count++;
            }
        }
        return count;
    }


    public  static void main(String[] args) {
        String str = "Mr John Smith  "; //created string and then convert to an array of character
        char[] arr = str.toCharArray();
        int trueLength = countOfChar(arr) + 1;
        replaceSpaces(arr, trueLength);
        System.out.println("\"" + AssortedMethods.char);

    }
}
