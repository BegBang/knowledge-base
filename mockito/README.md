# Mockito

## MATCHER RULES 

1. Use any() for objects. For primitives, use anyDouble(), anyBoolean() etc. 
2. Use eq() to mix matchers and concrete values: method(any(), eq(400.0)) 
3. For nullable Strings, use any().

## Mock vs Spy
- Mock vrací "nice values", logika v metodách se nevolá
  - Mockito.when(mock.method()).thenReturn()
- Spy volá přímo metody z objektu, pokud chci některou metodu mockovat:
  - Mockito.doReturn().when(spy).method()
  - void: Mockito.doNothind.when(spy).method()

Mockito obsahuje BDD syntaxi: import static org.mockito.DBBMockito.*

Answers - pokud potřebuji využít vstupní parametry metody (umí klasické i statické). Místo thenReturn se dává thenAnswer s lambda funkcí.

Mockování final metod funguje v artifactId mockito-inline
Mockování private metod není možné. Nemělo by to být potřeba, většinou je špatně návrh.

PowerMock - raději nepřidávat, vývoj je v něm velmi pomalý (například podpora JUnit5) a většinou stojí mnoho úsilí v něm něco rozběhnout. Jediné, co přinese, je mockování private metod, což je návrhově špatně.

