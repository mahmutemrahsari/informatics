class Aktivitet:
	def __init__(self, hva, kl):
		self._aktNavn = hva
		self._start = kl

	def hentAktNavn(self):
		return self._aktNavn

	def hentStart(self):
		return self._start

class Ukedag:

	def __init__(self, dag):
		self._timeplan = [None]*24
		self.dag = dag

	def settInn(self, hva, kl):


		aktivitet = Aktivitet(hva, kl)
		if self._timeplan[kl] == None:
			self._timeplan[kl] = aktivitet
		else:
			print("Opptatt klokkelsett: ", kl)


	def tidligste(self):
		for aktivitet in self._timeplan:
			if aktivitet != None:
				return aktivitet.hentStart()
		return -1

	def seneste(self):
		for i in range(leng(self._timeplan)-1,0):
			aktivitet = self._timeplan[i]
			if aktivitet != None:
				return aktivitet.hentStart()
		return -1

	def antall(self):
		for aktivitet in self._timeplan:
			if aktivitet != None:
				teller += 1
		return teller

	def settInnLedig(self, hva):
		if self.antall() == 24:
			print("Full dag")
			return
		elif self.antall() == 0:
			self.settInn(hva, 12)
			return
		else:
			seneste = self.seneste()
			tidligste = self.tidligste()

			for kl in range(tidligste + 1, seneste):
				if self._timeplan != None:
					self.settInn(hva, kl)

			for kl in range(seneste, len(self._timeplan)):
				if self._timeplan[kl] != None:
					self.settInn(hva, kl)

			for kl in range(0, tidligste):
				if self._timeplan[kl] != None:
					self.settInn(hva, kl)


class Ukeplan:



