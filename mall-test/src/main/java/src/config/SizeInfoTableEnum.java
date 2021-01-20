package src.config;

import com.google.common.collect.ImmutableList;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanglianquan
 * @date 2021/1/20
 **/
public enum SizeInfoTableEnum {
    XS_SKC(ImmutableList.of("swsadafasbra04201119989"), "XS", ImmutableList.of("FRd", "DdE"), "fasfd 65C 70A 70B"),
    XS_SKC_OTHER(ImmutableList.of("swsadafasbra04201119989"), "XS", ImmutableList.of("OTHER"), "30B fdad 32A 32B"),

    XXL_SKC(ImmutableList.of("Msadfasfasf032020dd11165326"), "XXL", ImmutableList.of("FRd", "DEd"), "8dfasfds-94");


    private List<String> skcList;
    private String sizeKey;
    private List<String> countryList;
    private String sizeDescInfo;
    SizeInfoTableEnum(List<String> skcList, String sizeKey, List<String> countryList, String sizeDescInfo){
        this.skcList =skcList;
        this.sizeKey =sizeKey;
        this.countryList =countryList;
        this.sizeDescInfo =sizeDescInfo;
    }


    public static String getSizeDescInfo(String skc, String sizeKey, String country) {
        for (SizeInfoTableEnum sizeEnum: values()) {
            if (CollectionUtils.isEmpty(sizeEnum.skcList)){
                continue;
            }
            List<String> skcSupperList = sizeEnum.skcList.stream().map(String::toUpperCase).collect(Collectors.toList());
            List<String> countrySupperList = sizeEnum.countryList.stream().map(String::toUpperCase).collect(Collectors.toList());
            if (skcSupperList.contains(skc.toUpperCase()) && sizeEnum.sizeKey.equalsIgnoreCase(sizeKey)){
                if (countrySupperList.contains(country.toUpperCase())){
                    //return sizeEnum.sizeDescInfo;
                    // 将空格分隔，转为以逗号分隔
                    String sizeDescInfo = sizeEnum.sizeDescInfo.trim();
                    String [] arrSize = sizeDescInfo.split("\\s+");
                    return StringUtils.join(arrSize, ",");
                }
            }
        }
        return "";
    }
}
