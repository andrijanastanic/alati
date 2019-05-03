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


