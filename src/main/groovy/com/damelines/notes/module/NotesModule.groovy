package com.damelines.notes.module

import com.google.inject.AbstractModule
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject

class NotesModule extends AbstractModule {

  Vertx vertx
  JsonObject config

  @Override
  protected void configure() {
  }
}
