#include <iostream>  // processor directive
#include <string>    // processor directive

using namespace std; // namespace directive

int main(void) {     // function header
	string fName, lName;

	cout << "Enter your first name: "; 
	getline(cin, fName);
	cout << "Enter your last name: ";
	getline(cin, lName);

	cout << "Thank you for your input " << fName << " " << lName << endl;
	system("pause");
}
