(ns bank-ocr-clj.core-test
  (:require [clojure.test :refer :all]
            [bank-ocr-clj.core :refer :all]))

(deftest process-test
  (testing "test cases"
    (is (= "000000000" (process "./test/fixtures/test_case_1.txt")))
    (is (= "111111111" (process "./test/fixtures/test_case_2.txt")))
    (is (= "222222222" (process "./test/fixtures/test_case_3.txt")))))
