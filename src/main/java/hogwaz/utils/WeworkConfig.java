package hogwaz.utils;

public class WeworkConfig {
    public String agentId = "1000002";
    public String corpsecret = "ps0ZI37_v5I1WTWLCTUT3y2mCaysu74rASA-KC891-U";
    public String weworkID = "ww452214f9c0e1de68";
    public String corpid = "ww452214f9c0e1de68";
    public String contactsecret = "s_KswAxf9TbQR1nVlYM-c586WGDSpeXh1k82O1RrYmw";
    public String customersecret = "TnInvzysbemxGr93ZXz0B7sEj9IwDMMXYuKOaRbsYcc";

    private static WeworkConfig weworkConfig;
    public static WeworkConfig getInstance(){
        if(weworkConfig ==null){
            weworkConfig = new WeworkConfig();
        }
        return weworkConfig;
    }
}
