(ns rw-questioneer.settings
  (:require [environ.core :refer [env]]))

(def telegram-token (env :telegram-token))
(def protocol (env :protocol))
(def domain (env :domain))

(def telegram-handler-uri "/telegram_handler")
