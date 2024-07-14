package com.neusoft.nepm.common.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class myGenerator {

    private static final String URL = "jdbc:mysql://localhost:3306/nepm?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String PACKAGE_NAME = "com.neusoft.nepm";
    private static final String AUTHOR_NAME = "crm";
    private static final String OUTDIR_JAVA = "D:\\Study\\Code\\2024ShiXi\\NEPM-crm\\src\\main\\java";
    private static final String OUTDIR_XML = "D:\\Study\\Code\\2024ShiXi\\NEPM-crm\\src\\main\\resources\\mapper";

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author(AUTHOR_NAME) // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(OUTDIR_JAVA) // 指定输出目录
                            .disableOpenDir();    // 禁止打开输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(PACKAGE_NAME) // 设置包名
                            .entity("po")         //设置实体类包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, OUTDIR_XML)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("admins","aqi","aqi_feedback","grid_city","grid_member","grid_province","statistics","supervisor") // 设置需要生成的表名
                            .controllerBuilder()   //这里写controllerBuilder，表示将开始controller配置
                            .enableRestStyle();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
