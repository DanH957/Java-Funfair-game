import java.util.ArrayList;
import java.util.List;


public class Room implements Funfair {
	
	private String name;
	
	private String exitlist;
	
	private Funfair[] side = new Funfair[4];
 
	
	
	
	private List<Item> itemlist = new ArrayList<Item>();
	
	Room(){
		side[0] = new Wall();
		side[1] = new Wall();
		side[2] = new Wall();
		side[3] = new Wall();
	}
	
	public void setDesc(String d){
	    exitlist = d;
	    }
	
	public String getDesc(){
		return exitlist;
	}
	
	public void setSide(int direction, Funfair m){
		side[direction] = m;
	}
	
	public void setname(String n){
		name = n;
	}
	
	public String getname(){
		return name;
	}
	
	public void enter(Player p){
		p.setLoc(this);
		System.out.printf("You are now in: %s\n", (p.getLoc().getname()));
	}
	
	public void exit(int direction, Player p){
		   side[direction].enter(p);
		   }
	
	public Boolean checkitem(String a){
		Boolean Clear = false;
		for (int i = 0; i < itemlist.size(); i++){
			
			
		if (a.contentEquals(itemlist.get(i).getname())){
			Clear = true;}
		}
		return Clear;
	}
	public void setitems(Item a, Item b, Item c){
		itemlist.add(a);
		itemlist.add(b);
		itemlist.add(c);
				
	}

	public Item getitemname(String a) {
		
		Item item = null;
		for (int i = 0; i < itemlist.size(); i++){
			if (itemlist.get(i).getname().contains(a))
				item = itemlist.get(i);
			}
		return item;
}

	public void removeitem(String a) {
	
		for (int i = 0; i < itemlist.size(); i++){
			
			if (itemlist.get(i).getname().contains(a))
				itemlist.get(i).subtractamount();
			
	}
	}

	public String Listitems(String list) {
		list = "Avaliable items in this room:\n ";
		for (int i = 0; i < itemlist.size(); i++){
			if (itemlist.get(i).getamount() > 0)
			list = list + itemlist.get(i).getname() +", Price :" + itemlist.get(i).getamount() + "\n";
		}
		return list;
	}

	public List<Item> getlist() {
		return itemlist;
		
	}
}
