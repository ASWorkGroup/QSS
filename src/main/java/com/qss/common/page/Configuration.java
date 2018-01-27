package com.qss.common.page;

import com.qss.common.utils.GsonUtil;
import org.dom4j.*;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanaiqing on 27/1/18.
 */
public class Configuration {
    private PageContainer pageContainer;
    private String[] paths;
    private Map<String, Map<String, List<String>>> defines = new HashMap<String, Map<String, List<String>>>();

    public Configuration(PageContainer pageContainer,  String ... paths){
        this.paths = paths;
        this.pageContainer = pageContainer;
    }

    public void parse(){
        try {
            for (String _path : paths) {
                StringBuilder stringBuilder = new StringBuilder();

                try (FileReader fileReader = new FileReader(_path)) {
                    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                        String readText;
                        while ((readText = bufferedReader.readLine()) != null) {
                            stringBuilder.append(readText);
                        }
                        bufferedReader.close();
                    } catch (FileNotFoundException ex) {
                        //todo
                    }

                }
                catch(IOException ex)
                {
                    //todo
                }

                Document document = DocumentHelper.parseText(stringBuilder.toString());
                Element root = document.getRootElement();
                if (!root.getName().equals("define")){
                    throw new PageDefineConfigParsingException("root element should be \"define\"");
                }

                Iterator<Element> iterator = root.elementIterator();
                while(iterator.hasNext()){
                    Element pageElement = iterator.next();
                    if (!pageElement.getName().equals("page")){
                        throw new PageDefineConfigParsingException("page element should be \"page\"");
                    }
                    //读取属性
                    String pageId = "";
                    String table = "";
                    List<Attribute> list = pageElement.attributes();
                    for(Attribute attribute : list){
                        if (attribute.getName().equals("id")){
                            pageId = attribute.getValue();
                        }
                        else if (attribute.getName().equals("table")){
                            table = attribute.getValue();
                        }
                    }
                    if (pageId.length() == 0){
                        throw new PageDefineConfigParsingException("page id is needed.");
                    }

                    //读取子节点
                    Iterator<Element> pageSubIterator = pageElement.elementIterator();
                    while(pageSubIterator.hasNext()) {
                        Element pageSubElement = pageSubIterator.next();
                        if (pageSubElement.getName().toLowerCase().equals("searchcondition")){

                            Iterator<Element> searchconditionIterator = pageSubElement.elementIterator();
                            while(searchconditionIterator.hasNext()) {
                                Element itemElement = searchconditionIterator.next();
                                String _define = itemElement.getText();

                                SearchConditionDefine define = GsonUtil.gson.fromJson(_define, SearchConditionDefine.class);
                                pageContainer.registerDefine(pageId, "searchcondition", define);
                            }
                        }
                        else if (pageSubElement.getName().toLowerCase().equals("listitem")){
                            Iterator<Element> listitemIterator = pageSubElement.elementIterator();
                            while(listitemIterator.hasNext()) {
                                Element itemElement = listitemIterator.next();
                                String _define = itemElement.getText();

                                ListItemDefine define = GsonUtil.gson.fromJson(_define, ListItemDefine.class);
                                pageContainer.registerDefine(pageId, "listitem", define);
                            }
                        }
                        else {
                            throw new PageDefineConfigParsingException("page sub element should be \"searchcondition\" or \"listitem\"");
                        }

                    }

                }
            }
        }


        catch(DocumentException ex)
        {
            //todo
        }

    }
}
