(defproject test-cloj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
		 [joodo "0.10.0"]
		 [stuarth/clj-oauth2 "0.3.2"]
		 [speclj "2.2.0"]
		 [hiccup "1.0.2"]
		 [ring/ring-core "1.3.1"]]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler test-cloj.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
