/* October 16, 2014 - Data Structures Lecture - Recursion */

/*
*   1)- Base case -> Recursive case
*     - Wrapper
*   2)- Examples: Factorial, Fibonacci Numbers
*
*   3)- Recursive ways\__ Linear Search: O(n)
*        vs.          \__ Binary Search: 0(log n)
*       Iterative ways\__


*   --- !!! 1 (wrapper) and 3 will be in the final!!! ---


* runtime stack and activation frames
*
*
*
*
*
*
*
*
*/

#include <string>
using namespace std;

int rec_size(string s);
int iter_factorial(int n);
int recur_factorial(int n);
double rec_power(double x, int n);
int rec_gcd(int m, int n);
int rec_2n_fibonacci(int n);
int rec_n_fibo(int fib_current, int fib_previous, int n);
int rec_n_wrapper_fibonacci_start(int n);


//////////////////////////////////
int main(){

    retun 0;
}
//////////////////////////////////



int rec_size(string s){
    if(string == ""){
        return;
    }
    else
        return 1+ size(s.substr(1));
}

int iter_factorial(int n){
    int fact = 1;
    for(int i = 1; i <= n; i++){
        fact = fact*n;
    }
    return fact;

}

int rec_factorial(int n){
    if(n == 0 && 1)
        return 1;
    else{
        return n * rec_factorial(n-1);
    }
}

/** Recursive power function
@param x The number being raised to a power @param n The exponent
@return x raised to the power n
*/
double rec_power(double x, int n) {
    if (n == 0){
        return 1;
    }
    else if (n > 0){
        return x * power(x, n – 1);
    }
    else{
        return 1.0 / power(x, -n);
    }
}

/** Recursive gcd function
pre: m > 0 and n > 0
@param m The larger number
@param n The smaller number
@return Greatest common divisor of m and n */
int rec_gcd(int m, int n) {
    if (m % n == 0){
        return n;
    }
    else if (m < n){
        return rec_gcd(n, m);
    }
    // Transpose arguments else
    return rec_gcd(n, m % n);
}


/** Recursive function to calculate Fibonacci numbers pre: n >= 1.
@param n The position of the Fibonacci number being calculated
@return The Fibonacci number
*** !!! O(2^n) !!! ***
*/
int rec_2n_fibonacci(int n) {
    if (n <= 2){
        return 1;
    }
    else{
        return fibonacci(n – 1) + fibonacci(n – 2);
    }
}


/*
Recursive O(n) function to calculate Fibonacci numbers pre: n >= 1
@param fib_current The current Fibonacci number
@param fib_previous The previous Fibonacci number
@param n The count of Fibonacci numbers left to calculate
@return The value of the Fibonacci number calculated so far
*/
int rec_n_fibo(int fib_current, int fib_previous, int n) {
  if (n == 1)
    return fib_current;
  else
    return rec_n_fibo(fib_current + fib_previous, fib_current, n – 1);
}

/*
Wrapper function for calculating Fibonacci numbers pre: n >= 1
@param n The position of the desired Fibonacci number
@return The value of the nth Fibonacci number
*/
int rec_n_wrapper_fibonacci_start(int n) {
     return rec_n_fibo(1, 0, n);
}

/** Recursive linear search function
@param items The vector being searched
@param target The item being searched for
@param pos_first The position of the current first element
@return The subscript of target if found; otherwise -1
*/
template<typename Item_Type>int
    linear_search(const std::vector<Item_Type>& items,
    const Item_Type& target, size_t pos_first) {

    if (pos_first == items.size()){
        return -1;
    }
    else if (target == items[pos_first]){
        return pos_first;
    }
    else{
        return linear_search(items, target, pos_first + 1);
    }
}

/** Wrapper for recursive linear search function
@param items The vector being searched
@param target The object being searched for
@return The subscript of target if found; otherwise -1
*/
template<typename Item_Type>int
    linear_search(const std::vector<Item_Type>& items,
    const Item_Type& target) {

    return linear_search(items, target, 0);
}

/*
Recursive binary search function (in binary_search.h).
@param items The vector being searched
@param first The subscript of the first element
@param last The subscript of the last element
@param target The item being searched for
@return The subscript of target if found; otherwise -1
*/
template<typename Item_Type>int
    binary_search(const std::vector<Item_Type>& items,
    int first, int last, const Item_Type& target) {

        if (first > last){
            return -1;  // base case for unsuccessful search
        }
        else {
            if(target == items[middle])
                return middle;
            else if()
        }
    }
