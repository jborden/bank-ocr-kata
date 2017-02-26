(ns bank-ocr-kata.test.core
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [bank-ocr-kata.core :as core]))

(deftest test-numbers
  (is (= 1 1))
  (is (= 1 2)))
