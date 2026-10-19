(ns nucleotide-count)

#_(defn count-of-nucleotide-in-strand [nucleotide strand]
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

#_(map
    (fn [nucleotide]
      {nucleotide
       (count-of-nucleotide-in-strand nucleotide "GGGGGTAACCCGG")})
    valid-nucleotides)

#_(defn nucleotide-counts [strand]
    (apply merge
           (map
             (fn [nucleotide]
               {nucleotide
                (count-of-nucleotide-in-strand nucleotide strand)})
             valid-nucleotides)))


;;using some nice abstractions

#_(frequencies "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")



#_(defn count-of-nucleotide-in-strand [nucleotide strand]
    (get (frequencies strand) nucleotide))

;; need to add exception handling

#_(defn count-of-nucleotide-in-strand [nucleotide strand]
    (get (frequencies strand) nucleotide (throw (Throwable.))))

;; add a guard condition if passed an empty strand
;; returning zero

#_(defn count-of-nucleotide-in-strand [nucleotide strand]
    (if (empty? strand)
      0
      (get (frequencies strand) nucleotide (throw (Throwable.)))))

#_(count-of-nucleotide-in-strand \T "GGGGGTAACCCGG")

;; using a function as the not-found
#_(get {:a 1 :b 2} :b (throw (Throwable.)))

;; unfortunately the throw expression is evaluated before the get
;; so we always get a Throwable exception even if the key is in the hash-map.
;; We can fix that with an or

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (empty? strand)
    0
    (or (get (frequencies strand) nucleotide) (throw (Throwable.)))))

#_(defn nucleotide-counts [strand]
    (frequencies strand))

;; fails the empty case,
;; but we can add an empty result as the default value
;; and merge it with the resulting frequencies


(defn nucleotide-counts [strand]
  (merge {\A 0 \C 0 \G 0 \T 0} (frequencies strand)))
