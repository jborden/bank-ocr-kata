# Bank OCR Kata based on a Kata presented at XP2005

Project was created with the figwheel-node-template found at https://github.com/malyn/figwheel-node-template

```
$ lein new figwheel-node bank-ocr-kata
```

# Prerequisties

node >= 4.2.1
Leiningen >= 2.7.1
npm >= 2.14.7

# Up and Running

## node packages

Install node packages required for this project

```
$ npm install
```

## Run the figwheel repl

```
$ rlwrap lein fighweel
```

There is a cache issue with figwheel and node projects. figwheel
will hang unless you first remove the target dir. Alternatively,
start the repl with

```
$ rlwrap lein do clean, figwheel
```

## Run the node server

MUST be done after running figwheel to compile this file!

```
$ node target/server_dev/node_hello_world.js
```
