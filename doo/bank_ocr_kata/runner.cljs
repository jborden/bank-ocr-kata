(ns bank-ocr-kata.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [bank-ocr-kata.test.core]))

(doo-tests 'bank-ocr-kata.test.core)
