package com.csx.utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigCache;

public class AppConfigHolder {
  private static final AppConfig INSTANCE = ConfigCache.getOrCreate(AppConfig.class);
  private AppConfigHolder() {
      }
  public static AppConfig getInstance() {
    return INSTANCE;
  }
}
