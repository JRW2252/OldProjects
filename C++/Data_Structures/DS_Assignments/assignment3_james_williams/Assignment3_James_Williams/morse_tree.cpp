#include <iostream>
#include "morse_tree.h"
#include<string>

using namespace std; 


Morse_Code::Morse_Code(){
	root = NULL; 
}

Morse_Code::~Morse_Code(){
	delete root;
}
bool Morse_Code::empty()const{
	return (root == NULL);
}
void Morse_Code::insert(char c, string s){
	if (root == NULL){
		root = new TreeNode('1', NULL, NULL);
	}
	TreeNode* ptr = root;
	insertNode(ptr, s, c);
}
void Morse_Code::insertNode(TreeNode* ptr, string s, char c){

	if (s == ""){
		//ptr->letter = c;
		return;
	}
	
	cout << "\ncurrent string: " << s << endl; 
	
	if (s.at(0) == '.'){
		if (ptr->left != NULL){
			ptr = ptr->left;
		}
		else{
			ptr->left = new TreeNode(c, NULL, NULL);
			ptr = ptr->left; 
		}
		cout << "Moved Left" << endl;
	}

	if (s.at(0) == '-'){
		cout << "Test2" << endl;
		if (ptr->right == nullptr){
			ptr->right = new  TreeNode(c, NULL, NULL);
			//ptr = ptr->right;
		}
		else{
			
			ptr = ptr->right;
		}
		cout << "Moved Right" << endl;
	}

	insertNode(ptr, s.substr(1), c);
}

void Morse_Code::printPreOrder(){
	preOrder(root);
}
void Morse_Code::preOrder(TreeNode* ptr){
	if (ptr != NULL) {  
		cout << ptr->letter << " ";    
		preOrder(ptr->left);
		preOrder(ptr->right);  
	}
}
