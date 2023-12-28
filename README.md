
# Employee APi 

A simple REST api using Spring boot and spring-boot-starter-data-jpa

## API Reference

#### Get all employees

```http
  GET /api/v1/employees
```

#### Get 

```http
  GET /api/v1/employee/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

## PUT 

```http
  PUT /api/v1/employees
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id in json body  |


#DELETE 
```http
  DELETE /api/v1/employee/{id}
```
