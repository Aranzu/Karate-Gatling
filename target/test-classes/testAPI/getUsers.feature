Feature: Obtener datos

  Background:
    * url 'https://reqres.in/api'
    * header Accept = 'application/json'

  Scenario: obtener datos del usuario en la pagina 2
    Given path '/users'
    And param page = 2
    When method GET
    Then status 200
    ##And print response
    ##And match response.data[0].first_name != null
    ##And assert response.data.length == 6
    ##And match response.data[3].id == 10
    ##And match $.data[5].email == 'rachel.howell@reqres.in'