(ns armstrong-numbers)

(defn raise-to-power
  [number power]
  (reduce * (repeat power number)))

(defn armstrong?
  [number]
  (let [;; Individual digits from the number
        digits (map #(rem % 10)
                    (take-while pos? (iterate #(quot % 10) number)))

        ;; number of digits, used as the power
        power (count digits)]

    (->> digits
         (map #(raise-to-power % power))
         (reduce +)
         (= number))))
