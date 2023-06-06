Feature: Prueba con datos de un archivo CSV

  Background: 
    * url 'https://reqres.in/api'
    * header Content-Type = 'application/json'

  Scenario Outline: Crear usuarios con datos de un archivo CSV
    Given path '/users'
    And request { name: '<name>', email: '<email>' }
    When method POST
    Then status 201
    ##And match response == { id: '#ignore', createdAt: '#ignore', name: '<name>', email: '<email>' }

    Examples: 
      | read('users2.csv') |