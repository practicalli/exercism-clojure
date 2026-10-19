(ns series)

(defn slices [string length]
  (distinct
    (map (partial apply str)
         (partition length 1 string))))
