#include<iostream> // preprocessor directive
#include<string>
#include<cstdlib>
using namespace std; // namespace directive

int main() { // function header
	cout << "Enter your name: ";
	string name; 
	getline(cin, name);
	cout << "Thank you for the information " << name << ".\n";
	cout << "Welcome to learning how to write C++.\nHappy coding." << endl;

	int num_students, j = 0;
	cout << "Enter the number of students: ";
	cin >> num_students;
	string* students = new string[num_students];

	do {
		cout << "Enter a students name: ";
		cin >> students[j];
		j++;
	} while (j < num_students);
	cout << "\n";

	for (int k = 0; k < num_students; k++) {
		cout << students[k] << "\n";
	}
	get(cin);
	return 0;
}