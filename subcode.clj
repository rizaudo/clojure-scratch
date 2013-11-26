;;;; SSTP client lIbrary
(ns sstp.protocol
    :require '[java.net InetSocketAddress ServerSocket])

;;; need var sender event & ref
;;; check use CRLF \r\n

(defn NOTIFY [sender event & ref]
  ;;後で改行コード入れること
  (str
   "NOTIFY SSTP/1.0"
   "Sender: " sender
   "Event: " event
   (doseq [[i x] (indexd ref)]
     (str "Reference" i ":" x))
       ))
