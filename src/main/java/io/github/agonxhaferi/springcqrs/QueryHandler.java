package io.github.agonxhaferi.springcqrs;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}