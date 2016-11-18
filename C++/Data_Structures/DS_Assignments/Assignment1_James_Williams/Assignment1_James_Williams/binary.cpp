#include "binary.h"
#include <string>

using namespace std;


Binary::Binary(int x) {
	firstTerm = nullptr; unsigned degree;
	while (x > 0) {
		// The degree of the next bit is the integer value of the 
		// base-2 log of x, where the base-2 log of x is log(x) / log(2).
		degree = unsigned(log(float(x)) / log(float(2))); // Create a BinaryNode with degree.
		set_bit(1, degree);
		x -= pow((float)2, (float)degree);
	}
}

Binary& Binary::operator=(const Binary &other) {
	if (this == &other) {
		return *this;
	}
	Binary bCopy = Binary(other);
	BinaryNode *pTemp = this->firstTerm;
	this->firstTerm = bCopy.firstTerm;
	bCopy.firstTerm = pTemp;
	return *this;
}


// notice a node is created if bit is 1 AND a node for that degree doesn't exist
// the node is removed if the bit is 0 AND the node with that degree
// already exists
// set_bit(creating new node, new node value)
// set_bit(1,5) —> [5|—]—>null
// set_bit(1,0) —> [0|—]—>null [0|—]—>[5|—]—>null
// set_bit(0, 5) —> remove [5|—] from list [0|—]—>null
// The basic idea is : Traverse through the linked list, 
// see if the term exists(assuming bit is 1) and create if it doesn't.
// If the bit is '0' and the degree exists in the list, you need to remove the node

void Binary::set_bit(int b, int d){
	BinaryNode* current = firstTerm;
	BinaryNode* prev = current; 
	static int numItems = 0; 

	
	cout << "toSet(" << b << ", " << d << ")" << endl;
	
	if (b == 0) {
		cout << "b = " << b << endl;
		
		for (current = firstTerm; current != NULL; current->next){
			
			cout << "current degree: " << current->degree;
			//cout << " - - previous degree: " << prev->degree << endl;

			if (current->degree == d){
				prev->next = current->next; 
				current = prev->next; 
				--numItems; 
				cout << "Items in list: " << numItems << endl;
			}

			prev = current; 
		}

	}

	if (b == 1 && current == NULL){
		
		current = new BinaryNode(d, NULL);
		prev = current; 

		++numItems;
		cout << "Items in list: " << numItems << endl;
	}
	else if (b == 1 && current != NULL){
		
		current->next = new BinaryNode(d, NULL);
		prev = current; 
		current = current->next; 

		++numItems;
		cout << "Items in list: " << numItems << endl;
	}
	
}

int Binary:: get_bit(int d)const{
	BinaryNode* current = firstTerm;
	
	// loop checks for bit
	while (current != NULL){
		if (current->degree == d)
			return 1;
		current = current->next;
	}
	return 0;
}

// convert
// returns the decimal integer representation of the binary number.
// int convert() const;
int Binary::convert()const{
	int decimal = 0;
	BinaryNode* current;

	for (current = firstTerm; current != nullptr; current->next){
		if (current->degree == 0){
			++decimal;
		}
		if (current->degree > 0){
			for (int i = 0; i >= current->degree; i++)
				decimal += decimal * 2; 
		}
	}
	return decimal;
}

int Binary::get_degree()const{
	BinaryNode* current = firstTerm;
	static int maxDeg; 

	if (current != NULL){
		for (current = firstTerm; current != NULL; current->next){
			if (current->degree > maxDeg){
				maxDeg = current->degree;
				cout << "max degree: " << maxDeg << endl; 
			}
		}
		return maxDeg; 
	}
	return -1;
}

Binary:: ~Binary(){
	BinaryNode* current = firstTerm;
	
	while (current != NULL) {
		BinaryNode* next = current->next;
		delete current;
		current = next;
	}
	firstTerm = NULL;
}

Binary::Binary(const Binary &b) {
	firstTerm = nullptr;
	for (BinaryNode *current_other = b.firstTerm; current_other != nullptr; current_other = current_other->next)
	{
		this->set_bit(1, current_other->degree);
	}
}

// assignment operator
// sets the current link list to be a deep copy of the provided list.
// make sure to check if assigning to itself, and make sure to free old memory
// before making the copy.
// Binary& operator=(const Binary &other); 
// print binary 
// prints the binary number to the output stream o
// please use like:		10001101
// terms must be printed in descending order of degree
// friend std::ostream& operator<<(std::ostream &o, const Binary &b);

int max(int a, int b){
	if (a > b)
		return a;
	else return b;
}

Binary operator+(const Binary &b1, const Binary &b2) {
	
	Binary newBinary = Binary();
	unsigned iMax = max(b1.get_degree(), b2.get_degree());
	// The carry bit
	unsigned bCarry = 0;
	// Traverse each bit of b1 or b2 (whichever has the higher degree).
	for (unsigned i = 0; i <= iMax; ++i) {
		unsigned sum = b1.get_bit(i) + b2.get_bit(i) + bCarry;
		// Determine if there is a new carry bit.
		if (sum >= 2) {
			bCarry = 1; sum -= 2;
		}
		else
		{
			bCarry = 0;
		}
		if (1 == sum) {
			newBinary.set_bit(1, i);
		}
	}
	// Handle the extra carry bit.
	if (1 == bCarry) {
		newBinary.set_bit(1, iMax + 1);
	}
	return newBinary;
}

// Binary subtraction operator
Binary operator-(const Binary &b1, const Binary &b2){
	Binary newBinary = Binary();
	return newBinary;
}

// Binary multiplication operator
Binary operator*(const Binary &b1, const Binary &b2){
	Binary newBinary = Binary();
	return newBinary;
}


// binary subtraction
// returns a new binary number representing the subtraction 
// of 2 provided binary numbers. can assume b1 will always be
// larger than b2.
// do NOT simply convert the numbers to decimal using convert(),subtract them,
// then convert back to binary.
// friend Binary operator-(const Binary &b1, const Binary &b2);


// binary multiplication
// returns a new binary number representing the multiplication
// of 2 provided binary numbers.
// do NOT simply convert the numbers to decimal using convert(),multiply them,
// then convert back to binary.
// friend Binary operator*(const Binary &b1, const Binary &b2);
