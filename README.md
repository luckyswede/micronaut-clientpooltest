Start server
```
./gradlew run
```
Run
```
curl localhost:8080/proxy
curl: (52) Empty reply from server
```
...which is expected because the idle-timeout is shorter than the response latency.
However, run the same curl again:
```
curl localhost:8080/proxy
{"message":"Internal Server Error: Connect Error: Acquire operation took longer then configured maximum time"}
```
shows that checking out a connection from the pool was unsuccessful.
The pool is now stuck in this state and never recovers.
