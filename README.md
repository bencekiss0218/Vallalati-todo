# Vállalati - todo
Alkalmazások fejlesztése tantárgy keretein belül fejlesztett beadandó feladat
Gyugyi Péter - EZEL5H Kiss Bence - I10EJA


## Feladat funkcionális követelményei:
1. Felhasználó regisztrálni tud a rendszerbe
	1. Regisztráció sikeres a kötelező mezők kitöltésével. Ügyelni kell a felhasználónak, hogy a mezőket megfelelő adatokkal töltse ki.
2. Felhasználó be tud lépni a rendszerbe
	1. Már regisztrált felhasználó be tud lépni a rendszerbe, ha megadja a regisztráció során megadott nevét, valamint jelszavát. Hibás felhasználó vagy jelszó esetén hibaüzenet.
3. Bejelentkezett felhasználó láthatja a vállalaton belüli felhasználók, feladatait
	1. Felhasználó tud szűrni a vállalaton belül feladatokra, valamint a többi felhasználóra
4. Vállalati feladatok hozzáadása, valamint törlése
	1. Felhasználó képes feladat hozzáadására, törlésére
5. Felhasználó hozzáadhat kommentet a feladatokhoz, megtekintheti a feladatot, változtathat a határidején, szűrhet feladatokra

## Feladat nem funkcionális követelményei:
1. Átlátható, letisztult, egyértelmű felhasználói felület
2. Az alkalmazás a fent említett funkcionális követelményeknek megfelel
3. Jelszavak biztonságos tárolása

## Szakterületi fogalomjegyzék:
 - Felhasználó: Egy munkatárs aki regisztráció során hitelesítette magát.
 - Hozzáadás: Új feladat felvétele.
 - Feladat: Elvégzendő tennivaló
 - Feladatok Listája: A feladatok összesége.
 - Feladatok státusza lehet: 
		1. New (ezt a feladatot nem rég adták hozzá, még nincs vele foglalkozva)
		2. In Work (ezt a feladatot az adott felhasználó már elkezdte)
		3. On Hold (ezt a feladatot az adott felhasználó elkezdte, de most épp másik feladattal foglalkozik ezért várakozó státuszra rakta)
		4. Done (ezt a feladatot az adott felhasználó befejezte)

## Szerepkörök: 
1. Megfelelő szerepkörök biztosítása a vállalat munkafolyamatainak pontos elvégzésére.
 	- Csapatvezető és csapattag kapcsolat 
	- Csapatvezetőnek lehetősége van feladat törlésére, csapattagnak nincs hozzá joga