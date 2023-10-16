from math import *
from functools import reduce

print("Welcome to ITC")
# Triangle shape
print("Practicing Shapes")
print("    /|")
print("   / |")
print("/____|")

# Variables
print("Practicing Variables")
my_name = "Qasim"
my_age = "25"
print(my_name + ", Stay focused")
print("Don't give up")
print("consistency is key, " + my_name)
print("Its never too late to start, " + my_name)
print("You are" + my_age + "and you are on time")

character_name = "Qasim"
print("Hello " + character_name)

#operations on strings
phrase = "Have a Good Day"
print(phrase.upper())
print(phrase.upper().islower())
print(len(phrase))
print(phrase[3])
print(phrase.index("e"))
print(phrase.index("Good"))
print(phrase.replace("Have","Had"))


#working with numbers
print(100)
print(40+50.55)
print(5*6+10)
print(100 % 6)
num = -4
print(abs(num)) #absolute value output:4
print(pow(2,4))
print(max(333,234))
print(round(45.4))
print(floor(5.9))  #output 5
print(ceil(5.9))   #output 6

#getting input: input(prompt)
name = input("Enter your name")
print("Hi " + name)

#calculator
num1 = input("Enter a number")
num2 = input("Enter another number")
result = float(num1) + float(num2)
print(result)

#Madlibs game
color = input("Enter a color: ")
plural_noun = input("Enter a plural noun: ")
celebrity = input("Enter a celebrity: ")

print("Roses are "+color)
print("Plural noun  "+plural_noun)
print("I love  "+celebrity)

#lists
friends = ["Raj","Robert","Alice", "Peter","Sophia"]
friends.append("Ruby")
friends.insert(2,"Jack")
friends.remove("Peter")
friends.pop() #removes the last element
print(friends.index("Raj"))
friends.clear()
print(friends[1:])
print(friends[2:4])
friends_copy = friends.copy()

#list functions
num_list = [2,5,6,9,12,45]
print(num_list)
print(friends)
print(friends_copy)

#Tuples(immutable)
coordinates = (4,5,6)
print(coordinates[2])
tup1 = [(3,5),(4,6),(1,7)]  #list of tuples

#Functions
def greeting(name):
    print("Hello "+name)
greeting("Chris")

def exponent(x,y):
    return(x**y)
print(exponent(2,3))


#If statements
is_female = True
is_tall = True
if is_female or not(is_tall):
    print("You are either female or tall or both")
elif is_female and is_tall:
    print("You are female and tall")
else:
    print("You are neither female not tall")

def max_num(x,y,z):
    if x>=y and x>=z:
        return x
    elif y>=x and y>=z:
        return y
    else:
        return z
print(max_num(9,3,2))


#calculator
num1 = float(input("Enter the first number: "))
num2 = float(input("Enter the second number: "))
op = input("Enter operator: ")

if op == "+":
    print(num1+num2)
elif op == "-":
    print(num1-num2)
elif op == "*":
    print(num1*num2)
elif op == "/":
    print(num1/num2)
else:
    print("Invalid operator")

#Dictionary: stored as key, value pair
monthConversions = {
    "Jan": "January",
    "Feb": "February",
    "Mar": "March",
    "April": "April",
    "Sep": "September",
    "Dec": "December"
}
print(monthConversions)
print(monthConversions["Feb"])
print(monthConversions.get("Mar"))
print(monthConversions.get("August", "Not in the dictionary"))

#while loop
i=1
while i<=6:
    print(i)
    i +=1

#secret word game
count = 0
secret_word ="potato"
guess = ""
out_of_trial = False

while guess!= secret_word and not(out_of_trial):
    if count<3:
        guess = input("Guess the word: ")
        count +=1
    else:
        out_of_trial = True
if out_of_trial:
    print("Out of trials, you loose")
else:
    print("You win!!!!!!!!!!!")

#For loop
for letter in "Hello":
    print(letter)

#for loops - exponent function
def exponentfn(base_num, pow_num):
    result= 1
    for index in range(pow_num):
        result = result * base_num
    return result
print(exponentfn(2,4))

#lists
number_grid = [[1,2,3],[4,5,6],[7,8,9],[0]]
print(number_grid[1][1]) #result 5

#nested for loops
for row in number_grid:
    for col in row:
        print(col)

#functional programming - pure function
def multiply_by2(li):
    new_list= []
    for item in li:
        new_list.append(item*2)
    return new_list
print(multiply_by2([1,2,3]))

#side effects
def multiply_by2(li):
    new_list= []
    for item in li:
        new_list.append(item*2)
    return print(new_list)   #interacting to the outside world, print
multiply_by2([1,2,3])

#map, filter, zip and reduce
#map - reduces the code
def multiply_by2(item):
    return item*2
print(list(map(multiply_by2, [1,2,3])))

#filter
my_list =[1,2,3]
def check_odd(item):
     return item % 2 != 0
print(list(filter(check_odd, my_list)))

#zip - zips two lists as list with tuples
my_list = [1,2,3]
your_list = [10,20,30]
print(list(zip(my_list, your_list)))

#reduce - not a built in function, have to import from functools
def accumulator(acc, item):
    print(acc, item)
    return acc+item
print(reduce(accumulator, my_list,2))


#lambda
n=[1,2,3,4]
print(list(map(lambda x : x*2,n)))
print(list(filter(lambda x : x%2 !=0 , n)))
print(reduce(lambda x,y : x+y , n))





