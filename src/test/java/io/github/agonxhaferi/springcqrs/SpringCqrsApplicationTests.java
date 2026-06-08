package io.github.agonxhaferi.springcqrs;

import io.github.agonxhaferi.springcqrs.autoconfigure.NestCqrsAutoConfiguration;
import io.github.agonxhaferi.springcqrs.command.CommandBus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class SpringCqrsApplicationTests {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(NestCqrsAutoConfiguration.class));

    @Test
    void shouldAutoConfigureBusesWhenLibraryIsImported() {
        this.contextRunner.run(context -> {
            assertThat(context).hasSingleBean(CommandBus.class);
            assertThat(context).hasSingleBean(io.github.agonxhaferi.springcqrs.QueryBus.class);
        });
    }

}
