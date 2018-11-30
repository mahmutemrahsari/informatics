#Oppgave 3
from ezgraphics import GraphicsWindow
import time

#Lager et grafikkvindu
win = GraphicsWindow() #3.1
can = win.canvas() #3.1
teller = 0 #3.2
s = 120
x_pos = 10 #3.2


storrelse=0
#3.3 Fortsetter saa lenge teller er mindre enn 9.
#For hver gang lokken kjorer skal det tegnes en sirkel.
while teller < 9: 
    time.sleep(0.2)
    can.drawOval(x_pos, 100, s, s)
    x_pos = x_pos + 10
  	teller+=1

win.wait()