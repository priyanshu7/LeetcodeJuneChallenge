package june2020;

public class ReverseString {
	public void reverseString(char[] s) {
        int n = s.length;
        int i = 0, j = s.length - 1;
        while(i < n/2){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

}
