Start server
```
./gradlew run
```
Run
```
ab -c 1 -n 200 localhost:8080/proxy
```
to warm up the app, all should be fine.
Now run
```
ab -c 5 -n 200 localhost:8080/proxy
```
and a few, normally 4, requests failed.
If u run 
```
curl localhost:8080/i
```
u will see that all (400) requests has arrived at the "server".
