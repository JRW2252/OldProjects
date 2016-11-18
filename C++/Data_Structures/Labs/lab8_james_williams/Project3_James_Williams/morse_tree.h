/* Name: James Williams */

#ifndef _MORSE_TREE_H_
#define _MORSE_TREE_H_
#include <iostream>
#include<string>
using namespace std; 

class Morse_Code {

private:
	struct TreeNode{
		char letter;
		TreeNode* left;
		TreeNode* right;
		TreeNode(char c, TreeNode* l, TreeNode* r): letter(c), left(l), right(r){ 
		}
	};
	TreeNode* root;
	void preOrder(TreeNode* ptr);
	void insertNode(TreeNode* p, string s, char c);
	
public:
	Morse_Code();
	Morse_Code(char c, string s);
	~Morse_Code(); 
	bool empty()const;
	void insert(const char c, string s);
	void printPreOrder();
	TreeNode newNode();
};
#endif