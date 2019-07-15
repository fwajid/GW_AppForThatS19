import java.util.Date;

class Player {

	private String player;
	private int pos_x, pos_y;
	private int gold;
	private String[] inventory;
	private int inventoryCounter;

	public Player(String p){
		this.player = p;
		this.gold = 0;
		this.inventory = new String[4];
		this.inventoryCounter = 0;
	}

	public void setPosition(int y, int x, int mapDim){
    // Starting at the middle of the map,
    // adjusted to follow Cartesian coords
		this.pos_y = y + (mapDim/2);
		this.pos_x = x + (mapDim/2);
	}

	public String getPlayer(){
		return this.player;
	}

	public void addToInventory(String e){
		if(inventoryCounter == this.inventory.length){
			System.out.println("Your inventory is full!");
			return;
		}

		for(int i=0; i<this.inventory.length; i++){
			if(this.inventory[i] != null){
				if(this.inventory[i].equals(e)){
					System.out.println("You already have this item!");
					return;
				}
			}
		}

		inventory[inventoryCounter] = e;
		inventoryCounter++;
	}

	public void getInventory(){
		System.out.println("Your Inventory:");
		for(int i=0; i<this.inventory.length; i++){
			if(this.inventory[i] != null){
				System.out.print(this.inventory[i]+" , ");
			}
		}
		System.out.println();
	}

	/* Position Getters/Setters */
	public int get_Y()			{ return this.pos_y; }
	public int get_X()			{ return this.pos_x; }
	public void set_Y(int y){ this.pos_y = y; }
	public void set_X(int x){ this.pos_x = x; }
  public void set_Y_up()	{ this.pos_y++; }
  public void set_Y_down(){ this.pos_y--; }
  public void set_X_up()	{ this.pos_x++; }
  public void set_X_down(){ this.pos_x--; }

}

public class GameObjects {
  
  private Player player;
  private int mapDim;
  private String MAP_NAME;
  private String[][] map;

  public GameObjects(String p, int y, int x){

    /* Define Map and Location */
    this.map = Maps.get_map_field();
    this.mapDim = map.length;
    this.MAP_NAME = "FIELDS";

    /* Define Player Attributes */
    this.player = new Player(p);
		this.player.setPosition(y, x, this.mapDim);
  }

  public String getMapSymbol(){
		int y = this.player.get_Y();
		int x = this.player.get_X();
    return this.map[y][x];
  }

  public void printMap(){
		int pos_y = this.player.get_Y();
		int pos_x = this.player.get_X();
		String player = this.player.getPlayer();
    for(int i = 0; i < this.mapDim; i++){
      for(int j = 0; j < this.mapDim; j++){
        if ( i == pos_y && j == pos_x ){
          System.out.print(" "+player+" ");
        }else{
          System.out.print(this.map[i][j]);
        }
      }
      System.out.println();
    }
  }

  public void updateMap(){
		int pos_y = this.player.get_Y();
		int pos_x = this.player.get_X();
    if(this.getMapSymbol().equals(" c ")){
      if(this.MAP_NAME.equals("FIELDS")){
        System.out.println("You've entered THE CAVE.");
        this.MAP_NAME = "CAVE";
        this.map = Maps.get_map_cave();
        //this.pos_y = 1 + (this.mapDim/2);
        //this.pos_x = 3 + (this.mapDim/2);
      }else if(this.MAP_NAME.equals("CAVE")){
        System.out.println("You've entered THE FIELDS.");
        this.MAP_NAME = "FIELDS";
        this.map = Maps.get_map_field();
        //this.pos_y = 0 + (this.mapDim/2);
        //this.pos_x = 0 + (this.mapDim/2);
      }
    }

		if(this.getMapSymbol().equals(" S ")){
			System.out.println("You've entered THE FIELDS.");
			this.MAP_NAME = "FIELDS";
			this.map = Maps.get_map_field();
			this.player.set_Y(6);
			this.player.set_X(6);
		}

    if(this.getMapSymbol().equals(" % ")){
        System.out.println("You have entered THE FOREST.");
        this.MAP_NAME = "FOREST";
        this.map = Maps.get_map_forest();
        this.player.set_Y(0 + (this.mapDim/2));
        this.player.set_X(4 + (this.mapDim/2));
    }
    if(this.getMapSymbol().equals(" 8 ")){
        System.out.println("You have entered THE MAZE.");
        this.MAP_NAME = "MAZE";
        this.map = Maps.get_map_maze();
        this.player.set_Y(0);
        this.player.set_X(1);
    }

    if(this.getMapSymbol().equals(" + ")){
        System.out.println("You found a Sword!");
				this.player.addToInventory("Sword");
				this.player.getInventory();
    }

  }

  /* Setters for positional updates */
  public void updatePosition(String input){
    System.out.print("\033[H\033[2J");
    if(input.equalsIgnoreCase("up") 
      || input.equals("u")
      || input.equals("W")){
      this.player.set_Y_down();
      if(this.getMapSymbol().equals(" * ")){
        System.out.println("You bumped into a wall.");
        this.player.set_Y_up();
      }
    }else if(input.equalsIgnoreCase("down") 
      || input.equals("d")
      || input.equals("S")){
      this.player.set_Y_up();
      if(this.getMapSymbol().equals(" * ")){
        System.out.println("You bumped into a wall.");
        this.player.set_Y_down();
      }
    }else if(input.equalsIgnoreCase("right")
      || input.equals("d")
      || input.equals("D")){
      this.player.set_X_up();
      if(this.getMapSymbol().equals(" * ")){
        System.out.println("You bumped into a wall.");
        this.player.set_X_down();
      }
    }else if(input.equalsIgnoreCase("left")
      || input.equalsIgnoreCase("l")
      || input.equals("A")){
      this.player.set_X_down();
      if(this.getMapSymbol().equals(" * ")){
        System.out.println("You bumped into a wall.");
        this.player.set_X_up();
      }
    }
    System.out.println("Y: "+this.player.get_Y()+" and X: "+this.player.get_X());
  }

  public static void main(String[] args){
    GameObjects g = new GameObjects("o", 0, 0);
    while(true) {
      g.printMap();
      System.out.println("You can go: {up, down, left, right}");
      String input = IO.readString();
      g.updatePosition(input);

      /* Trigger events based on map location */
      String mapSymbol = g.getMapSymbol();
      switch(mapSymbol){
        case " c ":
          g.updateMap();
          break;
        case " % ":
          g.updateMap();
          break;
        case " 8 ":
          g.updateMap();
          break;
        case " # ":
          System.out.println("You fell into the lake!");
          System.out.println("Game Over!");
          return;
				case " + ":
					g.updateMap();
					break;
				case " S ":
					g.updateMap();
					break;
        case " W ":
          int tries = Minigames.guessingGame();
          if( tries >= 10 ){
            System.out.println("You're a loser!");
            return;
          }
					break;
        case "(^)":
          boolean result = Minigames.fightEnemy("troll");
          if(result != true){
            System.out.println("Game Over!");
            return;
          }
          break;
        default:
          break;
      } // end case
      
    }   // end while
  }     // end main
}       // end class

  
