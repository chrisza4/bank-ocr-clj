(ns bank-ocr-clj.loader
  (:require [clojure.string :as str]
            [bank-ocr-clj.utils :as utils]))

(defn chunk-and-padding [s]
  (->> (utils/chunk-vector s 3)
       (map #(utils/pad 3 % " "))))

(defn process-ocr-text [str]
  (->> (str/split str #"\n")
       (filter #(not (str/blank? %)))
       (map #(str/split % #""))
       (map chunk-and-padding)
       (apply map vector)))

(defn load-ocr-file [path]
  (-> (slurp path)
      (process-ocr-text)))

(comment (chunk-vector [1 2 3 4 5 6 7] 2)
         (load-ocr-file "./test/fixtures/test_case_1.txt"))
