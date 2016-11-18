class calculator:
	def fibonacci(x, y=1):
		if(x > 1):
			y *= x
			x = x - 1
			fibonacci(x, y)
		else:
			print('fibonacci result: ', x)


import caclulator

calculator.fibonacci(8)