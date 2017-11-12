import java.io.*;
import java.util.Scanner;

public class findAndSpit{
  public static void main(String[] args) throws IOException{
    String dirName;

    FileInputStream infoFile = new FileInputStream("scarlet.txt");
    Scanner readInfo = new Scanner(infoFile);

    while(readInfo.hasNext()){
      dirName = readInfo.next();

    // replace keyword with the user input
    // We also need to make this non case sensitive
    String user_keyword = "Keyword".toLowerCase();
    int keywordCount = 0;
    double similarity = 0.0;

    // replace "locatedFile" with all listed .txt type file
    FileInputStream txtFile = new FileInputStream(dirName);
    Scanner read = new Scanner(txtFile);

    while(read.hasNext()){
      char[] word_keyword = new char[user_keyword.length()];
      similarity = 0.0;
      String word = read.next().toLowerCase();
      int j = 0;

try{
      for (int i=0;i<word.length();i++){
        if((word.charAt(i) == user_keyword.charAt(0))&&(word.charAt(i+1) == user_keyword.charAt(1))&&(word.charAt(i+2) == user_keyword.charAt(2))){
            j = 0;
          for(int g =i; g<i+user_keyword.length();g++){
             word_keyword[j]= word.charAt(g);
             j++;
          }
        }
      }

      for(int h=0;h<user_keyword.length();h++){
        if(word_keyword[h] == user_keyword.charAt(h)){
          similarity ++;
        }
      }
    }
    catch(StringIndexOutOfBoundsException e){}

      if(similarity/user_keyword.length() == 1.0){
        keywordCount ++;
      }

      }

System.out.println(keywordCount);




    }
  }
  }
