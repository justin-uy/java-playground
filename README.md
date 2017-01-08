# Java Playground

In effort to exercise my Java muscles and become familiar with Java 8. Here
are a collection of packages that do miscellaneous things.

Part of it is a simple lightweight test "framework".

The latter is partly bred from the fact that I wanted to understand how Java actually
works without the help of an IDE.

```
# Current build/test process
cd bin/
find ../ -name '*.java' | xargs javac -d ./ && java TestRunner
```
