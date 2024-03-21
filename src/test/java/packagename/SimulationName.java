package packagename;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class SimulationName extends Simulation {

    public static final int vu = Integer.getInteger("vu", 1);

    HttpProtocolBuilder httpProtocol =
        http.baseUrl("https://computer-database.gatling.io")
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader(
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/119.0"
            );

    ScenarioBuilder users = scenario("Scenario 1").exec(http("Home").get("/computers"));

    {
        setUp(
            users.injectOpen(atOnceUsers(vu))
        ).protocols(httpProtocol);
    }
}
