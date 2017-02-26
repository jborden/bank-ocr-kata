(defproject bank-ocr-kata "0.1.0-SNAPSHOT"
  :description "Bank OCR Kata"
  :url "https://github.com/jborden/bank-ocr-kata"

  :min-lein-version "2.5.3"

  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.473"]]

  :plugins [[lein-cljsbuild "1.1.5"]
            [lein-figwheel "0.5.9"]
            [lein-doo "0.1.7"]]

  :source-paths ["src" "test"]
  :profiles {:dev {:dependencies [[com.cemerick/piggieback "0.2.1"]
                                  [figwheel-sidecar "0.5.9"]]
                   :source-paths ["src" "test"]
                   :repl-options {:nrepl-middleware
                                  [cemerick.piggieback/wrap-cljs-repl]}}}
  :clean-targets ["server.js"
                  "target"]

  :cljsbuild {
              :builds [{:id "dev"
                        :source-paths ["src" "test"]
                        :figwheel true
                        :compiler {
                                   :main bank-ocr-kata.dev
                                   :output-to "target/server_dev/bank_ocr_kata.js"
                                   :output-dir "target/server_dev"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}
                       {:id "prod"
                        :source-paths ["src"]
                        :compiler {
                                   :output-to "server.js"
                                   :output-dir "target/server_prod"
                                   :target :nodejs
                                   :optimizations :simple}}]})
