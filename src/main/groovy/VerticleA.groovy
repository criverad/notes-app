import io.vertx.core.AbstractVerticle

class VerticleA extends AbstractVerticle {

  @Override
  void start() throws Exception {
    println "Starting VerticleA on thread ${Thread.currentThread().name}"
  }

  @Override
  void stop() throws Exception {
    println "Stopping VerticleA"
  }
}
