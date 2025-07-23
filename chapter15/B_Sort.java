package org.example.chapter15;

/*
1. 불변성 데이터: Stream API 정렬 사용
목적: 원본 리스트 변경 X, 정렬된 새로운 리스트만 필요시
클라이언트 응답용 DTO 리스트 정렬

2. 원본 리스트 자체 정렬

3. comparator 추출로 정렬 기준 재사용
목적) 정렬 기준이 자주 반복되거나 복잡한

 */
// 제품과 관련된 비지니스 로직을 수행하는 클래스
// crud + 필터링 존재

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.example.chapter09_practice.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
class Product {
    private int price;

}


@Getter
@AllArgsConstructor
@ToString

class Post {

    public Post(String title) {
    }
}

class ProductRepository {
    List<Product> findAll() {
        return new ArrayList<>(List.of(
                new Product(15),
                new Product(10),
                new Product(20),
                new Product(21),
                new Product(9)
        ));
    }
}

class PostRepository {
    List<Post> findTop5ByOrderByViewsDecs() {
        return new ArrayList<>(List.of(
                new Post("인기1"),
                new Post("인기2"),
                new Post("인기3"),
                new Post("인기4"),
                new Post("인기5")


        ));
    }
}


class ProductService {
    ProductRepository productRepository = new ProductRepository();
    // 생성
    void createProduct() {}
    // 수정
    void updateProduct() {}
    // 각 기준의 정렬된 새로운 리스트 반환
    List<Product> getProductSortedByPrice() {
     List<Product> products = productRepository.findAll();

     // stream().sorted()는 중간 연산
        // : 원본은 그대로 두고 가공된 결과를 생성
        // 불변 데이터 처리에 유리 클린 코드 작성에도 적합
     return products.stream()
             .sorted(Comparator.comparing(Product::getPrice))
             .collect(Collectors.toList());
    }
}

class PostService {
    PostRepository postRepository = new PostRepository();
    private List<Post> cachedPopularPosts;

    // list.sort는 리스트 그 자체로 변경
    // stream 보다 메모리 효율이 좋음

    public List<Post> getPopularPosts() {
        if (cachedPopularPosts == null) {
            cachedPopularPosts = postRepository.findTop5ByOrderByViewsDecs();
        }
        return cachedPopularPosts;
    }
    public void refreshPopularPostsCache() {
        cachedPopularPosts = postRepository.findTop5ByOrderByViewsDecs();
    }
}

// 정렬 기준 별도의 유틸 클래스로 분리
// 사용할 데이터 정렬 로직 정리
class UserComparators {
    public static final Comparator<User> BY_NAME = Comparator.comparing(User::getName);


}

public class B_Sort {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>(List.of(
                new User("홍기수",25),
                new User("이도경",20),
                new User("김명진",30),
                new User("조승범",27),
                new User("운대위",23)
        ));



        System.out.println(userList);

        userList.sort(UserComparators.BY_NAME);

        System.out.println(userList);
    }
}

// SQL 정렬 VS java 정렬의 역활 분리
// >> 성능 최적화 및 역활 구분
// 1) 데이터가 많고 단순한 정렬 : SQL - ORDER BY
// 2) 복잡한 정렬 기준 : JAVA - COMPARATOR Stream API
// 3) 정렬 조건이 요청마다 달라짐 : java 처리
// 4) 정렬된 순서를 DB에서 보장 : SQL 처리
