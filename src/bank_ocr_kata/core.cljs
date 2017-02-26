(ns bank-ocr-kata.core
  (:require [cljs.nodejs :as nodejs]
            [clojure.string :as string]))

(nodejs/enable-util-print!)

(defn -main []
  (println "Hello world!"))

(set! *main-cli-fn* -main)

;; Each entry is 4 lines long, and each line has 27 characters.
;; The first 3 lines of each entry contain an account number written using
;; pipes and underscores, and the fourth line is blank.

(def zero
  (str " _ " 
       "| |" 
       "|_|"))

(def one
  (str "   "
       "  |"
       "  |"))

(def two
  (str " _ "
       " _|"
       "|_ "))

(def three
  (str " _ "
       " _|"
       " _|"))

(def four
  (str "   "
       "|_|"
       "  |"))

(def five
  (str " _ "
       "|_ "
       " _|"))

(def six
  (str " _ "
       "|_ "
       "|_|"))

(def seven
  (str " _ "
       "  |"
       "  |"))

(def eight
  (str " _ "
       "|_|"
       "|_|"))

(def nine
  (str " _ "
       "|_|"
       " _|"))

(defn str->digit
  "Given a string, return a string representation of that digit. If
  it cannot be determined, return ?"
  [s]
  (condp = s
    zero "0"
    one "1"
    two "2"
    three "3"
    four "4"
    five "5"
    six "6"
    seven "7"
    eight "8"
    nine "9"
    "?"))

(def fs (js/require "fs"))

(defn read-file
  "Read file f and return a string"
  [f]
  (fs.readFileSync f "utf8"))

(defn file-str->entries
  "Given a str representing a file of entries, split into a vector
  of entries"
  [s]
  (mapv #(string/split % #"\n")
        (string/split s #"\.*\n\.*\n\.*")))

(defn digits
  "Given a coll of strings, convert them to a string of digits"
  [coll & [result]]
  (if (empty? coll)
    result
    (digits (nthrest coll 3)
            (str result (str->digit
                         (apply
                          str (take 3 coll)))))))

(defn entry->digits
  "Given an entry, convert it to a vector of digits"
  [s]
  (let [insert-blanks (fn [v] (mapv #(if (= % "")
                                       (apply str (take 27 (repeat " ")))
                                       %)
                                    v))
        char-block (fn [s] (into [] (re-seq #".{3}" s)))]
    (digits (->> s
                 (insert-blanks)
                 (mapv char-block)
                 (apply interleave)))))
