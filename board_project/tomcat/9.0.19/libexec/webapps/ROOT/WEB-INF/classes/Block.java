package simpleChain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import java.util.HashMap;


public class Block {
//	transactions.add();
	public int index;
	public String hash;
	public String previousHash; 
	private String data; //our data will be a simple message.
//	Tran transactions = new Tran();
	
	
	public List<Tran> trans = new ArrayList<Tran>(); // Tran class 내에 있는 요소들을 list로 저장.
	
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	private int nonce;
//	private String[] cvt_newTransactions; //시도해 보는 것
//	private String sender = "차민재";
//	private String recipient = "정상원";
	
//	Gson gson = new Gson();
//	String json = gson.toJson(obj);
	
	
	//Block Constructor.
	public Block(int index, String data, String previousHash, String sender, String recipient, int amount) {
		this.index = index + 1;
		this.data = data;
		
		trans.add(new Tran(sender,recipient, amount));
		
//		transactions.sender = sender;
//		transactions.recipient = recipient;
//		transactions.amount = amount;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
		
	}
	
//	//Block Constructor.
//		public Block(int index, String[] cvt_newTransactions,String previousHash ) {
//			this.index = index;
//			this.cvt_newTransactions = cvt_newTransactions;
//			this.previousHash = previousHash;
//			this.timeStamp = new Date().getTime();
//			this.hash = calculateHash(); //Making sure we do this after we set the other values.
//		}

	
	//Calculate new hash based on blocks contents
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(nonce) + 
				data 
				);
		return calculatedhash;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("블록 채굴 완료 [ 해쉬 값 ] : " + hash + "\n");
	}
}