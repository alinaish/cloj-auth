(ns test-cloj.handler
  (:require
    [clj-oauth2.client :as oauth2]
    [joodo.middleware.request :refer [*request*]]
    [ring.util.response :refer [redirect]]
    [compojure.core :as cc]
    [compojure.handler :as handler]
    [compojure.route :as route]))


(def login-uri "https://accounts.google.com")


(def google-com-oauth2
  {:authorization-uri (str login-uri "/o/oauth2/auth")
   :access-token-uri (str login-uri "/o/oauth2/token")
   :redirect-uri "http://localhost:3000/auth2"
   :client-id "376988262227-vm27ecnso6hi2k4sgh105k8vr0lqo8br.apps.googleusercontent.com"
   :client-secret "jW-j51NseajsbEdjP-vJHq-E"
   :access-query-param :access_token
   :scope ["https://www.googleapis.com/auth/userinfo.email"]
   :grant-type "authorization_code"
   :access-type "online"})

(def auth-req
  (oauth2/make-auth-request google-com-oauth2))

(defn- google-access-token [request]
  (oauth2/get-access-token google-com-oauth2 (:params request) auth-req))

(cc/defroutes app-routes
              (cc/GET "/" [] "Hey how")
              (cc/GET "/auth" [] (redirect (:uri auth-req)))
              (cc/GET "/auth2" [] "Nyaaa"))


(def app
  (handler/site app-routes))