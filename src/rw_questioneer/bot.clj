(ns rw-questioneer.bot
  (:require [clojure.string :as str]
            [morse.handlers :as h]
            [morse.api :as api]
            [environ.core :refer [env]]
            [rw-questioneer.settings :as s]
            [clj-http.client :as http]))


(def webhook-url (str "https://" s/domain s/telegram-handler-uri))

(api/set-webhook s/telegram-token webhook-url)

(h/defhandler handler
  (h/command "help" {{id :id} :chat}
           (api/send-text s/telegram-token id "Help is on the way")))
