package com.ht.healthtarget;

import java.io.Serializable;

public class Note implements Serializable {

    private int noteId;
    private String notename;
    private String noteqestion;
    private String noteupd;

    public Note() {

    }

    public Note(String notename, String noteqestion, String noteupd) {
        this.notename = notename;
        this.noteqestion = noteqestion;
        this.noteupd = noteupd;
    }

    public Note(int noteId, String notename, String noteqestion, String noteupd) {
        this.noteId = noteId;
        this.notename = notename;
        this.noteqestion = noteqestion;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNoteName() {
        return notename;
    }

    public void setNoteName(String notename) {
        this.notename = notename;
    }


    public String getNoteQestionId() {
        return noteqestion;
    }

    public void setNoteQestionId(String noteqestion) {
        this.noteqestion = noteqestion;
    }

    public String getNoteUpd() {
        return noteupd;
    }

    public void setNoteUpd(String noteupd) {
        this.noteupd = noteupd;
    }



    @Override
    public String toString() {
        return this.notename;
    }
}