import io.vertx.core.DeploymentOptions
import io.vertx.core.Vertx

class AppMain {

  static void main(String[] args) {
    def vertx = Vertx.vertx()
    def deploymentOptions = new DeploymentOptions()
    deploymentOptions.instances = 2

    vertx.deployVerticle('VerticleA', deploymentOptions)
  }

}
