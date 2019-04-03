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
         ;:init-script "init.sql"
         ;defaults to true, some databases do not support
         ;schema initialization in a transaction
         ;:init-in-transaction? false
         :migration-table-name "migratus"
         ;:db {:connection-uri db-url
         ;     :classname "org.postgresql.Driver"
         ;     }
         :db db-url
         })
