import java.util.Date;

public class Minigames {

  public static int guessingGame(){
    //int secretNumber = (int) (Math.random() * 999 + 1);           
    int secretNumber = (int) (Math.random() * 9 + 1);           
    int guess;
    int tries = 0;

    do {
      System.out.print("Enter a guess (1-10): ");
      guess = IO.readInt();

      if (guess == secretNumber){
        System.out.println("Your guess is correct. Congratulations!");
      } else if (guess < secretNumber) {
        System.out.println("Your guess is smaller than the secret number.");
      } else if (guess > secretNumber) {
        System.out.println("Your guess is greater than the secret number.");
      }
      tries++;
    } while (guess != secretNumber);

    return tries;
  }

  public static boolean fightEnemy(String enemy){
    int playerHealth = 100;
    int enemyHealth = 75;
    boolean playerTurn = true;  // True means Player's turn
    System.out.println("You've encountered an enemy "+enemy+"!");
    while(true){
      int attackVal = (int) (Math.random() * 9 + 1);           
      if(playerTurn){
        playerTurn = false;
        playerHealth = playerHealth - attackVal;
        System.out.println("Enemy "+enemy+" attacked you for: "+attackVal+" points!");
      }else{
        playerTurn = true;
        enemyHealth = enemyHealth - attackVal;
        System.out.println("You attacked enemy "+enemy+" for: "+attackVal+" points!");
      }
      System.out.println("Your Health: "+playerHealth + " / 100");
      System.out.println(enemy + " Health: "+enemyHealth + " / 100");

      // Add delay to display updates a little slower; easier to read
      try{
        Thread.sleep(500);
      } catch(InterruptedException e) {
        Thread.currentThread().interrupt();
      }

      if(playerHealth <= 0){
        System.out.println("You died!");
        return false;
      }else if(enemyHealth <= 0){
        System.out.println("You killed enemy "+enemy+"!");
        return true;
      }
    }
    //return false;
  }

}
