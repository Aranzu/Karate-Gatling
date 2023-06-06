package testAPI

import io.gatling.core.Predef._
import scala.concurrent.duration._
import com.intuit.karate.gatling.PreDef._
import scala.language.postfixOps

class postUsersCSV extends Simulation {

  val csvFeeder = csv("testAPI/users2.csv").random

  val createUserScenario = scenario("Create Users from CSV")
    .feed(csvFeeder)
    .exec(karateFeature("classpath:testAPI/postUsersCSV.feature"))

  val createUserScenario2 = scenario("Create Users from CSV")
    .feed(csvFeeder)
    .exec(karateFeature("classpath:testAPI/postUsersCSV.feature"))

  val createUserScenario3 = scenario("Create Users from CSV")
    .feed(csvFeeder)
    .exec(karateFeature("classpath:testAPI/postUsersCSV.feature"))

  setUp(
    createUserScenario.inject(
      rampUsers(100) during (30.seconds)
    )
  )
  setUp(
    createUserScenario2.inject(
      rampUsers(100) during (30.seconds)
    )
  )
  setUp(
    createUserScenario3.inject(
      rampUsers(100) during (30.seconds)
    )
  )

}
/*Carga ligera: 10 usuarios durante 30 segundos.
Carga media: 50 usuarios durante 1 minuto.
Carga alta: 100 usuarios durante 2 minutos.
Prueba de stress: 500 usuarios durante 5 minutos.

se utiliza stressPeakUsers para inyectar 500 usuarios en 10 segundos y luego mantener ese nivel de carga
durante los siguientes 5 minutos.Es importante ajustar la cantidad de usuarios y la duración de la prueba
de acuerdo a las características de la aplicación a probar y los objetivos de la prueba.
 */