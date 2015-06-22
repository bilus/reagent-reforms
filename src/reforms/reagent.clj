(ns reforms.reagent
    (:require [reforms.core :as core]))

(defmacro with-options
          [& args]
          `(core/with-options ~@args))