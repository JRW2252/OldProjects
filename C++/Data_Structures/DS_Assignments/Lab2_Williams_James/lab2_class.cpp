/* James Ryan Williams-Lab2-Data Structures CS3424-Fall 14 */

#include "lab2_class.h"

using namespace std;

StringLengthCalc::StringLengthCalc(string s1, string s2) {
	string1 = s1;
	string2 = s2;
}

int StringLengthCalc::add() {
	return(string1.length() + string2.length());
}

int StringLengthCalc::subtract() {
	return(string1.length() - string2.length());
}

int StringLengthCalc::divide() {
	return(string1.length() / string2.length());
}

int StringLengthCalc::multiply() {
	return(string1.length() * string2.length());
}