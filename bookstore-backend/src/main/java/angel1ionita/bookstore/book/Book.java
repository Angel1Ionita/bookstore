package angel1ionita.bookstore.book;

import angel1ionita.bookstore.author.Author;
import angel1ionita.bookstore.category.Category;
import angel1ionita.bookstore.publisher.Publisher;
import angel1ionita.bookstore.review.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    private String isbn;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    @Column(name = "publication_year")
    private Integer publicationYear;
    private String language;
    private Integer pages;
    private Float price;
    private String description;
    @Column(name = "average_rating")
    private Float averageRating;
    private Integer stock;
    private String image;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private Set<Review> reviews = new HashSet<>();
}
