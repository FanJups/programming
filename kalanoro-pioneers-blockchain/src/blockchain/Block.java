package blockchain;

import java.util.Date;

public class Block {

	/*
	 * To learn more about blockchain
	 * 
	 * 1-
	 * https://medium.com/programmers-blockchain/create-simple-blockchain-java-
	 * tutorial-from-scratch-6eeed3cb03fa
	 * 
	 * 2-
	 * https://medium.com/programmers-blockchain/creating-your-first-blockchain-
	 * with-java-part-2-transactions-2cdac335e0ce
	 * 
	 */

	public String hash;
	public String previousHash;
	private Animal data; // our data will be a simple message.
	private long timeStamp; // as number of milliseconds since 1/1/1970.
	private int nonce;

	// Block Constructor.
	public Block(Animal data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash(); // Making sure we do this after we set the
										// other values.
	}

	public String calculateHash() {
		String calculatedhash = StringUtil
				.applySha256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data.toString());
		return calculatedhash;
	}

	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); // Create
																				// a
																				// string
																				// with
																				// difficulty
																				// *
																				// "0"
		while (!hash.substring(0, difficulty).equals(target)) {
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}

}
