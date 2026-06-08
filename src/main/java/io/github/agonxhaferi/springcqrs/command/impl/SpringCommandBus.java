package io.github.agonxhaferi.springcqrs.command.impl;


import io.github.agonxhaferi.springcqrs.command.Command;
import io.github.agonxhaferi.springcqrs.command.CommandBus;
import io.github.agonxhaferi.springcqrs.command.CommandHandler;
import io.github.agonxhaferi.springcqrs.registry.SpringRegistryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@SuppressWarnings("unchecked")
public class SpringCommandBus implements CommandBus {

    private final SpringRegistryHandler<Command<?>, CommandHandler> registry;

    public SpringCommandBus(List<CommandHandler> handlers) {
        this.registry = new SpringRegistryHandler<>(
                handlers,
                CommandHandler.class,                "Command"
        );
    }

    @Override
    public <R, C extends Command<R>> R execute(C command) {
        CommandHandler<C, R> handler = (CommandHandler<C, R>) registry.getHandler(command.getClass());
        return handler.handle(command);
    }
}
