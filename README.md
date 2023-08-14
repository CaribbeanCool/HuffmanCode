# Data Structures Project 2 - Huffman Coding

*Huffman Coding* is an encoding algorithm for lossless data compression developed by
David A. Huffman in 1952. The compression works by replacing characters which take 8 bits,
with a with a binary number, where each digit takes 1 bit. To create the Huffman Code,
we must first calculate the frequency distribution of the input string. Let’s say that our input
string is "aaaaabbbbcccddf", then our frequency distribution would be:

| Symbol | Frequency |
|:------:|:---------:|
|   a    |     5     |
|   b    |     4     |
|   c    |     3     |
|   d    |     2     |
|   f    |     1     |

We then take the frequency distribution table and for each symbol we create a binary tree node
that contains its symbol and frequency. We store the nodes in a sorted list, where each node is sorted
using its frequency, having the lowest be first, but if they have the same frequency then we use 
lexicographical order. Then we remove the two lowest nodes from the list, we create a parent node,
where its left child is the first node removed from the list, and its right child is the second removed 
node. The parent’s symbol is equal to the combination of its children’s symbols and its frequency
is the sum of its children's frequencies. We then add the parent node to the sorted list and continue 
repeating the process until there is only one node left in the list, this node is the root of our tree.
Below you can see the code for this algorithm and a visual representation of the Huffman Tree.

```java
	/**
	 * Receives a {@code Map} with the frequency distribution and returns the root
	 * node of the corresponding Huffman tree.
	 * This method uses a {@code SortedList} to sort the map by the frequency of the
	 * letters.
	 * The main idea is in a loop, remove the two first elements of the list, create
	 * a new node with the sum of the two
	 * frequencies and add it to the list again, until the list has only one
	 * element, which is the root node of the tree.
	 * 
	 * @author Alejandro A. Perez Pabon
	 * @param fD Map with the frequency distribution of each character
	 * @return The root node of the corresponding Huffman tree
	 * 
	 */
	public static BTNode<Integer, String> huffman_tree(Map<String, Integer> fD) {

		BTNode<Integer, String> rootNode = null;
		SortedLinkedList<BTNode<Integer, String>> fDSortedList = new SortedLinkedList<BTNode<Integer, String>>();

		for (String key : fD.getKeys()) {
			fDSortedList.add(new BTNode<Integer, String>(fD.get(key), key)); // Adding the letters to the list
		}

		for (int i = 0; i < fD.size() - 1; i++) {
			BTNode<Integer, String> leftNode = fDSortedList.removeIndex(0); // Removing the first element
			BTNode<Integer, String> rightNode = fDSortedList.removeIndex(0); // Removing the second element
			BTNode<Integer, String> parent = new BTNode<>(leftNode.getKey() + rightNode.getKey(),
					leftNode.getValue() + rightNode.getValue());
			parent.setLeftChild(leftNode);
			parent.setRightChild(rightNode);
			fDSortedList.add(parent); // Adding the parent node to the list
		}
		rootNode = fDSortedList.removeIndex(0); // Removing the root node

		/*
		 * Use this method to see full Huffman Tree built with the generated root node
		 * BinaryTreePrinter.print(rootNode);
		 */
		BinaryTreePrinter.print(rootNode); // Dummy print
		return rootNode;
	}
```
Once we've created the Huffman Tree, we can proceed to the creation of the Huffman Code Table. We start
traversing the tree from the root until we reach a leaf, the path taken to reach the leaf is that leaf's 
Huffman Code, when we go left we add a 0, and when we go right we add a 1. Using this example, our Huffman
Code table would be:

| Symbol | Huffman Code |
|:------:|:------------:|
|   a    |       11     |
|   b    |       10     |
|   c    |       00     |
|   d    |      011     |
|   f    |      010     |

Notice that no Huffman Code is the prefix to another Huffman Code, that is because if
we had x = 1, and y = to 11, then the string "1111" could be interpreted as "xxxx" or "yy".

Using our example, we encode our original string "aaaaabbbbcccddf" into "111111111110101010000000011011010".
The original string would need 15 bytes, while our encoded string only needs 5 bytes. The encoded
string takes up 67% less space than the original string.
