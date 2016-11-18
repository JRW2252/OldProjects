#include<iostream>
#include<fstream>
#include<string>
#include<stdexcept>
#include"BTNode.h"

using namespace std;

#ifndef BINARY_TREE_H_
#define BINARY_TREE_H_

class BinaryTree{
private:
	Node* root;
	void trahsBTNode(Node* r); 
public:
	BTNode();
	~BTNode(); 
	bool empty(); 
	int nodeHeight(string s);
	void insert(char c, string s);
	void insertNW(char c, string s, Node* r, Node* current, string sub);
	void printTree(BTNode* root);
};

#endif BINARY_TREE_H_