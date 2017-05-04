package com.damelines.notes.handler

import io.vertx.ext.web.RoutingContext

class NotesHandlers {

  void getNoteList(RoutingContext routingContext) {
    def response = routingContext.response()
    response.putHeader('Content-Type', 'text/plain')
    response.end('You\'ve called getNoteList()')
  }

  void createNote(RoutingContext routingContext) {
    def jsonMap = routingContext.bodyAsString
    def response = routingContext.response()
    response.putHeader('Content-Type', 'text/plain')
    response.end("You\'ve called createNote($jsonMap)")
  }

  void updateNote(RoutingContext routingContext) {
    def jsonMap = routingContext.bodyAsJson
    def response = routingContext.response()
    response.putHeader('Content-Type', 'text/plain')
    response.end("You\'ve called updateNote($jsonMap)")
  }

  void deleteNote(RoutingContext routingContext) {
    def noteId = routingContext.request().getParam('noteId')
    def response = routingContext.response()
    response.putHeader('Content-Type', 'text/plain')
    response.end("You\'ve called deleteNote($noteId)")
  }

  void getNote(RoutingContext routingContext) {
    def noteId = routingContext.request().getParam('noteId')
    def response = routingContext.response()
    response.putHeader('Content-Type', 'text/plain')
    response.end("You\'ve called getNote($noteId)")
  }
}
