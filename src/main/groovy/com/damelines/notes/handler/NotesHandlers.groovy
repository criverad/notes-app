package com.damelines.notes.handler

import com.damelines.notes.repo.NotesRepo
import io.vertx.core.json.Json
import io.vertx.ext.web.RoutingContext

import javax.inject.Inject

class NotesHandlers {

  @Inject
  NotesRepo notesRepo

  void getNoteList(RoutingContext routingContext) {
    def response = routingContext.response()
    response.putHeader('Content-Type', 'text/plain')
    response.setStatusCode(200).end(Json.encodePrettily(notesRepo.notes))
  }

  void getNote(RoutingContext routingContext) {
    def noteId = routingContext.request().getParam('noteId')
    def response = routingContext.response()
    response.putHeader('Content-Type', 'text/plain')
    response.setStatusCode(200).end(Json.encodePrettily(notesRepo.getNote(noteId)))
  }

  void createNote(RoutingContext routingContext) {
    def noteMap = Json.decodeValue(routingContext.bodyAsString, Map)
    def response = routingContext.response()
    response.putHeader('Content-Type', 'text/plain')
    response.setStatusCode(201).end(Json.encodePrettily(notesRepo.createNote(noteMap)))
  }

  void updateNote(RoutingContext routingContext) {
    def noteMap = Json.decodeValue(routingContext.bodyAsString, Map)
    def response = routingContext.response()
    response.putHeader('Content-Type', 'text/plain')
    response.setStatusCode(200).end(Json.encodePrettily(notesRepo.updateNote(noteMap)))
  }

  void deleteNote(RoutingContext routingContext) {
    def noteId = routingContext.request().getParam('noteId')
    def response = routingContext.response()
    notesRepo.deleteNote(noteId)
    response.setStatusCode(200).end()
  }
}
