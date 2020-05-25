package sarguss.httpClient;

import feign.Param;
import feign.RequestLine;
import sarguss.model.Page;


public interface IClient {

    @RequestLine("GET /search/apartments?price%5Bmin%5D={minPrice}" +
            "&price%5Bmax%5D={maxPrice}&currency=usd&rent_type%5B%5D=1_room&" +
            "bounds%5Blb%5D%5Blat%5D=53.82484108401111&bounds%5Blb%5D%5Blong%5D=27.514348966750134&" +
            "bounds%5Brt%5D%5Blat%5D=53.989816536268066&bounds%5Brt%5D%5Blong%5D=27.741796507339092&" +
            "page={pageId}")
    Page getApartments(@Param("pageId") int pageId,
                       @Param("minPrice") String minPrice,
                       @Param("maxPrice") String maxPrice);

}
