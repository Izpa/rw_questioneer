(ns rw-questioneer.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[rw_questioneer started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[rw_questioneer has shut down successfully]=-"))
   :middleware identity})
