### Exception Handling

1. The program ends with `ExceptionInInitializerError` because any exception thrown in a static block is wrapped into `ExceptionInInitializerError` and then that `ExceptionInInitializerError` is thrown. Remember that a static or instance initializer can only throw a `RuntimeException`.