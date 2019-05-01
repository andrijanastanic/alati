(defproject project-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.1.6"]
                 [org.clojure/java.jdbc "0.3.0-alpha5"]
                 [mysql/mysql-connector-java "5.1.25"]
                 [ring-json-response "0.2.0"]
                 [de.ubercode.clostache/clostache "1.4.0"]
                 [ring-basic-authentication "1.0.2"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler project-clojure.api/app}
  :main ^:skip-aot project-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  )


