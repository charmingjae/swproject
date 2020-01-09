package simpleChain;

import java.util.Date;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.*;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Iterator;



public class Block {
	private static final String String = null;
//	transactions.add();
	public int index;
	public String hash;
	public String previousHash;
	private String data; //our data will be a simple message.
	
	public String sender;
	public String recipient;
	public String amount;

	


	
	public int[] chain = null;
	
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	private int nonce;
	
//	public List<Tran> trans = new ArrayList<Tran>(); // Tran class 내에 있는 요소들을 list로 저장.
	
	public List<Object> transSender = new ArrayList<Object>();
	
	Map<String, String> mapTrans = new HashMap<>();
	
	
	// 01. 09 BACKUP.!!!!!!!!!!!!!!!
	
	
//	Block Constructor.
//	public Block(int index, String data, String previousHash, String sender, String recipient, String amount) {
//		this.index = index + 1;
//		this.data = data;
//		
//		mapTrans.put("sender",sender);
//		mapTrans.put("recipient",recipient);
//		mapTrans.put("amount",amount);
//		
//		
//		
////		trans.add(new Tran(sender, recipient, amount));
//		
//		transSender.add(mapTrans); //// 12/30 MAP을 리스트에 추가하는 작업 수행
//		
//		
//		mapTrans = new HashMap<>();
//		mapTrans.put("sender","halo");
//		mapTrans.put("recipient","sap");
//		mapTrans.put("amount","55");
//		
//		transSender.add(mapTrans);
//		
//		
//		this.sender = sender;
//		this.recipient = recipient;
//		this.amount = amount;
//		
//		Iterator iterator = transSender.iterator();
//		
//		while(iterator.hasNext()) {
////			this.mapTrans = (Map<String, String>)transSender.get(0);
//			this.mapTrans = (Map<String, String>)iterator.next();
//			
//		}
//		
//		
//		this.previousHash = previousHash;
//		this.timeStamp = new Date().getTime();
//		this.hash = calculateHash(); //Making sure we do this after we set the other values.
//	}

	
	
	
	public Block(int index, String data, String previousHash, List<Object> transactions, Map<String, String> mapTrans) {
		this.index = index + 1;
		this.data = data;
		
		
		
		this.sender = sender;
		this.recipient = recipient;
		this.amount = amount;
		
//		Iterator iterator = transSender.iterator();
		this.transSender = transactions;
		this.mapTrans = mapTrans;
		
		
		
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
	
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