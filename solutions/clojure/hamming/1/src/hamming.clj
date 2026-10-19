(ns hamming)

(defn distance [strand1 strand2]
  ;; your code goes here
  (if (= (count strand1) (count strand2))
    (apply +
           (map #(if (= % %2) 0 1)
                strand1 strand2))
    nil))
