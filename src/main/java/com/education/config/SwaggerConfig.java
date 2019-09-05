package com.education.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl
 * @Description
 * @date 2019-09-02 13:54
 * @Param
 * @return
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.education.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeys;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> arrayList = new ArrayList();
        arrayList.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$"))
                .build());
        return arrayList;
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }
//
//    private ApiInfo metaData() {
//        ApiInfo apiInfo = new ApiInfoBuilder()
//                .title("API文档")
//                .description("API文档的详细描述")
//                .version("1.0")
//                .contact(new Contact("刘欣欣", "http://localhost:8056/swagger-ui.html", "18634318474@163.com"))
//                .build();
//        return apiInfo;
//    }


//        @Value("${swagger.enabled}")
//        private boolean swaggerEnabled = false;
//
//        @Resource
//        private Docket docket;
//
////        @Resource
////        private AuthInterceptor authInterceptor;
//
//        @PostConstruct
//        public void init() {
//            docket.apiInfo(new ApiInfoBuilder()
//                    .title("家教接口文档")
//                    .description("描述：家教小程序、app使用")
//                    .version("版本号:1.0")
//                    .build());
//        }
//
////        /**
////         * 注册拦截器
////         *
////         * @param registry 注册接口
////         */
////        @Override
////        public void addInterceptors(InterceptorRegistry registry) {
////            //注册 用户账号信息处理拦截器
////            registry.addInterceptor(authInterceptor).addPathPatterns("/**");
////        }
//
//        @Override
//        protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//            if (swaggerEnabled) {
//                super.addResourceHandlers(registry);
//                registry.addResourceHandler("swagger-ui.html","doc.html")
//                        .addResourceLocations("classpath:/META-INF/resources/");
//                registry.addResourceHandler("/webjars/**")
//                        .addResourceLocations("classpath:/META-INF/resources/webjars/");
//            }
//        }
}