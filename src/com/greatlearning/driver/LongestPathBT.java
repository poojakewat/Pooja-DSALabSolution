package com.greatlearning.driver;
import java.util.ArrayList;

class Node{
	int data;
	Node leftNode,rightNode ;
	Node(int value){
		data = value;
		leftNode=rightNode=null;
	}
}

public class LongestPathBT {

	public LongestPathBT() {}

	public static void main(String[] args) {

		Node node1 = new Node(100);
		Node node2= new Node(20);
		Node node3 = new Node(130);
		Node node4 = new Node(10);
		Node node5 = new Node(50);
		Node node6 = new Node(110);
		Node node7 = new Node(140);
		Node node8 = new Node(5);

		node4.leftNode = node8;
		node2.leftNode = node4;

		node2.rightNode=node5;
		node3.leftNode=node6;
		node3.rightNode=node7;

		node1.rightNode=node3;
		node1.leftNode=node2;

		ArrayList<Integer> result = findLongestPath(node1);
		int n = result.size();

		System.out.print(result.get(n - 1));
		for(int i = n - 2; i >= 0; i--)
		{
			System.out.print(" -> " + result.get(i));
		}
	}
	public static ArrayList<Integer> findLongestPath(Node root){

		if(root==null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

		ArrayList<Integer> rightNode = findLongestPath(root.rightNode);

		ArrayList<Integer> leftNode = findLongestPath(root.leftNode);

		if(rightNode.size() < leftNode.size()) {
			leftNode.add(root.data);
		}else {
			rightNode.add(root.data);
		}
		return (leftNode.size() > rightNode.size()?leftNode : rightNode);
	}
}

