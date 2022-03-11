DIACONU ARINA-IOANA		

		    README - LIBRODATA

	Implementare:

	Clasele de baza - Book, Languages, Author, EditorialGroup, PublishingBrand, Country si 
PublishingRetailer si interfata IpublishingArtifact. 
	Clasele Book, EditorialGroup si PublishingBrand implementeaza interfata IpublishingArtifact
si implicit suprascriu metoda Publish().
	La partea de initializare, se citesc liniile fiecarui fisier de initializare dat in arhiva de
initializare. Pentru fiecare fisier in parte, se sare peste prima linie ce descrie ce contine respectivul
fisier. Pentru fiecare linie din fisier, se citeste, se desparte in cuvintele delimitate de sirul de 
caractere dat si se initializaza fiecare camp, dupa care se initializeaza obiectul despre care se citesc
respectivele date sau se realizeaza legaturile in functie de ce fisier se citeste. 
	La sfarsitul citirii tuturor fisierelor, obiectul ce uneste toti vectorii - de carti, de limbi, 
de autori, de grupuri editoriale, de branduri de publicatie, de tari si de retaileri - se numeste LibroData.
Acest obiect contine toata biblioteca digitala de carti, impreuna cu toate legaturile dintre elementele
acesteia.
	La partea de functii ce manipuleaza datele acestei biblioteci digitale, am creat clasa 
Administration. Ea initializeaza biblioteca digitala si contine implementarea functiilor:
		- getBooksForPublishingRetailerID - cauta retailer-ul dat in lista de retaileri si pentru
fiecare carte din lista de carti ale acelui retailer, indiferent ca provin direct din clasa Book, 
EditorialGroup sau PublishingBrand, verifica daca este unica si o adauga in lista de carti pe care o 
intoarce la sfarsit.
		- getLanguagesForPublishingRetailerID - cauta retailer-ul dat in lista de retaileri si 
pentru fiecare carte din lista de carti ale acelui retailer, retine limba in care este scrisa cartea.
O verifica daca este unica, si daca este, mai intai o cauta in lista de limbi pentru a-i afla numele si
codul. Dupa aceea o adauga la lista de limbi pe care o intoarce la sfarsit.
		- getCountriesForBookID - parcurge lista de retaileri si pentru fiecare carte a fiecarui
retailer, daca este cartea data ca parametru, se retine tara in care a ajuns acea carte. Se cauta in lista
de tari acea tara pentru a-i seta codul si de adauga la lista de tari pe care o intoarce la sfarsit.
		- getCommonBooksForRetailerIDs - prima data se gasesc in lista de retaileri cei doi dati
ca parametri. Pentru a obtine complexitatea dorita O(n+m), se foloseste un hashtable in care se adauga 
cartile aferente primului retailer. Dupa aceea se ia fiecare carte a celui de-al doilea retailer si daca se 
afla in hashtable, se adauga la lista de carti intoarsa la sfarsitul functiei.
		- getAllBooksForRetailerIDs - prima data se gasesc in lista de retaileri cei doi dati ca 
parametri. Pentru a obtine complexitatea dorita O(n+m), se foloseste un hashset in care se adauga cartile
aferente ambilor retaileri. Hashset-ul retine doar cartile unice. La final, se parcurge hashset-ul si se 
construieste lista de carti intoarsa de functie.
	Clasa Test initializeaza clasa Administration si testeaza cu 5 seturi de teste diferite functiile 
implementate anterior.