package com.qa.api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersApiTest {

  @BeforeClass
  public void baseUri() {
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
  }

  @Test(description = "TC-API-001 List users returns data")
  public void listUsers() {
    given()
    .when()
        .get("/users")
    .then()
        .statusCode(200)
        .body("size()", greaterThan(0))
        .body("[0].email", not(emptyOrNullString()));
  }

  @Test(description = "TC-API-002 Single user by id")
  public void getUserById() {
    given()
    .when()
        .get("/users/1")
    .then()
        .statusCode(200)
        .body("id", equalTo(1))
        .body("name", not(emptyOrNullString()));
  }

  @Test(description = "TC-API-003 Create user returns 201 with id")
  public void createUser() {
    given()
        .contentType(ContentType.JSON)
        .body(Map.of("name", "Alex Rivera", "username", "arivera", "email", "alex@example.com"))
    .when()
        .post("/users")
    .then()
        .statusCode(201)
        .body("name", equalTo("Alex Rivera"))
        .body("id", notNullValue());
  }

  @Test(description = "TC-API-004 Unknown resource returns 404")
  public void unknownResourceNotFound() {
    given()
    .when()
        .get("/posts/999999")
    .then()
        .statusCode(404);
  }
}
