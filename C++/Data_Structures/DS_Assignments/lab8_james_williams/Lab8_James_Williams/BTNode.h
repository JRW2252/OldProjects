#include<iostream>
#include<fstream>
#include<string>
#include"BinaryTree.h"

using namespace std;

#ifndef BTNODE_H_
#define BTNODE_H_

struct BTNode
{
	char letter;
	string code;
	Node* left, *right;

	BTNode(char l, string c, Node* lC = NULL, Node* rC = NULL) :
		letter(l), code(c), left(lC), right(rC){}

	virtual ~BTNode() {}

	virtual string toString()const{
		ostringstream os; 
		os << letter; 
		return os.str(); 
	}
};

#endif BTNODE_H_