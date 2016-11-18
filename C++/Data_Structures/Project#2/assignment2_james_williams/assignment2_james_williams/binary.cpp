/* Name: James Ryan Williams */

#include "binary.h"
#include <algorithm>
#include <iostream>
using namespace std;

Binary::Binary(int x){
	firstTerm = nullptr; unsigned degree; 
	while (x > 0){
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
	/* Swap firstTerm of other and bCopy. */
	BinaryNode *pTemp = this->firstTerm;
	this->firstTerm = bCopy.firstTerm;
	bCopy.firstTerm = pTemp;
	return *this;
}

void Binary::set_bit(int b, int d){
	BinaryNode* current = firstTerm;
	
	if (b == 0){
		if (firstTerm->degree == d){
			firstTerm = firstTerm->next;
		}
		else {
			BinaryNode* prev = current;
			current = current->next;
			while (current != nullptr){
				if (current->degree == d){
					if (current->next != nullptr){
						prev->next = prev->next->next;
						current = current->next;
					}
					else {
						prev->next = nullptr;
						current = nullptr; 
					}
				}
				if (current != nullptr){
					prev = current;
					current = current->next;
				}
			}
		}
	}
	// create new node and add to list
	if (b == 1){
		firstTerm = new BinaryNode(d, firstTerm);
	}
}

int Binary::get_bit(int d)const{
	BinaryNode* current = firstTerm;

	if (firstTerm->degree == d){
		return 1;
	} 
	else {
		while (current->next != nullptr){
			if (current->next->degree == d){
				return 1; 
			}
			current = current->next; 
		}
	}
	return 0;
}

int Binary::convert()const{
	BinaryNode* ptr = firstTerm;
	int decimal = 0, deg, tmpdecimal = 0;
	
	while (ptr != nullptr){
		tmpdecimal = 0;
		deg = ptr->degree;
//		cout << "converting degree: " << deg; 
		if(deg > 0){
			for (int i = 0; i <= deg; i++){
				if (i > 0){
					tmpdecimal = 2 * tmpdecimal;
				}
				else{
					++tmpdecimal;
				}	
			}
//			cout << " = " << tmpdecimal << endl;
			decimal += tmpdecimal;
		}
		if (deg == 0){
			++tmpdecimal;
//			cout << " = " << tmpdecimal << endl;
			decimal += tmpdecimal;
		}
		ptr = ptr->next;
	}
	delete ptr; 
//	cout << "compled conversion, returning: " << decimal << endl; 
	return decimal;
}

int Binary::get_degree()const{
	BinaryNode* ptr = firstTerm;
	int max = -1;
	
	while (ptr != nullptr){
		if (ptr->degree > max){
			max = ptr->degree; 
		}
		ptr = ptr->next; 
	}
	return max; 
}

Binary:: ~Binary(){
	BinaryNode* current = firstTerm;
	BinaryNode* next;

	while (current != nullptr) {
		next = current->next;
		delete current;
		current = next;
	}
	firstTerm = nullptr;
}

Binary::Binary(const Binary &b) {
	firstTerm = nullptr;
	for (BinaryNode *current_other = b.firstTerm; current_other != nullptr; current_other = current_other->next)
	{
		this->set_bit(1, current_other->degree);
	}
}

Binary operator*(const Binary &b1, const Binary &b2){
	Binary newBinary = Binary();
	// convert to create a number of iterations
	// to add the multiplicand to its-self
	int multiplier = b2.convert(); 
	
	// loop for adding the multiplicand to its-self
	for (unsigned i = 1; i < multiplier; ++i) {
		// newBinary initialized value
		if (i == 1){
			newBinary = b1 + b1;
		}
		// add the value of newBinary to 
		// the vaule of the multiplacnd
		if (i > 1){
			newBinary = newBinary + b1; 
		}
	}
	// done multiplying so return newBinary
	return newBinary;
}

Binary operator+(const Binary &b1, const Binary &b2){
	Binary newBinary = Binary();

	unsigned iMax = max(b1.get_degree(), b2.get_degree());
	// The carry bit
	unsigned bCarry = 0;
	// Traverse each bit of b1 or b2 (whichever has the higher degree).
	for (unsigned i = 0; i <= iMax; ++i) {
		unsigned sum = b1.get_bit(i) + b2.get_bit(i) + bCarry;
		// Determine if there is a new carry bit.
		if (sum >= 2){
			bCarry = 1; 
			sum -= 2;
		}
		else{
		bCarry = 0;
		}
		if (1 == sum){
			newBinary.set_bit(1, i);
		}
	}
	// Handle the extra carry bit.
	if (1 == bCarry) {
		newBinary.set_bit(1, iMax + 1);
	}
return newBinary;
}

Binary operator-(const Binary &b1, const Binary &b2){
	Binary newBinary = Binary();

	unsigned iMax = max(b1.get_degree(), b2.get_degree());
	// The carry bit
	unsigned bBorrow = 0;
	// Traverse each bit of b1 or b2 (whichever has the higher degree).
	for (unsigned i = 0; i <= iMax; ++i) {
		unsigned diff = (b1.get_bit(i) - b2.get_bit(i));
		
		if (diff > 1){
			if (i < iMax){
				newBinary.set_bit(1, i);
				bBorrow = 1;
			}
			else{
				newBinary.set_bit(1, i);
				newBinary.set_bit(1, iMax + 1);
			}
		}
		if (diff == 0 && bBorrow == 1){
			if (i < iMax){
				newBinary.set_bit(1, i);
			}
			else{
				bBorrow = 0;
			}
		}
		if (diff == 1 && bBorrow == 0){
			newBinary.set_bit(1, i);
		}
	}
	return newBinary;
}

std::ostream& operator<<(std::ostream &o, const Binary &b){
	Binary newBinary = Binary();
	string out = "";
	unsigned msb = max(b.get_degree(), b.get_degree());
	for (unsigned i = 0; i <= msb; i++){
		o<<b.get_bit(i);
	}
	 
	return o;
}