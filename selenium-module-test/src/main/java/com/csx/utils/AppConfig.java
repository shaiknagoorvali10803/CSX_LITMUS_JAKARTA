package com.csx.utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Mutable;

@LoadPolicy(LoadType.MERGE)
@Sources({"classpath:application-${environment}.properties"})
public interface AppConfig extends Config, Mutable {
  @Key("application.url")
  String applicationUrl();

  @Key("browser")
  String browser();

  @Key("manager_Username")
  String userName();

  @Key("manager_Password")
  String password();

  @Key("maintainer_Username")
  String mantainer_userName();

  @Key("maintainer_Password")
  String maintainer_password();

  @Key("googleurl")
  String googleurl();

  @Key("gridExecution")
  String gridExecution();

  @Key("headlessRun")
  String headlessRun();




}
