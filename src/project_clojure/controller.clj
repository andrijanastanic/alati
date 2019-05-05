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

(defn add_author[]
  (render-template "AddAuthor" {}))

(defn update_book[id]
  (render-template "UpdateBook" {:book (dbb/select_book_by_id id)
                                 :authors (dbb/select_all_authors)}
                   ))

(defn add_book[]
  (render-template "AddBook" {:authors (dbb/select_all_authors)}))

(defn reviews[]
  (render-template "BookReview" {:reviews (dbb/select_all_reviews)}))

(defn add_review[]
  (render-template "AddReview" {:books (dbb/select_all_books)}))

(defn topList[]
  (render-template "TOPList" {:list (dbb/select_top_list)}))