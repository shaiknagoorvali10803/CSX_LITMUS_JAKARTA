package com.csx.util;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Mutable;

@LoadPolicy(LoadType.MERGE)
@Sources({"classpath:application-${environment}.properties"})
public interface AppConfig extends Config, Mutable {

  @Key("auth_url")
  String auth_url();

  @Key("hierarchy_api_endpoint")
  String hierarchy_api_endpoint();

}
