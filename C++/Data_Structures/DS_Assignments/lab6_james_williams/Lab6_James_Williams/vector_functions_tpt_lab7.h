#ifndef _VECTOR_FUNCS_TPT_H
#define _VECTOR_FUNCS_TPT_H

#include <vector>
#include <stdexcept>
using std::vector;

// TO-DO: implement recursive versions of following functions and modify provided wrapper functions to call recursive functions:
// MAX, MIN, SUM, FIND, CONTAINS, VEC_UNION, INTERSECTION, DIFFERENCE

// Notice I'm giving you the 'normal' interfaces (i.e. the 'wrapper' functions)
// the recursive ones you write may take extra parameters (and then you make the wrappers call them)

// returns the largest element in the vector, throws a domain_error exception if vector is empty
template <typename T> T max(const vector<T>&v){
	if(v.empty())
		throw std::domain_error("Empty vector");
	return max(v, 0);		
}

// finds the largest element in the vector RECURSIVELY
template <typename T> T max(const vector<T>&v, unsigned i){
	return v[0];
}

// returns the smallest element in the vector, throws a domain_error exception if vector is empty
template <typename T> T min(const vector<T>&v) {
	return v[0];
}

// returns the sum of all elements in the vector (0 if empty)
// DO NOT THROW EXCEPTION IF EMPTY
template <typename T> T sum(const vector<T>&v){
	return v[0];
}

// returns index of first element with that value, -1 if not found
// DO NOT THROW EXCEPTION IF EMPTY
template <typename T> int find(const vector<T>&v, T value){
	return 0;
}

// returns true if vector contains that element, 0 otherwise
// DO NOT THROW EXCEPTION IF EMPTY
template <typename T> bool contains(const vector<T>&v, T value) {
	return false;
}

// returns a new vector; every element in v1 and every element in v2 are also in this new vector
// if an element appears in both v1 and v2, it is only added once to the new vector
//
// Think about this from a Discrete Math point of view -- I will go over this in lab
template <typename T> vector<T> vec_union(vector<T> &v1, vector<T> &v2)
{
	return v1;
}

// returns a new vector; every element that is in both v1 and v2 are also in this new vector
// there are no duplicates in v1 and v2
//
// Think about this from a Discrete Math point of view -- I will go over this in lab
template <typename T> vector<T> intersection(vector<T> v1, vector<T> v2)
{
	return v1;
}

// returns a new vector; every element that is in v1 but not v2 are also in this new vector
// there are no duplicates in v1 and v2
template <typename T> vector<T> difference(vector<T> v1, vector<T> v2)
{
	return v1;
}

// END OF TO-DO
#endif
