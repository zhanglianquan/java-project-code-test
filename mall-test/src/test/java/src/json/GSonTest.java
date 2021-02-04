package src.json;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglianquan
 * https://blog.csdn.net/pngfi/article/details/54848449
 * @date 2021/2/4
 **/
public class GSonTest {
    @Test
    public  void test(){
        String jsonStr = "{\"name\": \"90\"}";
        Gson gson= new Gson();
        Book b=gson.fromJson(jsonStr, Book.class);
        System.out.println(b.name);

        List<Book> books = new ArrayList<>(2);
        books.add(new Book("23"));

        Stu stu = new Stu("zhansan", books);
        System.out.println(gson.toJson(stu));

        Book[] books2 = gson.fromJson(gson.toJson(books), Book[].class);
        System.out.println(books2);

        List<Book> books3 = gson.fromJson(gson.toJson(books), List.class);
        System.out.println(books3);


    }

    class Book{
        String name = "";

        public Book(String i) {
            this.name = i;
        }
    }

    class Stu{
        String name;
        List<Book> books;

        public Stu(String name, List<Book> books) {
            this.name = name;
            this.books = books;
        }
    }
}
