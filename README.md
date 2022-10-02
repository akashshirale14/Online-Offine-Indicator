:# Online-Offine-Indicator
Online-Offline indicator system is used to track online/offline status of a user in a chat application.This system can also be used as failure detection system to track up/down status of services.

Test to run this repo:

1) Import it in Ellipse or IntelliJ

2) Run "redis-server" command in terminal

3) Send HTTP requests to the HTTP server using CURL
  So basically users after every 5 seconds sends a POST(userid) to the server, to confirm that it is alive and working.
  The setting of this key happens with 30 sec timeout, so if another request is not received by the user then the key is removed
  Now if the application(frontend) does GET userid, it will show it as offline.


  The following are the commands:
  1) GET request (userid=999)
    curl http://localhost:4567/users/getUserId?userId=999    	
    
  2) POST request (4567 is the port of Spark API)
    curl -X POST -H "Content-Type:application/x-www-form-urlencoded" -d 'userId:999' http://localhost:4567/updateStatus/userId 
