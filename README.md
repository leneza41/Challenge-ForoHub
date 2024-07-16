# Challenge-ForoHub
Challenge Alura - Oracle One


Simulation of a blogpost based on a courses site backend


**Note that you must insert first some data into the database, the only available endpoint for creating data is for table topics**

## Available endpoints

### /login
- POST:
Returns token for Authorization

Example:
```json
{
    "email": "john.doe@example.com",
    "password": "password123"
}
```
**The password in the datavase should be encrypted using BCrypt**

### /topics
- GET: Returns a json of all topics saved
- POST: Creates a new topic, no two topics should have same title **and** message
Example:
```json
  {
    "title": "Topic Title",
    "message": "Topic Message",
    "author": 1,
    "course": 1
}
```
  
#### /topics/{id}
- GET: Returns a json of an specific topic
- PUT: Updates the topic with given id
Example use:
```json
  {
    "title":"New Topic title",
    "message": "New Topic Message",
    "author": 1,
    "course": 1
}
```
- DELETE: Deletes topic with given id
