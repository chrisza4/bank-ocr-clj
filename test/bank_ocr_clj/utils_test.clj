(ns bank-ocr-clj.utils-test
  (:require [clojure.test :refer :all]
            [bank-ocr-clj.utils :refer :all]))

(deftest chunk-vector-test
  (testing "Should be able to chunk vector"
    (is (= (chunk-vector [1 2 3 4 5] 2)
           [[1 2] [3 4] [5]]))
    (is (= (chunk-vector [1 2 3 4 5] 3)
           [[1 2 3] [4 5]]))
    (is (= (chunk-vector [1 2 3 4] 2)
           [[1 2] [3 4]]))))

(deftest pad-test
  (testing "padding vector"
    (is (= ["1" "2" " " " "] (pad 4 ["1" "2"] " ")))))
