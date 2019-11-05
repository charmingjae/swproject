import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Block {
	
	List<String> transactions = new ArrayList<String>();
//	transactions.add();
	
	public int index;
	public String hash;
	public String previousHash; 
	private String data; //our data will be a simple message.
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	private int nonce;
//	private String[] cvt_newTransactions = new String[transactions.size()]; //시도해 보는 것
//	private String sender = "차민재";
//	private String recipient = "정상원";
//	public int amount;
	
	
	//Block Constructor.
	public Block(int index, String data,String previousHash ) {
		this.index = index + 1;
		this.data = data;
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