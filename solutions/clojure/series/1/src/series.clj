(ns series)

(defn slices
  [string length]
  (into []
        (distinct
          (map #(apply str %)
               (partition length 1 string)))))
