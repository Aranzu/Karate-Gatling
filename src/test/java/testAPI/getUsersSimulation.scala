package testAPI

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._
import scala.language.postfixOps

class getUsersSimulation extends Simulation{


  val protocol = karateProtocol(
    "/api/users" -> pauseFor("get" -> 1),
    "/api/users/{userId}" -> pauseFor("get" -> 2)
  )

  val getUsers = scenario("getCall").exec(karateFeature("classpath:testAPI/getUsers.feature"))

  setUp(
    getUsers.inject(
      rampUsers(10) during (10 seconds),
      constantUsersPerSec(20) during (60 seconds)
    ).protocols(protocol)
  )
}
/* rampa de usuarios con 10 usuarios que se incrementan durante 10 segundos, seguido de una carga constante de 20
usuarios por segundo durante 60 segundos. Esto significa que la carga de usuarios comenzará con 1 usuario y aumentará
 gradualmente hasta 10 usuarios en 10 segundos, y luego mantendrá una carga constante de 20 usuarios por segundo durante
  60 segundos. Por supuesto, estos valores se pueden ajustar según las necesidades de su prueba.
 */