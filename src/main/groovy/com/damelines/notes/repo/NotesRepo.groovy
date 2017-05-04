package com.damelines.notes.repo

class NotesRepo {

  def notes = [
      [id: UUID.randomUUID().toString(), title: 'Note 1', content: 'content for note 1'],
      [id: UUID.randomUUID().toString(), title: 'Note 2', content: 'content for note 2'],
  ]

  def getNotes() {
    notes
  }

  def getNote(noteId) {
    notes.find { it.id == noteId }
  }

  def createNote(note) {
    note.id = UUID.randomUUID()
    notes.add(note)
    note
  }

  def updateNote(note) {
    def foundNote = notes.find { it.id == note.id }
    foundNote.title = note.title
    foundNote.content = note.content
    foundNote
  }

  def deleteNote(noteId) {
    notes.removeAll { it.id == noteId }
  }

}
