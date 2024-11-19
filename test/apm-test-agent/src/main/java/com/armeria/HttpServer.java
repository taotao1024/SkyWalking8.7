package com.armeria;

/**
 * https://armeria.dev/docs/server-basics/
 */
public class HttpServer {
    public static void main(String[] args) {
        /*ServerBuilder sb = Server.builder();
        sb.http(8080);

        // Add a simple 'Hello, world!' service.
        sb.service("/", (ctx, req) -> HttpResponse.of("Hello, world!"));

        // Using path variables:
        sb.service("/greet/{name}", new AbstractHttpService() {
            @Override
            protected HttpResponse doGet(ServiceRequestContext ctx, HttpRequest req) {
                String name = ctx.pathParam("name");
                return HttpResponse.of("Hello, %s!", name);
            }
        }.decorate(LoggingService.newDecorator())); // Enable logging

        // Using an annotated service object:
        sb.annotatedService(new Object() {
            @Get("/greet2/:name") // `:name` style is also available
            public HttpResponse greet(@Param("name") String name) {
                return HttpResponse.of("Hello, %s!", name);
            }
        });*/
    }
}
