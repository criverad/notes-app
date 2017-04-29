import io.vertx.core.Vertx

class NotesApp {

  static void main(String[] args) {
    def vertx = Vertx.vertx()
    vertx.deployVerticle('NotesVerticle')
  }

}
