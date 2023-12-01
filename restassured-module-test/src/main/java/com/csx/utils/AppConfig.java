package com.csx.utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Mutable;

/**
 * This interface associates Keys in the AppConfig.properties file with the abstract methods
 * declared inside this Interface and since the name of this interface is same as the properties
 * file hence AEON OWNERs API will be able to associate them. Key annotation is used to map the
 * property name often containing dot in the Key names to the associated method.
 *
 * @author Z2287
 *
 */
@LoadPolicy(LoadType.MERGE)
@Sources({"classpath:AppConfig.properties"})
public interface AppConfig extends Config, Mutable {

  @Key("environment")
  String environment();

  @Key("auth_qa_url")
  String auth_qa_url();

  @Key("hierarchy_qa_api_endpoint")
  String hierarchy_qa_api_endpoint();

  @Key("auth_dev_url")
  String auth_dev_url();

  @Key("hierarchy_dev_api_endpoint")
  String hierarchy_dev_api_endpoint();




}
