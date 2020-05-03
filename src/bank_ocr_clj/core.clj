(ns bank-ocr-clj.core
  (:require [clojure.string :as str]
            [bank-ocr-clj.loader :as loader]
            [bank-ocr-clj.ocr-number :as ocr-number]
            [bank-ocr-clj.utils :as utils]))

(defn ^:private to-digits [v]
  (if (some #(= :invalid %) v)
    :invalid
    (str/join v)))

(defn process [path]
  (->> (loader/load-ocr-file path)
       (map ocr-number/ocr-line)
       (map to-digits)))
