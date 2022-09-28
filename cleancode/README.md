# 97 Things every Java Programmer should know - myšlenky
## Behavior Is "Easy"; State Is Hard
### === aneb **zapouzdření** je jedna z nejdůležitějších OOP myšlenek. ===
> When I was first introduced to object-oriented programming, some of the very first concepts taught were the triple of polymorphism, inheritance, and encapsulation. And to be honest, we spent quite some time trying to understand and code with them. But, at least for me, too much emphasis was given to the first two, and very little to the third and most important of all: encapsulation.

> Encapsulation allows us to tame the growing state and complexity that is a constant in the software development field. The idea that we can internalize the state, hide it from other components, and offer only a carefully designed API surface for any state mutation is core to the design and coding of complex information systems

# Použití návrhových vzorů s rozumem
https://stackoverflow.com/questions/449731/design-patterns-to-avoid

> All design patterns should be used with care. In my opinion you should refactor towards patterns when there is a valid reason to do so instead of implementing a pattern right away. The general problem with using patterns is that they add complexity. Overuse of patterns makes a given application or system cumbersome to further develop and maintain. Remember that your goal should be simplicity and employ a pattern if you see a practical need to support change in your code.

* Program to an 'interface', not an 'implementation'. (Gang of Four 1995:18)
* Favor 'object composition' over 'class inheritance'. (Gang of Four 1995:20)

