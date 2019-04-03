(ns rw-questioneer.settings
  (:require [environ.core :refer [env]]))

(def telegram-token (env :telegram-token))
(def domain (env :domain))
(def redirect-telegram-id (env :redirect-telegram-id))

(def telegram-handler-uri "/telegram-handler")

(def db {:store :database
         :migration-dir "migrations/"
         ;:init-script "init.sql"
         ;defaults to true, some databases do not support
         ;schema initialization in a transaction
         ;:init-in-transaction? false
         :migration-table-name "migratus"
         :db {:connection-uri (env :database-url)}})
