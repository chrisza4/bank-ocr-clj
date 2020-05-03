(ns bank-ocr-clj.loader
  (:require [clojure.string :as str]
            [bank-ocr-clj.utils :as utils]))

(defn load-ocr-file [path]
  (let [s (-> (slurp path)
              (str/split #"\n"))]
    (->> s
         (map #(str/split % #""))
         (map #(utils/chunk-vector % 3)))))


(comment (chunk-vector [1 2 3 4 5 6 7] 2)
         (load-ocr-file "./test/fixtures/test_case_1.txt"))
