package ru.aberezhnoy.memento;

public class MementoApp {
    public static void main(String[] args) {
        Editor editor = new Editor();

        editor.type("This is the first sentence. This is second.");
        EditorMemento saved = editor.save();

        editor.type("And this is third.");

        System.out.println(editor.getContent());
        editor.restore(saved);

        System.out.println(editor.getContent());
    }
}
