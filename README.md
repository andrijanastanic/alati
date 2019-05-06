# Clojure web app

Simple Clojure web application for books. For communciation with databaase is used my SQL jdbc connector and database is hosted on localhost. Application uses CRUD(Create, Read, Update, Delete) operations.

It allows user to:
-see all authors from database
-insert new author
-update author
-delete author
-see all books from database
-insert new book
-update book
-delete book
-see reviews for books
-insert new review and rate the book
-see best rated books



## Usage

Import clojure.sql from root folder into mySQL database.

Web application starts with lein ring server command in command prompt.

## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

## Prerequisites
Leiningen 2.8.3 on Java 1.8.0_181
