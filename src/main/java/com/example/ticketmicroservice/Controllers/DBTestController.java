package com.example.ticketmicroservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dbtest")
public class DBTestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping
    public ResponseEntity<Map<String, Object>> testConnection() {
        Map<String, Object> response = new HashMap<>();
        
        try (Connection connection = dataSource.getConnection()) {
            response.put("status", "success");
            response.put("message", "Database connection successful");
            response.put("database", connection.getMetaData().getDatabaseProductName());
            response.put("url", connection.getMetaData().getURL());
            return ResponseEntity.ok(response);
        } catch (SQLException e) {
            response.put("status", "error");
            response.put("message", "Database connection failed: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}

