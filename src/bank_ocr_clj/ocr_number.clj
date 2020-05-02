(ns bank-ocr-clj.ocr-number
  (:require [bank-ocr-clj.ocr-number-tmpl :as ocr-number-tmpl]))

(def ^:private number-map
  {ocr-number-tmpl/zero 0
   ocr-number-tmpl/one 1
   ocr-number-tmpl/two 2
   ocr-number-tmpl/three 3
   ocr-number-tmpl/four 4})

(defn number-ocr [number-text]
  (or (number-map number-text) :invalid))
