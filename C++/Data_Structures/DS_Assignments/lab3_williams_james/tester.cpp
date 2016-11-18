#include "stack_vec_tpt.h"
#include <string>
#include <iostream>
#include <stdexcept>

using namespace std;

void main(int argc, char **argv) 
{

	// PART 1: stack using vector
	cout << "TESTING VECTOR STACK IMPLEMENTATION" << endl;
	mystack_vec<int> sv;
	
	// test push
	cout << "\nTESTING PUSH METHOD" << endl;
	sv.push(4);
	sv.push(2);
	sv.push(1);
	if (sv.size() == 3)
		cout << "\nSize of list stack after pushing 3 elements == 3." << endl;
	else
		cout << "\nSize of list stack after pushing 2 elements != 2. (INCORRECT)" << endl;

	// test pop
	cout << "\nTESTING POP METHOD" << endl;
	
	sv.pop();
	sv.pop();
	sv.pop();
	if (sv.size() == 0)
		cout << "\nSize of list stack after popping 3 elements == 0." << endl;
	else
		cout << "\nSize of list stack after pushing 2 elements != 0. (INCORRECT)" << endl;

	// test front
	cout << "\nTESTING TOP METHOD" << endl;
	try {
		cout << "\nThe value of the top element of the empty stack = " << sv.top() <<". (INCORRECT)" << endl;
	}
	catch (domain_error &de) {
		cerr << de.what() << endl;
	}
	
	sv.push(5);
	sv.push(3);
	sv.push(10);
	sv.push(20);
	sv.push(1);
	sv.push(40);
	sv.pop();
	sv.push(55);
	sv.pop(); 
	try {
		if (sv.top() == 1)
			cout << "\nThe value of the top element of the stack == 1." << endl;
		else
			cout << "\nThe value of the top element of the stack != 1. (INCORRECT)" << endl;
	}
	catch (domain_error &de) {
		cerr << de.what() << " (INCORRECT)" << endl;
	}

	sv.printVec();

	
	system("pause");
}

