#include<iostream>
#include<fstream>
#include"BTNode.h"
#include"BinaryTree.h"
using namespace std; 

string encode(string s);
string decode(string s);

int height(string s);

int main(void){

	
	string s = "", encoding;
	char letter;

	// start building a tree
	BTNode tree1;
	// test empty function
	if (tree1.empty() == true)
		cout << "The tree is empyt" << endl;
	else
		cout << "The tree is supposed to be empty, but it's not" << endl; 


	// Read morse_code.txt file contnts
	cout << "\nREADING MORSE_CODE.TXT FILE\n" << endl; 
	ifstream myfile("morse_code.txt");
	if (myfile.is_open()){
		while (myfile >> letter >> encoding){
			cout << "letter: " << letter << " - code: " << encoding;
			cout << "\t\tlevel in tree: " << height(encoding) << endl;
			tree1.insert(letter, encoding);
		}
		myfile.close();
		cout << "\nMORSE_CODE.TXT FILE CLOSED\n" << endl; 
	}
	
	/*cout << "could not open file: " << endl;
	cout << "\nBINARY TREE OPTIONS\n" << endl;
	cout << "e: Encode a word" << endl;
	cout << "d: Decode a word" << endl;
	cout << "q: Quit program\n" << endl;

	char w = NULL;
	while (w != 'n'){
		cin >> w;
		if (w == 'e') {
			;
			cout << "\nPlease enter a word to be encoded: ";
			cin >> s;
			cout << encode(s) << endl;
			cout << "Encode / Decode again: (y / n): ";
			cin >> w;
			if (w == 'y'){
				cout << "\nBINARY TREE OPTIONS\n" << endl;
				cout << "e: Encode a word\n";
				cout << "d: Decode a word\n";
				cout << "q: Quit program\n" << endl;
			}
		}
		else if (w == 'd'){
			string s = "";
			cout << "\nPlease enter an encoded word for decoding: ";
			cin >> s;
			cout << decode(s) << endl;
			cout << "Encode / Decode again: (y / n): ";
			cin >> w;
			if (w == 'y'){
				cout << "\nBINARY TREE OPTIONS\n" << endl;
				cout << "e: Encode a word\n";
				cout << "d: Decode a word\n";
				cout << "q: Quit program\n" << endl;
			}
		}
		else if (w == 'q')
			w = 'n';
		else
			cout << "invalid input\n" << endl;
	}*/
	system("pause");
}

string encode(string s){
	return "\nYour encoded word is: " + s;
}

string decode(string s){
	return "\nYour decoded word is: " + s;
}
int height(string s){
	if (s == "")
		return 0;
	else
		return 1 + height(s.substr(1));
}