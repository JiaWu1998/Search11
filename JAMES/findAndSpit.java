import java.io.*;
import java.util.Scanner;

public class findAndSpit{
  public static void main(String[] args) throws IOException{
    String dirName;
    int length = 0 ;

    FileInputStream infoFile = new FileInputStream("/Users/James/Documents/GitHub/Search11/JAMES/dirPage.txt");
    Scanner readInfo = new Scanner(infoFile);


    while(readInfo.hasNextLine()){
      dirName = readInfo.nextLine();





    // replace keyword with the user input
    // We also need to make this non case sensitive
    String user_keyword = "world".toLowerCase();
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

      try{
      FileOutputStream keywordStat = new FileOutputStream("keywordStatFile.txt",true);
      PrintWriter write = new PrintWriter(keywordStat);
      write.println(keywordCount);
      write.flush();
      keywordStat.close();
      }
      catch(FileNotFoundException e){
        FileOutputStream keywordStat = new FileOutputStream("keywordStatFile.txt");
        PrintWriter write = new PrintWriter(keywordStat);
        write.println(keywordCount);
        write.flush();
        keywordStat.close();
      }
        length ++;
    }
    compareAndReturn(length);

}
  public static void compareAndReturn(int len) throws IOException{
      FileInputStream readFile = new FileInputStream("keywordStatFile.txt");
      Scanner read = new Scanner(readFile);

      int indexofFirst = 0;
      int indexofSecond = 0;
      int indexofThird = 0;
      int indexofFourth = 0;
      int indexofFifth = 0;

      int[] keyCountArray = new int[len];
      int largest = 0;

      for(int i=0; i<len; i++){
        keyCountArray[i] = read.nextInt();
      }
      for(int g=0; g<len; g++){
        if(largest<keyCountArray[g]){
          largest = keyCountArray[g];
          indexofFirst = g;
        }
      }
      largest = 0;
      for(int g=0; g<len; g++){
        if((largest<keyCountArray[g])&&(g != indexofFirst)){
          largest = keyCountArray[g];
          indexofSecond = g;
        }
      }
      largest = 0;
      for(int g=0; g<len; g++){
        if((largest<keyCountArray[g])&&(g != indexofFirst)&&(g != indexofSecond)){
          largest = keyCountArray[g];
          indexofThird = g;
        }
      }
      largest = 0;
      for(int g=0; g<len; g++){
        if((largest<keyCountArray[g])&&(g != indexofFirst)&&(g != indexofSecond)&&(g != indexofThird)){
          largest = keyCountArray[g];
          indexofFourth = g;
        }
      }
      largest = 0;
      for(int g=0; g<len; g++){
        if((largest<keyCountArray[g])&&(g != indexofFirst)&&(g != indexofSecond)&&(g != indexofThird)&&(g != indexofFourth)){
          largest = keyCountArray[g];
          indexofFifth = g;
        }
      }
      System.out.println("indexofFirst =" + indexofFirst);
      System.out.println("indexofSecond =" + indexofSecond);
      System.out.println("indexofThird =" + indexofThird);
      System.out.println("indexofFourth =" + indexofFourth);
      System.out.println("indexofFifth =" + indexofFifth);

      FileInputStream infoFile = new FileInputStream("/Users/James/Documents/GitHub/Search11/JAMES/dirPage.txt");
      Scanner pop = new Scanner(infoFile);
      String filter = "";
      String firstDir = "";
      String secondDir = "";
      String thirdDir = "";
      String fourthDir = "";
      String fifthDir = "";
      int h = 0;

      String[] dirs = new String[len];

      while(pop.hasNextLine()){
        dirs[h] = pop.nextLine();
        h++;
      }

      for(int i=0;i<len; i++){
        if (i == indexofFirst){
          firstDir = dirs[i];
        }
        if (i == indexofSecond){
          secondDir = dirs[i];
        }
        if (i == indexofThird){
          thirdDir = dirs[i];
        }
        if (i == indexofFourth){
          fourthDir = dirs[i];
        }
        if (i == indexofFifth){
          fifthDir = dirs[i];
        }
      }


      System.out.println(firstDir);
      System.out.println(secondDir);
      System.out.println(thirdDir);
      System.out.println(fourthDir);
      System.out.println(fifthDir);

      String[] finishDir = {firstDir,secondDir,thirdDir,fourthDir,fifthDir}; 

  }

  }
