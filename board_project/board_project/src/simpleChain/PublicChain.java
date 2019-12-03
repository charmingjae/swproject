package simpleChain;

import java.io.PrintStream;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.GsonBuilder;
import simpleChain.Tran.*;
import simpleChain.*;
import simpleChain.Block;

public class PublicChain {
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	
	public List<Tran> trans = new ArrayList<Tran>(); // Tran class 내에 있는 요소들을 list로 저장.
	
	
	
	public static int difficulty = 5;
	
	public String sender = "";
	public String recipient = "";
	public String amount = "";
	
	public String sender2;
	public String recipient2;
	public String amount2;
	
	Tran tranTest = new Tran(sender, recipient, amount);
	
	HashMap<String,String> map = new HashMap<>();////// 11/26 append
	
	
//	Map<String,Tran> map2 = new HashMap<String, Tran>();////// 11/26 append
//	List<Map<String, Tran>> list = new ArrayList<Map<String, Tran>>();
	
//	Map<Tran,String> map2 = new HashMap<Tran, String>();////// 11/26 append
//	List<Map<Tran, String>> list = new ArrayList<Map<Tran, String>>();
	
	
//	Map<String,String> map2 = new HashMap<String, String>();////// 11/26 append
	
	///////////////////////// USE //////////////////////////
//	List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	
	
	
	

	
	
//	public List<HashMap<String,String>> transTest = new ArrayList<>(); // Tran class 내에 있는 요소들을 list로 저장.
	public int[] chain = null;
	///
	
//	public String sender2="";
//	public String recipient2="";
//	public String amount2="";
	
	///
//	public List<Tran> trans = new ArrayList<Tran>();
	public int index = 0;
	
	
	Map<String,String> map2;
//	Map<String,String> map2 = new HashMap<String, String>();////// 11/26 append
//	List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	List<Map<String,String>> list = new ArrayList<Map<String, String>>();
	

//	public List<Map<String, String>> newTran(String sender, String recipient, String amount) {
//		map2 = new HashMap<String, String>();////// 11/26 append
//		
//		
//		tranTest.setSender(sender);
//		tranTest.setRecipient(recipient);
//		tranTest.setAmount(amount);
//
//		
//		map2.put("sender", tranTest.getSender());
//		map2.put("recipient", tranTest.getRecipient());
//		map2.put("amount", tranTest.getAmount());
//
//		
//		list.add(map2);
//		
//		map2 = new HashMap<String, String>();////// 11/26 append
//		
//		
//		tranTest.setSender(sender);
//		tranTest.setRecipient(recipient);
//		tranTest.setAmount(amount);
//
//		
//		map2.put("sender", tranTest.getSender());
//		map2.put("recipient", tranTest.getRecipient());
//		map2.put("amount", tranTest.getAmount());
//
//		
//		list.add(map2);
//
//		
//		System.out.println(list);
//		return new ArrayList<Map<String, String>>();
//	}
	
	public void newTran(String sender, String recipient, String amount) {
		
		
		this.sender = sender;
		this.recipient = recipient;
		this.amount = amount;
		
	}
	

	
	public void test() {
		//add our blocks to the blockchain ArrayList:
				System.out.println("\n===========================================================================================\n");
				System.out.println(blockchain.size());
				
				
				while(true) {
					if(blockchain.size() == 0) {
						blockchain.add(new Block(blockchain.size(), Integer.toString(blockchain.size()+1)+"번째 블록", "0", this.sender, this.recipient, this.amount));
						System.out.println((blockchain.size())+"번째 블록 마이닝 중 ,,");
						blockchain.get(blockchain.size()-1).mineBlock(difficulty);
						index++;
						break;
					}
					else {
						blockchain.add(blockchain.size(), new Block(blockchain.size(), Integer.toString(blockchain.size()+1)+"번째 블록", blockchain.get(blockchain.size()-1).hash, this.sender, this.recipient, this.amount));
						System.out.println((blockchain.size())+"번째 블록 마이닝 중 ,,");
						blockchain.get(blockchain.size()-1).mineBlock(difficulty);
						index++;
						break;
					}
				}
				
				
				System.out.println("\nBlockchain is Valid: " + isChainValid());
				
				String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
				
				System.out.println("\n===========================================================================================");
				
				System.out.println("\n THE BLOCK CHAIN : ");
				System.out.println(blockchainJson);
				
				System.out.println("\n===========================================================================================");
				
	}
	
	
	
	
//	public static void main(String args[]) {	
//		
//		//add our blocks to the blockchain ArrayList:
//		System.out.println("\n===========================================================================================\n");
//		
//		for(int idx = 0; idx<1; idx++) {
//			if(idx == 0) {
//				blockchain.add(new Block(idx, Integer.toString(idx+1)+"번째 블록", "0", sender, recipient, amount));
//				System.out.println((idx+1)+"번째 블록 마이닝 중 ,,");
//				blockchain.get(idx).mineBlock(difficulty);
//			}
//			else {
//				blockchain.add(idx, new Block(idx, Integer.toString(idx)+"번째 블록", blockchain.get(blockchain.size()-1).hash,sender, recipient, amount));
//				System.out.println((idx+1)+"번째 블록 마이닝 중 ,,");
//				blockchain.get(idx).mineBlock(difficulty);
//			}
//		}
//		
//		
////		blockchain.add(new Block("THE GENESIS BLOCK", "0"));
////		System.out.println("제네시스 블록 마이닝 중 .. ");
////		blockchain.get(0).mineBlock(difficulty);
////		
////		blockchain.add(new Block("THE SECOND BLOCK",blockchain.get(blockchain.size()-1).hash));
////		System.out.println("두 번째 블록 마이닝 중 .. ");
////		blockchain.get(1).mineBlock(difficulty);
////		
////		blockchain.add(new Block("THE THIRD BLOCK",blockchain.get(blockchain.size()-1).hash));
////		System.out.println("세 번째 블록 마이닝 중 .. ");
////		blockchain.get(2).mineBlock(difficulty);	
//		
//		System.out.println("\nBlockchain is Valid: " + isChainValid());
//		
//		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//		
//		System.out.println("\n===========================================================================================");
//		
//		System.out.println("\n THE BLOCK CHAIN : ");
//		System.out.println(blockchainJson);
//		
//		System.out.println("\n===========================================================================================");
//	}
	
	public static Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			//check if hash is solved
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}
}