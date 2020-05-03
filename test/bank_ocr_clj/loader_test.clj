(ns bank-ocr-clj.loader-test
  (:require [clojure.test :refer :all]
            [bank-ocr-clj.loader :refer :all]
            [bank-ocr-clj.ocr-number-tmpl :as ocr-number-tmpl]))


(def test-case-1 "
 _  _
| || |
|_||_|
")

(deftest load-ocr-file-test
  (testing "able to load ocr file"
    (let [expected [ocr-number-tmpl/zero ocr-number-tmpl/zero]]
      (is (= expected (process-ocr-text test-case-1))))))
