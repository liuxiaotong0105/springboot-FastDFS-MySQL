package com.jk;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.*;
import org.springframework.jmx.support.RegistrationPolicy;

import javax.servlet.MultipartConfigElement;


@Configuration   //加入了最大传送数据  得加这个注解
@Import(FdfsClientConfig.class)
@SpringBootApplication
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@MapperScan("com.jk.mapper")  //扫描持久层
public class SpringbootFastdfsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFastdfsApplication.class, args);
	}

	/**
	 * 配置上传文件大小的配置
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//  单个数据大小
		factory.setMaxFileSize("102400KB");
		/// 总上传数据大小
		factory.setMaxRequestSize("102400KB");
		return factory.createMultipartConfig();
	}
}