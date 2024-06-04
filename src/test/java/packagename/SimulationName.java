package packagename;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class SimulationName extends Simulation {

  public static final int vu = Integer.getInteger("vu", 1);

  HttpProtocolBuilder httpProtocol =
      http.baseUrl("https://computer-database.gatling.io")
          .acceptHeader("application/json")
          .contentTypeHeader("application/json");

  ScenarioBuilder users = scenario("My Scenario").exec(http("Request 1").get("/computers"));

  {
    setUp(users.injectOpen(atOnceUsers(vu))).protocols(httpProtocol);
  }
}
