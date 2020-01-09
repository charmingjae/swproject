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
	public static List<Block> blockchain = new ArrayList<Block>();

	
	public List<Tran> trans = new ArrayList<Tran>(); // Tran class 내에 있는 요소들을 list로 저장.
	
	
	
	public static int difficulty = 3;
	
	public String sender;
	public String recipient;
	public String amount;
	
//	public static List<Object> transSender = new ArrayList<Object>(); // 갖고갈 array
	public static List<Object> transSender = new ArrayList<>(); // 갖고갈 array
	
	public static Map<String, String> mapTrans; // array에 요소를 넣기 위한 Map.

	public int index = 0;
	

	
///////// 01.09 BACKUP
	
//	public void test() {
//		//add our blocks to the blockchain ArrayList:
//				System.out.println("\n===========================================================================================\n");
//				System.out.println(blockchain.size());
//				
//				
//				while(true) {
//					if(blockchain.size() == 0) {
//						blockchain.add(new Block(blockchain.size(), Integer.toString(blockchain.size()+1)+"번째 블록", "0", "GENESIS BLOCK", "MADE BY", "CHA MIN JAE"));
//						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!Blockchain = " + blockchain.get(0));
//						System.out.println((blockchain.size())+"번째 블록 마이닝 중 ,,");
//						blockchain.get(blockchain.size()-1).mineBlock(difficulty);
//						index++;
//						break;
//					}
//					else {
//						blockchain.add(blockchain.size(), new Block(blockchain.size(), Integer.toString(blockchain.size()+1)+"번째 블록", blockchain.get(blockchain.size()-1).hash, sender, recipient, amount));
////						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!Blockchain = " + blockchain.get(blockchain.size()));
//						System.out.println((blockchain.size())+"번째 블록 마이닝 중 ,,");
//						blockchain.get(blockchain.size()-1).mineBlock(difficulty);
//						index++;
//						break;
//					}
//				}
//				
//				
//				System.out.println("\nBlockchain is Valid: " + isChainValid());
//				
//				String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//				
//				System.out.println("\n===========================================================================================");
//				
//				System.out.println("\n THE BLOCK CHAIN : ");
//				System.out.println(blockchainJson);
//				
//				System.out.println("\n===========================================================================================");
//				
//	}
	
	// 01. 09 알고리즘 수정해서 Block을 생성할 때 현재 클래스에 있는 Array를 갖고가게끔 시도.
	
	public void test() { 
		//add our blocks to the blockchain ArrayList:
				System.out.println("\n===========================================================================================\n");
				System.out.println("블록체인 사이즈 : " + blockchain.size());
//				block = new Block(blockchain.size(), Integer.toString(blockchain.size()+1)+"번째 블록", "0", transSender, mapTrans);
//				block = new Block(blockchain.size(), Integer.toString(blockchain.size()+1)+"번째 블록", blockchain.get(blockchain.size()-1).hash, transSender, mapTrans);
				
				while(true) {
					if(blockchain.size() == 0) {
						blockchain.add(new Block(blockchain.size(), Integer.toString(blockchain.size()+1)+"번째 블록", "0", transSender, mapTrans));
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!Blockchain = " + blockchain.get(0));
						System.out.println((blockchain.size())+"번째 블록 마이닝 중 ,,");
						blockchain.get(blockchain.size()-1).mineBlock(difficulty);
						index++;
						break;
					}
					else {
						blockchain.add(new Block(blockchain.size(), Integer.toString(blockchain.size()+1)+"번째 블록", blockchain.get(blockchain.size()-1).hash, transSender, mapTrans));
//						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!Blockchain = " + blockchain.get(blockchain.size()));
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
	
	
	public List<Object> addObject(String sender, String recipient, String amount) {
		mapTrans = new HashMap<>(); // 진짜 큰 한 수. https://its21c.net/248 을 참고하여 작성. 이 게시글 100번도 넘게 본 것 같은데 이제 이해함.
		System.out.println("BEFORE TRANSSENDER : \n");
		for(int i = 0 ; i < transSender.size(); i++)
		{
			System.out.println(transSender.get(i));
		}
		System.out.println("\n");
		
		
		mapTrans.put("sender", sender);
		mapTrans.put("recipient",recipient);
		mapTrans.put("amount",amount);

		transSender.add(mapTrans);
			
		
		System.out.println("AFTER TRANSSENDER : \n");
		for(int i = 0 ; i < transSender.size(); i++)
		{
			System.out.println(transSender.get(i));
		}
		
		return transSender;
		
	}
	
	
	

	
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