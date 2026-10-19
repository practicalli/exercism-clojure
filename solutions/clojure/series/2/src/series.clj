(ns series)


(defn slices
  [string length]
  (if (= 0 length)
    [""]
    (map #(apply str %1)
         (partition length 1 string))))
