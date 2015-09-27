(ns examples.controls
  (:require [reforms.reagent :as f :include-macros true]
            [reforms.table :as t]
            [reagent.core :refer [atom render-component]]
            [examples.shared.utils :refer [inspector-view]]))

(def app-state (atom {:color "#c26b66"
                      :selected nil}))

(defn simple-view
  [data]
  (f/with-options
    {:form {:horizontal false}}
    [:div
     [:h1 {:key "h1"} "Supported controls"]
     (f/panel
       "Panel"
       [:div "Contents 1"]
       [:div "Contents 2"]
       [:div "Contents 3"])
     (t/table [{:name "Tom" :id 12} {:name "Jerry" :id 23}]
                   :columns {:name "Hero name"}
                   :checkboxes {:cursor data
                                :korks [:selected]
                                :value :id})
     #_(f/form
       {:on-submit #(js/alert "Submitted")}
       (f/text "Text" data [:text] :placeholder "A placeholder")
       (f/password "Password" data [:password] :placeholder "A placeholder")
       (f/textarea {:rows 8} "Textarea" data [:textarea] :placeholder "A placeholder")
       (f/select "Select" data [:select]
                 [[:option1 "Option 1"] [:option2 "Option 2"] [:option3 "Option 3"] [:option4 "Option 4"]])
       (f/button "Button" #(js/alert "Click"))
       (f/button-primary "Primary button" #(js/alert "Click"))
       (f/button-default "Default button" #(js/alert "Click"))
       (f/checkbox "Checkbox" data [:checkbox])
       (f/radio "Radio" data [:radio])
       ;datetime, datetime-local, date, month, time, week, number, email, url, search, tel, and color
       (f/datetime-local "Datetime local" data [:datetime-local] :placeholder "A placeholder")
       (f/date "Date" data [:date] :placeholder "A placeholder")
       (f/month "Month" data [:month] :placeholder "A placeholder")
       (f/time "Time" data [:time] :placeholder "A placeholder")
       (f/week "Week" data [:week] :placeholder "A placeholder")
       (f/number "Number" data [:number] :placeholder "A placeholder")
       (f/email "Email" data [:email] :placeholder "A placeholder")
       (f/url "Url" data [:url] :placeholder "A placeholder")
       (f/search "Search" data [:search] :placeholder "A placeholder")
       (f/tel "Tel" data [:tel] :placeholder "A placeholder")
       (f/color "Color" data [:color] :placeholder "A placeholder"))]))

(defn main-view
  []
  [:div
   [simple-view app-state]
   [inspector-view app-state]])

(render-component
  [main-view]
  (. js/document (getElementById "app")))

