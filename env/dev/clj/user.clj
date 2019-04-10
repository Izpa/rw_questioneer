(ns user
  (:require
    [rw-questioneer.config :refer [env]]
    [clojure.spec.alpha :as s]
    [expound.alpha :as expound]
    [mount.core :as mount]
    [rw-questioneer.core :refer [start-app]]
    [rw-questioneer.db.core]
    [conman.core :as conman]
    [luminus-migrations.core :as migrations]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'rw-questioneer.core/repl-server))

(defn stop []
  (mount/stop-except #'rw-questioneer.core/repl-server))

(defn restart []
  (stop)
  (start))

(defn restart-db []
  (mount/stop #'rw-questioneer.db.core/*db*)
  (mount/start #'rw-questioneer.db.core/*db*)
  (binding [*ns* 'rw-questioneer.db.core]
    (conman/bind-connection rw-questioneer.db.core/*db* "sql/queries.sql")))

(defn reset-db []
  (migrations/migrate ["reset"] (select-keys env [:database-url])))

(defn migrate []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))

(defn create-migration [name]
  (migrations/create name (select-keys env [:database-url])))


