package com.appium.framework.core;

import com.support.framework.support.Property;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import static com.appium.framework.core.AppiumCukes.APPIUM_PORT;
import static com.support.framework.support.Property.APPIUM_HOST;
import static com.support.framework.support.Property.APPIUM_LOG;
import static com.support.framework.support.Util.getPort;
import static io.appium.java_client.service.local.AppiumDriverLocalService.buildService;

public final class AppiumServer {

    private final static AppiumDriverLocalService service;

    static {
        if (Property.PLATFORM_NAME.toString().equalsIgnoreCase("android")) {
            service = buildService(new AppiumServiceBuilder()
                    .withArgument(GeneralServerFlag.LOG_LEVEL, APPIUM_LOG.toString())
                    .withArgument(GeneralServerFlag.NO_PERMS_CHECKS)
                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                    .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, String.valueOf(getPort(0)))
                    .withArgument(AndroidServerFlag.SUPPRESS_ADB_KILL_SERVER)
                    .withIPAddress(APPIUM_HOST.toString())
                    .usingPort(APPIUM_PORT));
        } else {
            service = buildService(new AppiumServiceBuilder()
                    .withArgument(GeneralServerFlag.LOG_LEVEL, APPIUM_LOG.toString())
                    .withArgument(GeneralServerFlag.NO_PERMS_CHECKS)
                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                    .withIPAddress(APPIUM_HOST.toString())
                    .usingPort(APPIUM_PORT));
        }
    }

    static void startAppiumServer() {
        service.start();
    }

    static void stopAppiumServer() {
        if (service.isRunning()) {
            service.stop();
        }
    }

}
