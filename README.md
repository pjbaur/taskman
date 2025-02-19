# taskman
Task Manager application

## H2 console:
http://localhost:8080/h2-console

## Testing the REST API:
```
curl http://localhost:8080/tasks

curl -X POST -H "Content-Type: application/json" -d '{
  "title": "Sample Task",
  "description": "This is a sample task"
}' http://localhost:8080/tasks
```
