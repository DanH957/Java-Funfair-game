
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Game {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 Date date = new Date();
	public Player CurrentUser;
    public static void main(String[] args)
		throws IOException{
			System.out.println("Welcome to the funfair game,\n"
			+ "By Daniel Hyde\n");
			
			
			Game TheGame = new Game();
			TheGame.Startgame();
	}
			
          
	/**This method starts the 'game **/
	public void Startgame()throws IOException{
		Funrooms Main = new Funrooms();
		Room StartRM = Main.CreateFunfair();
	
		
		Scanner input = new Scanner(System.in);
		 List<Player> playerlist = new ArrayList<Player>();
			System.out.println("Welcome User, please enter a name:");
			String username = input.nextLine();
			System.out.println("You have been given 100 currency to spend\n");
			playerlist.add(new Player());
			
			
		CurrentUser = playerlist.get(0);
		CurrentUser.setname(username);
		CurrentUser.setEnt(StartRM);
		
		
		
		
		BufferedReader keyboard
		  = new BufferedReader(new InputStreamReader(System.in));
		String inputString = "prepare";
		int direction = 9;
		
		
		
		
		/** User is now offically in the funfair **/
		
		 System.out.printf( "Welcome %s", CurrentUser.getname() +
				            "\nWhich way (North, East, South ,West), \n" +
				            "Or type HELP for a list of avaliable Commands \n");
		 while(CurrentUser != null){
		 inputString = keyboard.readLine();
		/** List all commands in the system **/
		  if (inputString.equalsIgnoreCase("HELP"))
				  System.out.println("USE THE COMMANDS: NORTH, EAST, SOUTH ,WEST to travel between rooms. \n " +
						             "VIEW EXITS  - List which rooms you can currently travel to. \n"  + 
		                             "TAKE itemname  - Take the specified item and add it to your cart if it is avaliable. \n" +
						             "LIST CART   - View the items currently in your cart. \n" +
		                             "EDIT CART   - Delete any items from your cart. \n" +
		                             "LIST PLAYERS - Lists the users in the funfair, and which rooms they are in" +
		                             "ENTER username - Enter the funfair as a new/existing user \n" +
		                             "LIST ITEMS - List the items avaliable in the room\n" +
		                             "ENTER username - Enter as a new user of control another existing one\n" +
		                             "CHECK ROOM - list the users in the current room \n" );
		  
		  else if (inputString.equalsIgnoreCase("NORTH")){
			  direction = convertDirection(inputString);
			  CurrentUser.go(direction, CurrentUser);
			  if(CurrentUser.getLoc().equals("EXIT")){
				  
			  }
		  }
		  
		  /** Directions for travelling rooms **/
		  else if (inputString.equalsIgnoreCase("EAST")){
			  direction = convertDirection(inputString);
			  CurrentUser.go(direction, CurrentUser);}
		  
		  else if (inputString.equalsIgnoreCase("SOUTH")){
			  direction = convertDirection(inputString);
			  CurrentUser.go(direction, CurrentUser);}
	       
		  else if (inputString.equalsIgnoreCase("WEST")){
			  direction = convertDirection(inputString);
			  CurrentUser.go(direction, CurrentUser);}
	       
		  
		  /** viewing exits to a room **/
		  else if (inputString.equals("VIEW EXITS"))
			  System.out.printf("%s\n", (CurrentUser.getLoc()).getDesc());
		  
		  else if (inputString.contains("TAKE")){ /**Take an item from a room **/
			  Item I;
			  Boolean Itemcheck;
			  inputString = inputString.replace("TAKE ", "");
			  Itemcheck = (CurrentUser.getLoc()).checkitem(inputString);
			  if (Itemcheck == true){
				  CurrentUser.getLoc().removeitem(inputString);
				  
			    I =  (CurrentUser.getLoc()).getitemname(inputString);
			    CurrentUser.Additem(I);
			  System.out.printf("item added \n");
			  CurrentUser.setSpentmoney(I.getamount());
			  }
			    else
			    	System.out.printf("Item not avaliable to purchase\n");
			    	
			       
		  } /** listing current users in the funfair **/
		  else if (inputString.equalsIgnoreCase("LIST PLAYERS")){
			  String list = "";
			  for (int i = 0; i < playerlist.size(); i++){
				  list = list + "User: " + playerlist.get(i).getname() + " is in " + playerlist.get(i).getLoc().getname() + "\n";
			  }
			  System.out.printf("%s\n", list);
		  }
		  /** Check for users in the same room as you **/
		  else if (inputString.equalsIgnoreCase("CHECK ROOM")){
			  String list = "Users in this room: \n";
			  for (int i = 0; i < playerlist.size(); i++){
				  if(playerlist.get(i).getLoc().equals(CurrentUser.getLoc()))
				  list = list + playerlist.get(i).getname() + "\n";
			  }
			  System.out.printf("%s\n", list);
		  }
		  
		  /**list items in current room **/
		  else if (inputString.equalsIgnoreCase("LIST ITEMS")){
			  String list = "";
					 list = list +  CurrentUser.getLoc().Listitems(list);
					 System.out.printf("%s\n", list);
		  }
		  
		  
		  /** list the items in the current users inventory **/
		  else if (inputString.equalsIgnoreCase("LIST CART"))
			  CurrentUser.listitems();
		 
		 
		  else if (inputString.equalsIgnoreCase("EDIT CART")){
			 String a = null;
			 CurrentUser.listitems();
			 System.out.printf("Enter the item name you want to remove:\n");
			                   
			
			 a = keyboard.readLine();
			 CurrentUser.removeitem(a);
			 System.out.printf("Item Removed\n");
		 } 
		  
		 else if (inputString.contains("ENTER")){ /*Changes the user of the fun fair */
			 
			  int num = 0;
			  Boolean a = false;
			  inputString = inputString.replace("ENTER ", "");
			  for (int i = 0; i < playerlist.size(); i++){
				  if (playerlist.get(i).getname().contains(inputString)){
					  CurrentUser = playerlist.get(i);
					  System.out.printf( "Welcome %s\n", CurrentUser.getname() +
					            "Which way (North, East, South ,West), \n" +
					            "Or type HELP for a list of avaliable Commands \n");
				  a = true;}
				 num = num + i;
			  }
			  if (a == false){
				  num = num + 1;;
				  playerlist.add(new Player());
				  playerlist.get(num).setname(inputString);
				  playerlist.get(num).setmoney(10);
				  
				  CurrentUser = playerlist.get(num);
				  CurrentUser.setEnt(StartRM);}
			  System.out.printf( "Welcome %s\n", CurrentUser.getname() + "\n" +
			            "Which way (North, East, South ,West), \n" +
			            "Or type HELP for a list of avaliable Commands \n");
			  
			  
		 }
		 
		  /** This code is for displaying previous invoices, but is not fully functioning, so i have commented out the code **/
		 else if (inputString.equalsIgnoreCase("LIST PREVIOUS")){
			 /** FileWrite Display = new FileWrite(); 
			 Display.getInvoice(CurrentUser); **/
		 }
		  
		  if (CurrentUser.getLoc().getname().contains("EXIT")){ /**If the user is in the EXIT room **/
			  if (CurrentUser.getspent() < CurrentUser.getmoney())
			  {
			  FileOutput Output = new FileOutput();
			  PlayerInvoice Invoice = new PlayerInvoice();
			  CurrentUser.setLoc(StartRM);
			  Invoice.setname(CurrentUser.getname());
				Invoice.setAmount(CurrentUser.getspent());
				Invoice.SetDate(dateFormat.format(date));
			  Output.openfile();
			  Output.AddInvoice(Invoice);
			  Output.closefile();
			  CurrentUser = null;
			  }
			  else{ /**User cannot afford all of the items in cart **/
				  System.out.printf("You cannot afford the items you are carrying\n");
				  
				CurrentUser.go(2, CurrentUser); /** User goes back a room **/

		 } }  }
	
		 if (CurrentUser == null){
				backtostart();
			}
		  
	  }
	
		
		  
	  private void backtostart() throws IOException {
		Startgame();
	}



	private int convertDirection(String input){ /** This converts the text direction into numbers, so it's easier for the system to read**/
		   int theDirection = 9999;
		  if(input.equalsIgnoreCase("NORTH"))
			  theDirection = 0;
		  else if(input.equalsIgnoreCase("EAST"))
			  theDirection = 1;
		  else if(input.equalsIgnoreCase("SOUTH"))
			  theDirection = 2;
		  else if(input.equalsIgnoreCase("WEST"))
			  theDirection = 3;  
		  return theDirection;
	  }
	  


	public Player getcurrentuser() {
		return CurrentUser;
		
	}
	
	
		
	} 



