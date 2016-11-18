__author__ = 'jameswilliams'

import random

print('Hello World!')

# Python program to display the Fibonacci sequence up to n-th term using recursive functions

def recur_fibo(n = random.randint(1,10)):
   """Recursive function to print Fibonacci sequence"""
   if n <= 1:
       return n
   else:
       return(recur_fibo(n-1) + recur_fibo(n-2))


# take input from the user
nterms = random.randint(1,20)

# check if the number of terms is valid
if nterms <= 0:
   print("Plese enter a positive integer")
else:
   print("Fibonacci sequence:")
   for i in range(nterms):
       print(recur_fibo(i))

#prime numbers within range
lower = int(input("Enter lower range: "))
upper = int(input("Enter upper range: "))

for num in range(lower,upper + 1):
   if num > 1:
       for i in range(2,num):
           if (num % i) == 0:
               break
       else:
           print(num)


a = random.randint(0, 1000)
b = random.randint(0, 1000)
if a < b:
    lower = a
    upper = b
else:
    lower = b
    upper = a

print('Printing primes beween random ranges')
print('Lower: %d \tUpper: %d' % (lower, upper))

for num in range(lower,upper + 1):
   if num > 1:
       for i in range(2,num):
           if (num % i) == 0:
               break
       else:
           print(num)

# Shuffle deck of cards
import itertools

# make a deck of cards
deck = list(itertools.product(range(1,14),['Spade','Heart','Diamond','Club']))

# shuffle the cards
random.shuffle(deck)

# draw five cards
for i in range(5):
   print('You got: %d of %s' %(deck[i][0], deck[i][1]))
print('\n')

import calendar
yy = random.randint(2000, 2015)
mm = random.randint(1,12)

# display the calendar
print('Random Month, Year: %d, %d' %(mm, yy))
print(calendar.month(yy,mm))

# Solve the quadratic equation ax**2 + bx + c = 0
# Coeffients a, b and c are provided by the user

# import complex math module
import cmath

a = float(input('Enter a: '))
b = float(input('Enter b: '))
c = float(input('Enter c: '))

# calculate the discriminant
d = (b**2) - (4*a*c)

# find two solutions
sol1 = (-b-cmath.sqrt(d))/(2*a)
sol2 = (-b+cmath.sqrt(d))/(2*a)

print('The solution are {0} and {1}'.format(sol1,sol2))