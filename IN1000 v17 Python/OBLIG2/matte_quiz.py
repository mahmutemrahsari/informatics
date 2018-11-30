"""Det blir matte-quiz program for grunnskole elever.
Det skal sporre  denne sprosmolene som er (4 + 12 = ? , 15 - 6 = ? ,  99 / 9 = ?)
"""
print("Velkommen til matte-quiz")
svar = input("4 + 4 = ?\n")
if svar == str(8):
	print("Riktig!")
else:
	print("Feil!")
svar = input("15 - 6 = ?\n")
if svar == str(9):
	print("Riktig!")
else:
	print("Feil!")
svar = input("99 / 9 = ?\n")
if svar == str(11):
	print("Riktig")
else:
	print("Feil!")		
print("Quizen er ferdig!")	