public class Game {

  /* Method to print the map, and update with new player location.
   * px = x position
   * py = y position
   * showMap = display the map or not
   */
  public static String printMap(int px, int py, boolean showMap){
    // Map Legend (dimensions: 10 by 10)
    // # : lake
    // ^ : trap
    // $ : prize
    String[][] map = {
      {" | "," - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " | "},
      {" | "," $ ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " | "},
      {" | "," - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " | "},
      {" | "," - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " | "},
      {" | "," - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " | "},
      {" | "," - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " | "},
      {" | "," - ", " # ", " # ", " - ", " - ", " - ", " - ", " - ", " | "},
      {" | "," # ", " # ", " # ", " - ", " - ", " - ", " ^ ", " ^ ", " | "},
      {" | "," # ", " # ", " # ", " - ", " - ", " - ", " ^ ", " ^ ", " | "},
      {" | "," - ", " - ", " - ", " - ", " - ", " - ", " - ", " ^ ", " | "}
    };

    // Store the map length for later use
    int m = map.length;

    // Shift (x,y) to cartesian coords
    py = py + (m/2);
    px = px + (m/2);

    // Store the symbol at the desired location
    String s = map[py][px];

    // If no issues, update the map with new position
    map[py][px] = " o ";
    
    // Show map if requested (method param)
    if(showMap == true){
      for(int i = 0; i < m; i++){
        for(int j = 0; j < m; j++){
          System.out.print(map[i][j]);
        }
        System.out.println();
      }
    }

    // Return the symbol found at desired location
    return s;
  }

  public static void main(String[] args){
    // (x,y) of the player
    int pos_x = 0;
    int pos_y = 0;

    System.out.println("Welcome to ______, a weird place.");
    System.out.println("A strange wizard at the local market place");
    System.out.println("gave you this map. You only know that the");
    System.out.println("# means LAKE, ^ means TRAP. What could $ be?");
    System.out.println("");
    
    while(true)
    {
      printMap(pos_x, pos_y, true);
      System.out.println("You can go: {up, down, left, right}");
      String input = IO.readString();
      if(input.equalsIgnoreCase("up")){
        pos_y--;
      }else if(input.equalsIgnoreCase("down")){
        pos_y++;
      }else if(input.equalsIgnoreCase("right")){
        pos_x++;
      }else if(input.equalsIgnoreCase("left")){
        pos_x--;
      }
      if(printMap(pos_x, pos_y, false).equals(" # ")){
        System.out.println("You fell into the lake!");
        System.out.println("Game Over!");
        return;
      }
    }

  }
}

