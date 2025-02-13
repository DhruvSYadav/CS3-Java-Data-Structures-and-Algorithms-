import java.util.*;
import java.io.*;
public class BoggleSolver
{
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
    HashSet<String> dict;
    public BoggleSolver(String dictionaryName)
    {
        //TODO
        try{
      Scanner s = new Scanner(new File(dictionaryName));
      dict = new HashSet<>();
      while(s.hasNextLine()) {
        dict.add(s.nextLine());
      }
    } catch(Exception ex) {
      System.out.println(dictionaryName);
    }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable object
    public Iterable<String> getAllValidWords(BoggleBoard board)
    {
        HashSet<String> ans = new HashSet<String>(); 
        for(int i = 0; i < board.rows(); i++){
            for(int j = 0; j < board.cols(); j++){
                return allValidWordsHelper(board,i,j,"");
            }
        }
            

        return null;
    }
    
    public Iterable<String> allValidWordsHelper(BoggleBoard board, int row, int col, String begin)
    {
        String foundWords = "";
        if (row < 0 || row >= board.rows() || col < 0 || col >= board.cols()) 
        { 
            return null;
        }
        if(board.getLetter(row,col)=='Q')
        {
            begin+="Qu";
        }
        else
        {
            begin+=board.getLetter(row,col);
        }
        
        allValidWordsHelper(board,row+1, col, begin);
        allValidWordsHelper(board,row-1, col, begin);
        allValidWordsHelper(board,row, col+1, begin);
        allValidWordsHelper(board,row, col-1, begin);
        
        if(dict.contains(begin))
        {
            foundWords += begin;
        }
        return foundWords;
    }
    

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A - Z.)
    public int scoreOf(String word)
    {
        //TODO
        int score = word.length();
    if(score < 3){
        return 0;
    }
    if(score < 5){
        return 1;
    }
    if(score == 5){
        return 2;
    }
    if(score == 6){
        return 3;
    }
    if(score == 7){
        return 5;
    }
    return 11;

    }

    public static void main(String[] args) {
        System.out.println("WORKING");

        final String PATH   = "./data/";
        BoggleBoard  board  = new BoggleBoard(PATH + "board-q.txt");
        BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");

        int totalPoints = 0;

        for (String s : solver.getAllValidWords(board)) {
            System.out.println(s + ", points = " + solver.scoreOf(s));
            totalPoints += solver.scoreOf(s);
        }

        System.out.println("Score = " + totalPoints); //should print 84

        //new BoggleGame(4, 4);
    }

}
