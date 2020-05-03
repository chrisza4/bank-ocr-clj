(ns bank-ocr-clj.utils
  (:require [clojure.pprint :as pprint]))

(defn chunk-vector
  ([v n] (chunk-vector v n []))
  ([v n acc]
   (cond
     (= (count v) 0) acc
     (< (count v) n) (conj acc v)
     :else (let [[current-chunk next-v] (split-at n v)
                 next-acc (conj acc current-chunk)]
             (recur next-v n next-acc)))))

(defn pad-vector [n coll val]
  (take n (concat coll (repeat val))))

(defn inspect [var]
  (pprint/pprint var)
  var)
