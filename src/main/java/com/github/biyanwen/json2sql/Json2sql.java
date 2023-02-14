package com.github.biyanwen.json2sql;

import com.github.biyanwen.json2sql.api.JSONWriter;
import com.github.biyanwen.json2sql.impl.DefaultJSONParser;
import com.github.biyanwen.json2sql.impl.DefaultJSONWriter;
import com.github.biyanwen.json2sql.api.JSONParser;
import com.github.biyanwen.json2sql.config.Configuration;

import java.util.Map;

public class Json2sql {
    public static final String DATE = "DATE";
    public static final String DECIMAL = "DECIMAL";
    public static final String INTEGER = "INTEGER";
    public static final String TIMESTAMP = "TIMESTAMP";
    public static final String VARCHAR = "VARCHAR";

    private static Configuration configuration = new Configuration();

    /**
     * 将json解析成sql
     *
     * @param json      json字符串
     * @param tableName 表名字
     * @param path      生成sql文件存储路径 如果不传默认生成在当前项目目录
     */
    public static void parse(String json, String tableName, String... path) {
        Map<String, Object> sqlParamMap = parser(json, tableName);
        String outPath = null;
        if (path != null && path.length > 0) {
            outPath = path[0];
        }
        JSONWriter jsonWriter = new DefaultJSONWriter();
        jsonWriter.writer(sqlParamMap, outPath, tableName + ".sql");
    }

    public static String parse2String(String json, String tableName) {
        Map<String, Object> sqlParamMap = parser(json, tableName);
        JSONWriter jsonWriter = new DefaultJSONWriter();
        return jsonWriter.writer(sqlParamMap);
    }

    private static Map<String, Object> parser(String json, String tableName) {
        JSONParser parser = new DefaultJSONParser();
        return parser.parse(json, tableName);
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(Configuration configuration) {
        Json2sql.configuration = configuration;
    }

    public static void main(String[] args) {
        String json = "{\"createTime\":\"2020-08-03 15:04:11\",\"updateTime\":\"2020-08-03 15:04:11\",\"operator\":null,\"id\":\"8a8d813873a480c80173b322850c2f24\",\"date\":\"2020-07-28 00:00:00\",\"scheduleType\":0,\"tvMeta\":{\"startDateTime\":\"2020-07-28 00:00:00\",\"delta\":15,\"deltaUnit\":1,\"size\":96},\"tvCurveData\":[24665.049000,24418.200000,24131.447000,23784.557000,23502.484000,23217.092000,23050.082000,22788.170000,22499.367000,22278.930000,22110.252000,21920.418000,21707.723000,21551.438000,21400.354000,21265.904000,21215.463000,21111.490000,21115.215000,21239.277000,21713.352000,22153.686000,22611.660000,23015.732000,23525.436000,23784.420000,23933.363000,23992.572000,24371.514000,24437.902000,24731.568000,25049.850000,25779.238000,26295.688000,26673.348000,26903.291000,27103.790000,27446.810000,27725.887000,28018.656000,28375.945000,28707.154000,29184.545000,29813.383000,30458.496000,30536.781000,30077.227000,28623.346000,27940.363000,27933.219000,27952.164000,27868.686000,28079.777000,28180.820000,28545.812000,28835.643000,29436.969000,29662.441000,30138.797000,30245.012000,30546.883000,30666.678000,30845.344000,30853.200000,31102.846000,31213.676000,31281.486000,31416.062000,31423.174000,31547.244000,31417.824000,31389.066000,31251.246000,31238.422000,31000.812000,30677.668000,30385.852000,30194.648000,30024.453000,30090.438000,30177.648000,30278.812000,30232.482000,30195.715000,30344.605000,30220.700000,29977.906000,29821.050000,29758.137000,29394.443000,28776.871000,28011.277000,27316.236000,26531.625000,25877.281000,25267.000000],\"areaName\":\"河北\",\"areaId\":\"FkNOycgY4s\",\"deviceId\":\"FkNOycgY4s\"}";
        // 参数1：json字符串；参数2：表名
        String emAreaLoadFc = Json2sql.parse2String(json, "EM_AREA_LOAD_FC");
        System.out.println(emAreaLoadFc);
    }
}
