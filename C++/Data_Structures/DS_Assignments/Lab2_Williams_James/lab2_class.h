/* James Ryan Williams-Lab2-Data Structures CS3424-Fall 14 */

#ifndef _LAB2_CLASS_H_
#define _LAB2_CLASS_H_

#include <string>
using namespace std;

// simple class to add, subtract, multiply, 
// and divide the lengths of 2 strings
class StringLengthCalc {
	public:
		// constructor method to set private attributes 
		// based on provided arguments
		StringLengthCalc (string s1, string s2);
		
		// add the length of the private attribute strings
		int add (void);
		
		// subtract the length of the private attribute strings
		int subtract (void);
		
		// multiply the length of the private attribute strings
		int multiply (void);
		
		// divide the length of the private attribute strings
		int divide (void);
		
	private:
		string string1, string2;
};

#endif