import sys
import time

import pandas as pd

# peanut butter cookies recipe
cookiesPB = [
    # ingredient, quantity, type
    ['Quantity', 36.0, 'count'],
    ['Cook Time', 45.0, 'min'],
    ['Prep Time', 15.0, 'min'],
    ['Shortening', 1.0, 'cup'],
    ['Peanut Butter', 1.0, 'cup'],
    ['Sugar', 1.0, 'cup'],
    ['Brown Sugar', 1.0, 'cup'],
    ['Eggs', 3.0, 'egg'],
    ['Flour', 3.0, 'cup'],
    ['Baking Soda', 2.0, 'cup'],
    ['Salt', 0.25, 'teaspoon']
]
PBtemp = 375.0

# jumbo brownie cookie recipe
cookiesJB = [
    # ingredient, quantity, type
    ['Quantity', 18.0, 'count'],
    ['Cook Time', 30.0, 'min'],
    ['Prep Time', 20.0, 'min'],
    ['Chocolate Chips', 2.67, 'cup'],
    ['Butter', 0.5, 'cubed'],
    ['Eggs', 4.0, 'egg'],
    ['Sugar', 1.5, 'cup'],
    ['Vanilla Extract', 4.0, 'teaspoon'],
    ['Espresso Powder', 2.0, 'teaspoon'],
    ['Flour', 0.67, 'cup'],
    ['Baking Powder', 0.5, 'teaspoon'],
    ['Salt', 0.25, 'teaspoon'],
    ['Chocolate Chunks', 11.5, 'ounces']
]
JPtemp = 350.0

print("Hello, I am ready to make you some cookies!")
print("What kind of cookies do you want to make? --(enter 1 or 2)")
print("1. Peanut Butter")
print("2. Jumbo Brownie")

while True:
    cookieType = input()
    if cookieType == '1' or cookieType == '2':
        break
    else:
        print("Please enter a valid input of 1 or 2")

print("Thanks!")
print("How many cookies would you like to bake?")

while True:
    cookieCount = input()
    if cookieCount.isnumeric():
        break
    else:
        print("Please enter a valid number")

if cookieType == "1":
    stageList = cookiesPB
    temp = PBtemp
else:
    stageList = cookiesJB
    temp = JPtemp

pdList = pd.DataFrame(stageList, columns=["Ingredient", "Quantity", "Type"])

# divides each value to provide what's needed per cookie then multiplies
# by user requested count
recipeCount = pdList["Quantity"][0]
alterValues = pdList[pdList.columns[1:2]] / recipeCount * int(cookieCount)
ingredientList = pdList[pdList.columns[0:1]]
typeList = pdList[pdList.columns[2:3]]
mergeList = ingredientList.merge(alterValues, left_index=True, right_index=True).merge(typeList, left_index=True,
                                                                                       right_index=True)

print()
print("Here are the ingredients I have gathered:")
print(mergeList[3:])
print()
print("The cookies require a heat of " + str(temp) + " for " + str(round(mergeList["Quantity"][2], 2)) + " minutes")
print()
print("Would you like me to make your cookeis? You may have to wait a while... (enter yes or no)")


def printSlow(str):
    for letter in str:
        sys.stdout.write(letter)
        sys.stdout.flush()
        time.sleep(mergeList["Quantity"][2] / 10 / 15)

while True:
    wait = input()
    if wait == "yes":
        print("Baking now:")
        printSlow("[---------DONE]")
        break
    elif wait == "no":
        break
    else:
        print("please type yes or no")

print()
print("Enjoy and have a great day!")
