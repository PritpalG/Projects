##ASSIGNMENT 3: TURTLE PICTURE

import turtle as t
#Star Function
def shape_star(size, color):
    angle = 120
    t.fillcolor(color)
    t.begin_fill()

    for side in range(5):
        t.forward(size)
        t.right(angle)
        t.forward(size)
        t.right(72 - angle)
    t.end_fill()
    return
#Center circle function
def middle_circle(di):
    t.fillcolor("black")
    t.begin_fill()
    t.circle(di)
    t.end_fill()
#cool box function    
def box_spin(rad):
    t.speed(0)
    for x in range(90):
        t.forward(1)
        t.right(1)
        t.right(90)
        t.forward(rad)
    
#box pair Function
def box_spin2(mad):
    t.speed(0)
    box_spin(75)
    t.penup()
    t.right(180)
    t.forward(25)
    t.right(90)
    t.forward(-40)
    t.pendown()
    middle_circle(10)
    t.penup()
    t.right(175)
    t.forward(375)
    t.pendown()
    box_spin(75)
    t.penup()
    t.right(180)
    t.forward(25)
    t.right(90)
    t.forward(-38)
    t.pendown()
    middle_circle(10)

    
#Non Fruitful Functions

#Gets pen in place
t.penup()
t.left(90)
t.left(90)
t.forward(300)
t.left(90)
t.forward(185)
t.pendown()

##Makes flat P
t.width(3)
t.pencolor("red")
t.fillcolor("black")
t.begin_fill()
t.left(180)
t.forward(490)
t.right(90)
t.forward(250)
t.right(90)
t.forward(195)
t.right(90)
t.forward(175)
t.end_fill()

#Gets ready for inner bubble of P
t.penup()
t.right(90)
t.forward(50)
t.right(90)
t.forward(5)
t.pendown()

#starts bubble
t.pencolor("red")
t.fillcolor("white")
t.begin_fill()
t.width(3)
t.forward(100)
t.left(90)
t.forward(100)
t.left(90)
t.forward(100)
t.left(90)
t.forward(100)
t.pencolor("black")
t.end_fill()

#getting to bubble part for bottom of P
t.penup()
t.forward(345)
t.right(90)
t.forward(80)
t.pendown()

#Bottom bubble of P
t.pencolor("red")
t.left(180)
t.forward(75)
t.left(90)
t.forward(295)
#Getting ready for G
t.penup()
t.right(90)
t.forward(450)
t.left(90)
t.forward(195)
t.pendown()

#Design for G
t.fillcolor("blue")
t.width(1)
t.pencolor("red")
t.left(90)
t.forward(220)
t.left(90)
t.forward(200)
t.left(45)
t.pencolor("black")
t.forward(83)
t.pencolor("red")
t.left(135)
t.forward(215)
t.right(90)
t.forward(162)
t.left(90)
t.forward(45)
t.end_fill()

#G
t.width(3)
t.fillcolor("black")
t.begin_fill()
t.left(90)
t.forward(220)
t.left(90)
t.forward(500)
t.left(90)
t.forward(200)
t.left(90)
t.forward(175)
t.left(90)
t.forward(100)
t.left(90)
t.forward(55)
t.left(90)
t.forward(40)
t.right(90)
t.forward(80)
t.right(90)
t.forward(80)
t.right(90)
t.forward(415)
t.right(90)
t.end_fill()
t.forward(160)
t.left(90)
t.forward(45)

#Getting ready for 4 random squares
t.penup()
t.left(180)
t.forward(95)
t.right(90)
t.forward(397)
t.pendown()

#for loop squares random color
t.width(2)
t.pencolor("red")
import random
for i in range(random.randint(1,4)):
    t.fillcolor("red")
    t.begin_fill()
    t.forward(50)
    t.left(90)
    t.forward(50)
    t.left(90)
    t.forward(50)
    t.left(90)
    t.forward(50)
    t.end_fill()
    
#Getting ready for the random squares -2
t.penup()
t.goto(105,-114)
t.pendown()

# Random batch of squares-2
t.pencolor("red")

for i in range(random.randint(1,4)):
    t.fillcolor("red")
    t.begin_fill()
    t.forward(39)
    t.left(90)
    t.forward(39)
    t.left(90)
    t.forward(39)
    t.left(90)
    t.forward(39)
    t.end_fill()
#Getting ready for star function
t.penup()
t.goto(-240,-172)
t.pendown()



# P Star forming
shape_star(5, "black")

#Move to star 2
t.penup()
t.goto(212,276)
t.pendown()

# G star forming- Function is reused
shape_star(5, "black")

#cool circles
t.pencolor("black")    
t.speed(0)
for i in range(1, 500, 50):
        t.right(90)    
        t.forward(i)   
        t.right(270)  
        t.pendown()    
        t.circle(i)    
        t.penup()      
        t.home()

#Moving to final circle pair
t.penup()
t.goto(-220,-225)
t.pendown()

#Final Circle pair
box_spin2(75)


#End of program



