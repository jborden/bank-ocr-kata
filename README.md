## A ClojureScript solution to the Bank OCR Kata presented at XP2005

## Prerequisties

node v4.2.1

Leiningen 2.7.1

npm 2.14.7

java 1.8.0_101

### Install node packages

Install node packages required for this project

```
$ npm install
```

## Figwheel REPL

### Run the figwheel repl

figwheel will hang on compilation unless you first remove the previous compiled javascript in the target/ dir,
therefore 'lein clean' is run before starting the REPL

```
$ rlwrap lein do clean, figwheel
```

### Run the node server

In a another terminal, run the node server. This should be done after
figwheel has compiled the project to javascript and is awaiting connection.

```
$ node target/server_dev/bank_ocr_kata.js
```

## Tests

The tests are located in test/bank_ocr_kata/core.cljs and make use
of the data/ dir.

### Command Line
```
$ lein doo node test once
```

### REPL

```clojure
dev:cljs.user=> (in-ns 'bank-ocr-kata.test.core)
nil
dev:bank-ocr-kata.test.core=> (run-tests)

Testing bank-ocr-kata.test.core

Ran 2 tests containing 9 assertions.
0 failures, 0 errors.
nil
dev:bank-ocr-kata.test.core=>
```
