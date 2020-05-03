(ns bank-ocr-clj.loader
  (:require [clojure.string :as str]
            [bank-ocr-clj.utils :as utils]))

(defn ^:private sanitize-empty-lines [lines]
  (map #(if (= "" %) " " %) lines))

(defn ^:private chunk-and-padding [v]
  (let [max-length (apply max (map count v))]
    (->> (map #(utils/pad-vector max-length % " ") v)
         (map sanitize-empty-lines)
         (map #(utils/chunk-vector % 3))
         (apply map vector))))


(defn process-ocr-text [str]
  (->> (str/split str #"\n")
       (map #(str/split % #""))
       (chunk-and-padding)))

(defn load-ocr-file [path]
  (-> (slurp path)
      (process-ocr-text)))

(comment (chunk-vector [1 2 3 4 5 6 7] 2)
         (load-ocr-file "./test/fixtures/test_case_2.txt"))
