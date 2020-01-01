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
	
	
	
	public static int difficulty = 5;
	
	public String sender;
	public String recipient;
	public String amount;



	public int index = 0;
	

	

	
	public void test() {
		//add our blocks to the blockchain ArrayList:
				System.out.println("\n===========================================================================================\n");
				System.out.println(blockchain.size());
				
				
				while(true) {
					if(blockchain.size() == 0) {
						blockchain.add(new Block(blockchain.size(), Integer.toString(blockchain.size()+1)+"번째 블록", "0", this.sender, this.recipient, this.amount));
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!Blockchain = " + blockchain.get(0));
						System.out.println((blockchain.size())+"번째 블록 마이닝 중 ,,");
						blockchain.get(blockchain.size()-1).mineBlock(difficulty);
						index++;
						break;
					}
					else {
						blockchain.add(blockchain.size(), new Block(blockchain.size(), Integer.toString(blockchain.size()+1)+"번째 블록", blockchain.get(blockchain.size()-1).hash, sender, recipient, amount));
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