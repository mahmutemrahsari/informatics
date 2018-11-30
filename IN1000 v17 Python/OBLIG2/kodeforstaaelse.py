"""
1) Nei dette er ikke lovlig kode. Fordi den er i linje 13 (print(b +"Hei!"))
gir "TypeError: unsupported operand type(s) for +: 'int' and 'str' ". 
Fordi i " print( b + "Hei!") " der prøves å samle integer og string typer.
den er ikke lov i python.

2) Det er TypeError i " print(b + "Hei!") ". Utenfor den er lovlig kode.
Vi kan fikse det problemmet med endres "print(b + "Hei!")" til "print(str(b) + "Hei!")"
 det skal kjøre med uten problem.
"""

a = input("Tast inn et heltall! ")
b = int(a)
if b < 10:
    print(str(b) + "Hei!")
