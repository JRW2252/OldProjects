//////////////////////////
/* Name: James Williams */
//////////////////////////
#include <algorithm>
#include <iostream>
#include "morse_tree.h"
#include <string>
using namespace std; 
/// Constructor ////
Morse_Code::Morse_Code(){
	root = NULL; 
}
/// Destructor ///
Morse_Code::~Morse_Code(){
	delete (root); 
}
/// Trash tree wrapper  ///
void Morse_Code::trashCan(){
	trashTree(root); 
}
/// trash can worker /// 
/// recursive calls to /// 
///  delete each node  ///
void Morse_Code::trashTree(TreeNode* p){
	if (p != nullptr){
		trashTree(p->left);
		trashTree(p->right);
		delete p;
	}
}
/// Empty ////
bool Morse_Code::empty()const{
	return (root == NULL);
}
/// Insert wrapper ////
void Morse_Code::insert(char c, string s){
	if (root == NULL){
		root = new TreeNode('\0', NULL, NULL);
	}
	TreeNode* ptr = root;
	insertNode(ptr, s, c);
}
/// Insert worker ///
void Morse_Code::insertNode(TreeNode* ptr, string s, char c){
	// cout << "\ncurrent string: " << s << endl;
	if (s == ""){
		ptr->letter = c;
		return;
	}
	 
	if (s.at(0) == '.'){
		if (ptr->left != NULL){
			ptr = ptr->left;
		}
		else{
			ptr->left = new TreeNode(c, NULL, NULL);
			ptr = ptr->left; 
		}
		// cout << "Moved Left" << endl;
	}

	if (s.at(0) == '-'){
		if (ptr->right == nullptr){
			ptr->right = new  TreeNode(c, NULL, NULL);
			ptr = ptr->right;
		}
		else{
			
			ptr = ptr->right;
		}
		// cout << "Moved Right" << endl;
	}

	insertNode(ptr, s.substr(1), c);
}
/// Print pre-order wrapper ////
void Morse_Code::printPreOrder(){
	preOrder(root);
}
/// Print pre-order worker ////
void Morse_Code::preOrder(TreeNode* ptr){
	if (ptr != NULL) {  
		cout << ptr->letter << " ";    
		preOrder(ptr->left);
		preOrder(ptr->right);  
	}
}
/// Encode wrapper ///
///   Takes string and parses each   ///
/// character to the worker function ///
void Morse_Code::encode(string e){
	while (e != ""){
		encoder(root, e.at(0), "");
		e = e.substr(1);
	}
}
/// Encoder worker ///
///    receives pointer, char to    ///
/// find and a string for path/code ///
void Morse_Code::encoder(TreeNode* p, char c, string s){
	if (p != NULL){
		if (p->letter == c)
			cout << s << " ";
		encoder(p->left, c, s+".");
		encoder(p->right, c, s+"-"); 	
	}
}
/// Decode wrapper ///
void Morse_Code::decode(string d){
	TreeNode* ptr = root; 
	string s = "";
	int dSize = d.size(), i = 0; 
	////////////////////////////////////////////////////
	while (i < dSize){
		if (d.at(i) != ' '){
			if (d.at(i) == '.' || d.at(i) == '-')
				s+=d.at(i);
		}
		if (d.at(i) == ' ' || i == dSize-1){
			decoder(ptr, s);
			s = "";
		}
		++i; 
	}
}
/// Decode worker ///
/// Takes pointer and string/path  ///
/// Prints out the letter in node  ///
///    once the string is empty    ///
void Morse_Code::decoder(TreeNode* ptr, string d){
/// do noting - invalid path /// 
	if (ptr == NULL)
		return;
/// print node contents ///
		if (d == ""){
		cout << ptr->letter; 
	}
	if (d.size() > 0){
		if (d.at(0) == '.')
			ptr = ptr->left; 
		if (d.at(0) == '-')
			ptr = ptr->right; 
		decoder(ptr, d.substr(1));
	}
}