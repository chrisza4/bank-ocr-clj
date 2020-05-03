(ns bank-ocr-clj.core
  (:require [clojure.string :as str]
            [bank-ocr-clj.loader :as loader]
            [bank-ocr-clj.ocr-number :as ocr-number]))

(defn to-digits [v]
  (if (some #(= :invalid %) v)
    :invalid
    (str/join v)))

(defn process [path]
  (->> (loader/load-ocr-file path)
       (map #(ocr-number/number-ocr %))
       (to-digits)))
