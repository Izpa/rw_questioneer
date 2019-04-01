(ns rw-questioneer.core
  (:require [compojure.handler :refer [site]]
            [clojure.core.async :refer [<!!]]
            [environ.core :refer [env]]
            [morse.polling :as p]
            [ring.adapter.jetty :as jetty]
            [rw-questioneer.bot :as bot]
            [rw-questioneer.web :as web])
 ;; (:gen-class)
  )

(defn -main [& [port]]
  ;;(when (str/blank? token)
  ;;  (println "Please provde token in TELEGRAM_TOKEN environment variable!"))

  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'web/app) {:port port :join? false}))

  (println "Starting the rw_questioneer")
  (<!! (p/start bot/token bot/handler)))
