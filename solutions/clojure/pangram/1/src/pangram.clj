(ns pangram
  (:require [clojure.string]))

(defn pangram? [sentence]
  (let [lowercase (clojure.string/lower-case sentence)]
      (= 26 
         (count (set (re-seq #"[a-z]"lowercase))))))
