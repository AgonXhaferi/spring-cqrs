package io.github.agonxhaferi.springcqrs.command;

public interface CommandBus {
    <R, C extends Command<R>> R execute(C command);
}