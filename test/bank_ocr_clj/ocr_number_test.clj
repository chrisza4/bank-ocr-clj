(ns bank-ocr-clj.ocr-number-test
  (:require [clojure.test :refer :all]
            [bank-ocr-clj.ocr-number :refer :all]
            [bank-ocr-clj.ocr-number-tmpl :as ocr-number-tmpl]))


(deftest number-ocr-test
  (testing "Can evaluate individual numbers"
    (is (= (number-ocr ocr-number-tmpl/zero) 0))
    (is (= (number-ocr ocr-number-tmpl/one) 1))
    (is (= (number-ocr ocr-number-tmpl/two) 2))
    (is (= (number-ocr ocr-number-tmpl/three) 3))
    (is (= (number-ocr ocr-number-tmpl/four) 4))
    (is (= (number-ocr ocr-number-tmpl/five) 5))
    (is (= (number-ocr ocr-number-tmpl/six) 6))
    (is (= (number-ocr ocr-number-tmpl/seven) 7))
    (is (= (number-ocr ocr-number-tmpl/eight) 8))
    (is (= (number-ocr ocr-number-tmpl/nine) 9)))

  (testing "Return invalid for wrong input"
    (is (= (number-ocr "some invalid input") :invalid))))

(deftest ocr-line-test
  (testing "Can ocr line"
    (is (= (ocr-line [ocr-number-tmpl/four ocr-number-tmpl/eight])
           [4 8]))))
