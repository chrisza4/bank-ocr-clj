(ns bank-ocr-clj.utils)

(defn chunk-vector
  ([v n] (chunk-vector v n []))
  ([v n acc]
   (if (< (count v) n)
     (conj acc v)
     (let [[current-chunk next-v] (split-at n v)
           next-acc (conj acc current-chunk)]
       (recur next-v n next-acc)))))
