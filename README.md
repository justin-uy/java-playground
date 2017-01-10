# Java Playground

In effort to exercise my Java muscles and become familiar with Java 8. Here
are a collection of packages that do miscellaneous things.

Part of it is a simple lightweight test "framework". It takes in (fully qualified) Test Class names (Classes that end in the name Test and extend TestClass) as string args.
Uses reflection to instantiate them, and runs concurrently on up to 8 threads (if there are fewer than 8 tests, only create as many threads as tests).

CLI args API probably needs to be cleaned up, but right now args can be in any order.

The test runner also returns a proper exit code to notify success or failure, which might tie into some sort
of CI process in the future.

The latter is partly bred from the fact that I wanted to understand how Java actually
works without the help of an IDE.

```
# Current build/test process
cd bin/
find ../ -name '*.java' | xargs javac -d ./ && find ./ -regextype posix-extended -regex '.++[A-Za-z]+Test.class' | perl -pe 's/(\.\/|\.class)//g' | perl -pe 's/\//\./g' | xargs java TestRunner
```
