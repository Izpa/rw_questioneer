(ns rw-questioneer.bot
  (:require [morse.handlers :as h]
            [morse.api :as api]
            [rw-questioneer.settings :as s]))


(def webhook-url (str "https://" s/domain s/telegram-handler-uri))

(api/set-webhook s/telegram-token webhook-url)

(h/defhandler handler
  (h/command "help" message
             (api/send-text s/telegram-token (:id (:chat message)) message))
  (h/command "id" {{user-id :id} :from {chat-id :id} :chat}
             (api/send-text s/telegram-token chat-id user-id))
  (h/message {{first-name :first_name last-name :last_name user-name :user_name} :from text :test}
             (when (not-empty s/redirect-telegram-id)
               (api/send-text s/telegram-token s/redirect-telegram-id
                              (str first-name " " last-name " (" user-name ") спрашивает: " text)))))
