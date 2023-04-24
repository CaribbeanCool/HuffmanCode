package p2.test;

import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;

import p2.HuffmanCoding;
import p2.DataStructures.Map.Map;
import p2.DataStructures.SortedList.SortedLinkedList;
import p2.DataStructures.SortedList.SortedList;
import p2.DataStructures.Tree.BTNode;

public class P2Test1 {
	
	@SuppressWarnings("unchecked")
	BTNode<Integer, String>[] freq = new BTNode[5];
	String[] codes = {"11", "10", "01", "001", "000"};
	String input;
	String encoded;
	String decoded;
	int inputBytes;
	double outputBytes;
	String savings;
	
	Map<String, Integer> fD;
	BTNode<Integer,String> huffmanRoot;
	Map<String,String> encodedHuffman;
	String output;

	@Before
	public void setUp() throws Exception {
		input = "EEEEIIITTOS";
		
		freq[0] = new BTNode<>(4, "E");
		freq[1] = new BTNode<>(3, "I");
		freq[2] = new BTNode<>(2, "T");
		freq[3] = new BTNode<>(1, "S");
		freq[4] = new BTNode<>(1, "O");
		
		fD = HuffmanCoding.compute_fd(input);
		huffmanRoot = HuffmanCoding.huffman_tree(fD);
		encodedHuffman = HuffmanCoding.huffman_code(huffmanRoot);
		output = HuffmanCoding.encode(encodedHuffman, input);
	}

	@Test
	public void testEncoding() {
		
		boolean check = output.equals("111111111010100101000001") 
				&& HuffmanCoding.decodeHuff(output, encodedHuffman).equals(input);
		
		assertTrue("Failed to encode correctly input string", check);
	}
	
	@Test
	public void testBytes() {
		inputBytes = input.getBytes().length;
		
		DecimalFormat d = new DecimalFormat("##.##");
		outputBytes = Math.round((float) output.getBytes().length / 8);
		savings =  d.format(100 - (( (float) (outputBytes / (float)inputBytes) ) * 100));
		
		boolean check = inputBytes == 11 && outputBytes == 3 && savings.equals("72.73");
	
		assertTrue("Failed to calculate correctly bytes when encoding", check);
	}
	
	@Test
	public void testFrequencyDistribution() {
		
		boolean check = true;
		SortedList<BTNode<Integer,String>> sortedList = new SortedLinkedList<BTNode<Integer,String>>();

		for (String key : fD.getKeys()) {
			BTNode<Integer,String> node = new BTNode<Integer,String>(fD.get(key),key);
			sortedList.add(node);
		}

		
		int i = sortedList.size() - 1;
		int j = 0;
		while(i >= 0 && j < freq.length) {
			BTNode<Integer,String> node = sortedList.get(i);
			if(node.getKey() != freq[j].getKey() && !node.getValue().equals(freq[j].getValue())) {
				check = false;
			}
			i--;
			j++;
		}
		
		assertTrue("Final Frequency Distribution is Incorrect", check);
	
	}
	
	@Test
	public void testCode() {
		boolean check = true;
		
		SortedList<BTNode<Integer,String>> sortedList = new SortedLinkedList<BTNode<Integer,String>>();

		for (String key : fD.getKeys()) {
			BTNode<Integer,String> node = new BTNode<Integer,String>(fD.get(key),key);
			sortedList.add(node);
		}
		
		int i = sortedList.size() - 1;
		int j = 0;
		while(i >= 0 && j < codes.length) {
			BTNode<Integer,String> node = sortedList.get(i);
			if(!encodedHuffman.get(node.getValue()).equals(codes[j])) {
				check = false;
			}
			
			i--;
			j++;
		}
		
		assertTrue("Failed to encode symbols correctly", check);
	}

}
