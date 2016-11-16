package ca.jbrains.pos.test;

public class StandardOutCanvas implements Canvas {
    @Override
    public void render(String message) {
        System.out.println(message);
    }
}