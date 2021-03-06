(ns name-service.delivery.server.delete
  (:require [cheshire.core :as json]
            [clojure.spec.alpha :as s]
            [name-service.delivery.server.http :as http]
            [name-service.delivery.server.spec :as spec]
            [name-service.delivery.server.utils :as utils]
            [name-service.delivery.state :as state]))

(defn- delete-keymap [where-kv]
  (let [key (utils/first-key-to-str where-kv)
        value (utils/first-value-to-str where-kv)]
    (utils/action->response (state/delete-keymap key value))))

(defn- delete-by-key [key-to-delete where-kv]
  (let [key (utils/first-key-to-str where-kv)
        value (utils/first-value-to-str where-kv)]
    (-> key-to-delete
        (state/delete-key-binding key value)
        (utils/action->response))))

; If json-params contain delete, given key is going to be deleted
; otherwise whole keymap is going to be deleted
(defn- delete-key-binding [json-params]
  (if-let [key (:delete json-params)]
    (delete-by-key key (:where json-params))
    (delete-keymap (:where json-params))))

(defn dispatch
  [{:keys [json-params]}]
  (if (s/valid? ::spec/delete-request json-params)
    (delete-key-binding json-params)
    (-> json-params
        (s/explain-data ::spec/delete-request)
        (json/encode)
        (http/bad-request))))
