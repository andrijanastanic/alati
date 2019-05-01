(ns project-clojure.DB.books
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




