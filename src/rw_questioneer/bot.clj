(ns rw-questioneer.bot
  (:require [morse.handlers :as h]
            [morse.api :as api]
            [rw-questioneer.settings :as s]))

(defn set-webhook []
  (let [webhook-url (str "https://" s/domain s/telegram-handler-uri)]
    (api/set-webhook s/telegram-token webhook-url)))

(h/defhandler handler
  (h/command "start" {{chat-id :id} :chat}
             (api/send-text s/telegram-token chat-id
                            (str "Приветствую! Здесь можно задать свой вопрос и на ближайшем митапе руководители ответят на него!)\n"
                                 "Два момента:\n"
                                 "1) Если хотите услышать ответ от кого-то конкретно, пожалуйста, укажите имя, кому адресуете свой вопрос\n"
                                 "2) Если хотите, чтобы ваш вопрос попал руководителям без указания вашего имени - напишите свой вопрос и далее фразу \"я хочу остаться инкогнито\"")))
  (h/command "help" {{chat-id :id} :chat}
             (api/send-text s/telegram-token chat-id
                            (str "Здесь можно задать свой вопрос и на ближайшем митапе руководители ответят на него!)\n"
                                 "Два момента:\n"
                                 "1) Если хотите услышать ответ от кого-то конкретно, пожалуйста, укажите имя, кому адресуете свой вопрос\n"
                                 "2) Если хотите, чтобы ваш вопрос попал руководителям без указания вашего имени - напишите свой вопрос и далее фразу \"я хочу остаться инкогнито\"")))
  (h/command "id" {{user-id :id} :from {chat-id :id} :chat}
             (api/send-text s/telegram-token chat-id user-id))
  (h/message msg
             (api/send-text s/telegram-token s/redirect-telegram-id
                            msg)))
