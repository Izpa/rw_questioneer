(ns rw-questioneer.core
  (:require [compojure.handler :refer [site]]
            [clojure.core.async :refer [<!!]]
            [environ.core :refer [env]]
            [morse.polling :as p]
            [ring.adapter.jetty :as jetty]
            [rw-questioneer.bot :as bot]
            [rw-questioneer.web :as web]
            [rw-questioneer.settings :as s]))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'web/app) {:port port :join? false}))

  (println "Starting the rw_questioneer")
  ;;(<!! (p/start s/token bot/handler))
  )
