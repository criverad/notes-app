import io.vertx.core.AbstractVerticle
import io.vertx.ext.web.Router

class NotesVerticle extends AbstractVerticle {

  @Override
  void start() throws Exception {
    println('Starting NotesVerticle')

    def server = vertx.createHttpServer()
    def router = Router.router(vertx)

    router.route().handler({ routingContext ->
      def response = routingContext.response()
      response.putHeader('Content-Type', 'text/plain')
      response.end('Vertx Web transmitting!')
    })

    server.requestHandler(router.&accept).listen(8080)
  }

  @Override
  void stop() throws Exception {
    println 'Stopping NotesVerticle'
  }
}
