package com.damelines.notes.module

import com.damelines.notes.repo.NotesRepo
import com.google.inject.AbstractModule
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject

import javax.inject.Singleton

class NotesModule extends AbstractModule {

  Vertx vertx
  JsonObject config

  @Override
  protected void configure() {
    bind(NotesRepo).in(Singleton)
  }
}
