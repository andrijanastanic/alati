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
            [project-clojure.DB.DBBroker :as dbb]
            ))

(defroutes api_routes
           (GET "/" [] (controller/index))
           (route/resources "/")
           (GET "/index" [] (controller/index))
           (route/resources "/")
           (GET "/books" [] (controller/books))
           (route/resources "/")
           (GET "/authors" [] (controller/authors))
           (route/resources "/")
           (GET "/DB/dbb/:id/delete_author" [id]
             (do (dbb/delete_author id)
                 (resp/redirect "/authors")))
           (GET "/DB/dbb/:id/select_author" [id]
             (controller/update_author id))
           (POST "/DB/dbb/:authorID/update_author" [& author]
             (do (dbb/update_author (:authorID author) author)
                 (resp/redirect "/authors")))
           )

(defroutes app-routes
           api_routes
           (route/not-found "404 Not Found")
           )
(def app
  (handler/site app-routes)
  )