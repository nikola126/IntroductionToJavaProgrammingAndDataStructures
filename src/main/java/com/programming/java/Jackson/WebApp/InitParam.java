package com.programming.java.Jackson.WebApp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InitParam {
    @JsonProperty("configGlossary:installationAt")
    private String configGlossaryInstallationAt;
    @JsonProperty("configGlossary:adminEmail")
    private String configGlossaryAdminEmail;
    @JsonProperty("configGlossary:poweredBy")
    private String configGlossaryPoweredBy;
    @JsonProperty("configGlossary:poweredByIcon")
    private String configGlossaryPoweredByIcon;
    @JsonProperty("configGlossary:staticPath")
    private String configGlossaryStaticPath;

    private String templateProcessorClass;
    private String templateLoaderClass;
    private String templatePath;
    private String templateOverridePath;

    private String defaultListTemplate;
    private String defaultFileTemplate;

    private boolean useJSP;
    private String jspListTemplate;
    private String jspFileTemplate;

    private int cachePackageTagsTrack;
    private int cachePackageTagsStore;
    private int cachePackageTagsRefresh;

    private int cacheTemplatesTrack;
    private int cacheTemplatesStore;
    private int cacheTemplatesRefresh;

    private int cachePagesTrack;
    private int cachePagesStore;
    private int cachePagesRefresh;
    private int cachePagesDirtyRead;

    private String searchEngineListTemplate;
    private String searchEngineFileTemplate;
    private String searchEngineRobotsDb;

    private boolean useDataStore;
    private String dataStoreClass;
    private String redirectionClass;
    private String dataStoreName;
    private String dataStoreDriver;
    private String dataStoreUrl;
    private String dataStoreUser;
    private String dataStorePassword;
    private String dataStoreTestQuery;
    private String dataStoreLogFile;
    private int dataStoreInitConns;
    private int dataStoreMaxConns;
    private int dataStoreConnUsageLimit;
    private String dataStoreLogLevel;
    private int maxUrlLength;

    private String mailHost;
    private String mailHostOverride;

    private int log;
    private String logLocation;
    private String logMaxSize;
    private int dataLog;
    private String dataLogLocation;
    private String dataLogMaxSize;
    private String removePageCache;
    private String removeTemplateCache;
    private String fileTransferFolder;
    private int lookInContext;
    private int adminGroupID;
    private boolean betaServer;
}
