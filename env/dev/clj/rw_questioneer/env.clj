(ns rw-questioneer.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [rw-questioneer.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[rw_questioneer started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[rw_questioneer has shut down successfully]=-"))
   :middleware wrap-dev})
