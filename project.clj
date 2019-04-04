(defproject rw_questioneer "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [environ             "1.1.0"]
                 [morse               "0.2.4"]
                 [compojure "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [clj-http "3.9.1"]
                 [migratus "1.2.3"]
                 ;[migratus-lein "0.7.2"]
                 [com.layerware/hugsql "0.4.9"]
                 [org.postgresql/postgresql "42.2.2"]]

  :plugins [[lein-environ "1.1.0"]
            [migratus-lein "0.7.2"]]
  :min-lein-version "2.0.0"
  :uberjar-name "rw-questioneer.jar"
  :profiles {:uberjar {:aot :all}}
  :migratus {:store :database
             :migration-dir "migrations/"
             :migration-table-name "migratus"
             :db ~(get (System/getenv) "DATABASE_URL")})
