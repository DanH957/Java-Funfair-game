import java.io.Serializable;


@SuppressWarnings("serial")
public class PlayerInvoice implements Serializable {
public String name;
public int AmountSpent;
public String SpentDate;

/** This is the code for creating invoice objects, ready to be written to file **/
public void setname(String PName){
	name = PName;
}


public void setAmount(int getspent) {
	AmountSpent = getspent;
	
}




public void SetDate(String format) {
	SpentDate = format;
	
}


public String getname() {
	return name;
	
}


public int getSpent() {
	
	return AmountSpent;
}


public String getDate() {
	
	return SpentDate;
}



}
