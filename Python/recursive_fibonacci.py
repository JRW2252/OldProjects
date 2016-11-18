

def fibonacci(x, y = 1):
	if(x > 1):
		y *= x
		x = x - 1
		fibonacci(x, y)
	else:
		print y

def add(x, y):
	print x + y

def sub(x, y):
	print x - y 
########################
# for x in xrange(1, 750):
# 	print(x)
# 	fibonacci(x)
# 	print('\n')
########################
num = input('enter a number to get it\'s fibonacci: ')
fibonacci(num)