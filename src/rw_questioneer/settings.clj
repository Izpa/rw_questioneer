(ns rw-questioneer.settings
  (:require [environ.core :refer [env]]))

(def telegram-token (env :telegram-token))
(def domain (env :domain))
(def redirect-telegram-id (env :redirect-telegram-id))

(def telegram-handler-uri "/telegram-handler")

(def db-url (str (env :database-url)
                 "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"))
(def db {:store :database
         :migration-dir "migrations/"
         :migration-table-name "migratus"
         :db db-url})
