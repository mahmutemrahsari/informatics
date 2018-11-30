class Maks{
	public static void main(String[] args) 
	{
		int[] a = {1,2,4,5,6,77};

	}

	public static int maks(int[] a) // a er en heltallstabell
	{
		if (a.length < 1)
			throw new java.util.NoSuchElementException("Tabellen a er tom!");

		int m = 0; // indeks til stoerste verdi

		for (int i = 1; i < a.length; i++) // obs: starter med i = 1
		{
			if (a[i]>a[m]) m = i; // indeksen oppdateres
		}
			System.out.println(a[i]);
				System.out.println(a[m]);
		return m; // returnerer indeksen/posisjonen til stoerste verdi
	} // maks
	
}