package com.juzheng.Api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by 华 on 2018/5/30.
 */
@Configuration
@EnableSwagger2
public class Api {
	
	@Value("${show}")
	private Integer show;
	
	
	   @Bean
	    public Docket createRestApi() {
		  if (show==1) {
			  ParameterBuilder ticketPar = new ParameterBuilder();
		        List<Parameter> pars = new ArrayList<Parameter>();
		        ticketPar.name("Authorization").description("user token")
		                .modelRef(new ModelRef("string")).parameterType("header")
		                .required(false).build(); //header中的ticket参数非必填，传空也可以
		        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
		        return new Docket(DocumentationType.SWAGGER_2)
		                .apiInfo(apiInfo())
		                .globalOperationParameters(pars)
		                .select()
		                // 指定controller存放的目录路径
		                .apis(RequestHandlerSelectors.basePackage("com.juzheng.controller"))
		                .paths(PathSelectors.any())
		                .build();
			}else {
				return new Docket(DocumentationType.SWAGGER_2)
			    	.apiInfo(apiInfoOnline())
					.select()
			        .paths(PathSelectors.none())//如果是线上环境，添加路径过滤，设置为全部都不符合
					.build();
			}
		  
		  

	        

	    }
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("政务系统接口文档")
	                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
	                .termsOfServiceUrl("http://blog.didispace.com/")
	                .contact("wzh")
	                .version("1.0")
	                .build();
	    }
	    
	    private ApiInfo apiInfoOnline() {
	    	return new ApiInfoBuilder()
	                .title("")
	                .description("")
	                .license("")
	                .licenseUrl("")
	                .termsOfServiceUrl("")
	                .version("")
	                .contact("wzh")
	                .build();
	    }


}
