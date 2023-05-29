package f_dynamicsql.mapper;

import f_dynamicsql.pojo.Book;

import java.util.ArrayList;

/**
 * 功能
 *
 * @author caojianbang
 * @date 28.7.22 8:33 AM
 */
public interface BookMapper {
    ArrayList<Book> getAll();
    ArrayList<Book> getAll2();
}
