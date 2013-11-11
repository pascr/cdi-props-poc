# CDI properties injection experimentation

While migrating a spring based project to JBoss and CDI, I was looking for a way to inject properties the same way
Spring does with the @Value("prop.key") annotation and a property-placeholder.

Here is an example implementation in order to do so with CDI.

The tests run with CDI-Unit (jglue.org)