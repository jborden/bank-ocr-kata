# Bank OCR Kata based on a Kata presented at XP2005

Project was created with the figwheel-node-template found at https://github.com/malyn/figwheel-node-template

```
$ lein new figwheel-node bank-ocr-kata
```

# Prerequisties

This was written using:

node >= 4.2.1

Leiningen >= 2.7.1

npm >= 2.14.7

java >= 1.8.0_101

This project may still work given older versions of the required software, but is not
guaranteed to do so.

# Up and Running

## Install node packages

Install node packages required for this project

```
$ npm install
```

## Run the figwheel repl

There is a cache issue with using figwheel for node projects. figwheel
will hang on compilation unless you first remove the target dir. Do this by
starting the figwheel repl with:

```
$ rlwrap lein do clean, figwheel
```

## Run the node server

In a seperate terminal, run the node server. This should be done after running
figwheel to transpile the javascript.

```
$ node target/server_dev/bank_ocr_kata.js
```

# Running the tests

The use case and user story scenarios are tested in test/bank_ocr_kata/core.cljs

To run the tests at the command line:
```
$ lein doo node test once
```

Alternatively, run the tests at the REPL:

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
