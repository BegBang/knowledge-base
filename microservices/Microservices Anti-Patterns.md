# Microservices Anti-Patterns

https://www.developer.com/design/solving-microservices-anti-patterns/

- Distributed Monolith
  - Pozná se, že změna jedné služby vyžaduje změnu dalších. Služby nejsou dostatečně odděleny. Základní pravidlo zní, že služby jsou nezávisle programovatelné, testovatelné, nasaditelné a udržovatelné.
- Shared Database
  - Služby sdílejí databázi. Výsledek je, že nelze udělat změna v databázi, protože je potřeba udělat změnu i v dalších služnách.
- Entangled Data
  - Služby sdílejí data, nejsou jasně definované domény, kde každá služba působí.
- Improper Versioning Strategy
  - Bez jasné strategie verzování vznikne mezi jednotlivými službami zmatek.
  
  
# Improve Your Monolith Before Transitioning to Microservices

https://semaphoreci.com/blog/monolith-microservices

Je to spíše seznam věcí, které jsme podcenili při přechodu na služby. Vše chce nějaký čas a vyplatí se s přechodem nechvátat.

- Make a plan
  - Najít potřeby pro přechod na služby
  - Rozplést závislosti uvnitř monolithu.
  - Vytvořit způsob pro migraci a synchronizaci mezi db monolithu a služeb.
  - Zjistit úzké místa u monolith systému. Nastavit cíle pro dostupnost a výkonost nového systému.
- Put everything in a monorepo
  - Pro snadnější start verzovat vše v jednom repository, monolith včetně služeb, snadněji se přesouvá funkčnost z jednoho projektu do jiného a zase zpět.
- Ensure you have enough testing
  - Správně nastavená testovací pyramida. Unit testama se snadno ověří, že se nic nerozbilo/neztratilo.
- Consider the monolith-in-a-box pattern
  - Nechat nějakou dobu běžet monolith v dockeru a k8s, osahat si infrastrukturu.
- Modularize the monolith
  - Pokud je v monolithu silná provázánost, nejspíše tak skončí i služby. Nejdříve je dobré udělat dekompozici v rámci monolithu a co nejvíce roztrhat existující vazby a cykliclé závislosti. Veřejně dostupné rozhranní se snadno převádí na API služby.
- Decouple the data
  - V monolithu to lze například přes schémata, případně úplně odlišné databáze.
- Add observability
  - Nový systém by měl být rychlejší a škálovatelnější. Vytvořit metriky a najít ideálně jedno místo, kde je měřit.