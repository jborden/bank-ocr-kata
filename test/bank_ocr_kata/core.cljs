(ns bank-ocr-kata.test.core
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [bank-ocr-kata.core :refer [entry->digits file-str->entries
                                        read-file number-validator
                                        validate-digits read-file write-file!]]))

(deftest test-validator
  (is (= (number-validator "457508000")) nil)
  (is (= (number-validator "664371495")) "ERR")
  (is (= (number-validator "86110??36")) "ILL"))

(deftest read-tests
  ;; use story 1 applied to use case 1 data
  (is
   (= (map entry->digits (file-str->entries (read-file "data/use_case_1.txt"))))
   '("000000000"
     "111111111"
     "222222222"
     "333333333"
     "444444444"
     "555555555"
     "666666666"
     "777777777"
     "888888888"
     "999999999"
     "123456789"))
  ;; use case 3
  (is
   (= (map entry->digits (file-str->entries (read-file "data/use_case_3.txt")))
      '("000000051" "49006771?" "1234?678?")))
  ;; user story 3
  (is (= (number-validator "457508000")) nil)
  (is (= (number-validator "664371495")) "ERR")
  (is (= (number-validator "86110??36")) "ILL")
  (do (write-file! "data/user_story3.txt"
                   (validate-digits '("457508000" "664371495" "86110??36")))
      (is (= (read-file "data/user_story3.txt")
             "457508000 \n664371495 ERR\n86110??36 ILL\n"))))

