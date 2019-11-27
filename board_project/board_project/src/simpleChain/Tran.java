package simpleChain;

import java.util.List;

public class Tran {
	public static String sender;
	public static String recipient;
	public static String amount;
	public static List<Tran> trans;
	
	

	
	public Tran(String sender, String recipient, String amount) {
		this.sender = sender;
		this.recipient = recipient;
		this.amount = amount;
	}
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public List<Tran> getTrans() {
		return trans;
	}

	public void setTrans(List<Tran> trans) {
		this.trans = trans;
	}
}
