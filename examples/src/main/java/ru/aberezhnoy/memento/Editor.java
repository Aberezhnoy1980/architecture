package ru.aberezhnoy.memento;

public class Editor {
    private String content = "";

    public void type(String words) {
        this.content = this.content + " " + words;
    }

    public String getContent() {
        return content;
    }

    public EditorMemento save() {
        return EditorMemento
                .createEditor()
                .setContent(content)
                .build();
    }

    public void restore(EditorMemento memento) {
        this.content = memento.getContent();
    }
}
