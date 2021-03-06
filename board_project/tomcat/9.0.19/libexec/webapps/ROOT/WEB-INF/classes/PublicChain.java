package simpleChain;

import java.util.ArrayList;

import java.util.HashMap;

import com.google.gson.*;
import simpleChain.Tran;

public class PublicChain {
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;
	
	public String sender = product_name;
	public String recipient = nation;
	public int amount = count;

	
	public static void PublicChain() {
		//add our blocks to the blockchain ArrayList:
				System.out.println("\n===========================================================================================\n");
				
				for(int idx = 0; idx<1; idx++) {
					if(idx == 0) {
						blockchain.add(new Block(idx, Integer.toString(idx+1)+"번째 블록", "0", sender, recipient, amount));
						System.out.println((idx+1)+"번째 블록 마이닝 중 ,,");
						blockchain.get(idx).mineBlock(difficulty);
					}
					else {
						blockchain.add(idx, new Block(idx, Integer.toString(idx)+"번째 블록", blockchain.get(blockchain.size()-1).hash,sender, recipient, amount));
						System.out.println((idx+1)+"번째 블록 마이닝 중 ,,");
						blockchain.get(idx).mineBlock(difficulty);
					}
				}
				
				
//				blockchain.add(new Block("THE GENESIS BLOCK", "0"));
//				System.out.println("제네시스 블록 마이닝 중 .. ");
//				blockchain.get(0).mineBlock(difficulty);
//				
//				blockchain.add(new Block("THE SECOND BLOCK",blockchain.get(blockchain.size()-1).hash));
//				System.out.println("두 번째 블록 마이닝 중 .. ");
//				blockchain.get(1).mineBlock(difficulty);
//				
//				blockchain.add(new Block("THE THIRD BLOCK",blockchain.get(blockchain.size()-1).hash));
//				System.out.println("세 번째 블록 마이닝 중 .. ");
//				blockchain.get(2).mineBlock(difficulty);	
				
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