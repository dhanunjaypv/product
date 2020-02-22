package com.bicgraphic.ods.odsproductmarketingdata.configuration;

import java.util.Properties;
import java.util.function.Function;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.bicgraphic.ods.odsproductmarketingdata.service.EventObjectTypeService;

@Configuration
public class ValidationConfiguration implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
    
    @SuppressWarnings("unchecked")
    @Bean
    public Function<String, Function<String, EventObjectTypeService>> eventTypeFactory() {
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(Function.class);
        Properties validatorMappings = new Properties();
        validatorMappings.put("ENTERPRISEPRODUCT", "productDataEventTypeServiceFactory");
        validatorMappings.put("PRODUCTORG", "productOrgEventTypeServiceFactory");
        validatorMappings.put("PRODUCTATTRIBUTE", "productAttributeEventTypeServiceFactory");
        validatorMappings.put("PRODUCTALERT", "productAlertEventTypeServiceFactory");
        serviceLocatorFactoryBean.setServiceMappings(validatorMappings);
        serviceLocatorFactoryBean.afterPropertiesSet();
        serviceLocatorFactoryBean.setBeanFactory(applicationContext);
        return (Function<String, Function<String, EventObjectTypeService>>) serviceLocatorFactoryBean.getObject();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Function<String, EventObjectTypeService> productDataEventTypeServiceFactory() {
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(Function.class);
        Properties validatorMappings = new Properties();
        validatorMappings.put("CREATE", "productDataUpsertEventTypeService");
        validatorMappings.put("UPDATE", "productDataUpsertEventTypeService");
        //validatorMappings.put("DELETE", "productDataDeleteEventTypeService");
        validatorMappings.put("UPSERT", "productDataUpsertEventTypeService");
        serviceLocatorFactoryBean.setServiceMappings(validatorMappings);
        serviceLocatorFactoryBean.afterPropertiesSet();
        serviceLocatorFactoryBean.setBeanFactory(applicationContext);
        return (Function<String, EventObjectTypeService>) serviceLocatorFactoryBean.getObject();
    }
    
    @SuppressWarnings("unchecked")
    @Bean
    public Function<String, EventObjectTypeService> productOrgEventTypeServiceFactory() {
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(Function.class);
        Properties validatorMappings = new Properties();
        validatorMappings.put("CREATE", "productOrgUpsertEventTypeService");
        validatorMappings.put("UPDATE", "productOrgUpsertEventTypeService");
        validatorMappings.put("DELETE", "productOrgDeleteEventTypeService");
        validatorMappings.put("UPSERT", "productOrgUpsertEventTypeService");
        serviceLocatorFactoryBean.setServiceMappings(validatorMappings);
        serviceLocatorFactoryBean.afterPropertiesSet();
        serviceLocatorFactoryBean.setBeanFactory(applicationContext);
        return (Function<String, EventObjectTypeService>) serviceLocatorFactoryBean.getObject();
    }
    
    @SuppressWarnings("unchecked")
    @Bean
    public Function<String, EventObjectTypeService> productAttributeEventTypeServiceFactory() {
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(Function.class);
        Properties validatorMappings = new Properties();
        validatorMappings.put("CREATE", "productAttributeUpsertEventTypeService");
        validatorMappings.put("UPDATE", "productAttributeUpsertEventTypeService");
        validatorMappings.put("DELETE", "productAttributeUpsertEventTypeService");
        validatorMappings.put("UPSERT", "productAttributeUpsertEventTypeService");
        serviceLocatorFactoryBean.setServiceMappings(validatorMappings);
        serviceLocatorFactoryBean.afterPropertiesSet();
        serviceLocatorFactoryBean.setBeanFactory(applicationContext);
        return (Function<String, EventObjectTypeService>) serviceLocatorFactoryBean.getObject();
    }
    
    @SuppressWarnings("unchecked")
    @Bean
    public Function<String, EventObjectTypeService> productAlertEventTypeServiceFactory() {
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(Function.class);
        Properties validatorMappings = new Properties();
        validatorMappings.put("CREATE", "productAlertUpsertEventTypeService");
        validatorMappings.put("UPDATE", "productAlertUpsertEventTypeService");
        validatorMappings.put("DELETE", "productAlertUpsertEventTypeService");
        validatorMappings.put("UPSERT", "productAlertUpsertEventTypeService");
        serviceLocatorFactoryBean.setServiceMappings(validatorMappings);
        serviceLocatorFactoryBean.afterPropertiesSet();
        serviceLocatorFactoryBean.setBeanFactory(applicationContext);
        return (Function<String, EventObjectTypeService>) serviceLocatorFactoryBean.getObject();
    }

}
