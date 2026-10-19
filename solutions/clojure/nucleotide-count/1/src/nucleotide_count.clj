(ns nucleotide-count)

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (= \X nucleotide)
    (throw (Throwable.))
    (count (filter #(= nucleotide %) strand))))

#_(defn nucleotide-counts [strand]
    (apply merge
           (for [nucleotide strand]
             {nucleotide
              (count-of-nucleotide-in-strand nucleotide strand)})))


;; for produces repeated results
;; this seems a bit brute force
;; but we get the right result by merging

#_(merge {\A 20}
         {\G 17}
         {\C 12}
         {\T 21}
         {\T 21}
         {\T 21}
         {\T 21}
         {\C 12}
         {\A 20}
         {\T 21}
         {\T 21}
         {\C 12}
         {\T 21}
         {\G 17}
         {\A 20}
         {\C 12}
         {\T 21}
         {\G 17}
         {\C 12}
         {\A 20}
         {\A 20}
         {\C 12}
         {\G 17}
         {\G 17}
         {\G 17}
         {\C 12}
         {\A 20}
         {\A 20}
         {\T 21}
         {\A 20}
         {\T 21}
         {\G 17}
         {\T 21}
         {\C 12}
         {\T 21}
         {\C 12}
         {\T 21}
         {\G 17}
         {\T 21}
         {\G 17}
         {\T 21}
         {\G 17}
         {\G 17}
         {\A 20}
         {\T 21}
         {\T 21}
         {\A 20}
         {\A 20}
         {\A 20}
         {\A 20}
         {\A 20}
         {\A 20}
         {\A 20}
         {\G 17}
         {\A 20}
         {\G 17}
         {\T 21}
         {\G 17}
         {\T 21}
         {\C 12}
         {\T 21}
         {\G 17}
         {\A 20}
         {\T 21}
         {\A 20}
         {\G 17}
         {\C 12}
         {\A 20}
         {\G 17}
         {\C 12})


;; specifying the specific valid nucleotides


(def valid-nucleotides
  [\A \C \G \T])


;; we can filter the strand for the specific values
;; this avoids repeats,
;; also returns zero counts when nucleotide is not in strand


#_(defn nucleotide-counts [strand]
    (apply merge
           (for [nucleotide valid-nucleotides]
             {nucleotide
              (count-of-nucleotide-in-strand nucleotide strand)})))


;; without the for macro

(map
  (fn [nucleotide]
    {nucleotide
     (count-of-nucleotide-in-strand nucleotide "GGGGGTAACCCGG")})
  valid-nucleotides)

(defn nucleotide-counts [strand]
  (apply merge
         (map
           (fn [nucleotide]
             {nucleotide
              (count-of-nucleotide-in-strand nucleotide strand)})
           valid-nucleotides)))
