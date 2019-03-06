package clientpooltest;

import io.micronaut.http.annotation.*;
import io.reactivex.Single;

import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@Controller("/")
public class TestController {
    @Inject
    private LocalClient client;

    @Get("slow")
    Single<String> getSlow() {
        return Single.just("hi")
                   .delay(3, TimeUnit.SECONDS);
    }
    @Get("proxy")
    Single<String> proxy() {
        return client.getSlow();
    }
}
