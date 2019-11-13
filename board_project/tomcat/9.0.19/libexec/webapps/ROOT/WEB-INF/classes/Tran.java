package simpleChain;

import java.util.List;

public class Tran {
	public String sender;
	public String recipient;
	public int amount;
	public List<Tran> trans;
	
	public Tran(String sender, String recipient, int amount) {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<Tran> getTrans() {
		return trans;
	}

	public void setTrans(List<Tran> trans) {
		this.trans = trans;
	}
}
