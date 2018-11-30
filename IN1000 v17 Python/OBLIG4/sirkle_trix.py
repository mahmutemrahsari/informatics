from ezgraphics import GraphicsWindow
import time

win = GraphicsWindow()
canvas = win.canvas()
i = 0
s = 20
x = 10
while i < 9:
    time.sleep(0.1)
    canvas.drawOval(x, 100, s, s)
    x = x + s + 10
    if i < 4:
        s+=5
    else:
        s-=5


    i+=1

win.wait()