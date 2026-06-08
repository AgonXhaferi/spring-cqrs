package io.github.agonxhaferi.springcqrs;


import io.github.agonxhaferi.springcqrs.registry.SpringRegistryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@SuppressWarnings("unchecked")
public class SpringQueryBus implements QueryBus {
    private final SpringRegistryHandler<Query<?>, QueryHandler> registry;

    public SpringQueryBus(List<QueryHandler> handlers) {
        this.registry = new SpringRegistryHandler<>(
                handlers,
                QueryHandler.class,
                "Query"
        );
    }

    @Override
    public <R, Q extends Query<R>> R execute(Q query) {
        QueryHandler<Q, R> handler = (QueryHandler<Q, R>) registry.getHandler(query.getClass());

        return handler.handle(query);
    }
}