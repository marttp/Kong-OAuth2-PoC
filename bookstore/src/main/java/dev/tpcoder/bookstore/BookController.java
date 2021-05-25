package dev.tpcoder.bookstore;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1")
public class BookController {

    @GetMapping("/books")
    public Flux<Book> getBooks() {
        return Flux.just(
                Book.builder()
                        .bookName("Forest")
                        .author("Steve")
                        .price(new BigDecimal("9.00"))
                        .build(),
                Book.builder()
                        .bookName("Beach")
                        .author("Badiou")
                        .price(new BigDecimal("5.00"))
                        .build(),
                Book.builder()
                        .bookName("Volcano")
                        .author("Ifrit")
                        .price(new BigDecimal("13.00"))
                        .build()
        );
    }

    @GetMapping("/books/alternatives")
    public Flux<Book> getBooksAlternative() {
        return Flux.just(
                Book.builder()
                        .bookName("Attack on Mountain")
                        .author("Elon Jaegy")
                        .price(new BigDecimal("100.00"))
                        .build(),
                Book.builder()
                        .bookName("One junk")
                        .author("Smokebomb Unji")
                        .price(new BigDecimal("50.00"))
                        .build()
        );
    }
}
