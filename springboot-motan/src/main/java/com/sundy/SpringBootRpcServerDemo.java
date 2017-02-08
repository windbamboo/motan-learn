package com.sundy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import com.weibo.api.motan.util.MotanSwitcherUtil;

/**
 * springboot 启动motan服务
 */
@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootRpcServerDemo {

		public static void main(String[] args) {
			System.setProperty("server.port", "8081");
			SpringApplication.run(SpringBootRpcServerDemo.class, args);
			MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
			System.out.println("server start...");
		}

		@Bean
		public AnnotationBean motanAnnotationBean() {
			AnnotationBean motanAnnotationBean = new AnnotationBean();
			motanAnnotationBean.setPackage("com.sundy.motan.server");
			return motanAnnotationBean;
		}

		@Bean(name = "demoMotan")
		public ProtocolConfigBean protocolConfig1() {
			ProtocolConfigBean config = new ProtocolConfigBean();
			config.setDefault(true);
			config.setName("motan");
			config.setMaxContentLength(1048576);
			return config;
		}

		@Bean(name = "registryConfig1")
		public RegistryConfigBean registryConfig() {
			RegistryConfigBean config = new RegistryConfigBean();
			config.setRegProtocol("local");
			return config;
		}

		@Bean
		public BasicServiceConfigBean baseServiceConfig() {
			BasicServiceConfigBean config = new BasicServiceConfigBean();
			config.setExport("demoMotan:8002");
			config.setAccessLog(false);
			config.setShareChannel(true);
			config.setGroup("motan-demo-rpc");
			config.setModule("motan-demo-rpc");
			config.setApplication("myMotanDemo");
			config.setRegistry("registryConfig1");
			return config;
		}


}
