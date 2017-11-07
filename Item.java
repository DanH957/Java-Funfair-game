
public class Item {
	/** This is the Item class **/
	public String name;
	public int price;
    public int amount = 1;
	public Item(String itemname, int itemprice, int itemamount) {
		name = itemname;
		price = itemprice;
		amount = itemamount;		
	}

	

	public String getname() {
		return name;
	}

	public int getamount() {
		return amount;
	}

	public void subtractamount() {
		amount = amount - 1 ;
		
	}



	public void addamount() {
		amount = amount + 1;
		
	}



	public int getprice() {
		
		return price;
	}

}
