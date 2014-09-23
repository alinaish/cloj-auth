(ns test-cloj.test)
;
;(def users {"kyle" {:password "123" :number-pets 3}
;           "ann" {:password "qwe" :number-pets 2}
;           "stan" {:password "qwe123" :number-pets 2}})

(def users {})

;(defn check-login [username password]
;  (try
;  (let [actual-password ((users username) :password)]
;    (= actual-password password)))
;  (catch Exception e
;    (println "Error!")
;    0))


;(check-login "kyle" "12bbbb")

  (defn count-down [n]
    (if-not (zero? n)
      (do
        (if (= 0 (rem n 100))
          (println "count-down:" n))
        (recur (dec n)))))

(count-down 10000)