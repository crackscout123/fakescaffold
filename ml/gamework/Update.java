package ml.gamework;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

public class Update {

    public void checkUpdate(Integer SourceID, String name, String language){
        Plugin plugin = Bukkit.getPluginManager().getPlugin(name);
        String installed = plugin.getDescription().getVersion();
        String posted = "";
        String response = null;
        try {
            HttpsURLConnection con = (HttpsURLConnection)new URL(
                    "https://www.spigotmc.org/api/general.php").openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.getOutputStream()
                    .write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=" + SourceID)
                            .getBytes("UTF-8"));
            posted = new BufferedReader(new InputStreamReader(
                    con.getInputStream())).readLine();
            response = con.getResponseMessage();
        }catch (Exception localException) {
            System.err.println(localException.getCause());
            System.out.println("");
            System.err.println(localException.fillInStackTrace());
        }
        String[] installed_Arr = installed.split("[.]");
        String[] posted_Arr;
        if(posted != null){
            posted_Arr = posted.split("[.]");
            for (int i = 0; i < posted_Arr.length; i++) {
                if ((installed_Arr.length <= i) || (Integer.valueOf(installed_Arr[i]).intValue() < Integer.valueOf(posted_Arr[i]).intValue())) {
                    if(language == "enUS"){
                        Bukkit.getLogger().info(name + " has an update ready [" + installed + " -> " + posted + "]!");
                    }
                    if(language == "deDE"){
                        Bukkit.getLogger().info("Für " +name + " gibt es ein Update [" + installed + " -> " + posted + "]!");
                    }
                    if(language == "frFR"){
                        Bukkit.getLogger().info("Pour " + name + " il y a une mise à jour [" + installed + " -> " + posted + "]!");
                    }
                    if(language != "enUS" && language != "deDE" && language != "frFR"){
                        Bukkit.getLogger().info(name + " has an update ready [" + installed + " -> " + posted + "]!");
                    }

                    break;
                }
            }
        }else{
            Bukkit.getLogger().warning("UpdateNotifyerAPI Server is not available!");
            System.err.println(response);
            return;
        }
    }

}
