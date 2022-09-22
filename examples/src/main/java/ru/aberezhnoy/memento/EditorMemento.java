package ru.aberezhnoy.memento;

public class EditorMemento {
    private String content;

    public String getContent() {
        return content;
    }

    public static Builder createEditor() {
        return new Builder();
    }

    public static class Builder {
        private final EditorMemento editorMemento;

        public Builder() {
            this.editorMemento = new EditorMemento();
        }

        public Builder setContent(String content) {
            this.editorMemento.content = content;
            return this;
        }

        public EditorMemento build() {
            return editorMemento;
        }
    }
}
