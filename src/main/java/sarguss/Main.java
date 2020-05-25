package sarguss;

import sarguss.data.Storage;
import sarguss.httpClient.FeignClient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Storage storage = new Storage();
        FeignClient client = new FeignClient();
        storage.update(client);

    }
}
