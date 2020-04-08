/**
 *
 *  @author Dobosz Kacper S18903
 *
 */

package PASSTIME1;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import javax.crypto.spec.OAEPParameterSpec;
import java.io.*;
import java.lang.module.Configuration;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;


public class Tools {
    public static Options createOptionsFromYaml(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(new File(fileName));
        Yaml yaml = new Yaml();
        Map mapa = yaml.load(inputStream);
        return new Options(mapa.get("host").toString(), (int) mapa.get("port"), (boolean) mapa.get("concurMode"), (boolean) mapa.get("showSendRes"), (Map) mapa.get("clientsMap"));
    }
}
