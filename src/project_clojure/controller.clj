(ns project-clojure.controller
  (:require
    [clostache.parser :as clostache]
    [project-clojure.DB.books :as db_books]
    ))


(defn load-template-by-name [name-of-template]
  (slurp (clojure.java.io/resource
           (str "view/" name-of-template ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (load-template-by-name template-file) params))

(defn index []
  (render-template "FirstPage" {}))

(defn books[]
  (render-template "Books" {:books (db_books/select_all_books)}))

