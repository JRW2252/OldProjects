#include <iostream>

using namespace std;

int feetToInches(int);
int cToF(int);

int main(void){

	int feet; 
	cout << "Enter a number of feet to convert to inches: "; 
	cin >> feet; 
	cout << endl;

	int inches = feetToInches(feet);
	cout << "\n" << feet << " feet equals " << inches << " inches.\n" << endl; 

	int degC;
	cout << "\nEnter a Celsius to convert to Fahrenheit: ";
	cin >> degC;
	cout << endl;

	int degF = cToF(degC);
	cout << "\n" << degC << " degrees Celsius equals " << degF << " degrees Fahrenheit.\n" << endl; 

	system("pause");
}
 
int feetToInches(int ft){
	return ft * 12;
}

int cToF(int c){
	return 1.8*c + 32;
}
