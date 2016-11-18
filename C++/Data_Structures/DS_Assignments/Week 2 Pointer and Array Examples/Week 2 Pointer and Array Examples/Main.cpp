#include <iostream>
#include <string>

using namespace std; 

void addNums(int arr[]);

int main(void){
	int i, j, aSize, sum, *p, *q;

	cout << "Enter a number for the array size: ";
	cin >> aSize;
	cout << endl;
	
	p = new int[aSize];
	i = 0;
	do 
	{
		cout << "Enter a number to store in the array: ";
		cin >> p[i];
		cout << endl;
		i++;
	} while (i < aSize);
	
	cout << "Now we are going to add all of the numbers in the array together:\n" << endl;

	for (j = *p, q = p + 1; q < p + aSize; q++)
	{
		sum = j;
		cout << j << "+" << *q << "=";
		sum = (j += *q);
		cout << sum << endl;
	}

	cout << "\nThe first array item is: " << *p << endl;
	system("pause");
}