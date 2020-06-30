package com.eppear.baiju.common.mgr.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * 重命名插件，用于修改的名称，增前缀，后缀，或者正则替换相应字符
 *
 * @author jianf
 * @date 2020年06月29 14:58
 */
public class RenameJavaModelPlugin extends PluginAdapter {

    private String searchString;
    private String replaceString;
    private Pattern pattern = null;
    /**
     * 前缀
     */
    private String prefixString;
    /**
     * 后缀
     */
    private String suffixString;

    public boolean validate(List<String> warnings) {

        searchString = properties.getProperty("searchString");
        replaceString = properties.getProperty("replaceString");
        prefixString =  properties.getProperty("prefixString");
        suffixString = properties.getProperty("suffixString");

        boolean valid = stringHasValue(searchString)
                && stringHasValue(replaceString);

        if (valid) {
            pattern = Pattern.compile(searchString);
        } else {
            if (!stringHasValue(searchString)
                    && !stringHasValue(replaceString)) {
             return true;
            }
            if (!stringHasValue(searchString)) {
                warnings.add(getString("ValidationError.18",
                        "RenameJavaModelPlugin",
                        "searchString"));
            }
            if (!stringHasValue(replaceString)) {
                warnings.add(getString("ValidationError.18",
                        "RenameJavaModelPlugin",
                        "replaceString"));
            }
        }

        return valid;
    }

    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        String baseRecordTypeType = introspectedTable.getBaseRecordType();
        String exampleType = introspectedTable.getExampleType();
        String recordWithBLOBsType = introspectedTable.getRecordWithBLOBsType();

        if(stringHasValue(prefixString)){
            baseRecordTypeType = prefixString+baseRecordTypeType;
            exampleType = prefixString+exampleType;
            recordWithBLOBsType = prefixString+recordWithBLOBsType;
        }
        if(stringHasValue(suffixString)){
            baseRecordTypeType = baseRecordTypeType+suffixString;
            exampleType = exampleType+suffixString;
            recordWithBLOBsType = recordWithBLOBsType+suffixString;
        }
        if(pattern != null){
            Matcher matcher = pattern.matcher(baseRecordTypeType);
            baseRecordTypeType = matcher.replaceAll(replaceString);

            matcher = pattern.matcher(exampleType);
            exampleType = matcher.replaceAll(replaceString);

            matcher = pattern.matcher(recordWithBLOBsType);
            recordWithBLOBsType = matcher.replaceAll(replaceString);
        }

        introspectedTable.setBaseRecordType(baseRecordTypeType);
        introspectedTable.setExampleType(exampleType);
        introspectedTable.setRecordWithBLOBsType(recordWithBLOBsType);
    }
}
