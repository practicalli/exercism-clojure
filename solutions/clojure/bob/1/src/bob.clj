(ns bob
  (:require clojure.string))

(defn response-for [s] ;; <- arglist goes here
  (let [question           (= \? (last (clojure.string/trim s)))
        capitalized        (= s (clojure.string/upper-case s))
        special-characters (< 0 (count (re-seq #"[^a-zA-Z]" s)))
        whitespace         (or (= \  (last s)) (= \  (first s)))
        acronyms           (clojure.string/includes? s "DMV")
        shrek              ()]
    (cond
      ;; s is capitalised and ends with a ?
      (and capitalized
           question) "Calm down, I know what I'm doing!"

      ;; s ends in with a ?
      question "Sure."

      ;; s is capitalised
      (and capitalized
           (not special-characters)) "Whoa, chill out!"


      ;; s is just bob
      (and special-characters
           (not whitespace)
           (not acronyms)) "Fine. Be that way!"

      ;; anything else
      :else "Whatever.")))


;; Bob is a lackadaisical teenager. In conversation, his responses are very limited.

;; Bob answers 'Sure.' if you ask him a question.

;; He answers 'Whoa, chill out!' if you yell at him.

;; He answers 'Calm down, I know what I'm doing!' if you yell a question at him.

;; He says 'Fine. Be that way!' if you address him without actually saying anything.

;; He answers 'Whatever.' to anything else.

;; Bob's conversational partner is a purist when it comes to written communication and always follows normal rules regarding sentence punctuation in English.
