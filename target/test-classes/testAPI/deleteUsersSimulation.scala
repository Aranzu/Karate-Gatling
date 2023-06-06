package testAPI

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import scala.concurrent.duration._
import com.intuit.karate.gatling.PreDef._
import scala.language.postfixOps

class deleteUsersSimulation extends Simulation {

  val deleteUserScenario: ScenarioBuilder =
    scenario("Delete User Test")
      .exec(
        karateFeature("classpath:testAPI/deleteUsers.feature")
      )

  setUp(
    deleteUserScenario.inject(
      rampUsers(10) during (10 seconds),
      constantUsersPerSec(20) during (60 seconds)
    )
  )
}