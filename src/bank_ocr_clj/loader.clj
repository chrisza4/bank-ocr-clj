(ns bank-ocr-clj.loader
  (:require [clojure.string :as str]
            [bank-ocr-clj.utils :as utils]))

; This file seems to be too complicated for whatever reason.

(defn ^:private sanitize-empty-lines [lines]
  (map #(if (= "" %) " " %) lines))

(defn ^:private split-account-numbers [v]
  (let [by-lines (str/split v #"\n")]
    (->> (utils/chunk-vector by-lines 4)
         (map #(take 3 %)))))

(defn split-numbers [str]
  (let [str-vector (map #(str/split % #"") str)
        max-length (apply max (map count str-vector))]
    (->> (map #(utils/pad-vector max-length % " ") str-vector)
         (map sanitize-empty-lines)
         (map #(utils/chunk-vector % 3))
         (apply map vector))))

(defn load-ocr-file [path]
  (->> (slurp path)
       (split-account-numbers)
       (map #(split-numbers %))))

(comment (chunk-vector [1 2 3 4 5 6 7] 2)
         (load-ocr-file "./test/fixtures/test_case_4.txt"))
