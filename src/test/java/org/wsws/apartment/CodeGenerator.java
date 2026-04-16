package org.wsws.apartment;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

public class CodeGenerator {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/smart_apartment?useSSL=false&serverTimezone=Asia/Shanghai"+ "&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "hea1thy";

    public static void main(String[] args) {
        String outputDir = System.getProperty("user.dir") + "/src/main/java";

        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author("wsws")
                            .outputDir(outputDir);
                })
                .packageConfig(builder ->
                        builder.parent("org.wsws.apartment")
                                .moduleName("generator")
                )
                .strategyConfig(builder ->
                        builder.addInclude("t_ai_conversation", "t_ai_house_desc")
                                .addTablePrefix("t_")
                )
                .execute();
    }
}
