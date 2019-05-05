(ns project-clojure.DB.DBBroker
  (:require [clojure.java.jdbc :as sql]
            [clojure.java.jdbc.sql :as s])
)

(def connection
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//127.0.0.1:3306/clojure"
   :user "root"
   :password ""})

(defn select_all_books []
  (into [] (sql/query connection ["SELECT * FROM book left join author on book.authorID=author.authorID order by book.name asc"])))

(defn select_all_authors []
  (into [] (sql/query connection ["SELECT * FROM author order by author.author_name asc"])))

(defn select_author_by_id[id]
  (first (sql/query connection
                    (s/select * :author (s/where {:authorID id})))))

(defn delete_author [id]
  (sql/delete! connection :author
               ["authorID = ?" id]))

(defn update_author [id params]
  (sql/update! connection :author params (s/where {:authorID id})))

(defn insert_author
  [params]
  (sql/insert! connection :author params))

(defn select_book_by_id[id]
  (first (sql/query connection
                    (s/select * :book (s/where {:bookID id})))))

(defn delete_book [id]
  (sql/delete! connection :book
               ["bookID = ?" id]))

(defn update_book [id params]
  (sql/update! connection :book params (s/where {:bookID id})))

(defn insert_book
  [params]
  (sql/insert! connection :book params))

(defn select_all_reviews []
  (into [] (sql/query connection ["SELECT * FROM review left join book on review.bookID=book.bookID order by book.name asc"])))

(defn insert_review
  [params]
  (sql/insert! connection :review params))