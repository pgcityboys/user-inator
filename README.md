# user-inator
Service for receiving user's data.

### API
Receiving routes in reversed order they were added:\
`GET /api/routes/{email}`
#### Params:
- limit (optional) - Maximum number of returned routes for user.
#### Result:
```json
{
  "routes": [
    {
      "id": int,
      "startAddress": str,
      "endAddress": str,
      "duration": int,
      "distance": int,
      "email": str,
      "dateTime": DateTime
    }
  ]
}
```
Adding route: \
`POST /api/routes`
#### Requested body:
```json
{
  "startAddress": str,
  "endAddress": str,
  "duration": int,
  "distance": int,
  "email": str
}
```
Receiving stats about routes:
`GET /api/routes/{email}/stats`
#### Result:
```json
{
  "carbon": float,
  "money": float
}
```
Adding user:
`POST /api/users`
#### Requested body:
```json
{
  "email": str
}
```