(ns rw-questioneer.bot
  (:require [clojure.string :as str]
            [morse.handlers :as h]
            [morse.api :as api]
            [environ.core :refer [env]]
            [rw-questioneer.settings :as s]
            [clj-http.client :as http]))

(def base-url "https://api.telegram.org/bot")
;;(def webhook-url (str "https:// " s/domain s/telegram-handler-uri))
(def webhook-url "https://dev.questioneer.rw.izpa.xyz/telegram-handler")

(defn set-webhook
  "Register WebHook to receive updates from chats"
  [token webhook-url]
  (let [url   (str base-url token "/setWebhook")
        query {:url webhook-url}]
    (http/post url {:as :json :query-params query})))

(set-webhook s/telegram-token webhook-url)
;;(api/set-webhook s/telegram-token webhook-url)

(h/defhandler handler

  (h/command-fn "start"
                (fn [{{id :id :as chat} :chat}]
                  (println "Bot joined new chat: " chat)
                  (api/send-text token id "Welcome to rw_questioneer!")))

  (h/command-fn "help"
                (fn [{{id :id :as chat} :chat}]
                  (println "Help was requested in " chat)
                  (api/send-text token id "Help is on the way")))

  (h/message-fn
   (fn [{{id :id} :chat :as message}]
     (println "Intercepted message: " message)
     (api/send-text s/token id "I don't do a whole lot ... yet."))))
