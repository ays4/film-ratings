(ns film-ratings.handler.index-test
  (:require
    [film-ratings.handler.index]
    [ring.mock.request :as mock]
    [clojure.test :refer :all]
    [integrant.core :as ig]))


(deftest check-index-handler
  (testing "Ensure that the index handler returns two links for add and list films"
    (let [handler (ig/init-key :film-ratings.handler/index {})
          response (handler (mock/request :get "/"))]
      (is (= :ataraxy.response/ok (first response)))
      (is (= "href=\"/add-film\""
             (re-find #"href=\"/add-film\"" (second response))))
      (is (= "href=\"/list-films\""
             (re-find #"href=\"/list-films\"" (second response)))))))


