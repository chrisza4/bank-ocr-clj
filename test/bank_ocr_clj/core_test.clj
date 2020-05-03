(ns bank-ocr-clj.core-test
  (:require [clojure.test :refer :all]
            [bank-ocr-clj.core :refer :all]))

(deftest process-test
  (testing "test cases"
    (is (= ["000000000"] (process "./test/fixtures/test_case_1.txt")))
    (is (= ["111111111"] (process "./test/fixtures/test_case_2.txt")))
    (is (= ["222222222"] (process "./test/fixtures/test_case_3.txt")))
    (is (= ["333333333"] (process "./test/fixtures/test_case_4.txt")))
    (is (= (process "./test/fixtures/test_case_5.txt")
           ["444444444"
            "555555555"
            "666666666"
            "777777777"
            "888888888"
            "999999999"
            "123456789"]))))
