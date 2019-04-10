(ns rw-questioneer.core
  (:require [compojure.handler :refer [site]]
            [ring.middleware.json :as middleware]
            [migratus.core :as migratus]
            [ring.adapter.jetty :as jetty]
            [rw-questioneer.bot :as bot]
            [rw-questioneer.web :as web]
            [rw-questioneer.settings :as s]))

(def app
  (-> (site web/app)
      (middleware/wrap-json-body {:keywords? true})
      middleware/wrap-json-response))

(defn -main [& args]
  (cond
    (some #{"release"} args)
    (do
      (migratus/migrate s/db)
      (bot/set-webhook)
      (System/exit 0))
    :else
    (do
      (jetty/run-jetty app {:port s/port :join? false})
      (println "Starting the rw_questioneer"))))

;(defn -main [& args]
  ;(migratus/migrate s/db)
  ;(bot/set-webhook)
  ;(let [port (Integer. (or (:port args) (env :port) 5000))]
    ;(jetty/run-jetty app {:port port :join? false}))
  ;(println "Starting the rw_questioneer"))
