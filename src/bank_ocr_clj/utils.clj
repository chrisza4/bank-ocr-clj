(ns bank-ocr-clj.utils)

(defn chunk-vector
  ([v n] (chunk-vector v n []))
  ([v n acc]
   (cond
     (= (count v) 0) acc
     (< (count v) n) (conj acc v)
     :else (let [[current-chunk next-v] (split-at n v)
                 next-acc (conj acc current-chunk)]
             (recur next-v n next-acc)))))

(defn pad [n coll val]
  (take n (concat coll (repeat val))))
