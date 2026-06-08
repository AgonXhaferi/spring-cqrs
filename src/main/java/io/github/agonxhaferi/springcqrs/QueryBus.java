package io.github.agonxhaferi.springcqrs;

public interface QueryBus {
    <R, Q extends Query<R>> R execute(Q query);
}