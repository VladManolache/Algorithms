package algorithms.sequences;
 

/**
 * Reverse the words in a sentence—i.e., “My name is Chris” becomes “Chris is
 * name My. Optimize for time and space.
 * 
 * @author Vlad Manolache
 */
public class ReverseWords {
  
    
    /**
     * Method that reverses words in a char array by copying words from the initial
     * array to a second array starting with the end of the second array.
     * @param phrase - input char array
     * @return reversed phrase
     */
    public char[] reverseWords1(char[] phrase) {
        int n = phrase.length;
        char[] reversedPhrase = new char[n];
        
        int i = 0, j = 0, k;
        while (i < n) { 
            if (j == n || phrase[j] == ' ') {  // First check if j == n to avoid crash.
                for (k = i; k < j; ++k) {  
                    reversedPhrase[n - j + k - i] = phrase[k];  // n - (j - k) - i
                }  
                
                if (j == n) {
                    i = j; 
                }
                else { 
                    reversedPhrase[n - j - 1] = ' ';
                    i = ++j;
                } 
            } 
            ++j; 
        } 
        
        return reversedPhrase;
    }
    
    /**
     * Method that reverses words in a char array by 
     * 1) Reversing the entire array.
     * 2) Reversing each word in the array.
     * @param phrase - input char array
     * @return reversed phrase
     */
    public char[] reverseWords2(char[] phrase) {
        int n = phrase.length;  
        
        reverse(phrase, 0, n);
        
        int i = 0, j = 0;
        while (i < n) {
            if (j == n || phrase[j] == ' ') {
                reverse(phrase, i, j);
                
                if (j == n) {
                    i = j; 
                }
                else {  
                    i = ++j;
                } 
            }
            ++j;
        }
        
        return phrase;
    }
    
    /**
     * Reverse characters in the char array. 
     * This method compensates for the case that i is not the start of the array.
     * @param phrase - input phrase
     * @param i - start position
     * @param j - end position
     */
    public void reverse(char[] phrase, int i, int j) {
        char aux;  
        int totalCount = (j - i) / 2;
        int count = 0;
        for (int k = i; k < j && count < totalCount; ++k, ++count) {
            aux = phrase[j-k+i-1];
            phrase[j-k+i-1] = phrase[k];
            phrase[k] = aux;
        } 
    }
}
