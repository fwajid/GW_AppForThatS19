public class hangman {
  
  // The number of max tries before fail
  public static int MAX_TRIES = 7;
  // Define the graphic that's displayed
  public static String[][] platform = {
      {" "," ", "-", "-", "-", "-", "-", " ", " "},
      {" "," ", "|", " ", "|", " ", " ", " ", " "},
      {" "," ", "|", " ", " ", " ", " ", " ", " "},
      {" "," ", "|", " ", " ", " ", " ", " ", " "},
      {" "," ", "|", " ", " ", " ", " ", " ", " "},
      {" "," ", "|", " ", " ", " ", " ", " ", " "},
      {" "," ", "|", "|", "|", "|", "|", " ", " "},
  };

  // Update the platform and print the hangman!
  public static void printMap(int tries) {
    switch(tries){
      case 1:
        platform[2][4] = "o"; break;
      case 2:
        platform[3][4] = "|"; break;
      case 3:
        platform[3][3] = "/"; break;
      case 4:
        platform[3][5] = "\\"; break;
      case 5:
        platform[4][4] = "|"; break;
      case 6:
        platform[5][3] = "/"; break;
      case 7:
        platform[5][5] = "\\"; break;
      default: System.out.println("It's Game Over Man!"); break;
    }
    for(int i=0; i<platform.length; i++){
      for(int j=0; j<platform.length+1; j++){
        System.out.print(platform[i][j]);
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    for(int i=0; i<=MAX_TRIES; i++){
      printMap(i);
    }
    /* Your Code Here */
    // Hint: Use "contains()"

  }
}
