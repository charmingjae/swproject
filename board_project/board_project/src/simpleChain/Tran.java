package simpleChain;

import java.util.List;

public class Tran {
	public static String sender;
	public static String recipient;
	public static String amount;
	public static List<Tran> trans;
	
	

	
//	public Tran(String sender, String recipient, String amount) {
//		Tran.sender = sender;
//		Tran.recipient = recipient;
//		Tran.amount = amount;
//	}
	public Tran(String sender, String recipient, String amount) {
		this.sender = sender;
		this.recipient = recipient;
		this.amount = amount;
	}
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		Tran.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		Tran.recipient = recipient;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		Tran.amount = amount;
	}

	public List<Tran> getTrans() {
		return trans;
	}

	public void setTrans(List<Tran> trans) {
		Tran.trans = trans;
	}
}
