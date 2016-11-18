/* Name: James Williams */

#include <iostream>
#include <fstream>
#include <string>
#include "morse_tree.h"
using namespace std;

string encode(string s);
string decode(string s);

int main(void){
	char letter, w = '\0';
	string code, s;
	
	Morse_Code tree1; 
	cout << "\nTree empty test: " << tree1.empty() << "\n" << endl;
	ifstream morseFile("morse_code.txt");
	if (morseFile.is_open()){
		while (morseFile >> letter >> code){
			// cout << letter << ": " << code << endl;
			tree1.insert(letter, code);
		}
		morseFile.close();
	}
	else
		cout << "could not open file: " << endl;
	
	cout << "\nPRINT TREE IN PRE ORDER\n" << endl; 
	tree1.printPreOrder();

	cout << "\n\nTree empty: " << tree1.empty() << endl;

	cout << "\nBINARY TREE OPTIONS\n" << endl;
	cout << "e: Encode a word" << endl;
	cout << "d: Decode a word" << endl;
	cout << "q: Quit program\n" << endl;

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
		else if (w == 'q'){
			w = 'n';
		}
		else {
			cout << "invalid input\n" << endl;
		}
	}
	system("pause");
}

string encode(string s){
	return "\nYour encoded word is: " + s;
}

string decode(string s){
	return "\nYour decoded word is: " + s;
}
