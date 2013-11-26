;;;; SSTP client lIbrary
(ns sstp.protocol
    :require '[java.net InetSocketAddress ServerSocket])

;;; need var sender event & ref
;;; check use CRLF \r\n

(defn NOTIFY [sender event & ref]
  ;;後で改行コード入れること
  (str
   "NOTIFY SSTP/1.0\r\n"
   "Sender: " sender "\r\n"
   "Event: " event "\r\n"
   (cond
    (nil? (seq ref)) ""
    (< 7 (count ref)) (throw (llegalArgumentException. "wrong number of arguments"))
    :default
    (doseq [[i x] (indexd ref)]
      (str "Reference" i ":" x "\r\n")))))

;;; (.write w (NOTIFY hogehoge ) ) (.flush w ) 
