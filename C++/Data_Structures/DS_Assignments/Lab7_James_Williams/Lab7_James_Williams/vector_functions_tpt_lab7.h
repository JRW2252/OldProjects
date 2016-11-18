/* name: James Williams */

#ifndef _VECTOR_FUNCS_TPT_H
#define _VECTOR_FUNCS_TPT_H

#include <vector>
#include <stdexcept>
using std::vector;

// TO-DO: implement recursive versions of following functions and 
// modify provided wrapper functions to call recursive functions:
// MAX, MIN, SUM, FIND, CONTAINS, VEC_UNION, INTERSECTION, DIFFERENCE
template <typename T> T max(const vector<T>&v){
	if (v.empty())
		throw std::domain_error("Empty vector");
	return max(v, 0, 0);
}
template <typename T> T max(const vector<T>&v, int i, int m){
	if (i == v.size())
		return m;
	if (v[i] > m)
		m = v[i];
	return max(v, ++i, m);
}
template <typename T> T min(const vector<T>&v) {
	if (v.empty())
		throw std::domain_error("Empty vector");
	return min(v, 0, 0);
}
template <typename T> T min(const vector<T>&v, int i, int m) {
	if (i == v.size())
		return m;
	if (i == 0)
		m = v[i];
	else if (v[i] < m)
		m = v[i];
	return min(v, ++i, m);
}
template <typename T> T sum(const vector<T>&v){
	return sum(v, 0, 0);
}
template <typename T> T sum(const vector<T>&v, int i, int s){
	if (i == v.size())
		return s;
	s += v[i];
	return sum(v, ++i, s);
}
template <typename T> int find(const vector<T>&v, T value){
	return find(v, value, 0, false);
}
template <typename T> int find(const vector<T>&v, T val, int i, bool b){
	if (i == v.size() && b == false)
		return -1;
	if (val == v[i])
		return i;
	return find(v, val, ++i, false);
}
template <typename T> bool contains(const vector<T>&v, T value) {
	return contains(v, value, 0, false);
}
template <typename T> bool contains(const vector<T>&v, T val, int i, bool b) {
	if (i == v.size() && b == false)
		return false;
	if (val == v[i])
		return true;
	return contains(v, val, ++i, false);
}
template <typename T> vector<T> vec_union(vector<T> &v1, vector<T> &v2)
{
	int s = v2.size();
	vector<T> v3 = v1;
	return vec_union(v2, v3, s, 0);
}
template <typename T> vector<T> vec_union(vector<T> &v2, vector<T> &v3, int s, int i){
	if (i == s)
		return v3;
	if (contains(v3, v2[i]) == false)
		v3.push_back(v2[i]);
	return vec_union(v2, v3, s, ++i);
}
template <typename T> vector<T> intersection(vector<T> v1, vector<T> v2)
{
	int s = v2.size();
	vector<T> v3; 
	return intersection(v1, v2, v3, s, 0);
}
template <typename T> vector<T> intersection(vector<T> v1, vector<T> v2, vector<T> v3, int s, int i)
{
	if (i == s)
		return v3;
	if (contains(v1, v2[i]) == true && contains(v3, v2[i]) == false)
		v3.push_back(v2[i]);
	return intersection(v1, v2, v3, s, ++i);
}
template <typename T> vector<T> difference(vector<T> v1, vector<T> v2)
{
	int s = v1.size(); 
	vector<T> v3; 
	return difference(v1, v2, v3, s, 0);
}
template <typename T> vector<T> difference(vector<T> v1, vector<T> v2, vector<T> v3, int s, int i){
	if (i == s)
		return v3; 
	if (contains(v2, v1[i]) == false && contains(v3, v1[i]) == false)
		v3.push_back(v1[i]); 
	return difference(v1, v2, v3, s, ++i);
}
// END OF TO-DO
#endif