package clientpooltest;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client("http://localhost:8080")
public interface LocalClient {
    @Get("/slow")
    Single<String> getSlow();
}
