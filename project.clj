(defproject reagent-reforms "0.4.2"                     ;; Keep in sync with reforms.
            :description "Reforms bindings for Reagent."
            :url "http://bilus.github.io/reforms/"
            :license {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.7.0"]
                           [org.clojure/clojurescript "1.7.122"]
                           [reforms "0.4.1"]
                           [reagent "0.5.0"]]
            :jar-exclusions [#"\.cljx|\.swp|\.swo|\.DS_Store"]
            :auto-clean false

            :plugins [[lein-cljsbuild "1.1.0"]]

            :clean-targets ["examples/hello_world/out"
                            "examples/controls/out"
                            "examples/simple/out"
                            "examples/progress/out"
                            "examples/validation/out"
                            "target/"]

            :profiles {:dev {:dependencies [[org.clojure/core.async "0.1.346.0-17112a-alpha"]]}}

            :aliases {"cljsbuild" ["with-profile" "dev" "cljsbuild"]}

            :cljsbuild {:builds {:hello-world
                                 {:source-paths ["examples/shared/" "examples/hello_world/src" "src" #_"../reforms/src"]
                                  :compiler     {:output-to     "examples/hello_world/out/main.js"
                                                 :output-dir    "examples/hello_world/out"
                                                 :source-map    true
                                                 :optimizations :none}}
                                 :controls
                                 {:source-paths ["examples/shared/" "examples/controls/src" "src" #_"../reforms/src"]
                                  :compiler     {:output-to     "examples/controls/out/main.js"
                                                 :output-dir    "examples/controls/out"
                                                 :source-map    true
                                                 :optimizations :none}}
                                 :simple
                                 {:source-paths ["examples/shared/" "examples/simple/src" "src" #_"../reforms/src"]
                                  :compiler     {:output-to     "examples/simple/out/main.js"
                                                 :output-dir    "examples/simple/out"
                                                 :source-map    true
                                                 :optimizations :none}}
                                 :progress
                                 {:source-paths ["examples/shared/" "examples/progress/src" "src" #_"../reforms/src"]
                                  :compiler     {:output-to     "examples/progress/out/main.js"
                                                 :output-dir    "examples/progress/out"
                                                 :source-map    true
                                                 :optimizations :none}}
                                 :validation
                                 {:source-paths ["examples/shared/" "examples/validation/src" "src" #_"../reforms/src"]
                                  :compiler     {:output-to     "examples/validation/out/main.js"
                                                 :output-dir    "examples/validation/out"
                                                 :source-map    true
                                                 :optimizations :none}}}})

