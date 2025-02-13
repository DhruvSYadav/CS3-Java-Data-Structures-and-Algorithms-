import java.util.*;
import java.io.File;

/**
 * Write a description of class WordLadder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordLadder
{
    // instance variables - replace the example below with your own
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args) throws Exception
    {
        // put your code here
        File file_input = new File("C:\\Users\\Dhruv\\Downloads\\input.txt");
        Scanner input = new Scanner(file_input);
        File file_dict = new File("C:\\Users\\Dhruv\\Downloads\\dictionary.txt");
        Scanner dictionary = new Scanner(file_dict);
        
        String beginWord = input.next();
        String endWord = input.next();
        Queue <String> beginWords = new LinkedList<String>();
        HashSet<String> set = new HashSet<>();
        Stack<String> stack = new Stack<String> ();
        stack.add(beginWord);
        while(dictionary.hasNext()){
            set.add(dictionary.next().toLowerCase());       
        }

        for(int i =0; i<beginWord.length(); i++){
            char[] word_chars = beginWord.toCharArray();
            
            for(char ch = 'a'; ch <= 'z'; ch++){
                word_chars[i] = ch;
                String new_word = String.valueOf(word_chars);
                if(set.contains(new_word)){
                    stack.add(new_word);
                    set.remove(new_word);
                    set.remove(beginWord);
                    
                }
            
            }
        
        }
        System.out.println(stack);
    
    
        
        
    }
}
