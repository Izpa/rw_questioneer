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

(defn telegram-handler [request]
  ;;(map bot/handler updates))
  (println (str (:body request)))
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body ""})

(defroutes app
  (GET "/" []
       (splash))
  (POST s/telegram-handler-uri request (telegram-handler request))
 
  (ANY "*" []
       (route/not-found (slurp (io/resource "404.html")))))
