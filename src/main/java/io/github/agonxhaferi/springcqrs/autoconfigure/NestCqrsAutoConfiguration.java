package io.github.agonxhaferi.springcqrs.autoconfigure;

import io.github.agonxhaferi.springcqrs.QueryBus;
import io.github.agonxhaferi.springcqrs.QueryHandler;
import io.github.agonxhaferi.springcqrs.SpringQueryBus;
import io.github.agonxhaferi.springcqrs.command.CommandBus;
import io.github.agonxhaferi.springcqrs.command.CommandHandler;
import io.github.agonxhaferi.springcqrs.command.impl.SpringCommandBus;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@AutoConfiguration
@SuppressWarnings("rawtypes")
public class NestCqrsAutoConfiguration {

    @Bean
    public CommandBus commandBus(List<CommandHandler> handlers) {
        return new SpringCommandBus(handlers);
    }

    @Bean
    public QueryBus queryBus(List<QueryHandler> handlers) {
        return new SpringQueryBus(handlers);
    }
}