#include<iostream>
#include<fstream>
#include<string>
#include"BTNode.h"
#include"BinaryTree.h"


BTNode::BTNode(){
	root = NULL;
	return;
}
BTNode::~BTNode(){
	trahsBTNode(root);
	return;
}
void BTNode::trahsBTNode(Node* r){
	if (r == NULL)
		return;
	else if (r->right != NULL)
		trahsBTNode(r->right);
	else if (r->left != NULL)
		trahsBTNode(r->left);
	else
		delete r;
	return;
}
bool BTNode::empty(){
	return (root == NULL);
}
int BTNode::nodeHeight(string s){
	if (s == "")
		return 0;
	else
		return 1 + nodeHeight(s.substr(1));
}
void BTNode::insert(char c, string s){
	return insertNW(c, s, root, root, s);
}
void BTNode::insertNW(char c, string s, Node* r, Node* current, string sub){
	if (current == r){

	}
	if (sub == ""){  // insert node at location (done)
		if (current->left == NULL && current->right == NULL)
			current = (c, s, current->left, current->right);
	}
	if (sub.at(0) == '.'){ // go left
		if (current->left == NULL){
			current->left = new Node('!', "", NULL, NULL);
		}
		else
			current = current->left;
		sub = sub.substr(1);
	}
	if (sub.at(0) == '-'){ // go right
		if (current->right == NULL){
			current->right = new Node('!', "", NULL, NULL);
		}
		else
			current = current->right;
		sub = sub.substr(1);
	}
}