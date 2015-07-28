(require 'cljs.repl)
(require 'cljs.build.api)
(require 'cljs.repl.browser)

;(cljs.build.api/build "src"
;                      {:main 'examples.hello-world
;                       :output-to "examples/hello_world/out/main.js"
;                       :verbose true})

(cljs.repl/repl (cljs.repl.browser/repl-env)
                :watch "src"
                :output-dir "out")