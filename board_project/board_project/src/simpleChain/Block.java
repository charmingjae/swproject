package simpleChain;

import java.util.Date;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.*;

import com.google.gson.Gson;

import java.util.HashMap;



public class Block extends PublicChain {
	private static final String String = null;
//	transactions.add();
	public int index;
	public String hash;
	public String previousHash; 
	private String data; //our data will be a simple message.
	
	public String sender;
	public String recipient;
	public String amount;
	
	public String sender2;
	public String recipient2;
	public String amount2;

//	Tran tranTest = new Tran(sender2, recipient2, amount2);
	
	HashMap<String,String> map = new HashMap<>();////// 11/26 append
	
	public List<Tran> trans = new ArrayList<Tran>(); // Tran class 내에 있는 요소들을 list로 저장.
	public List<HashMap<String,String>> transTest = new ArrayList<HashMap<String, String>>(); // Tran class 내에 있는 요소들을 list로 저장.
	public int[] chain = null;
	
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	private int nonce;
//	private String[] cvt_newTransactions; //시도해 보는 것
//	private String sender = "차민재";
//	private String recipient = "정상원";
	
//	Gson gson = new Gson();
//	String json = gson.toJson(obj);
	
	
	Tran tranTest = new Tran(sender, recipient, amount);
	List<Map<String,String>> list = new ArrayList<Map<String, String>>();

	
	
//	Block Constructor.
	public Block(int index, String data, String previousHash, String sender, String recipient, String amount) {
		
		this.index = index + 1;
		this.data = data;
//		trans.add(new Tran(sender, recipient, amount));
//		transactions.sender = sender;
//		transactions.recipient = recipient;
//		transactions.amount = amount;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
	
	
	Map<String,String> map2 = new HashMap<String, String>();////// 11/26 append
	public List<Map<String, String>> newTran(String sender, String recipient, String amount) {

		
		
		
		this.tranTest.setSender(sender);
		this.tranTest.setRecipient(recipient);
		this.tranTest.setAmount(amount);
		
		this.map2.put("sender", tranTest.getSender());
		this.map2.put("recipient", tranTest.getRecipient());
		this.map2.put("amount", tranTest.getAmount());
		
		
		
		list.add(map2);
		
//		for(HashMap<String,String> m : transTest)
//		{
//			System.out.println(m.get("sender"));
//			System.out.println(m.get("recipient"));
//			System.out.println(m.get("amount"));
//		}
		
		System.out.println(list);
		return list;
	}
	
	public List<Map<String, String>> getTran(){
		return list;
	}
	
	
	public int last_block() {
		return chain.length;
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