package clientpooltest;

import io.micronaut.http.annotation.*;
import io.reactivex.Single;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;

@Controller("/")
public class TestController {
    private AtomicInteger i = new AtomicInteger(0);
    @Inject
    private LocalClient client;

    @Get("slow")
    Single<String> getSlow() {
        i.incrementAndGet();
        return Single.just("hi")
                   .delay(10, TimeUnit.MILLISECONDS);
    }
    @Get("proxy")
    Single<String> proxy() {
        return client.getSlow();
    }

    @Get("i")
    Single<Integer> getI() {
        return Single.just(i.get());
    }
}
