Feature: Eliminar un usuario

  Background:
    * url 'https://reqres.in/api'
    * header Content-Type = 'application/json'

  Scenario: Eliminar un usuario existente
    Given path '/users/2'
    When method DELETE
    Then status 204