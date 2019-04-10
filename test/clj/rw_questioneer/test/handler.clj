(ns rw-questioneer.test.handler
  (:require
    [clojure.test :refer :all]
    [ring.mock.request :refer :all]
    [rw-questioneer.handler :refer :all]
    [rw-questioneer.middleware.formats :as formats]
    [muuntaja.core :as m]
    [mount.core :as mount]))

(defn parse-json [body]
  (m/decode formats/instance "application/json" body))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'rw-questioneer.config/env
                 #'rw-questioneer.handler/app)
    (f)))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= 404 (:status response))))))
