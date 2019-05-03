(ns project-clojure.controller
  (:require
    [clostache.parser :as clostache]
    [project-clojure.DB.DBBroker :as dbb]

    ))


(defn load-template-by-name [name-of-template]
  (slurp (clojure.java.io/resource
           (str "view/" name-of-template ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (load-template-by-name template-file) params))

(defn index []
  (render-template "FirstPage" {}))

(defn books[]
  (render-template "Books" {:books (dbb/select_all_books)}))

(defn authors[]
  (render-template "Authors" {:authors (dbb/select_all_authors)}))

(defn update_author[id]
  (render-template "UpdateAuthor" {:author (dbb/select_author_by_id id)}
                   ))