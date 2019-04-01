(ns rw-questioneer.web
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [rw-questioneer.bot :as bot]
            [rw-questioneer.settings :as s]))


(defn splash []
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello from Heroku"})

(defroutes app
  (GET "/" []
       (splash))
  (POST s/telegram-handler-uri body
        ;;(map bot/handler updates))
        (println (str body))
        (splash))
  (ANY "*" []
       (route/not-found (slurp (io/resource "404.html")))))
