package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.hrbust.common.dto.request.BaseRequestDTO;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceSearchRequestDTO extends BaseRequestDTO {
    /**
     *     检索关键字。行政区划区域检索不支持多关键字检索。
     *     如果需要按POI分类进行检索，请将分类通过query参数进行设置，如query=美食
     */
    private String query;
    /**
     *     检索分类偏好，与q组合进行检索，多个分类以","分隔
     *     （POI分类），如果需要严格按分类检索，请通过query参数设置
     */
    private String tag;
    /**
     *     检索行政区划区域（增加区域内数据召回权重，如需严格限制召回数据在区域内，请搭配使用city_limit参数），可输入行政区划名或对应cityCode
     */
    private String region;

    /**
     * 区域数据召回限制，为true时，仅召回region对应区域内数据。
     */
    private Boolean city_limit;

    /**
     *     输出格式为json或者xml
     */
    private String output;

    /**
     *     检索结果详细程度。取值为1 或空，则返回基本信息；取值为2，返回检索POI详细信息
     */
    private String scope;

    /**
     * 检索过滤条件。当scope取值为2时，可以设置filter进行排序。
     * industry_type：行业类型，注意：设置该字段可提高检索速度和过滤精度，取值有：
     * hotel（宾馆）；
     * cater（餐饮）；
     * life（生活娱乐）
     * <p>
     * sort_name：排序字段，根据industry_type字段的值而定。
     * 1、industry_type为hotel时，sort_name取值有：
     * default（默认）；
     * price（价格）；
     * total_score（好评）；
     * level（星级）；
     * health_score（卫生）；
     * distance（距离排序，只有圆形区域检索有效）
     * 2、industry_type为cater时，sort_name取值有：
     * default（默认）；
     * taste_rating（口味）；
     * price（价格）；
     * overall_rating（好评）；
     * service_rating（服务）；
     * distance（距离排序，只有圆形区域检索有效）
     * 3、industry_type为life时，sort_name取值有：
     * default（默认）；
     * price（价格）；
     * overall_rating（好评）；
     * comment_num（服务）；
     * distance（距离排序，只有圆形区域检索有效）
     * <p>
     * sort_rule：排序规则：0（从高到低），1（从低到高）
     * price_section：价格区间
     * groupon：是否有团购：1（有），0（无）
     * discount：是否有打折：1（有），0（无）
     * <p>
     * 示例：sort_name:distance|sort_rule:1
     */
    private String filter;

    /**
     * 坐标类型，
     * 1（wgs84ll即GPS经纬度），
     * 2（gcj02ll即国测局经纬度坐标），
     * 3（bd09ll即百度经纬度坐标），
     * 4（bd09mc即百度米制坐标）
     * 注："ll为小写LL"
     */
    private Integer coord_type;

    /**
     *     可选参数，添加后POI返回国测局经纬度坐标
     */
    private String ret_coordtype;

    /**
     * 圆形区域检索中心点，不支持多个点
     * 38.76623,116.43213
     * lat<纬度>,lng<经度>
     */
    private String location;

    /**
     * 圆形区域检索半径，单位为米。(当半径过大，超过中心点所在城市边界时，会变为城市范围检索，检索范围为中心点所在城市）
     * 1000（默认）
     */
    private String radius;

    /**
     * 是否严格限定召回结果在设置检索半径范围内。true（是），false（否）。设置为true时会影响返回结果中total准确性及每页召回poi数量，我们会逐步解决此类问题。
     */
    private String radius_limit;

    /**
     * 检索矩形区域，多组坐标间以","分隔
     * 38.76623,116.43213,39.54321,116.46773 lat,lng(左下角坐标),lat,lng(右上角坐标)
     */
    private String bounds;

    /**
     * 单次召回POI数量，默认为10条记录，最大返回20条。多关键字检索时，返回的记录数为关键字个数*page_size。
     */
    private Integer page_size;

    /**
     * 分页页码，默认为0,0代表第一页，1代表第二页，以此类推。
     * 常与page_size搭配使用。
     */
    private Integer page_num;

    @Override
    public  String toString() {

        if (output == null) {
            throw new IllegalArgumentException("参数错误，请指定一种输出类型");
        }
        int paramCount = 0;
        if (region == null) {
            paramCount++;
        }
        if (location == null) {
            paramCount++;
        }
        if (bounds == null) {
            paramCount++;
        }
        switch (paramCount) {
            case 2:
                break;
            case 3:
                throw new IllegalArgumentException("参数错误，地址位置region location bounds参数为空！");
            default:
                throw new IllegalArgumentException("参数错误，地址位置region location bounds中只能填一项！");
        }

        return super.toString();
    }
}

