package com.hospital.hospitalmanagementsystem;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MybatisPlusGenerator {
    public MybatisPlusGenerator() {
    }

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/hospitalmanagementsystem", "root", "root")
                .globalConfig((builder) -> {
                    builder.author("asfand")
                            .enableSwagger()
                            .outputDir("D://workspace//hospitalManagementSystem//src//main//java//");
                })
                .dataSourceConfig((builder) -> {
                    builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                        int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                        return (IColumnType)(typeCode == 5 ? DbColumnType.INTEGER : typeRegistry.getColumnType(metaInfo));
                    });
                })
                .packageConfig((builder) -> {
                    builder.parent("com.hospital.hospitalmanagementsystem")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://workspace//hospitalManagementSystem//src//main//resources//com//hospital//hospitalmanagementsystem//mapper//"));
                })
                .strategyConfig((builder) -> {
                    // This will automatically fetch all table names in the database
                    builder.addInclude(getAllTableNames())  // This gets all the tables from the database
                            .entityBuilder()
                            .enableLombok()  // Optional: If you want to enable Lombok annotations
                            .enableChainModel(); // Optional: Enables chain model for setters
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    // This method will fetch all table names from the database
    private static String[] getAllTableNames() {
        // You need to connect to the database and retrieve all table names.
        // This is a basic example using JDBC.

        // Assuming you have a method to get the connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagementsystem", "root", "root")) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW TABLES");

            // Collect all the table names
            List<String> tables = new ArrayList<>();
            while (rs.next()) {
                tables.add(rs.getString(1));
            }

            // Convert the List to a String array and return
            return tables.toArray(new String[0]);
        } catch (SQLException e) {
            e.printStackTrace();
            return new String[0]; // If error occurs, return an empty array
        }
    }
}
