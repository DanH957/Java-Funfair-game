
public class Funrooms {
/** this class is responsible for building/creating the fun rooms, including how they connect to eachother, and items
 **/
	
	
	private Room enterance;
	public Room CreateFunfair(){
		
		
		/** Start room (reception): **/
		Room r1 = new Room();
		r1.setname("Reception");
		r1.setDesc("North leads to room 3.");
		
		Room r2 = new Room();
		r2.setname("Room 2");
		r2.setDesc("North leads to room 5. \n" +
		           "East leads to room 3.");
		Item fork = new Item("fork", 9, 10);
		Item spoon = new Item("spoon", 9, 10);
		Item knife = new Item("knife", 9, 10);
		r2.setitems(fork, spoon, knife);
		
		Room r3 = new Room();
		r3.setname("Room 3");
		r3.setDesc("North leads to room 6. \n" +
				   "East leads to room 4. \n" +
				   "West leads to room 2.");
		Item shovel = new Item("shovel", 10, 10);
		Item rake = new Item("rake", 15, 10);
		Item mower = new Item("mower", 30, 10);
		r3.setitems(shovel, rake, mower);
		
		Room r4 = new Room();
		r4.setname("Room 4");
		r4.setDesc("North leads to room 7. \n" +
		           "West leads to room 3.");
		Item bat = new Item("bat", 10, 10);
		Item baseball = new Item("baseball", 10, 10);
		Item glove = new Item("glove", 10, 10);
		r4.setitems(bat, baseball, glove);
		
		Room r5 = new Room();
		r5.setname("Room 5");
		r5.setDesc("North leads to room 8. \n" +
				   "East leads to room 6. \n" +
				   "South leads to room 2.");
		Item book = new Item("book", 50, 10);
		Item pencil = new Item("pencil", 10, 10);
		Item pen = new Item("pen", 10, 10);
		r5.setitems(book, pencil, pen);
		
		Room r6 = new Room();
		r6.setname("Room 6");
		r6.setDesc("North leads to room 9. \n" +
				   "East leads to room 7. \n" +
				   "South leads to room 3. \n" +
				   "West leads to room 5"  );
		Item laptop = new Item("laptop", 100, 10);
		Item mouse = new Item("mouse", 10, 10);
		Item keyboard = new Item("keyboard", 40, 10);
		r6.setitems(laptop, mouse, keyboard);
		
		Room r7 = new Room();
		r7.setname("Room 7");
		r7.setDesc("North leads to room 10. \n" +
				   "South leads to room 4. \n" +
				   "West leads to room 6.");
		Item drink = new Item("drink", 5, 10);
		Item sandwich = new Item("sandwich", 13, 10);
		Item snack = new Item("snack", 10, 10);
		r7.setitems(drink, sandwich, snack);
		
		Room r8 = new Room();
		r8.setname("Room 8");
		r8.setDesc("East leads to room 9. \n" +
		           "South leads to room 5.");
		Item melon = new Item("melon", 10, 10);
		Item apple = new Item("apple", 10, 10);
		Item orange = new Item("orange", 10, 10);
		r8.setitems(melon, apple, orange);
		
		Room r9 = new Room();
		r9.setname("Room 9");
		r9.setDesc("North leads to EXIT. \n" +
				   "East leads to room 10. \n" +
				   "South leads to room 6. \n" +
				   "West leads to room 8"  );
		Item duck = new Item("shovel", 70, 10);
		Item sheep = new Item("rake", 20, 10);
		Item cow = new Item("mover", 50, 10);
		r9.setitems(duck, sheep, cow);
		
		Room r10 = new Room();
		r10.setname("Room 10");
		r10.setDesc("South leads to room 7. \n" +
		           "West leads to room 9.");
		Item shirt = new Item("shirt",7, 10);
		Item jumper = new Item("Jumper", 10, 10);
		Item shoes = new Item("Shoes", 4, 10);
		r10.setitems(shirt, jumper, shoes);
	
		Room Exit = new Room();
		Exit.setname("EXIT");
		Exit.setDesc("");
		
		/** The following list of code connects the rooms together **/
		r1.setSide(0,r3);
		r2.setSide(0,r5);
		r2.setSide(1,r3);
		r3.setSide(0,r6);
		r3.setSide(1,r4);
		r3.setSide(3,r2);
		r4.setSide(0,r7);		
		r4.setSide(3,r3);
		r5.setSide(0,r8);
		r5.setSide(1,r6);
		r5.setSide(2,r2);
		r6.setSide(0,r9);
		r6.setSide(1,r7);
		r6.setSide(2,r3);
		r6.setSide(3,r5);
		r7.setSide(0,r10);
		r7.setSide(2,r4);
		r7.setSide(3,r6);
		r8.setSide(1,r9);
		r8.setSide(2,r5);
		r9.setSide(0,Exit);
		r9.setSide(1,r10);
		r9.setSide(2,r6);
		r9.setSide(3,r9);
		r10.setSide(2,r7);
		r10.setSide(3,r9);
		Exit.setSide(2, r9);
		
		
		enterance = r1;
	
		return enterance;
		
	}}
	
	
	
	


