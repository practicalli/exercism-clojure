(ns series
  (:require [clojure.string :as string]))




(defn slices [string length]
  (if (zero? length)
    [""]
    (map string/join (partition length 1 string))))
