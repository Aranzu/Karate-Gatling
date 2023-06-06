package testAPI

import io.gatling.core.Predef._
import scala.concurrent.duration._
import com.intuit.karate.gatling.PreDef._
import scala.language.postfixOps

class putUsersSimulation extends Simulation {

  val updateUserScenario = scenario("Update User")
    .exec(karateFeature("classpath:testAPI/putUsers.feature"))

  setUp(
    updateUserScenario.inject(
      rampUsers(10) during (5.seconds)
    )
  )

}
