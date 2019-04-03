(ns rw-questioneer.web
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [rw-questioneer.bot :as bot]
            [rw-questioneer.settings :as s]))

(defn splash []
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello"})

(defroutes app
  (GET "/" []
       (splash))
  (POST s/telegram-handler-uri {body :body} (bot/handler body))
  (ANY "*" []
       (route/not-found (slurp (io/resource "html/404.html")))))
