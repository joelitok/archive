package com.proplant.backend.archive.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import com.proplant.backend.domaines.archive.repository.entity.Archive;
import com.proplant.backend.domaines.archive.service.ArchiveService;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArchiveControllertest {

  @LocalServerPort
  private Integer port;

  public static final String BASE_ARCHIVE_URL = "http://localhost:2022/archive";
  public static final String AUTHORIZATION = "Authorization";
  public static final String APPLICATION_JSON = "application/json";

  @Autowired
  public ArchiveService archiveService;

  @Test
  public void shouldReturnSuccessfullyWhenGetaddArchive200() {
    RestAssured.given().header(AUTHORIZATION, authenticationToken())
        .contentType(APPLICATION_JSON)
        .body(userTrueInfo())
        .when()
        .post(BASE_ARCHIVE_URL + "/new")
        .then()
        .statusCode(200);
  }

  @Test
  public void shouldReturnBadRequestWhenPostArchiveWithoutAuthenticationToken403() {
    RestAssured.given()
        .contentType(APPLICATION_JSON)
        .body(userTrueInfo())
        .when()
        .post(BASE_ARCHIVE_URL + "/new")
        .then()
        .statusCode(403);
  }

  @Test
  public void shouldReturnBadRequestWhenPostBadInfoArchive400() {
    RestAssured.given().header(AUTHORIZATION, authenticationToken())
        .contentType(APPLICATION_JSON)
        .body(userFalseInfo())
        .when()
        .post(BASE_ARCHIVE_URL + "/new")
        .then()
        .statusCode(200);
  }

  @Test
  public void shouldReturnBadRequestWhenPostBadURLArchive405() {
    RestAssured.given().header(AUTHORIZATION, authenticationToken())
        .contentType(APPLICATION_JSON)
        .body(userTrueInfo())
        .when()
        .post(BASE_ARCHIVE_URL + "/newfalse")
        .then()
        .statusCode(405);
  }

  @Test
  public void shouldReturnSuccessfullyWhendeleteArchive200() {
    RestAssured.given().header(AUTHORIZATION, authenticationToken())
        .contentType(APPLICATION_JSON)
        .post(BASE_ARCHIVE_URL + "/delete/1")
        .then()
        .statusCode(200);
  }

  @Test
  public void shouldReturnInternalServerErrorWhendeleteArchiveNotExist500() {
    RestAssured.given().header(AUTHORIZATION, authenticationToken())
        .contentType(APPLICATION_JSON)
        .post(BASE_ARCHIVE_URL + "/delete/" + randomId())
        .then()
        .statusCode(500);
  }

  @Test
  public void shouldReturnSuccessfullyWhengetallArchives200() {
    RestAssured.given().contentType(APPLICATION_JSON)
        .get(BASE_ARCHIVE_URL + "/all").then().statusCode(200);

  }

  @Test
  public void shouldReturnSuccessfullyWhengetSingleArchive200() {
    RestAssured.given().contentType(APPLICATION_JSON)
        .get(BASE_ARCHIVE_URL + "/1").then().statusCode(200);

  }

  @Test
  public void shouldReturnSuccessfullyWhenCheckIfArchiveExist() {
    Archive archive = new Archive();
    archive.setDescription("archive 2");
    archive.setImage(null);
    archive.setFile(null);
    archive.setName("archive 2");
    archive.setType("archive 2");
  }

  public String userTrueInfo() {
    return "{\"name\": \"Effective Java\", \"description\":\"mydescription\",\"image\":\"null\",\"file\":\"null\",\"type\":\"mytype\"}";
  }

  public String userFalseInfo() {
    return "{\"name\": \"Effective Java\", \"description\":\"mydescription\",\"file\":\"null\",\"type\":\"mytype\"}";
  }

  // espired after 10 days
  public String authenticationToken() {
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIkFETUlOIl0sImlzcyI6Ii9sb2dpbiIsImV4cCI6MTY1NTEyMTQxNX0._zEJ_gdO4PTiMOKuCHaWe2hEBw4Fo5rw6KswtFaZVWc";
    return token;
  }

  // mapShop String to file
  public byte[] mapShopStringToFile(String fileName) {
    byte[] bytes = fileName.getBytes();
    return bytes;
  }

  // get random value ID
  public int randomId() {
    int minimum = 10000;
    int maximum = 1000000000;
    int randomValue = 0;
    randomValue = minimum + (int) (Math.random() * maximum);
    return randomValue;

  }

}
