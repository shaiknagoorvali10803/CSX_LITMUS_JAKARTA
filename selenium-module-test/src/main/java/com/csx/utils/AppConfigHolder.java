package com.csx.utils;

import org.aeonbits.owner.ConfigCache;

public class AppConfigHolder {
  private AppConfigHolder() {

  }
  private static final AppConfig INSTANCE = ConfigCache.getOrCreate(AppConfig.class);
  public static AppConfig getInstance() {
    return INSTANCE;
  }
}
