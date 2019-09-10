package com.spring.boot.service.common;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.common.domain.Col;
import com.spring.boot.entity.Operator;
import com.spring.boot.query.base.MapQuery;
import com.spring.boot.service.GeneralQueryService;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-25 18:37
 **/
public class GeneraExportService {
    static ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
    static ObjectFactory objectFactory = new DefaultObjectFactory();
    static ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
    private Object map;
    private GeneralQueryService generalQueryService;
    private String funCode;
    private Workbook workbook;

    /**
     * 只针对此场景使用  非线程安全
     */
    static SimpleTypeConverter simpleTypeConverter=new SimpleTypeConverter();
    Col[] cols = null;
    Page page = new Page(1, 1000);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static{
        simpleTypeConverter.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        simpleTypeConverter.registerCustomEditor(String.class,  new StringTrimmerEditor(true));
    }
    public GeneraExportService(HttpServletRequest request, Object map, GeneralQueryService generalQueryService, String funCode) {
        //     this.request = request;
        this.map = map;
        this.generalQueryService = generalQueryService;
        this.funCode = funCode;
        workbook = new SXSSFWorkbook(500);
    }


    public Workbook export() {
        // 取出一共有多少个sheet. sheet 有数量限制
        Sheet sheet = workbook.createSheet();
        Row row = createHeadRow(sheet);
        createDate(sheet);
        return workbook;

    }

    private void createDate(Sheet sheet) {
        CellStyle cellStyle = workbook.createCellStyle();
        int rowindex = 0;
        while (hasNext()) {
            List listObj = next();
            for (Object obj : listObj) {

                MetaObject metaObject = newMetaObject(obj);
                // BeanWrapper beanWrapper=new BeanWrapperImpl(obj);
                rowindex++;
                int colIndex = -1;
                Row row = sheet.createRow(rowindex);
                for (Col col : cols) {
                    colIndex++;

                    Cell cell = row.createCell(colIndex);
                    try {

                        // Object object= beanWrapper.getPropertyValue(String.format(key,col.getField()));
                        Object object = metaObject.getValue(col.getField());
                        cell.setCellType(CellType.STRING);


                        cell.setCellStyle(cellStyle);
                        cell.setCellValue((String) object);
                    } catch (Exception e) {
                        cell.setCellValue(e.getMessage());
                    }

                }

            }
        }

    }

    public boolean hasNext() {

        page.setRecords(null);
        page = generalQueryService.generalFind(funCode, map, page);
        page.setCurrent(page.getCurrent() + 1);
        if (page.getRecords() != null && page.getRecords().size() > 0) {

            return true;
        }

        return false;
    }

    public List next() {

        return page.getRecords();
    }

    private Row createHeadRow(Sheet sheet) {
        // 产生一行
        Row row = sheet.createRow(0);
        cols = findCol();
        for (int i = 0; i < cols.length; i++) {
            Col col = cols[i];
            Cell cell = row.createCell(i);
            // 设置列中写入内容为String类型
            cell.setCellType(CellType.STRING);
            CellStyle cellStyle = workbook.createCellStyle();
            // cellStyle.setAlignment(HorizontalAlignment.CENTER);
            // cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            // cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // cellStyle.setWrapText(true);
            cell.setCellStyle(cellStyle);

            cell.setCellValue(col.getTitle());
        }
        return row;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public Col[] findCol() {
        Col[] cols = generalQueryService.findColByFunCtion(funCode);
        List<Col> colLi = new ArrayList<>();
        Arrays.stream(cols).forEach(col -> {
            if (col.getExcel()) {
                colLi.add(col);
            }
        });
        return colLi.toArray(new Col[colLi.size()]);
    }

    public MetaObject newMetaObject(Object obj) {

        return MetaObject.forObject(obj, objectFactory, objectWrapperFactory, reflectorFactory);
    }

    public static void main(String[] arg) {
        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        ObjectFactory objectFactory = new DefaultObjectFactory();
        ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
        Map<String, String> obj = new HashMap<>();
        obj.put("aa", "dd");
        MetaObject metaObject = MetaObject.forObject(obj, objectFactory, objectWrapperFactory, reflectorFactory);
        System.out.println(metaObject.getValue("aa"));


    }

    public static void test1() {
        GeneraExportService generaExportService = new GeneraExportService(null, null, null, null);
        TestBean TestBean = generaExportService.new TestBean();
        Map<String, String> obj = new HashMap<>();
        obj.put("aa", "dd");
        TestBean.setMap(obj);
        BeanWrapper beanWrapper = new BeanWrapperImpl(obj);
        beanWrapper.getPropertyDescriptors();
        System.out.println(beanWrapper.getWrappedClass());
        System.out.println(beanWrapper.getWrappedInstance());
        System.out.println(beanWrapper.getPropertyValue(String.format("[%s]", "aa")));
    }

    public class TestBean {
        private Map<String, String> map = new HashMap<>();

        public Map<String, String> getMap() {
            return map;
        }

        public void setMap(Map<String, String> map) {
            this.map = map;
        }
    }

}
