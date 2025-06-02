package info.htoomaungthait.ems_backend.shell.command;

import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class HelloWorld {
    @ShellMethod(value = "Say hello to someone", key = "hello")
    public String hello(@ShellOption(defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }
}
