import java.util.ArrayList;
import java.util.List;
/** This is the player class **/
public class Player {
public String name;
public int money = 100;
public Item[] inventory = new Item[10]; 
public Room myloc;
public Boolean out = false;
private List<Item> itemlist = new ArrayList<Item>();
public int Spentmoney = 0;

public void setname(String d){
name = d;
}

public String getname(){
	return name;
}

public Boolean getout(){
	return out;
}

public void setLoc(Room r){myloc = r;}


public void go(int direction, Player p){
    myloc.exit(direction,p);
}
public void setEnt(Room r){
	   myloc = r;
	   }
public Room getLoc(){return myloc;}

public void Additem(Item i) {
	itemlist.add(i);
	
}

public void listitems() {
	String Text = "You currently have: ";
	for (int i = 0; i < itemlist.size(); i++){
		Text = Text + itemlist.get(i).getname() + ", ";
	}
	System.out.printf("%s\n", Text);
}

public void removeitem(String a) {
	
	for (int i = 0; i < itemlist.size(); i++){
		if (itemlist.get(i).getname().contains(a)){
			int x = itemlist.get(i).getprice();
			deductprice(x);
		itemlist.remove(i);
		
	} }
}
private void deductprice(int item) {
    Spentmoney = Spentmoney - item;
}

public void setmoney(int m){
	money = m;
}

public void setSpentmoney(int getamount) {
	Spentmoney = Spentmoney + getamount;
	
}





public int getspent() {
	return Spentmoney;
	
}

public int getmoney() {
	return money;
}

 }


