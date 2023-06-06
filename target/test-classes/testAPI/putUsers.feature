Feature: Actualizar información del usuario

  Background:
    * url 'https://reqres.in/api'
    * header Content-Type = 'application/json'

  Scenario: Actualizar información del usuario
    Given path '/users/2'
    And request { "name": "morpheus", "job": "leader" }
    When method PUT
    Then status 200
    ##And match response.name == 'morpheus'
    ##And match response.job == 'leader'
    ##And match response.updatedAt != null