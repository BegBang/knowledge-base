https://www.youtube.com/watch?v=HtwFp5GyFMM

## TDD
- neni to nabozenstvi, ani dogma
- s TDD pomoci lze dosahnout urcitych vyhod
  - pokryti kodu => mame odvahu refaktorovat
  - early design feedback !!
    - vetsinou je jeste cas na zmenu
  - cleaner code
  - happy boss :)
- testovat spis chovani, ne kazdou blbost

## BDD
- TDD is a software development process. BDD is a team process.
- BDD popisuje business testovaci scenare
  - Vetsinou je BDD popis scenaru implementovan pres vice TDD cyklu
- Spolecne se nevylucuji a funguji dohromady
  - BDD zasahuje i do dalsich procesu ve vyvoji software, ale mala cast BDD se da vyuzit v TDD

Psani unit testu jako takove (exponencialne) nakopne dovednost pro spravny navrh (design skills)

## Unit Testy
 - izolovane (mocky)
 - rychle!
 - umi vyresit slozitost (cyclomatic complexity) = vsechny mozne scenare
 - pokud je slozitost mala, je lepsi se vyhnout mockum

## Design
- nepouzivat heavy objects, pokud metoda potrebuje jen 1 nebo 2 property
- pouzivat immutable objekty jako argument metody - pokud se argumenty meni, nelze mockovat
  - melo by byt pravidlo, ze parametry metod se nemeni
- command-query separation
  - void nema vystup, tak meni stav
  - pokud funkce neco vraci, nemela by nic menit
  - pokud je potreba stub (when, ...) a zaroven na stejnout metodu verify (metoda volana 1x - times(1)), je porusen CQS princip
- Složitá logika vyžaduje hodně testů
  - psat funkce s co nejmene zavislostmi, protoze ty se musi mockovat
  - lepsi je mit vse v argumentech
  - complex logic in "pure functions" - na zaklade vstupu vrati vystup
    - Core of the system by mel mit jen "pure functions"
- Social tests - testuji i sve nejblizsi okoli (integracni testy)
  - Nema cenu vse mockovat
  - „If you mock all of your dependencies, your dependencies mock you in production“
  - Mock Roles, not Objects http://jmock.org/oopsla2004.pdf
  - Nez se pouzije Mock, melo by se zvalidovat, zda se neporusuje Single Responsibility Principle (separation of concerns)
- Bloated fixture - nafoukly before[Each], kde je spousta priprav pro vetsinu testu zbytecna
  - Mockito tohle hlida (od urcite verze je to chyba) - zpetna kompatibilita pres Strictness = Lenient
  - Jedno z reseni je rozdelit testy na vice trid
    - nebo rozdelit testovanou tridu na dve
    - nebo lze vyuzit nested class (priprava dat ve vrchni tride, testy ve spodnich)
 
## Separation by Layers of Abstraction  
- Pokud komplexni funkce "a" vola dalsi komplexni funkci "b", lze vyuzit "partial mocks" = @Spy
  - V jednom testu se kompletne otestuje funkce "b"
  - V dalsim testu se pouzije partial mock na funkci "b" a otestuje se funkce "a" ("b" se ve skutecnosti nevola a je mockovano)
  - Jeste lepsi je presunout "b" do jine tridy
  
## Honeycomb testing strategy
- mít více integračních testů, porušuje pyramidu, je to spíše včelí plástev
- produkční kód má 2 řádky, které testuju 8 mocky a verify (zavolala se metoda)
  - asi není také dobře design
- integrační testy jako první a teprve co nejde, tak se testuje unit testy
- lze posunout až na úroveň @SpringBootTest - testovat rovnou celou službu včetně DB

## Object mother
- sdílené vytváření složitějších objektů
- již jsme něco podobného v DCI měli a je dost složité na údržbu, pokud se rozleze
  - svazuje testovací scénáře dohromady
- pokud jsou objekty mutable, lze vrátit standardní instanci a ostatní dotvořit v testu 
- https://blog.codeleak.pl/2014/06/test-data-builders-and-object-mother.html
- 

## Mám třídy, které mají API a DTO z cizích knihoven
- takove by nikdy nemeli projit do jadra systemu, vzdy oddelit
- jadro systemu je silne pokryto testy, okoli vzdy mene
- pouzivam Adapter na propojeni jadra ke zbytku
  - Adapter lze mockovat  

Genericke typy jsou hlavne pro knihovny