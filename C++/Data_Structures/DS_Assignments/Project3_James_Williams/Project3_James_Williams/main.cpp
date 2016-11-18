//////////////////////////
/* Name: James Williams */
//////////////////////////
#include <algorithm>
#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
#include "morse_tree.h"
using namespace std;
//////////////////////////
/*   main functioins    */
//////////////////////////
void options();
string endProgram(); 
//////////////////////////
/* end main functioins  */
//////////////////////////
int main(void){
	char letter;
	string code, stringIn = "";
/// end var init, create tree ///
	Morse_Code tree1; 
	cout << "\nTree Empty? ( " << tree1.empty() << " )" << endl;
	ifstream morseFile("morse_code.txt");
/// read in file, construct/build tree ///
	if (morseFile.is_open()){
		while (morseFile >> letter >> code){
		    cout << letter << ": " << code << endl;
			tree1.insert(letter, code);
		}
		morseFile.close();
	}
	else
		cout << "could not open file: " << endl;
/// test tree empty ///
	cout << "\nTree Empty? (" << tree1.empty() << ")" << endl;
/// test print tree in pre order ////
	cout << "\nPRINT TREE IN PRE ORDER\n" << endl; 
	tree1.printPreOrder();
/// start user input ///
	options(); 
/// continue user input ///
	while (stringIn != "q"){
		getline(cin, stringIn);
		transform(stringIn.begin(), stringIn.end(),
			stringIn.begin(), ::tolower);
/// start using morse code decode function ////
		if (stringIn == "d"){
			stringIn = "";
			cout << "\nEnter a stirng to decode: ";
			getline(cin, stringIn);
			cout << "\nYour decoded word:\t";
			tree1.decode(stringIn);
		}
/// start using morse code encode function ////
		if (stringIn == "e"){
			stringIn = "";
			cout << "\nEnter a string to encode: ";
			getline(cin, stringIn);
			transform(stringIn.begin(), stringIn.end(),
				stringIn.begin(), ::tolower);
			cout << "\nYour encoded word:\t";
			tree1.encode(stringIn);
		}
		stringIn = endProgram();
	}

}
/// main functions build out ///
/// print options for user ///
void options(){
	cout << "\nMORSE CODE OPTIONS\n" << endl;
	cout << "e: Encode a word" << endl;
	cout << "d: Decode a word" << endl;
	cout << "q: Quit program\n" << endl;
}
/// take input to determine end program or not ///
string endProgram(){
	string s = "";
////////////////////////////////////////////////////
	while (s != "y" || s != "n"){
		cout << "\n\nEncode or Decode anoter: (y / n): ";
		getline(cin, s);
		transform(s.begin(), s.end(),
			s.begin(), ::tolower);
////////////////////////////////////////////////
		if (s == "y"){
			options(); 
			return "";
			break;
		}
////////////////////////////////////////////////
		if (s == "n"){
			return "q";
			break; 
		}
	}
	return "";
}
/// Done Main /// 