(ns rw-questioneer.core
  (:require [compojure.handler :refer [site]]
            [ring.middleware.json :as middleware]
            [clojure.core.async :refer [<!!]]
            [environ.core :refer [env]]
            [morse.polling :as p]
            [ring.adapter.jetty :as jetty]
            [rw-questioneer.bot :as bot]
            [rw-questioneer.web :as web]
            [rw-questioneer.settings :as s]))

(def app
  (-> (handler/site web/app)
      (middleware/wrap-json-body {:keywords? true})
      middleware/wrap-json-response))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty app {:port port :join? false}))

  (println "Starting the rw_questioneer"))
