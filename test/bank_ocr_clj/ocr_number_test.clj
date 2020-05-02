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
    (is (= (number-ocr ocr-number-tmpl/four) 4))))

(comment (ocr-number-tmpl/zero))
