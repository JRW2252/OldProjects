/* Name: James Williams */

#include <iostream>
#include <fstream>
#include <string>
#include "morse_tree.h"

using namespace std;

string encode(string s);
string decode(string s);

int main(void){
	char w = '_';
	string s = "", lineIn;
	char charIn; 
	ifstream myfile ("morse_code.txt");

	if (myfile.is_open()){
		while (myfile >> noskipws >> charIn)
			cout << charIn; 
		myfile.close();
	}
	else
		cout << "could not open file: " << endl;

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
