(ns project-clojure.api
  (:use compojure.core
        ring.util.json-response
        ring.adapter.jetty)
  (:require [compojure.core :refer [defroutes GET POST]]
            [clojure.string :as str]
            [ring.util.response :as resp]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [project-clojure.controller :as controller]
            [ring.middleware.resource :refer [wrap-resource]]
            ))

(defroutes api_routes
           (GET "/" [] (controller/index))
           (route/resources "/")
           (GET "/index" [] (controller/index))
           (route/resources "/")
           (GET "/books" [] (controller/books))
           (route/resources "/")
           )

(defroutes app-routes
           api_routes
           (route/not-found "404 Not Found")
           )
(def app
  (handler/site app-routes)
  )