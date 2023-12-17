package com.csx.util;

public class PropertyHandler {
    public static final String setHeadlessProperty(String headlessMode) {
        String isHeadLessSel = null;
        isHeadLessSel= headlessMode == null ? AppConfigHolder.getInstance().headlessRun() : headlessMode;
        return isHeadLessSel;
    }

    public static final String setGridExecutionMode(String gridExecutionMode) {
        String isRemoteExecutionSel = null;
        isRemoteExecutionSel= gridExecutionMode == null ? AppConfigHolder.getInstance().gridExecution() : gridExecutionMode;
        return isRemoteExecutionSel;
    }
}
