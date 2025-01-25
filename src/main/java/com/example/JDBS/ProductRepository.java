package com.example.JDBS;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    // объект для работы с базой данных с импользованием именновыных парметров в SQL запросах
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getProductName(String name) {
        // переменная с именем скрипта
        String fileName = "fetchProduct.sql";
        //получаю скрипт в переменную "sql"
        String sql = read(fileName);

        // ключ - имя параметра в sql запросе
        //значение - имя которое ищем
        Map<String, String> params = new HashMap<>();
        params.put("name", name.toLowerCase());
        return jdbcTemplate.queryForObject(sql, params, String.class);
    }


    // метод копирует скрипт запроса в переменную read
    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}