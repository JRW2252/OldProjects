#include "binary.h"
#include <algorithm>
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
	int decimal = 0, deg;

	while (ptr != nullptr){
		if (ptr->degree == 0)
			++decimal;
		else{
			deg = ptr->degree;
			for (int i = 0; i < deg; i++){
				if (i == 0){
					++decimal;
				}
				else{
					decimal = (2 * decimal);
				}
			}
			++decimal;
		}
		ptr = ptr->next;
	}
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

/* copied addition operator and pasted in for temp purposes */
// binary multiplication
// returns a new binary number representing the multiplication
// of 2 provided binary numbers.
// do NOT simply convert the numbers to decimal using convert(),multiply them,
// then convert back to binary.
// friend Binary operator*(const Binary &b1, const Binary &b2);
Binary operator*(const Binary &b1, const Binary &b2){
	Binary newBinary = Binary();

	unsigned iMax = max(b1.get_degree(), b2.get_degree());
	// The carry bit
	unsigned bCarry = 0;
	// Traverse each bit of b1 or b2 (whichever has the higher degree).
	for (unsigned i = 0; i <= iMax; ++i) {
		unsigned sum = b1.get_bit(i) + b2.get_bit(i) + bCarry;
		// Determine if there is a new carry bit.
		if (sum >= 2){
			bCarry = 1; sum -= 2;
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

Binary operator+(const Binary &b1, const Binary &b2) {
	Binary newBinary = Binary();

	unsigned iMax = max(b1.get_degree(), b2.get_degree());
	// The carry bit
	unsigned bCarry = 0;
	// Traverse each bit of b1 or b2 (whichever has the higher degree).
	for (unsigned i = 0; i <= iMax; ++i) {
		unsigned sum = b1.get_bit(i) + b2.get_bit(i) + bCarry;
		// Determine if there is a new carry bit.
		if (sum >= 2){
			bCarry = 1; sum -= 2;
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

/* copied addition operator and pasted in for temp purposes */
// binary subtraction
// returns a new binary number representing the subtraction
// of 2 provided binary numbers. can assume b1 will always be
// larger than b2.
// do NOT simply convert the numbers to decimal using convert(),subtract them,
// then convert back to binary.
// friend Binary operator-(const Binary &b1, const Binary &b2);
Binary operator-(const Binary &b1, const Binary &b2){
	Binary newBinary = Binary();

	unsigned iMax = max(b1.get_degree(), b2.get_degree());
	// The borrowed bit
	unsigned bBorrow = 0;
	// Traverse each bit of b1 or b2 (whichever has the higher degree).
	for (unsigned i = 0; i <= iMax; ++i) {
		unsigned top = b1.get_bit(i), bottom = b2.get_bit(i);
		


	}
	// Handle the extra carry bit.
	if (1 == bBorrow) {
		newBinary.set_bit(1, iMax + 1);
	}
	return newBinary;
}
