(defproject bank-ocr-kata "0.2.0"
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
                       {:id "test"
                        :source-paths ["src" "test" "doo"]
                        :compiler {:output-to "target/test_dev/testable.js"
                                   :output-dir "target/test_dev"
                                   :main bank-ocr-kata.runner
                                   :target :nodejs}}
                       ]})
