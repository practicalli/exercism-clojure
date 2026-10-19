(ns pangram
  (:require [clojure.string :as string]))

(def alphabet-size 26)

(defn pangram?
  "A panagram should contain each character
  of the alphabet, one or more times"
  [sentence]
  (= alphabet-size
     (count 
       (set 
         (re-seq #"[a-z]" (string/lower-case sentence))))))
