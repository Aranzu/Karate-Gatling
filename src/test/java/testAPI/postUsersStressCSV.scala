package testAPI

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class postUsersStressCSV extends Simulation {

  val csvFeeder = csv("testAPI/users2.csv").random

  val createUserScenario = scenario("Create Users from CSV")
    .feed(csvFeeder)
    .exec(karateFeature("classpath:testAPI/postUsersCSV.feature"))

  setUp(
    createUserScenario.inject(
      stressPeakUsers(500) during (5.minutes)
      /* heavisideUsers(500) during (5.minutes) */
      /* stressPeakUsers no disponible 3.1.2 gatling */
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