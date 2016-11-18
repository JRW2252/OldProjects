/* James Ryan Williams-Lab2-Data Structures CS3424-Fall 14 */

#include "lab2_func.h"

using namespace std;

// function adding 2 integers
int add (int i1, int i2) {
	return (i1 + i2);
}

// function subtracting 2 integers
int subtract (int i1, int i2) {
	return (i1 - i2); 
}

// function multiplying 2 integers
int multiply (int i1, int i2) {
	return (i1 * i2); 
}

// function dividing 2 integers unless the divisor is 0
// returns a 0 if the divisor is set to 0
int divide (int i1, int i2) {
	if (i2 != 0) 
		return (i1 / i2);
	else return 0; 
}